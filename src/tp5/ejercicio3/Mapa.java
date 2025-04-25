package tp5.ejercicio3;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa {
	
	public Mapa(Graph<String> mapaCiudades) {
		this.mapaCiudades = mapaCiudades;
	}

	private Graph<String> mapaCiudades; 
	
	//Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso
	//de que se pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
	//DFS
	public List<String> devolverCamino (String ciudad1, String ciudad2){
		List<String> lista = new LinkedList<>();
		List<String> camino = new LinkedList<>();
		boolean [] marca = new boolean[mapaCiudades.getSize()];
		//Me falta chequear que ciudad1 y ciudad2 esten en el grafo para no recorrer al pedo!!!!
		dfs_devolverCamino(mapaCiudades.search(ciudad1).getPosition(),lista,camino,ciudad2,marca);
		return camino;
	}
	
	private void dfs_devolverCamino (int i,List<String> lista,List<String> camino ,String ciudad2,boolean[]marca) {
		if(camino.isEmpty()) {
			Vertex<String> vertice = mapaCiudades.getVertex(i);
			marca[i]=true;
			lista.add(vertice.getData());
		if(vertice.getData().equals(ciudad2))
			camino.addAll(lista);
		else
			for(Edge<String> edge : mapaCiudades.getEdges(vertice)) {
				int j= edge.getTarget().getPosition();
				if(camino.isEmpty())
				if(!marca[j]) {
					dfs_devolverCamino(j,lista,camino,ciudad2,marca);
					lista.remove(lista.size()-1);
				}
			}
		}
		
	}
	//Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por
	 //las ciudades que están contenidas en la lista ciudades pasada por parámetro, si no existe
	 //camino retorna la lista vacía. (Sin tener en cuenta el combustible).
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String>ciudades) {
		List<String> lista = new LinkedList<>();
		List<String> camino = new LinkedList<>();
		boolean [] marca = new boolean[mapaCiudades.getSize()];
		//Me falta chequear que ciudad1 y ciudad2 esten en el grafo para no recorrer al pedo!!!!
		dfs_devolverCaminoExceptuando(mapaCiudades.search(ciudad1).getPosition(),lista,camino,ciudad2,marca,ciudades);
		return camino;
	}
	 
	
	private void dfs_devolverCaminoExceptuando (int i,List<String> lista,List<String> camino ,String ciudad2,boolean[]marca,List<String> ciudades) {
		if(camino.isEmpty()) {
			Vertex<String> vertice = mapaCiudades.getVertex(i);
			marca[i]=true;
			lista.add(vertice.getData());
		if(vertice.getData().equals(ciudad2))
			camino.addAll(lista);
		else
			for(Edge<String> edge : mapaCiudades.getEdges(vertice)) {
				int j= edge.getTarget().getPosition();
				if(camino.isEmpty())
				if(!marca[j]) {
					if(!ciudades.contains(mapaCiudades.getVertex(j).getData()))	{						
					dfs_devolverCaminoExceptuando(j,lista,camino,ciudad2,marca,ciudades);
					lista.remove(lista.size()-1);}
				}
			}
		}
		
	}
	
	 //Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a
	 //ciudad2, si no existe camino retorna la lista vacía. (Las rutas poseen la distancia).
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> lista = new LinkedList<>();
		List<String> camino = new LinkedList<>();
		boolean [] marca = new boolean [mapaCiudades.getSize()];
		System.out.println("El valor del camino mas corto es:"+dfs_caminoMasCorto(mapaCiudades.search(ciudad1).getPosition(),ciudad2,lista,camino,Integer.MAX_VALUE,0,marca));
		return camino;
	
	}
	
	private int dfs_caminoMasCorto (int i,String ciudad2,List<String> lista,List<String> camino,int min,int peso,boolean [] marca) {
		Vertex<String> vertice = mapaCiudades.getVertex(i);
		lista.add(vertice.getData());
		marca[i]=true;
		if(vertice.getData().equals(ciudad2) && peso < min) {
			camino.clear();
			camino.addAll(lista);
			marca[i]=false;
			return peso;
		}
		int min2;
		for(Edge<String> edge : mapaCiudades.getEdges(vertice)) {
				min2 = dfs_caminoMasCorto(edge.getTarget().getPosition(),ciudad2,lista,camino,min,edge.getWeight()+peso,marca);
				if(min2 < min) 
					min=min2;
				lista.remove(lista.size()-1);
		}
		marca[i]=false;
		return min;
	}
	
//	 Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El
//	 auto no debe quedarse sin combustible y no puede cargar. Si no existe camino retorna la
//	 lista vacía.
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> lista = new LinkedList<>();
		List<String> camino = new LinkedList<>();
		boolean[] marca = new boolean[mapaCiudades.getSize()];
		dfs_caminoSinCargarCombustible(mapaCiudades.search(ciudad1).getPosition(),ciudad2,tanqueAuto,lista,camino,marca);
		return camino;
	}
	
	private void dfs_caminoSinCargarCombustible (int index,String ciudad2,int combustible,List<String>lista,List<String> camino,boolean[] marca) {
		if(camino.isEmpty()) { //Aca o sino donde seria mas eficiente ?
			Vertex<String> vertice = mapaCiudades.getVertex(index);
			marca[index] = true;
			lista.add(vertice.getData());
			if(vertice.getData().equals(ciudad2))
				camino.addAll(lista);
			for(Edge<String> edge : mapaCiudades.getEdges(vertice)) {
					int nuevoCombustible = combustible - edge.getWeight();
					if(!(nuevoCombustible < 0)) {
						dfs_caminoSinCargarCombustible(edge.getTarget().getPosition(),ciudad2,nuevoCombustible,lista,camino,marca);
						lista.remove(lista.size()-1);
						}
			}
			marca[index]=false;
		}
	}
//	 Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2
//	 teniendo en cuenta que el auto debe cargar la menor cantidad de veces. El auto no se
//	 debe quedar sin combustible en medio de una ruta, además puede completar su tanque al
//	 llegar a cualquier ciudad. Si no existe camino retorna la lista vacía
	public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto) {
		  List<String> lista = new LinkedList<>();
		  List<String> camino = new LinkedList<>();
		  boolean [] marca = new boolean[mapaCiudades.getSize()];
		  if(mapaCiudades.search(ciudad1) != null && mapaCiudades.search(ciudad2) != null)
			  dfs_caminoConMenorCargaDeCombustible(mapaCiudades.search(ciudad1).getPosition(),ciudad2,tanqueAuto,lista,camino,Integer.MAX_VALUE,marca,tanqueAuto,0);
		  return camino;
	}
	
	private int dfs_caminoConMenorCargaDeCombustible (int index ,String ciudad2,int combustible,List<String> lista , List<String> camino,int min,boolean [] marca,int maximoTanque,int cantRecargas) {
		Vertex<String> vertice = mapaCiudades.getVertex(index);
		lista.add(vertice.getData());
		if(vertice.getData().equals(ciudad2) && cantRecargas < min) {
			camino.clear();
			camino.addAll(lista);
			return cantRecargas;
		}
		marca[index] =true;
		int recargas,combustibleActual;
		for(Edge<String> edge : mapaCiudades.getEdges(vertice)) {
			if(!marca[edge.getTarget().getPosition()]) {
			if(edge.getWeight() <= maximoTanque) {
				if(combustible - edge.getWeight() < 0 ) {
					combustibleActual=maximoTanque;
					cantRecargas++;
				}
				combustibleActual=combustible - edge.getWeight();
				recargas=dfs_caminoConMenorCargaDeCombustible(edge.getTarget().getPosition(),ciudad2, combustibleActual,lista,camino,min,marca,maximoTanque,cantRecargas);
				lista.remove(lista.size()-1);
				if(recargas < min)
					min=recargas;
					}
				}
			}
		marca[index]=false;
		return min;
		
	}

		
	
	 
}
