package main;


public class ProductoMatrices implements ProductoMatriz{
	
	@Override
	public float[][] Producto(float[][] A, float[][] B, int f, int c, int m) {
		MultiplicarVectores v = new MultiplicarVectores();
		float[] temp = new float[c];
		float[][] P = new float[f][c];
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < m; k++) {
					temp[k] = B[k][j];
				}
					P[i][j] = v.calcular(A[i], temp, m);				
			}
		}
		return P;
	}
}
