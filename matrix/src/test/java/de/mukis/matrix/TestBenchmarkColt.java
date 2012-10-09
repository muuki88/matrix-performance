package de.mukis.matrix;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;

import cern.colt.matrix.DoubleMatrix2D;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

public class TestBenchmarkColt {

    @Rule
    public MethodRule benchmarkRun = new BenchmarkRule();

    private DoubleMatrix2D a;
    private DoubleMatrix2D b;
    private DoubleMatrix2D c;

    @Test
    @BenchmarkOptions(benchmarkRounds = 20, warmupRounds = 10)
    public void testSmallelst() {
        init(100, 100, 100);
        a.zMult(b, c);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 10, warmupRounds = 2)
    public void testSmall() {
        init(500, 500, 500);
        a.zMult(b, c);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 5, warmupRounds = 0)
    public void testNormal() {
        init(1000, 1000, 1000);
        a.zMult(b, c);
        ;
    }

    private void init(int m, int nm, int n) {
        a = SampleDataFactory.getSampleColtDenseMatrix(m, nm);
        b = SampleDataFactory.getSampleColtDenseMatrix(nm, n);
        c = SampleDataFactory.getEmptyDenseResultMatrix(a, b);
    }

}
