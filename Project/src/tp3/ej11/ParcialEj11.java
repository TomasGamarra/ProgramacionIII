package tp3.ej11;

import java.util.List;

import Tp1.Clases.Queue;
import tp3.GeneralTree.GeneralTree;

public class ParcialEj11 {

	 public static boolean resolver(GeneralTree<Integer> arbol) {
		 //Recorrido por niveles
		 GeneralTree<Integer> aux;
		 int nodosNivel =0,nodosSup=1;
		 Queue<GeneralTree<Integer>> cola = new Queue<>();
		 cola.enqueue(arbol);
		 cola.enqueue(null);
		 while (!cola.isEmpty()) {
			 aux=cola.dequeue();
			 if(aux != null) {
				 if(aux.hasChildren()) {
					 List<GeneralTree<Integer>> children =aux.getChildren();
					 nodosNivel+=children.size();
					 for (GeneralTree<Integer> child :children) 
						 cola.enqueue(child);
						 
				 }
			 }
			 else {
				 if(!cola.isEmpty()) {
					 if(nodosNivel!=++nodosSup)
						 return false;
					 nodosNivel=0;
					 cola.enqueue(null);
				 }
				 
			 }	 
		 }
		 return true;
	 }
	 
	 
}
