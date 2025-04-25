package Tp2.Ej9;

import Tp2.Ej1.BinaryTree;

public class ParcialArboles {

	public BinaryTree<Objeto> sumAndDif(BinaryTree<Integer> arbol){
		if(arbol==null || arbol.isEmpty())
			return null;
		return private_sumAndDif(arbol,0,0); //Arbol original,suma,nodoAnt
		
		
		
	}
	
	private BinaryTree<Objeto> private_sumAndDif(BinaryTree<Integer> root,int suma,int nodoAnt){
		Objeto valores = new Objeto(suma + root.getData(),root.getData() - nodoAnt);
		BinaryTree<Objeto> aux= new BinaryTree<Objeto>(valores);
		if(root.hasLeftChild())
			aux.addLeftChild(private_sumAndDif(root.getLeftChild(),suma + root.getData(),root.getData()));
		if(root.hasRightChild())
			aux.addRightChild(private_sumAndDif(root.getRightChild(),suma + root.getData(),root.getData()));
		return aux;

		
	}
	
	
	
	
	
}
