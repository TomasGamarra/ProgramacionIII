package tp3.ej7;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> ab;
	
	public Caminos () {
		
	}
	public Caminos (GeneralTree<Integer> ab) {
		setAb(ab);
	}
	
	//Retorna el camino a la hoja más lejana en forma de lista.
	public List<Integer> caminoAHojaMasLejana (){
		LinkedList<Integer> camino = new LinkedList<Integer>();
		LinkedList<Integer> lista = new LinkedList<Integer>();
		lista.add(ab.getData());
		caminoAHojaMasLejana(ab,ab.altura(),camino,lista);
		return camino;
	}

	private void caminoAHojaMasLejana(GeneralTree<Integer>ab,int altura,LinkedList<Integer> camino,LinkedList<Integer> lista) {
		if(camino.isEmpty()) {
			if(ab.altura()==0 && altura ==0)
				camino.addAll(lista);
			if(ab.altura()==altura)
				if(ab.hasChildren()) {
					List<GeneralTree<Integer>> children = ab.getChildren();
					for(GeneralTree<Integer> child :children) {
						lista.add(child.getData());
						caminoAHojaMasLejana(child,altura-1,camino,lista);
						lista.remove(lista.size()-1);
					}
				}
					
			}
	}
	public GeneralTree<Integer> getAb() {
		return ab;
	}

	public void setAb(GeneralTree<Integer> ab) {
		this.ab = ab;
	}
}
