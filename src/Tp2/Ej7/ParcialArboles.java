package Tp2.Ej7;

import Tp2.Ej1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> ab; //No repetidos
	
	public ParcialArboles(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> nodo = buscarNodo(num,this.ab);
		if(nodo == null)
			return false;
		else {
			int subIzq=0,subDer=0;
			if(nodo.hasLeftChild())
				subIzq=chequeo(nodo.getLeftChild());
				else
					subIzq=-1;
			if(nodo.hasRightChild())
				subDer=chequeo(nodo.getRightChild());
				else
					subDer=-1;
			if(subIzq > subDer)
				return true;
				else
					return false;
			
			}
	}
	
	private BinaryTree<Integer> buscarNodo (int num,BinaryTree<Integer> root){
		BinaryTree<Integer> a = new BinaryTree<Integer>();
		BinaryTree<Integer> b= new BinaryTree<Integer>();
		if(root != null) {
			if(root.getData()==num)
				return root; 
			else{
				if(root.hasLeftChild())
					a=buscarNodo(num,root.getLeftChild());
				if(root.hasRightChild())
					b=buscarNodo(num,root.getRightChild());
			}
			if ((a == null) && (b==null))
				return null;
			else 
				if(a != null)
					return a;
				else
					return b;
		} 
		else
			return null;
	}
	
	private int chequeo (BinaryTree<Integer> root) {
		if(root.isLeaf())
			return 0;
		if( root.hasLeftChild() && !(root.hasRightChild()) )	
			return chequeo(root.getLeftChild()) +1 ;
		else
			if( root.hasRightChild() && !(root.hasLeftChild()) )
				return chequeo(root.getRightChild()) + 1;
			else { //TIENE 2 HIJOS , RECORRO POR AMBOS LADOS
				return chequeo(root.getLeftChild()) + chequeo(root.getRightChild());
			}
			
		
	}
}	

