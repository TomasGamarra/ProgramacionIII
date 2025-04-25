package tp5.ejercicio6;

import tp5.ejercicio1.AdjListGraph;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
public class CaperucitaPrueba {
public static void main (String[]args) {
	AdjListGraph<String> arbol = new AdjListGraph<String>();
	Vertex<String> casaCaperucita =arbol.createVertex("Casa Caperucita");
	Vertex<String> claro3=arbol.createVertex("Claro 3");
	Vertex<String> claro1=arbol.createVertex("Claro 1");
	Vertex<String> claro2=arbol.createVertex("Claro 2");
	Vertex<String> claro5=arbol.createVertex("Claro 5");
	Vertex<String> claro4=arbol.createVertex("Claro 4");
	Vertex<String> casaAbuelita=arbol.createVertex("Casa Abuelita");
	arbol.connectBoth(casaCaperucita,claro3,4);
	arbol.connectBoth(casaCaperucita, claro1, 3);
	arbol.connectBoth(casaCaperucita, claro2, 4);
	arbol.connectBoth(claro3, claro5, 15);
	arbol.connectBoth(claro1, claro5, 3);
	arbol.connectBoth(claro5, casaAbuelita, 4);
	arbol.connectBoth(claro1, claro2, 4);
	arbol.connectBoth(claro2, claro4, 10);
	arbol.connectBoth(claro2, claro5, 11);
	arbol.connectBoth(claro4, casaAbuelita, 9);
	BuscadorDeCaminos prueba = new BuscadorDeCaminos();
	prueba.setBosque(arbol);
	System.out.println(prueba.recorridosMasSeguro());
}
}
