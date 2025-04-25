package Tp2.Ej8;

import Tp2.Ej1.BinaryTree;

public class ParcialArboles {

public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
	if(arbol1 != null ) { 
		if(arbol2 != null) { 
			if(arbol1.getData() != arbol2.getData())
				return false;
			else {
				boolean resul1=true;
				boolean resul2=true;
				if(arbol1.hasLeftChild())
					resul1=esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild());
				if(arbol2.hasRightChild())
					resul2=esPrefijo(arbol1.getRightChild(),arbol2.getRightChild());

				return (resul1 && resul2);
			}

		}else
			return false;

	}else
		if(arbol2 == null)
			return true;
		else
			return false;


	}
}