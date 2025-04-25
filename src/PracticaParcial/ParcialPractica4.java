package PracticaParcial;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree.GeneralTree;

public class ParcialPractica4 {
	
	public static void main (String [] args) {
		GeneralTree<Boolean> n0 = new GeneralTree<>(true);

        GeneralTree<Boolean> n1 = new GeneralTree<>(false);
        GeneralTree<Boolean> n2 = new GeneralTree<>(true);
        GeneralTree<Boolean> n3 = new GeneralTree<>(false);

        GeneralTree<Boolean> n4 = new GeneralTree<>(true);
        GeneralTree<Boolean> n5 = new GeneralTree<>(false);
        GeneralTree<Boolean> n6 = new GeneralTree<>(true);
        GeneralTree<Boolean> n7 = new GeneralTree<>(true);

        GeneralTree<Boolean> n8 = new GeneralTree<>(true);
        GeneralTree<Boolean> n9 = new GeneralTree<>(true);

        // Building the tree structure
        n0.addChild(n1);
        n0.addChild(n2);
        n0.addChild(n3);

        n1.addChild(n4);
        n1.addChild(n5);

        n3.addChild(n6);
        n3.addChild(n7);

        n5.addChild(n8);
        n5.addChild(n9);
        System.out.println(resolver(n0));
	}
	
	public static List<Integer> resolver (GeneralTree<Boolean> ag){
		List<Integer> lista= new LinkedList<>();
		private_resolver(ag,0,lista);
		return lista;
	}
	
	private static boolean private_resolver(GeneralTree<Boolean> arbol,int nivel,List<Integer> lista) {
		if(arbol.isLeaf())
			return arbol.getData();
		List<GeneralTree<Boolean>> children = arbol.getChildren();
		boolean resul=true;
		for(GeneralTree<Boolean> child :children) {
			if(!private_resolver(child,nivel+1,lista))
				resul=false;
		}
		if(arbol.getData()==false && resul) {
				lista.add(nivel);
				return false;
			}
		return resul && arbol.getData();
	
	}
}
