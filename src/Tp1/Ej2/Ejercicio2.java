package Tp1.Ej2;

public class Ejercicio2 {
	
	public static int[] devolverArreglo (int n) {
		int[] array = new int [n];
		for(int i=0;i<=array.length-1;i++) 
			array[i]=n*(i+1);
		return array;
	}
}
