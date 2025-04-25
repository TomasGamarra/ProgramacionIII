package Tp2.Ej4;

import Tp2.Ej1.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> ab;
	
	public RedBinariaLlena() {
		
	}
	public RedBinariaLlena(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	public int retardoReenvio() {
		return private_retardoReenvio(this.ab);
	}
	private  int private_retardoReenvio(BinaryTree<Integer> ab) {
		if(ab!=null) {
			int sum1 = ab.getData();
			int sum2= ab.getData();
			sum1+=private_retardoReenvio(ab.getLeftChild());	
			sum2+=private_retardoReenvio(ab.getRightChild());
			if(sum1>sum2)
				return sum1;
			else
				return sum2;
		}
		else
			return 0;
	}
	public BinaryTree<Integer> getArbol() {
		return ab;
	}
	public void setArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
}
