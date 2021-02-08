package main;

public class MultiplicarVectores {
	public float calcular(float[] N, float[] M, int k) {
		float result = 0;
		long Tiempo;
		long inicialTime = System.nanoTime();
		for (int i = 0; i < k; i++) {
			result += N[i]*M[i];
		}
		Tiempo = System.nanoTime() - inicialTime;
		System.out.println("Calculado en " + Tiempo + " nanosegundos.");
		return result;
	}
}
