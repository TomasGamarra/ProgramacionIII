package Tp1.Ej7dye;
import Tp1.Ej3.Estudiante;
import java.util.*;
public class Main {
public static void main(String[] args) {
	List<Estudiante> list = new LinkedList <>();
	list.add(new Estudiante ("Federico","Goncalves",8,"cag@gmail",1980));
	list.add(new Estudiante ("Baltazar","Patane",10,"cabc@gmail123",1982)); //Agrego elementos a list
	list.add(new Estudiante ("Luciano","Soto",9,"pepe@gmail",1981));
	List<Estudiante> list2 = new LinkedList<>(list); // Copio listas por parametro
	//List list2 = new LinkedList<>();
	// list2.addAll(list); //El addAll tecnicamente tambien copia referencias ya que ambos se modifican
	//List list2 = (LinkedList) list.clone(); //No me encuentra el method clone en superclases
	Iterator<Estudiante> it= list.iterator();
	Iterator<Estudiante> it2= list2.iterator();//Genero iteradores para ambas para imprimir
	list.get(1).setNombre("Nico");
	list2.get(2).setNombre("Facu"); //Las listas al copiarlas por parametro tienen la misma direc de memoria
	while (it.hasNext()) {
		System.out.println(it.next().tusDatos());
		System.out.println(it2.next().tusDatos());

	}
	Estudiante prueba = new Estudiante ("Federico","Goncalves",8,"cag@gmail",1980);
	System.out.println("The index of Facu is : " + list.indexOf(prueba));

	}
}
