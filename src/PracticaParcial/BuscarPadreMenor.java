package PracticaParcial;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree.GeneralTree;

public class BuscarPadreMenor {
	
	public static void main (String args []) {
		GeneralTree<Integer> nodo100= new GeneralTree<>(100);
		GeneralTree<Integer> nodo2= new GeneralTree<>(2);
		GeneralTree<Integer> nodo33= new GeneralTree<>(33);
		GeneralTree<Integer> nodo4= new GeneralTree<>(4);
		nodo100.addChild(nodo2);
		nodo100.addChild(nodo33);
		nodo100.addChild(nodo4);
		GeneralTree<Integer> nodo5= new GeneralTree<>(5);
		nodo2.addChild(nodo5);
		GeneralTree<Integer> nodo6= new GeneralTree<>(6);
		GeneralTree<Integer> nodo2repetido= new GeneralTree<>(2);
		GeneralTree<Integer> nodo8= new GeneralTree<>(8);
		nodo33.addChild(nodo6);
		nodo33.addChild(nodo2repetido);
		nodo33.addChild(nodo8);
		GeneralTree<Integer> nodo6repetido= new GeneralTree<>(6);
		nodo4.addChild(nodo6repetido);
		GeneralTree<Integer> nodo1000= new GeneralTree<>(1000);
		nodo4.addChild(nodo1000);
		System.out.println("Cant:"+buscar(nodo100));
		System.out.println(Repositorio.devolverLista().toString());
		
	}
	
	public static int buscar (GeneralTree<Integer> arbol) {
		if(arbol.hasChildren()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			int cant=0,sumaHijos=0;
			for (GeneralTree<Integer> child : children) {
				cant+=buscar(child);
				sumaHijos+=child.getData();
			}
			if(sumaHijos > arbol.getData()) {
				cant++;
				Repositorio.add(arbol.getData());
			}
			return cant;
		}else
			return 0;
	}
	
	public class Repositorio {
		private static LinkedList<Integer> lista = new LinkedList<>();
		
		public static void add (Integer ab) {
			lista.add(ab);
		}
		
		public static List<Integer> devolverLista (){
			return lista;
		}
	}
}
