package Tp1.Ej7g;

import java.util.LinkedList;
import java.util.List;


public class EjercicioSucesion {

	public static List<Integer> calcularSucesion(int n) {

		if (n == 1) {
			List<Integer> sucesion = new LinkedList<Integer>();
			sucesion.add(n);
			return sucesion;
			
		} else if (n % 2 == 0) {
			List<Integer> sucesion = calcularSucesion(n/2);
			sucesion.add(0, n);
			return sucesion;
			
		} else {
			List<Integer> sucesion = calcularSucesion((3*n)+1);
			sucesion.add(0, n);
			return sucesion;
		}

	}

}