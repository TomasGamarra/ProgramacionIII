package tp3.encontrarPrincesa;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree.GeneralTree;

public class EncontrarPrincesa {
	
	public LinkedList<Personaje> encontrarPrincesa (GeneralTree<Personaje> ab){
		LinkedList<Personaje> l = new LinkedList<Personaje>();
		if(ab.getData().esPrincesa()) 
			l.add(ab.getData());
		else {
			if(ab.getData().esDragon() || ab.isLeaf()) //No encontre un camino correcto
				return null;
			else{
				l.add(ab.getData());
				List <GeneralTree<Personaje>> children = ab.getChildren();			
				for (GeneralTree<Personaje> nodo : children) {
					LinkedList<Personaje> aux=encontrarPrincesa(nodo);
					if(aux!=null && aux.getLast().esPrincesa()) {
						l.addAll(aux);
						return aux;
					}
				}
			}
		}
		return l; //Lo necesito porque me lo pide Java
		
	}
}
