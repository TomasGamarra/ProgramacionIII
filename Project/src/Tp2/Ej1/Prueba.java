package Tp2.Ej1;
import java.util.LinkedList;

import Tp2.Ej3.ContadorArbol;
import Tp2.Ej4.RedBinariaLlena;
import Tp2.Ej5.ProfundidadDeArbolBinario;
import Tp2.Ej6.Transformacion;
import Tp2.Ej7.ParcialArboles;

public class Prueba {
	    public static void main(String[] args) {
	        BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
	        BinaryTree<Integer> hijoIzq = new BinaryTree<Integer>(2);
	        hijoIzq.addLeftChild(new BinaryTree<Integer>(4));
	        hijoIzq.addRightChild(new BinaryTree<Integer>(5));
	        BinaryTree<Integer> hijoDer=new BinaryTree<Integer>(3);
	        hijoDer.addLeftChild(new BinaryTree<Integer>(6));
	        ab.addLeftChild(hijoIzq);
	        ab.addRightChild(hijoDer);
	        System.out.println("Arbol Inicial :");
	        ab.printLevelTraversal();
	        ab=ab.espejo();
	        System.out.println("\nArbol espejo : ");
	        ab.printLevelTraversal();
	        System.out.print("\nHojas :");
	        System.out.print(ab.contarHojas());
	        //ab.printLevelTraversal();
	        System.out.println("\nEntre niveles 1 y 2: ");
	        ab.entreNiveles(1, 2);
	        ContadorArbol cont=new ContadorArbol(ab);
	        LinkedList<Integer> lcont = cont.numerosParesInOrder();
	        System.out.println("\nLista Enlazada con nros pares: ");
	        System.out.println(lcont.toString());
	        System.out.println("Retardo de envio max:");
	        System.out.println(new RedBinariaLlena(ab).retardoReenvio());
	        System.out.println("La suma de los elementos de la profundidad elegida es de: "+new ProfundidadDeArbolBinario(ab).sumaElementosProfundidad(1));
	        Transformacion tran = new Transformacion(ab);
	        BinaryTree<Integer> abTransformado = tran.suma(); 
	        System.out.println("El arbol luego de la transformacion es: ");
	        abTransformado.printLevelTraversal();
	        ParcialArboles prueba = new ParcialArboles(ab);
	        System.out.println(prueba.isLeftTree(4));
	    }
}

