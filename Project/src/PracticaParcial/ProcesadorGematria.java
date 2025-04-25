package PracticaParcial;

import java.util.List;

import tp3.GeneralTree.GeneralTree;

public class ProcesadorGematria {
	
	public int contar (GeneralTree<Integer> arbol, int valor) {
		Valores objeto = new Valores();
		private_contar(arbol,valor,0,objeto);
		return objeto.getCant();
	}
	
	private void private_contar (GeneralTree<Integer> arbol,int valor,int suma,Valores objeto) {
		if(arbol.hasChildren()) {
			List<GeneralTree<Integer>> children=arbol.getChildren();
			for(GeneralTree<Integer> child : children) {
				private_contar(child,valor,child.getData()+suma,objeto);
			}
		}else
			if(suma == valor) {
				objeto.setCant(objeto.getCant()+1);
			}
	}
	
	public int contarReturnInt(GeneralTree<Integer> arbol,int valor) {
		int sum=0;
		if (arbol.hasChildren()) {
			if( valor-arbol.getData() > 0) {
				List<GeneralTree<Integer>> children = arbol.getChildren();
				for (GeneralTree<Integer> child : children) 
					sum+=contarReturnInt(child,valor-arbol.getData());
				
			}
			return sum;
		}else
			if(0==valor-arbol.getData()) {
				return 1;
			}else
				return 0;
		
	}
	
	public class Valores {
		int cant=0;
		
	public void setCant(int cant) {
			this.cant=cant;
		}
	public int getCant() {
		return cant;
	}
	}
}
