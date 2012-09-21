package de.mukis.matrix;

import Jama.Matrix;

public class PartialMatrix {

	/* Describes position in matrix */
	public final int x;
	public final int y;
	public final int rows;
	public final int cols;

	/** Reference to the matrix object */
	public final Matrix matrix;

	public PartialMatrix(int x, int y, int rows, int yLength, Matrix matrix) {
		super();
		this.x = x;
		this.y = y;
		this.rows = rows;
		this.cols = yLength;
		this.matrix = matrix;
	}

}
