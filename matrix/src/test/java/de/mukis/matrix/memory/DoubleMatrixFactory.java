package de.mukis.matrix.memory;

import Jama.Matrix;
import de.mukis.matrix.ObjectFactory;

public class DoubleMatrixFactory implements ObjectFactory {

	@Override
	public Object makeObject() {
		return Matrix.random(1000, 1000);
	}

}
