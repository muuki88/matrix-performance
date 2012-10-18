package de.mukis.matrix.memory;

import de.mukis.matrix.MemoryTestBench;

public class FloatDoubleBenchmark {

	public static void main(String[] args) {
		MemoryTestBench bench = new MemoryTestBench();
		for (int i = 0; i < 10; i++) {
			System.out.println("### Interation " + i);
			long dMemory = bench.calculateMemoryUsage(new DoubleArrayFactory());
			long fMemory = bench.calculateMemoryUsage(new FloatArrayFactory());
			System.out.println(" float < double :: " + fMemory + " < " + dMemory);

			double ratio = ((double) fMemory / (double) dMemory);
			System.out.println(" ratio: " + ratio * 100.0 + " %");
		}

	}
}
