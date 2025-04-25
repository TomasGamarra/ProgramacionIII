package Tp1.Ej3;

public class Profesor {
	String nombre;
	String apellido;
	String email;
	int catedra ;
	String facultad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCatedra() {
		return catedra;
	}
	public void setCatedra(int catedra) {
		this.catedra = catedra;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String tusDatos() {
		return "Nombre y Apellido: "+ this.getNombre() +" "+ this.getApellido()+"\n Facultad: " + this.getFacultad() + "\n Email: " + this.getEmail() + "\n Catedra: "+ this.getCatedra();
	}
}
