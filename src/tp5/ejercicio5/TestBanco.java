package tp5.ejercicio5;

import tp5.ejercicio1.AdjListGraph;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class TestBanco {

    public static void main(String[] args) {

        AdjListGraph<Persona> grafo = new AdjListGraph<Persona>();

        Vertex<Persona> emp1 = grafo.createVertex(new Persona ("Fausto",false));
        Vertex<Persona> emp2 = grafo.createVertex(new Persona("Alber",false));
        Vertex<Persona> j1 = grafo.createVertex(new Persona ("Carlos",true));
        Vertex<Persona> j2 = grafo.createVertex(new Persona ("Fede",true));
        Vertex<Persona> j3 = grafo.createVertex(new Persona ("Octa",true));
        Vertex<Persona> j4 = grafo.createVertex(new Persona ("Joaco",true));
        Vertex<Persona> j5 = grafo.createVertex(new Persona ("Blas",true));
        Vertex<Persona> j6 = grafo.createVertex(new Persona ("Lucho",true));
        Vertex<Persona> j7 = grafo.createVertex(new Persona ("Santi",true));

        grafo.connectBoth(emp1, j1);
        grafo.connectBoth(emp1, j2);
        grafo.connectBoth(emp1, j3);
        grafo.connectBoth(emp1, j4);
        grafo.connectBoth(emp1, emp2);
        grafo.connectBoth(emp2, j5);
        grafo.connectBoth(j1, j6);
        grafo.connectBoth(j6, j7);
        
        Banco prueba = new Banco();
        System.out.println(prueba.bfs_devolverListaJubilados(grafo, emp1.getData(), 2));
    }

}
