package tp5.ejercicio1;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio2.*;
import tp5.ejercicio3.Mapa;
public class MainDePrueba {
	
	public static void main (String[] args) {
	Graph<Integer> grafo = new AdjListGraph<Integer>();
	grafo.createVertex(1);
	grafo.createVertex(2);
	grafo.createVertex(3);
	grafo.createVertex(4);
	grafo.createVertex(5);
	grafo.connect(grafo.getVertex(0), grafo.getVertex(1));
	grafo.connect(grafo.getVertex(1), grafo.getVertex(2));
	grafo.connect(grafo.getVertex(0),grafo.getVertex(4));
	/*
	 *	(1) --- > (2) -----> (3)    (4) 
	 * 		\
	 	 	 \	
	 	     (5)
	 	 */		 	
	RecorridosGrafos<Integer> recorridos = new RecorridosGrafos<>();
	System.out.println(recorridos.dfs(grafo));
	System.out.println(recorridos.bfs(grafo));
	
	/* Busqueda de Mapa */
	
	System.out.println("Mapa de nodos:");
	Graph<String> grafoMapa = new AdjListGraph<String>();
	//Creo vertices del grafo
	Vertex<String> buenosAires = grafoMapa.createVertex("Buenos Aires");
	Vertex<String> santiago = grafoMapa.createVertex("Santiago");
	Vertex<String> asuncion = grafoMapa.createVertex("Asuncion");
	Vertex<String> caracas = grafoMapa.createVertex("Caracas");		
	Vertex<String> madrid = grafoMapa.createVertex("Madrid");
	Vertex<String> roma = grafoMapa.createVertex("Roma");
	
	
	
	//Conecto los nodos
//	grafoMapa.connect(map1, map2);//	Buenos Aires --> Santiago
//	grafoMapa.connect(map1, map3);//	Buenos Aires --> Asunción
//	grafoMapa.connect(map2, map6);//	Santiago 	 --> Roma
//	grafoMapa.connect(map3, map4);//	Asunción 	 --> Caracas
//	grafoMapa.connect(map3, map5);//	Asunción 	 --> Madrid
//	grafoMapa.connect(map4, map5);//	Caracas		 --> Madrid
//	grafoMapa.connect(map5, map6);//	Madrid		 --> Roma	
	
	//grafoMapa.connect(map5, map1);// 	Madrid 		 --> Buenos Aires
	//grafoMapa.connect(map6, map2); //	Roma 		 --> Santiago
	//grafoMapa.connect(map2, map1); 	//Santiago 	 --> Buenos Aires
	

	//Conecto nodo con peso
	grafoMapa.connect(buenosAires, santiago,5);//	Buenos Aires -(5)-> Santiago
	grafoMapa.connect(buenosAires, asuncion,3);//	Buenos Aires -(3)-> Asunción
	grafoMapa.connect(santiago, roma,12);	   //	Santiago 	 -(12)-> Roma
	grafoMapa.connect(asuncion, caracas,7);    //	Asunción 	 -(7)-> Caracas
	grafoMapa.connect(asuncion, madrid,10);    //	Asunción 	 -(10)-> Madrid
	grafoMapa.connect(caracas, madrid,10);    //	Caracas		 -(1)-> Madrid
	grafoMapa.connect(madrid, roma,3);        //	Madrid		 -(3)-> Roma	
	
	
	// Para imprimir los vértices y las aristas del grafo dirigido
	System.out.println("Conexiones del mapa:");
	for (Vertex <String> v : grafoMapa.getVertices()) {
	    System.out.println("Nodo: " + v.getData());
	    System.out.println("Aristas:");
	    for (Edge<String> edge : grafoMapa.getEdges(v)) {
	        System.out.println(v.getData() + " -> " + edge.getTarget().getData());
	    }
	}
	
	Mapa GrafoMapa = new Mapa(grafoMapa);
	
	 //DevolverCamino
	System.out.println("Devuelvo camino "+GrafoMapa.devolverCamino( "Buenos Aires","Roma"));
	//DevolverCaminoExceptuando
	List<String> exceptuar = new LinkedList<>();
	exceptuar.add("Asuncion");
	exceptuar.add("Caracas");
	System.out.println("Devuelvo camino exceptuando "+GrafoMapa.devolverCaminoExceptuando("Buenos Aires", "Roma",exceptuar));
	System.out.println("Devuelvo camino mas corto "+GrafoMapa.caminoMasCorto("Buenos Aires", "Madrid"));
	System.out.println("Camino sin cargar combustible  "+GrafoMapa.caminoSinCargarCombustible("Buenos Aires","Madrid", 10));
	System.out.println("Camino de menor recarga "+ GrafoMapa.caminoConMenorCargaDeCombustible("Buenos Aires", "Roma", 10));
	}
}
