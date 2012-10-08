package de.mukis.matrix;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Jama.Matrix;

import com.google.common.base.Stopwatch;

public class SystemNanoJamaBenchmark {

    private Matrix a;
    private Matrix b;
    private final int m1, nm, n2;

    public SystemNanoJamaBenchmark(int m1, int nm, int n2) {
        this.m1 = m1;
        this.nm = nm;
        this.n2 = n2;
        setUp();
    }

    private void setUp() {
        a = SampleDataFactory.getSampleJamaMatrix(m1, nm);
        b = SampleDataFactory.getSampleJamaMatrix(nm, n2);
    }

    public void warmUp(int times) {
        for (int i = 0; i < times; i++) {
            a.times(b);
        }
    }

    public void run(int times) {
        for (int i = 0; i < times; i++) {
            a.times(b);
        }
    }

    public static void main(String[] args) {
        RuntimeMXBean RuntimemxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = RuntimemxBean.getInputArguments();
        System.out.println("## Settings");
        System.out.println("vm args: " + arguments);
        Stopwatch watch = new Stopwatch();

        int[] dimensions = new int[] { 1000, 2000, 5000, /* 10000 */};
        for (int i = 0; i < dimensions.length; i++) {
            int dim = dimensions[i];
            System.out.println("#### Benchmark #####");
            System.out.println("Dimension: " + dim);
            watch.start();
            SystemNanoJamaBenchmark b1 = new SystemNanoJamaBenchmark(dim, dim, dim);
            watch.stop();
            System.out.println("Creating matrices took: " + watch.elapsedMillis() + " ms");
            watch.reset();

            // Warm up
            // b1.warmUp(2);

            // Run benchmark
            watch.start();
            b1.run(1);
            watch.stop();
            System.out.println("## Multiplication ");
            System.out.println();
            System.out.println("Milliseconds: " + watch.elapsedMillis());
            System.out.println("Seconds: " + watch.elapsedTime(TimeUnit.SECONDS));
            System.out.println("Minutes: " + watch.elapsedTime(TimeUnit.MINUTES));
            watch.reset();
        }
    }
}
