package tp3.MainPrueba;
import tp3.GeneralTree.GeneralTree;
import tp3.RecorridosAG.RecorridosAG;
import tp3.ej11.ParcialEj11;
import tp3.ej4.AnalizadorArbol;
import tp3.ej6.RedDeAguaPotable;
import tp3.ej7.Caminos;
import tp3.ej9.ParcialEsDeSeleccion;
public class Main {
	public static void main (String [] args) {
        // Arbol para todo la demas
        GeneralTree<Integer> nodo1 = new GeneralTree<>(1);
        GeneralTree<Integer> nodo2 = new GeneralTree<>(2);
        GeneralTree<Integer> nodo3 = new GeneralTree<>(3);
        GeneralTree<Integer> nodo5 = new GeneralTree<>(5);
        GeneralTree<Integer> nodo7 = new GeneralTree<>(7);
        GeneralTree<Integer> nodo9 = new GeneralTree<>(9);
        GeneralTree<Integer> nodo4 = new GeneralTree<>(4);
        GeneralTree<Integer> nodo6=new GeneralTree<>(6);
        GeneralTree<Integer> nodo8 = new GeneralTree<>(8);
        GeneralTree<Integer> nodo10 = new GeneralTree<>(10);
		//Arbol para chequear si es de seleccion aca abajo
//		GeneralTree<Integer> nodo1 = new GeneralTree<>(12);
//        GeneralTree<Integer> nodo2 = new GeneralTree<>(25);
//        GeneralTree<Integer> nodo3 = new GeneralTree<>(12);
//        GeneralTree<Integer> nodo5 = new GeneralTree<>(25);
//        GeneralTree<Integer> nodo7 = new GeneralTree<>(12);
//        GeneralTree<Integer> nodo9 = new GeneralTree<>(29);
//        GeneralTree<Integer> nodo4 = new GeneralTree<>(34);
//        GeneralTree<Integer> nodo6=new GeneralTree<>(25);
//        GeneralTree<Integer> nodo8 = new GeneralTree<>(12);
//        GeneralTree<Integer> nodo10 = new GeneralTree<>(12);
        nodo8.addChild(nodo10);
        nodo7.addChild(nodo8);
        // Agregar hijos al nodo 2
        nodo5.addChild(nodo4);
        nodo5.addChild(nodo6);
        nodo2.addChild(nodo5);
        nodo2.addChild(nodo9);

        // Agregar hijos al nodo 3
        nodo3.addChild(nodo7);
        
        // Agregar hijos al nodo 1
        nodo1.addChild(nodo2);
        nodo1.addChild(nodo3);
        /* Arbol para todos los demas   
                  1    
                /   \
               2    3  
              / \   /
             5   9 7
     		/ \		\
		   4   6	 8
		   			/
		   		   10 
         
        Arbol para es de seleccion
                  12    
                /   \
               25   12  
              / \   /
             25 29 12
     		/ \		\
		   34  25	 12
		   			/
		   		   12 
         */
        System.out.println("---PreOrder---");
        nodo1.printPreOrder();
        System.out.println("---PostOrder");
        nodo1.printPostOrder();
        System.out.println("---PorNiveles---");
        nodo1.printPorNiveles();
        System.out.println("---InOrder---");
        nodo1.printInOrder();
        System.out.println(RecorridosAG.numerosImparesMayoresQuePreOrden(nodo1,2));
        System.out.println(RecorridosAG.numerosImparesMayoresQueInOrden(nodo1, 0));
        System.out.println(RecorridosAG.numerosImparesMayoresQuePostOrden(nodo1, 2));
        System.out.println(RecorridosAG.numerosImparesMayoresQuePorNiveles(nodo1, 2));
        System.out.println(nodo1.nivel(4));
        System.out.println("La altura es: "+nodo1.altura());
        System.out.println("El ancho es: " +nodo1.ancho());
        System.out.println("El maximo promedio entre los niveles es de: " + AnalizadorArbol.devolverMaximoPromedio(nodo1));
        System.out.println("Es ancestro 1 de 4 ? " + nodo1.esAncestro(1, 4));
        RedDeAguaPotable<Integer> red= new RedDeAguaPotable<>(nodo1);
        System.out.println("El minimo caudal de la red es : "+ red.minimoCaudal(1000));
        Caminos cam = new Caminos(nodo1);
        System.out.println(cam.caminoAHojaMasLejana());
        System.out.println(ParcialEsDeSeleccion.esDeSeleccion(nodo1));
        System.out.println("El arbol es creciente?"+ ParcialEj11.resolver(nodo1));
	}

}
