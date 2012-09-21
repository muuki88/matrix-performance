package de.mukis.matrix;

import Jama.Matrix;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class CaliperJamaBenchmark extends SimpleBenchmark {

	@Param({ "100", "1000", })
	private int m1;
	@Param({ "10", "100", "1000" })
	private int nm;
	@Param({ "100", "1000" })
	private int n2;

	private Matrix a;
	private Matrix b;

	@Override
	protected void setUp() throws Exception {
		a = SampleDataFactory.getSampleMatrix(m1, nm);
		b = SampleDataFactory.getSampleMatrix(nm, n2);
	}

	public void timeJama(int reps) {
		for (int i = 0; i < reps; i++) {
			a.times(b);
		}
	}

	public static void main(String[] args) throws Exception {
		// programm arguments
		// -JmemoryMax=-Xmx512M,-Xmx1024M,-Xmx2048M
		Runner.main(CaliperJamaBenchmark.class, args);
	}
}
