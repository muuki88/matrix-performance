package de.mukis.matrix;

import Jama.Matrix;
import cern.colt.matrix.DoubleFactory2D;
import cern.colt.matrix.DoubleMatrix2D;

public class SampleDataFactory {

    public static Matrix getEmptyResultMatrix(Matrix a, Matrix b) {
        return new Matrix(a.getRowDimension(), b.getColumnDimension());
    }

    public static DoubleMatrix2D getEmptyDenseResultMatrix(DoubleMatrix2D a, DoubleMatrix2D b) {
        return DoubleFactory2D.dense.make(a.rows(), b.columns());
    }

    public static DoubleMatrix2D getEmptySparseResultMatrix(DoubleMatrix2D a, DoubleMatrix2D b) {
        return DoubleFactory2D.sparse.make(a.rows(), b.columns());
    }

    public static Matrix getSampleJamaMatrix(int m, int n) {
        double[][] values = new double[m][n];
        fillSampleArray(values, m, n);
        return new Matrix(values);
    }

    public static DoubleMatrix2D getSampleColtDenseMatrix(int m, int n) {
        double[][] values = new double[m][n];
        fillSampleArray(values, m, n);
        return DoubleFactory2D.dense.make(values);
    }

    public static DoubleMatrix2D getSampleColtSparseMatrix(int m, int n) {
        double[][] values = new double[m][n];
        fillSampleArray(values, m, n);
        return DoubleFactory2D.sparse.make(values);
    }

    public static void fillSampleArray(double[][] values, int m, int n) {
        for (double[] rows : values) {
            for (int i = 0; i < rows.length; i++) {
                rows[i] = Math.random() * 100.0;
            }
        }
    }
}
