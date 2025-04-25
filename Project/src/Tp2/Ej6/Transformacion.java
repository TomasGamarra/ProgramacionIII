package Tp2.Ej6;

import Tp2.Ej1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> ab;
	
	public Transformacion() {
	
	}
	
	public Transformacion(BinaryTree<Integer> ab) {
		this.ab=ab;
	}
	
	public BinaryTree<Integer> getArbol() {
		return ab;
	}

	public void setArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<Integer> suma(){
		BinaryTree<Integer> aux = new BinaryTree<Integer>();//Creo una copia donde guardar el nuevo arbol
		private_suma(aux,this.ab); //Helper
		return aux;
	}
	
	private void private_suma (BinaryTree<Integer> root,BinaryTree<Integer> ab){ 
		root.setData(sumaHijos(ab)-ab.getData()); //Guardo la suma de los hijos
		if(ab.hasLeftChild()) {
			root.addLeftChild(new BinaryTree<Integer>()); //Creo una instancia para que no me de NullExceptionPointer
			private_suma(root.getLeftChild(),ab.getLeftChild()); //Recursividad con hijoIzq
			}
		if(ab.hasRightChild()) {
			root.addRightChild(new BinaryTree<Integer>()); //Creo una instancia para que no me de NullExceptionPointer
			private_suma(root.getRightChild(),ab.getRightChild());//Recursividad con hijoDer
		}
			}
		
	
	
	private int sumaHijos(BinaryTree<Integer> ab) {
		    if (ab == null) { //Si es null no tengo nada que sumar
		        return 0;
		    } else {
		        int sumaIzquierda = sumaHijos(ab.getLeftChild()); //Recursividad
		        int sumaDerecha = sumaHijos(ab.getRightChild());//Recursividad
		        return sumaIzquierda + sumaDerecha + ab.getData();
		    }
		}
}
