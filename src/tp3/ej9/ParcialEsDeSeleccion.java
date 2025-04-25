package tp3.ej9;

import java.util.List;

import tp3.GeneralTree.GeneralTree;

public class ParcialEsDeSeleccion {
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		Integer min = Integer.MAX_VALUE;
		if(arbol.hasChildren()) {
			List<GeneralTree<Integer>> children = arbol.getChildren();
			for (GeneralTree<Integer> child :children) {
				if(!esDeSeleccion(child))
					return false;
				if (child.getData() < min)
					min=child.getData();
			}
			if (min.equals(arbol.getData()))
				return true;
			else
				return false;
		}
		else
			return true;		
	}
	
}
