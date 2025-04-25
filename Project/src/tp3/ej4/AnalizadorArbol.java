package tp3.ej4;

import Tp1.Clases.Queue;
import tp3.GeneralTree.GeneralTree;

public class AnalizadorArbol {
	public static int devolverMaximoPromedio (GeneralTree<Integer> root) {
		//Recorrido por niveles 
		Queue <GeneralTree<Integer>> queue = new Queue<>();
		int max_Promedio =root.getData() , promedio_Ant=0,nodos=0;
		GeneralTree<Integer>aux= root;
		queue.enqueue(aux);
		queue.enqueue(null);
		while (!queue.isEmpty()) {
				aux=queue.dequeue();
				if(aux != null) {
						promedio_Ant+=aux.getData();
						nodos++;
						if(aux.hasChildren())
							for(GeneralTree<Integer> child : aux.getChildren())
								queue.enqueue(child);
				}
				else
					if(!queue.isEmpty()) {
						queue.enqueue(null);
						promedio_Ant=promedio_Ant/nodos;
						if(promedio_Ant >max_Promedio)
							max_Promedio=promedio_Ant;
						nodos=0;
						promedio_Ant=0;
					}
		}
	return max_Promedio;
	}
	
}
