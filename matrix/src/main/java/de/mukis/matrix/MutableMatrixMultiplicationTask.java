package de.mukis.matrix;

import java.util.concurrent.RecursiveAction;

import Jama.Matrix;

public class MutableMatrixMultiplicationTask extends RecursiveAction {

	private static final long serialVersionUID = 1727280960228146674L;
	protected static int THRESHOLD = 100;
	private final Matrix a;
	private final Matrix b;
	private final Matrix des;

	/** Destination computation values */
	private final int x, y;

	/** How many rows and columns should be computed */
	private final int rows, cols;

	public MutableMatrixMultiplicationTask(Matrix a, Matrix b, Matrix des, int x, int y, int rows, int cols) {
		this.a = a;
		this.b = b;
		this.des = des;
		this.x = x;
		this.y = y;
		this.rows = rows;
		this.cols = cols;
	}

	public MutableMatrixMultiplicationTask(Matrix a, Matrix b, Matrix des) {
		this(a, b, des, 0, 0, a.getRowDimension(), b.getColumnDimension());
	}

	@Override
	protected void compute() {
		if (a.getColumnDimension() != b.getRowDimension()) {
			throw new IllegalStateException("a.cols != b.rows " + a.getColumnDimension() + " != " + b.getRowDimension());
		}
		if (rows < THRESHOLD && cols < THRESHOLD) {
			matrixMultiplication();
		} else {
			if (rows > cols) {
				// Split rows
				int rowsT1 = rows / 2;
				int rowsT2 = rows - rowsT1;
				int xT2 = x + rowsT1;
				MutableMatrixMultiplicationTask t1 = new MutableMatrixMultiplicationTask(a, b, des, x, y, rowsT1, cols);
				MutableMatrixMultiplicationTask t2 = new MutableMatrixMultiplicationTask(a, b, des, xT2, y, rowsT2, cols);
				invokeAll(t1, t2);

			} else {
				// Split columns
				int colsT1 = cols / 2;
				int colsT2 = cols - colsT1;
				int yT2 = y + colsT1;
				MutableMatrixMultiplicationTask t1 = new MutableMatrixMultiplicationTask(a, b, des, x, y, rows, colsT1);
				MutableMatrixMultiplicationTask t2 = new MutableMatrixMultiplicationTask(a, b, des, x, yT2, rows, colsT2);
				invokeAll(t1, t2);
			}
		}
	}

	private void matrixMultiplication() {
		// Running through destination matrix
		for (int row = x; row < (x + rows); row++) {
			for (int col = y; col < (y + cols); col++) {
				des.set(row, col, calculateSingleValue(row, col));
			}
		}
	}

	private double calculateSingleValue(int row, int col) {
		double value = 0.0;
		for (int i = 0; i < a.getColumnDimension(); i++) {
			double aValue = a.get(row, i);
			double bValue = b.get(i, col);
			value += aValue * bValue;
		}
		return value;
	}
}
