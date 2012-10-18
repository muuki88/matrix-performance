package de.mukis.matrix.memory;

import de.mukis.matrix.ObjectFactory;

public class DoubleArrayFactory implements ObjectFactory {

	@Override
	public Object makeObject() {
		double[][] array = new double[1000][1000];
		for (double[] ds : array) {
			for (int i = 0; i < ds.length; i++) {
				ds[i] = Math.random();
			}
		}
		return array;
	}
}
