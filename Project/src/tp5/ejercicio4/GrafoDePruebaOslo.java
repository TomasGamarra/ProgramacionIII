package tp5.ejercicio4;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.AdjListGraph;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class GrafoDePruebaOslo {

public static void main(String[] args) {

System.out.println("Mapa de nodos:");
Graph<String> grafoOslo = new AdjListGraph<String>();
//Creo vertices del grafo
Vertex<String> ayun = grafoOslo.createVertex("Ayuntamiento");
Vertex<String> tigre = grafoOslo.createVertex("El Tigre");
Vertex<String> munch = grafoOslo.createVertex("Museo Munch");
Vertex<String> opera = grafoOslo.createVertex("La Opera");
Vertex<String> fort = grafoOslo.createVertex("Fortaleza Akershus");
Vertex<String> botanico = grafoOslo.createVertex("Parque Botánico");
Vertex<String> galeria = grafoOslo.createVertex("Galería Nacional");
Vertex<String> vigeland = grafoOslo.createVertex("Parque Vigeland");
Vertex<String> holm = grafoOslo.createVertex("Holmenkollen");
Vertex<String> folk = grafoOslo.createVertex("FolkMuseum");
Vertex<String> palacio = grafoOslo.createVertex("Palacio Real");
Vertex<String> akker = grafoOslo.createVertex("Akker Brigge");
Vertex<String> vikingo = grafoOslo.createVertex("Museo Vikingo");
Vertex<String> fram = grafoOslo.createVertex("Museo Fram");
Vertex<String> barco= grafoOslo.createVertex("Museo del Barco Polar");
//---------------------------------------------
//----------Ayuntamiento
grafoOslo.connect(ayun,tigre,15); //Ayuntamiento -> El Tigre
grafoOslo.connect(tigre,ayun,15); //El Tigre -> Ayuntamiento

grafoOslo.connect(ayun,botanico,10); //Ayuntamiento -> Parque Botánico
grafoOslo.connect(botanico,ayun,10); //Parque Botánico -> Ayuntamiento

grafoOslo.connect(ayun,palacio,5); //Ayuntamiento -> Palacio Real
grafoOslo.connect(palacio,ayun,5); //Palacio Real -> Ayuntamiento

grafoOslo.connect(ayun,akker,20); //Ayuntamiento -> Akker Brigge
grafoOslo.connect(akker,ayun,20); //Akker Brigge -> Ayuntamiento
//----------El Tigre

grafoOslo.connect(tigre,opera,5); //El Tigre -> La Opera
grafoOslo.connect(opera,tigre,5); //La Opera -> El TIgre

grafoOslo.connect(tigre,munch,15); //El Tigre -> Museo Munch
grafoOslo.connect(munch,tigre,15); //Museo Munch -> El Tigre
//----------La Opera
grafoOslo.connect(opera,fort,10); //La Opera -> Fortaleza Akershus
grafoOslo.connect(fort,opera,10); //Fortaleza Akershus -> La Opera
//----------Museo Munch
grafoOslo.connect(munch,botanico,1); //Museo Munch -> Parque Botánico
grafoOslo.connect(botanico,munch,1); //Parque Botánico -> Museo Munch
//-----------Parque Botanico
grafoOslo.connect(botanico,galeria,15); //Parque Botánico -> Galería Nacional
grafoOslo.connect(galeria,botanico,15); //Galería Nacional -> Parque Botánico
//-----------Galería Nacional
grafoOslo.connect(galeria,vigeland,10); //Galería Nacional -> Parque Vigeland
grafoOslo.connect(vigeland,galeria,10); //Parque Vigeland -> Galería Nacional
//-----------Parque Vigeland
grafoOslo.connect(vigeland,holm,30); //Parque Vigeland -> Holmenkollen
grafoOslo.connect(holm,vigeland,30); //Holmenkollen -> Parque Vigeland

grafoOslo.connect(vigeland,folk,20); //Parque Vigeland -> FolkMuseum
grafoOslo.connect(folk,vigeland,20); //FolkMuseum ->Parque Vigeland
//-----------FolkMuseum
grafoOslo.connect(folk,palacio,5); //FolkMuseum -> Palacio Real
grafoOslo.connect(palacio,folk,5); //Palacio Real -> FolkMuseum

grafoOslo.connect(folk,akker,30); //FolkMuseum -> Akker Brigge
grafoOslo.connect(akker,folk,30); //Akker Brigge -> FolkMuseum

grafoOslo.connect(folk,fram,5); //FolkMuseum -> Museo Fram
grafoOslo.connect(fram,folk,5); //Museo Fram -> FolkMuseum
//----------Museo Fram
grafoOslo.connect(fram,barco,5); //Museo Fram -> Museo del Barco Polar
grafoOslo.connect(barco,fram,5); //Museo del Barco Polar -> Museo Fram
//----------Museo del Barco Polar
grafoOslo.connect(barco,vikingo,5); //Museo del Barco Polar -> Museo Vikjngo
grafoOslo.connect(vikingo,barco,5); //Museo Vikingo -> Museo del Barco Polar
//----------Museo Vikingo
grafoOslo.connect(vikingo,akker,30); //Museo Vikingo -> Akker Brigge
grafoOslo.connect(akker,vikingo,30); //Akker Brigge -> Museo Vikingo 

//---------------------------------------------------
VisitaOslo prueba = new VisitaOslo();
List <String> restringidos = new LinkedList<>();
restringidos.add("Akker Brigge");
restringidos.add("Palacio Real");
System.out.println("Paseo en bici" + prueba.paseoEnBici(grafoOslo,"Museo Vikingo", 120,restringidos ));
}

}