package Tp1.Ej7g;
import java.util.List;
import java.util.Scanner;
public class Collatz {
		public static void main(String[] args) {
			System.out.println("Ingrese un numero para hacer su sucesion de Collatz: ");
			try (Scanner in = new Scanner (System.in)) {
				List <Integer> lista=EjercicioSucesion.calcularSucesion(in.nextInt());
				for(Integer elto : lista) {
					System.out.println(elto);
				}
			}
		}
}
