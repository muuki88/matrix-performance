package de.mukis.matrix.memory;

import de.mukis.matrix.ObjectFactory;

public class FloatArrayFactory implements ObjectFactory {

	@Override
	public Object makeObject() {
		float[][] array = new float[1000][1000];
		for (float[] fs : array) {
			for (int i = 0; i < fs.length; i++) {
				fs[i] = (float) Math.random();
			}
		}
		return array;
	}
}
