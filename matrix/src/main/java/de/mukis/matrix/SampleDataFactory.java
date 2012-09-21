package de.mukis.matrix;

import Jama.Matrix;

public class SampleDataFactory {

	public static Matrix getEmptyResultMatrix(Matrix a, Matrix b) {
		return new Matrix(a.getRowDimension(), b.getColumnDimension());
	}

	public static Matrix getSampleMatrix(int m, int n) {
		double[][] values = new double[m][n];
		fillSampleArray(values, m, n);
		return new Matrix(values);
	}

	public static void fillSampleArray(double[][] values, int m, int n) {
		for (double[] rows : values) {
			for (int i = 0; i < rows.length; i++) {
				rows[i] = Math.random() * 100.0;
			}
		}
	}
}
