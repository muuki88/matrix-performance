package de.mukis.matrix;

import cern.colt.matrix.DoubleMatrix2D;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

public class CaliperColtBenchmark extends SimpleBenchmark {

	@Param({ "100", "1000", })
	private int m1;
	@Param({ "10", "100", "1000" })
	private int nm;
	@Param({ "100", "1000" })
	private int n2;

	private DoubleMatrix2D a;
	private DoubleMatrix2D b;
	private DoubleMatrix2D c;

	@Override
	protected void setUp() throws Exception {
		a = SampleDataFactory.getSampleColtDenseMatrix(m1, nm);
		b = SampleDataFactory.getSampleColtDenseMatrix(nm, n2);
		c = SampleDataFactory.getEmptyResultMatrix(a, b);
	}

	public void timeColt(int reps) {
		for (int i = 0; i < reps; i++) {
			a.zMult(b, c);
		}
	}

	public static void main(String[] args) throws Exception {
		// programm arguments
		// -JmemoryMax=-Xmx512M,-Xmx1024M,-Xmx2048M
		Runner.main(CaliperJamaBenchmark.class, args);
	}
}
