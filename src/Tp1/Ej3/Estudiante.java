package Tp1.Ej3;

public class Estudiante {
	String nombre;
	String apellido;
	int comision;
	String email;
	int direccion;
	
	public Estudiante () {
		
	}
	public Estudiante (String nombre, String apellido, int comision, String email, int direccion){
		this.nombre = nombre;
		this.apellido = apellido;
		this.comision = comision;
		this.email = email;
		this.direccion = direccion;
		}
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
	public int getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDireccion() {
		return direccion;
	}
	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	public String tusDatos() {
		return "Nombre y Apellido: "+ this.getNombre() +" "+ this.getApellido()+"\n Comision: " + this.getComision() + "\n Email: " + this.getEmail() + "\n Direccion: "+ this.getDireccion();
	}
	
	@Override
	public boolean equals (Object o)
	{	boolean result=false;
		if((o!= null) && (o instanceof Estudiante)) {
			Estudiante est=(Estudiante)o;
			if((est.getApellido().equals(this.apellido) ) && (est.getComision()== this.comision)&&(est.getDireccion()==this.direccion)&&(est.getEmail().equals(this.email) )&&(est.getNombre().equals(this.nombre)))
				result=true;}
		return result;
	}
}
