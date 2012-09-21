package de.mukis.matrix;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;

import Jama.Matrix;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

public class TestBenchmarkJama {

	@Rule
	public MethodRule benchmarkRun = new BenchmarkRule();

	private Matrix a;
	private Matrix b;
	private Matrix des;

	@Test
	@BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 10)
	public void testSmallelst() {
		init(100, 100, 100);
		a.times(b);
	}

	@Test
	@BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 2)
	public void testSmall() {
		init(500, 500, 500);
		a.times(b);
	}

	@Test
	@BenchmarkOptions(benchmarkRounds = 5, warmupRounds = 0)
	public void testNormal() {
		init(1000, 1000, 1000);
		a.times(b);
	}

	private void init(int m, int nm, int n) {
		a = SampleDataFactory.getSampleMatrix(m, nm);
		b = SampleDataFactory.getSampleMatrix(nm, n);
		des = SampleDataFactory.getEmptyResultMatrix(a, b);
	}

}
