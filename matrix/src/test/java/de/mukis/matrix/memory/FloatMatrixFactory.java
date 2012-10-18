package de.mukis.matrix.memory;

import de.mukis.matrix.ObjectFactory;
import de.mukis.matrix.jama.FloatMatrix;

public class FloatMatrixFactory implements ObjectFactory {

	@Override
	public Object makeObject() {
		return FloatMatrix.random(1000, 1000);
	}

}
