package PracticaParcial;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree.GeneralTree;

public class ParcialPractica1 {
	// devuelve true si el árbol enviado como argumento posee dos caminos desde la raíz a 
	//las hojas que suman el mismo valor. 
	public boolean resolver (GeneralTree<Integer> ag) {
		List<Integer> lista = new LinkedList<>();
		return private_resolver(ag,0,lista);
	}
	private boolean private_resolver(GeneralTree<Integer>arbol,int suma,List<Integer> lista) {
		suma+=arbol.getData();
		if(arbol.hasChildren()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for(GeneralTree<Integer> child : children) {
				if(private_resolver(child,suma,lista))
					return true;
			}
		}else 
			if(lista.contains(suma)) 
				return true;
			else 
				lista.add(suma);
			
		return false;
			
	}
}
