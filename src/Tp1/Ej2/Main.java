package Tp1.Ej2;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Ingrese n: ");
			int n=in.nextInt();
			int [] array= Ejercicio2.devolverArreglo(n);
			for(int elto:array)
				System.out.print("["+elto+"]");
		}
		
	}

}
