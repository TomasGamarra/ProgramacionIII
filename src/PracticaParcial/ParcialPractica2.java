package PracticaParcial;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree.GeneralTree;

public class ParcialPractica2 {
	
	public boolean resolver(GeneralTree<Integer> arbol) {
		List<Integer> lista= new LinkedList<>();
		return private_resolver(arbol,lista);
	}
	
	private boolean private_resolver(GeneralTree<Integer> arbol,List<Integer>lista) {
		if(lista.contains(arbol.getData()))
				return true;
		if(arbol.hasChildren()) {
			lista.add(arbol.getData());
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for(GeneralTree<Integer> child: children) 
				if(private_resolver(child,lista))
					return true;
			lista.remove(lista.size()-1);
		}
		return false;

			
	}
}
