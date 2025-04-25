package Tp2.Ej3;
import java.util.LinkedList;

import Tp2.Ej1.*;
public class ContadorArbol {
	private BinaryTree<Integer> ab;
	
	public ContadorArbol() {
		
	}
	public ContadorArbol(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	public LinkedList<Integer> numerosParesInOrder(){
		LinkedList<Integer> lista = new LinkedList<Integer>();
		helperInOrder(ab,lista);
		return lista;
	}
	private void helperInOrder(BinaryTree<Integer>root,LinkedList<Integer> lista){
		if(root!=null) {
			helperInOrder(root.getLeftChild(),lista);
			if(root.getData() % 2==0)
				lista.add(root.getData());
			helperInOrder(root.getRightChild(),lista);
			}
			
	}
	public BinaryTree<Integer> getArbol() {
		return ab;
	}
	public void setArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
}
