package tp5.ejercicio4;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class VisitaOslo {

	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
		List<String> lista = new LinkedList<String>();
		List<String> camino = new LinkedList<String>();
		boolean [] marca = new boolean[lugares.getSize()];
		Vertex<String> ayuntamiento=lugares.search("Ayuntamiento");
		if( ayuntamiento != null && lugares.search(destino) != null)
			dfs_paseoEnBici(ayuntamiento.getPosition(),lugares,destino,maxTiempo,lugaresRestringidos,marca,lista,camino);
		return camino;
	}
	
	private void dfs_paseoEnBici (int position ,Graph<String> grafo,String destino,int tiempo,List<String> restringidos,boolean [] marca,List<String>lista,List<String> camino) {
		Vertex<String> vertice = grafo.getVertex(position);
		lista.add(vertice.getData());
		if(vertice.getData().equals(destino)) {
			camino.addAll(lista);
			return;
		}
		//Podria haber un else aca , un if(camino.isEmpty())
		marca[position]=true;
		List<Edge<String>> adys = grafo.getEdges(vertice);
		for(Edge<String> edge :adys) {
			if(camino.isEmpty()) {
				if(!marca[edge.getTarget().getPosition()]) {
					if(!( restringidos.contains(edge.getTarget().getData()) )){
						int tiempoAux = tiempo - edge.getWeight();
						if(tiempoAux > 0) { //Mayor o igual aca ? eso que hago en el 2do if para ser mas "eficiente" realmente importa?
							dfs_paseoEnBici(edge.getTarget().getPosition(),grafo,destino,tiempoAux,restringidos,marca,lista,camino);
							lista.remove(lista.size()-1);
						}
						if(tiempoAux == 0 && edge.getTarget().getData().equals(destino)) {
							dfs_paseoEnBici(edge.getTarget().getPosition(),grafo,destino,tiempoAux,restringidos,marca,lista,camino);
							lista.remove(lista.size()-1);
						}
					}	
				}
			}
		}
	   marca[position]=false;
	}
}
