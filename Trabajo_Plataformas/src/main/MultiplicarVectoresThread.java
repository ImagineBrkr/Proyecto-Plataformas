package main;

public class MultiplicarVectoresThread extends Thread {
	private float[] A, B;
	private int c;
	private float result;
	
	@Override
	public void run() {
		MultiplicarVectores v = new MultiplicarVectores();
		result = v.calcular(A, B, c);
	}
	
	public MultiplicarVectoresThread(float[] A, float[] B, int c) {
		super();
		this.A = A;
		this.B = B;
		this.c = c;
	}
	
	public float getResult() {
		return result;
	}
	
	public void setResult(float result) {
		this.result = result;
	}
}
