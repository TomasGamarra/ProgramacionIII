package tp5.ejercicio2;

import java.util.LinkedList;
import java.util.List;

import Tp1.Clases.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class RecorridosGrafos<T> {
	// Retorna una lista de vértices con el recorrido en profundidad del grafo recibido como parámetro.
	public List<T> dfs(Graph<T> grafo){
		boolean [] marca = new boolean[grafo.getSize()];
		List<T> lista = new LinkedList<T>();
		for (int i=0 ; i< grafo.getSize();i++) {
			if(!marca[i])
				dfs(i,grafo,lista,marca);
		}
		return lista;
		
	}
	
	private void dfs (int i,Graph<T> grafo,List<T> lista,boolean [] marca) {
		Vertex <T> vertice = grafo.getVertex(i);
		marca[i]=true;
		lista.add(vertice.getData());
		for(Edge<T> edge : grafo.getEdges(vertice)) {
			if(!marca[edge.getTarget().getPosition()])
				dfs(edge.getTarget().getPosition(),grafo,lista,marca);
		}
	}
	// Retorna una lista de vértices con el recorrido en amplitud del grafo recibido como parámetro.
	public List<T> bfs(Graph<T> grafo){
		List<T> lista = new LinkedList<>();
		boolean[] visitados = new boolean[grafo.getSize()];
		for(int i=0;i<grafo.getVertices().size();i++) {
			if(!visitados[i])
				bfs(i,grafo,visitados,lista);
		}
		return lista;
	}
	private void bfs(int i,Graph<T> grafo,boolean[] visitados,List<T> lista){
		Queue<Vertex<T>> cola = new Queue<>();
		cola.enqueue(grafo.getVertex(i));
		while (!cola.isEmpty()) {
			Vertex<T> vertice =cola.dequeue();
			visitados[vertice.getPosition()]=true;
			lista.add(vertice.getData());
			for(Edge<T> edge : grafo.getEdges(vertice)) {
				int j = edge.getTarget().getPosition();
				if(!visitados[j]) {
					visitados[j]=true;
					cola.enqueue(edge.getTarget());}
			}
		}
		
	}
	 
	
	 
}
