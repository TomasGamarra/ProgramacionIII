package tp3.RecorridosAG;

import java.util.LinkedList;
import java.util.List;

import Tp1.Clases.Queue;
import tp3.GeneralTree.GeneralTree;

public class RecorridosAG {

//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
//pasados como parámetros, recorrido en preorden.
	public static List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n){
	LinkedList <Integer> list = new LinkedList<Integer>();
	private_numerosImparesMayoresQuePreOrden(a,n,list);
	return list;	
	}
	
	private static void private_numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a,Integer n,List<Integer> list){
		if(a.getData() > n && a.getData() % 2 != 0)
			list.add(a.getData());
		for (GeneralTree<Integer> child :a.getChildren())
			private_numerosImparesMayoresQuePreOrden(child,n,list);
	}
	
//	Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
//	pasados como parámetros, recorrido en inorden.
	public static List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
		List<Integer> list = new LinkedList <Integer>();
		private_numerosImparesMayoresQueInOrden(a,n,list);
		return list;
	}
	private static void private_numerosImparesMayoresQueInOrden(GeneralTree <Integer> a,Integer n,List<Integer> list) {
		List<GeneralTree<Integer>> children = a.getChildren();
		if(a.hasChildren()) 
			private_numerosImparesMayoresQueInOrden(children.get(0),n,list);
		if(a.getData() > n && a.getData() % 2 != 0)
			list.add(a.getData());
		for(int i=1 ;i<children.size();i++)
			private_numerosImparesMayoresQueInOrden(children.get(i),n,list);
	}

//		Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
//		pasados como parámetros recorrido en postorden.
	
	public static List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
	 	LinkedList<Integer> list = new LinkedList<Integer>();
		private_numerosImparesMayoresQuePostOrden(a,n,list);
		return list;
	 	
	}
	private static void private_numerosImparesMayoresQuePostOrden (GeneralTree<Integer> a ,Integer n,LinkedList<Integer> list) {
		List<GeneralTree<Integer>> children = a.getChildren();
	 	for(GeneralTree<Integer> child : children)
	 		private_numerosImparesMayoresQuePostOrden(child,n,list);
	 	if(a.getData() > n && a.getData() % 2 != 0)
			list.add(a.getData());
	
	}
	
//	Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
//	pasados como parámetros, recorrido por niveles.
	
	public static List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
		LinkedList<Integer> list = new LinkedList <Integer>();
		private_numerosImparesMayoresQuePorNiveles(a,n,list);
		return list;
		
	}
	
	private static void private_numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n,LinkedList<Integer> list) {
		Queue <GeneralTree<Integer>> cola = new Queue <GeneralTree<Integer>>();
		cola.enqueue(a);
		while (!cola.isEmpty()) {
			GeneralTree<Integer> aux = cola.dequeue();
			if(aux.getData() > n && aux.getData() % 2 != 0)
				list.add(aux.getData());
			List<GeneralTree<Integer>> children = aux.getChildren();				
				for(GeneralTree<Integer> child : children)
					cola.enqueue(child);
			
		}
		
	}

}
