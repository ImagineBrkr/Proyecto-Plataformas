package main;

import java.util.Random;
import java.util.Scanner;

public class Principal {
	
	public static float[][] GenerarMatriz(int n, int m) {
		Random r = new Random();
		float[][] M = new float[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				M[i][j] = (r.nextFloat() * 10);
			}
		}
		return M;
	}
	
	public static void imprimirMatriz(float[][] M, int n, int m) {
		String linea;
		for (int i = 0; i < n; i++) {
			linea = "";
			for (int j = 0; j < m; j++) {
				linea += Float.toString(M[i][j]) + "  ";
			}
			System.out.println(linea);
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductoMatrices M1 = new ProductoMatrices();
		ProductoMatricesHilos M2 = new ProductoMatricesHilos();

		int n, m, p;
		String r;
		long Tiempo, inicialTime;
		
		System.out.println("Ingrese las filas de la matriz A");
		n = sc.nextInt();
		System.out.println("Ingrese las columnas de la matriz A");
		m = sc.nextInt();
		System.out.println("Ingrese las columnas de la matriz B");
		p = sc.nextInt();
		float[][] A = new float[n][m];
		float[][] B = new float[m][p];
		float[][] P = new float[n][p];
		
		System.out.println("¿Desea generarlas aleatoriamente? (S/N)");
		do {
			System.out.println("Ingrese su respuesta");
			
			r = sc.next();
		} while(!(r.equals("S") || r.equals("N")));
		if (r.equals("S")) {
			A = GenerarMatriz(n, m);
			B = GenerarMatriz(m, p);
		} else {
			System.out.println("Ingrese datos de la matriz A");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					A[i][j] = sc.nextFloat();
				}
			}
			System.out.println("Ingrese datos de la matriz B");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					B[i][j] = sc.nextFloat();
				}
			}
		}
		imprimirMatriz(A, n, m);
		System.out.println("");
		imprimirMatriz(B, m, p);
		System.out.println("");
		
		inicialTime = System.currentTimeMillis();
		P = M1.Producto(A, B, n, p, m);
		Tiempo = System.currentTimeMillis() - inicialTime;
		System.out.println("Calculado en " + Tiempo + " milisegundos.");
		imprimirMatriz(P, n, p);		
		System.out.println("");		
		
		inicialTime = System.currentTimeMillis();
		P = M2.Producto(A, B, n, p, m);
		Tiempo = System.currentTimeMillis() - inicialTime;	
		System.out.println("Calculado en " + Tiempo + " milisegundos.");
		imprimirMatriz(P, n, p);
		
	}

}
