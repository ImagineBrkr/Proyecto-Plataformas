package main;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductoMatricesHilos implements ProductoMatriz{
	
	@Override
	public float[][] Producto(float[][] A, float[][] B, int f, int c, int m) {
		MultiplicarVectoresThread[] th = new MultiplicarVectoresThread[c];
		ExecutorService executor;
		float[] temp = new float[c];
		float[][] P = new float[f][c];
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < m; k++) {
					temp[k] = B[k][j];
				}
				th[j] = new MultiplicarVectoresThread(A[i], temp, m);			
			}
			executor = Executors.newFixedThreadPool(c);
			for (int l = 0; l < c; l++) {
				executor.execute(th[l]);
				P[i][l] = th[l].getResult();
			}
			executor.shutdown();
			while(!executor.isTerminated()) {
				
			}
		}
		return P;
	}
}
