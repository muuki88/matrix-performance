package de.mukis.matrix;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;

import Jama.Matrix;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

//@AxisRange(min = 0, max = 20)
//@BenchmarkMethodChart(filePrefix = "benchmark-lists")
public class TestBenchmarkMutableForkJoin {

	@Rule
	public MethodRule benchmarkRun = new BenchmarkRule();

	private Matrix a;
	private Matrix b;
	private Matrix des;

	@Test
	@BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 10)
	public void testSmallelst() {
		init(100, 100, 100);
		runTest();
	}

	@Test
	@BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 2)
	public void testSmall() {
		init(500, 500, 500);
		runTest();
	}

	@Test
	@BenchmarkOptions(benchmarkRounds = 5, warmupRounds = 0)
	public void testNormal() {
		init(1000, 1000, 1000);
		runTest();
	}

	private void runTest() {
		Matrix des = SampleDataFactory.getEmptyResultMatrix(a, b);
		ForkJoinPool pool = new ForkJoinPool();
		MutableMatrixMultiplicationTask task = new MutableMatrixMultiplicationTask(a, b, des);
		pool.execute(task);
		pool.shutdown();
		try {
			pool.awaitTermination(120, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void init(int m, int nm, int n) {
		a = SampleDataFactory.getSampleMatrix(m, nm);
		b = SampleDataFactory.getSampleMatrix(nm, n);
		des = SampleDataFactory.getEmptyResultMatrix(a, b);
	}

}
