package de.mukis.matrix;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import Jama.Matrix;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class CaliperMutableForkJoinBenchmark extends SimpleBenchmark {

	@Param({ "100", "1000" })
	private int m1;
	@Param({ "10", "100", "1000" })
	private int nm;
	@Param({ "100", "1000" })
	private int n2;

	@Param({ "100", "500", "1000" })
	private int threshold;

	private Matrix a;
	private Matrix b;

	@Override
	protected void setUp() throws Exception {
		a = SampleDataFactory.getSampleMatrix(m1, nm);
		b = SampleDataFactory.getSampleMatrix(nm, n2);
	}

	public void timeMutableForkJoin(int reps) {
		for (int i = 0; i < reps; i++) {
			Matrix des = SampleDataFactory.getEmptyResultMatrix(a, b);
			ForkJoinPool pool = new ForkJoinPool();
			MutableMatrixMultiplicationTask task = new MutableMatrixMultiplicationTask(a, b, des, threshold);
			pool.execute(task);
			pool.shutdown();
			try {
				pool.awaitTermination(120, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Runner.main(CaliperMutableForkJoinBenchmark.class, args);
	}
}
