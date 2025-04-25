package tp3.encontrarPrincesa;

public class Personaje {
	 private String nombre;
	 private String tipo; //Dragon, Princesa, Animal, etc.
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
	 public boolean esDragon(){
	 return this.getTipo().equals("Dragon");
	 }
	 public boolean esPrincesa(){
	 return this.getTipo().equals("Princesa");
	 }
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	}
