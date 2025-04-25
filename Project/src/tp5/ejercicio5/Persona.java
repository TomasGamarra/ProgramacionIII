package tp5.ejercicio5;
public class Persona {
    private boolean jubilado;
    private String nombre;
    public Persona(String nombre,boolean jubilado) {
        this.nombre=nombre;
        this.jubilado = jubilado;
    }

    public boolean isJubilado() {
        return jubilado;
    }

    public void setJubilado(boolean jubilado) {
        this.jubilado = jubilado;
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public void setNombre(String nombre) {
    	this.nombre=nombre;
    }

    @Override
    public String toString () {
    	return nombre;
    }

}