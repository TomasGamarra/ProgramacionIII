package tp5.ejercicio6;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class BuscadorDeCaminos {
	Graph<String> bosque;

	public Graph<String> getBosque() {
		return bosque;
	}

	public void setBosque(Graph<String> bosque) {
		this.bosque = bosque;
	}
	
	public List<List<String>> recorridosMasSeguro(){
		List<List<String>> caminos = new LinkedList<>();
		List<String> lista = new LinkedList<>();
		Vertex<String> casaCaperucita = bosque.search("Casa Caperucita");
		boolean [] marca = new boolean[bosque.getSize()];
		if(casaCaperucita != null && bosque.search("Casa Abuelita")!= null)
			dfs_recorridosMasSeguro(casaCaperucita.getPosition(),5,lista,caminos,marca);
		return caminos;
	}
	
	private void dfs_recorridosMasSeguro (int index ,int frutalesMax,List<String> lista , List<List<String>> caminos,boolean [] marca) { 
		Vertex<String> vertice = bosque.getVertex(index);
		String data = vertice.getData();
		lista.add(data);
		if(data.equals("Casa Abuelita")) {
			List<String> camino = new LinkedList<String>();
			camino.addAll(lista);
			caminos.add(camino);
			return ;
		}
		marca[index]=true;
		List<Edge<String>> adys = bosque.getEdges(vertice);
		for(Edge<String> edge :adys) {
			if(!marca[edge.getTarget().getPosition()]) {
				if(edge.getWeight() < 5) {
					dfs_recorridosMasSeguro(edge.getTarget().getPosition(),frutalesMax,lista,caminos,marca);
					lista.remove(lista.size()-1);
				}
			}
		}
		marca [index]=false;
			
	}
}
