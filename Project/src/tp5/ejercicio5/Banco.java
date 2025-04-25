package tp5.ejercicio5;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Tp1.Clases.Queue;

public class Banco {

    public List<Persona> bfs_devolverListaJubilados (Graph<Persona> grafo, Persona empleado, int distancia){
       List<Persona> lista = new LinkedList<>();
       Queue <Vertex<Persona>> cola = new Queue<>();
       boolean [] marca = new boolean [grafo.getSize()];
       Vertex<Persona> vertice = grafo.search(empleado);
       Vertex <Persona> aux;
       int nivel=0;
       cola.enqueue(vertice);
       marca[vertice.getPosition()]=true;
       cola.enqueue(null);
       while(!cola.isEmpty()) {
    	   	aux = cola.dequeue();
    	   	if(aux != null) {
    	   		if( nivel <=distancia ) {
    	   			lista.add(aux.getData());
    	   			for(Edge<Persona> edge : grafo.getEdges(aux)) {
    	   				if(!marca[edge.getTarget().getPosition()]) {
    	   					if(edge.getTarget().getData().isJubilado()) {
    	   						cola.enqueue(edge.getTarget());
    	   						marca[edge.getTarget().getPosition()]=true;
    	   						
    	   						}
    	   			}
    	   				}
    	   		}
    	   		
    	   	}else
    	   		if(!cola.isEmpty()) {
    	   			nivel++;
    	   			cola.enqueue(null);
    	   		}
       }
       lista.remove(0);
       return lista;
    } 


}
