package de.mukis.matrix

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import Jama.Matrix
import org.junit.runner.RunWith
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit
import scala.Math

@RunWith(classOf[JUnitRunner])
class TestForkJoinMatrixMultiplication extends FunSuite with ShouldMatchers {

  val values01 = Array(Array(1.5, 2.3, 7.7, 9.9), Array(3.89, 23.63, 1.2, 3.561))
  val values02 = Array(Array(1.111, 2.222), Array(3.333, 4.444), Array(5.555, 6.666), Array(7.777, 8.888))

  test("Correctness test with Jama") {
    val a1 = new Matrix(3, 3, 3)
    val b1 = new Matrix(3, 2, 2)
    val des1 = new Matrix(3, 2)

    val t1 = new MutableMatrixMultiplicationTask(a1, b1, des1, 1000)
    t1.compute

    des1 should be equals (a1.times(b1))

    // More complicated matrix
    val a2 = new Matrix(values01)
    val b2 = new Matrix(values02)
    val des2 = new Matrix(a2.getRowDimension, b2.getColumnDimension)

    val t2 = new MutableMatrixMultiplicationTask(a2, b2, des2, 1000)
    t2.compute()

    des2 should be equals (a2.times(b2))
  }

  test("Fork Join Task Small") {
    val pool = new ForkJoinPool
    val a2 = new Matrix(values01)
    val b2 = new Matrix(values02)
    val des2 = new Matrix(a2.getRowDimension, b2.getColumnDimension)

    val task = new MutableMatrixMultiplicationTask(a2, b2, des2, 1000)
    pool.execute(task)
    pool.shutdown()
    pool.awaitTermination(10, TimeUnit.SECONDS);

    des2 should be equals (a2.times(b2))
  }

  test("Fork Join Task Big") {
    // Memory problem -> scalatest increase memory. Or Scala?!
    val m1 = 500
    val nm = 4000
    val n2 = 800

    val pool = new ForkJoinPool
    val a2 = SampleDataFactory.getSampleJamaMatrix(m1, nm)
    val b2 = SampleDataFactory.getSampleJamaMatrix(nm, n2)
    val des2 = new Matrix(a2.getRowDimension, b2.getColumnDimension)

    val task = new MutableMatrixMultiplicationTask(a2, b2, des2, 1000)
    pool.execute(task)
    pool.shutdown()
    pool.awaitTermination(50, TimeUnit.SECONDS);

    des2 should be equals (a2.times(b2))
  }

}