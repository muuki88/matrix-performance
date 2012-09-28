package de.mukis.matrix

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import Jama.Matrix
import cern.colt.matrix.{ DoubleMatrix2D, DoubleFactory2D }

@RunWith(classOf[JUnitRunner])
class TestColtLibrary extends FunSuite with ShouldMatchers {

  val values01 = Array(Array(1.5, 2.3, 7.7, 9.9), Array(3.89, 23.63, 1.2, 3.561))
  val values02 = Array(Array(1.111, 2.222), Array(3.333, 4.444), Array(5.555, 6.666), Array(7.777, 8.888))

  test("Colt DenseMatrix equals to Jama") {
    val a1 = new Matrix(values01)
    val b1 = new Matrix(values02)

    val a2 = DoubleFactory2D.dense.make(values01)
    val b2 = DoubleFactory2D.dense.make(values02)

    // Check content is equals
    checkEquals(a1, a2)
    checkEquals(b1, b2)

    // Linear algebraic matrix-matrix multiplication; c2 = a2 x b2;
    val c2 = DoubleFactory2D.dense.make(a2.rows, b2.columns)
    checkEquals(a1.times(b1), a2.zMult(b2, c2))
  }

  // Want to use duck-typing here :)
  private def checkEquals(jama: Matrix, colt: DoubleMatrix2D) {
    for (i <- 0 until values01.length)
      for (j <- 0 until values02(i).length)
        jama.get(i, j) should equal(colt.get(i, j))
  }
}