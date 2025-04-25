/*Escriba una clase llamada TestArrayList cuyo método main recibe una secuencia de
números, los agrega a una lista de tipo ArrayList, y luego de haber agregado todos los
números a la lista, imprime el contenido de la misma iterando sobre cada elemento.
*/
package Tp1.Ej7a;
import java.util.*;
public class TestArrayList {
	
	public static void main (String [] args) {
		List <Integer> lista = new LinkedList <>();
		for (String elto: args) {
			lista.add(Integer.parseInt(elto));
			}
		for (int elto : lista) {
			System.out.println(elto);
		}
		System.out.println("\n Iterator: \n");
		Iterator <Integer> it  = lista.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			}
	}

}
