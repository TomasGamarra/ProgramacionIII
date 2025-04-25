package PracticaParcial;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree.GeneralTree;

public class EncontrarPrincesa {
	
	 
	public static List<Personaje> devolverListaPrincesa(GeneralTree<Personaje> ag){
		List<Personaje> lista = new LinkedList<>();
		List<Personaje> camino = new LinkedList<>();
		lista.add(ag.getData());
		private_princesa(ag,lista,camino);
		return camino;
	}
	
	private static void private_princesa (GeneralTree<Personaje> ag,List<Personaje> lista,List<Personaje> camino) {
		if(camino.isEmpty()) {
			if(ag.getData().esPrincesa()) {
				camino.addAll(lista);
			}else 
				if(ag.hasChildren()) {
					List<GeneralTree<Personaje>> children=ag.getChildren();
					for(GeneralTree<Personaje> child : children) {
						if(!child.getData().esDragon()) {
							lista.add(child.getData());
							private_princesa(child,lista,camino);
							lista.remove(lista.size()-1);
						}
					}
				}
			
			
		}
		
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public class Personaje {
		 private String nombre;
		 private String tipo;    //Dragon, Princesa, Animal, etc.
	public Personaje(String nombre, String tipo) {
		  this.nombre = nombre;
		  this.tipo = tipo;
		 }
		 public String getNombre() {
		  return nombre;
		 }
		 public void setNombre(String nombre) {
		  this.nombre = nombre;
		 }
		 public String getTipo() {
			 return tipo;
		 }
		 public void setTipo(String tipo) {
			 this.tipo=tipo;
		 }
		 public boolean esDragon(){
		  return this.getTipo().equals("Dragon");
		 }
		 public boolean esPrincesa(){
		  return this.getTipo().equals("Princesa");
		 }
		 }
}
