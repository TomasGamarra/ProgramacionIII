package Tp2.Ej5;

import Tp2.Ej1.BinaryTree;
import Tp1.Clases.Queue;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> ab;
	
	public ProfundidadDeArbolBinario() {
		
	}
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	
	public int sumaElementosProfundidad (int depth) {
	     	 BinaryTree<Integer> ab = null;
	     	 int nivel=0,tot=0;
	     	 Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
	     	 cola.enqueue(this.ab);
	         cola.enqueue(null);
	     	 while (!cola.isEmpty() && (nivel<depth+1)) {
	     		 ab = cola.dequeue();
	     		 if (ab != null) {
	     			 if(nivel== depth) 
	     				 tot+=ab.getData();
	     			 if (ab.hasLeftChild()) 
	     				 cola.enqueue(ab.getLeftChild());
	     			 if (ab.hasRightChild()) 
	     				 cola.enqueue(ab.getRightChild());
	     			 
	     		 } else if (!cola.isEmpty()) {
	     			 cola.enqueue(null);
	     			 nivel++;
	     		 }
	     	 }
	    return tot;
		}
}
