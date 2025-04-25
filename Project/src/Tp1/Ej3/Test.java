package Tp1.Ej3;

public class Test {

	public static void main(String[] args) {
		Estudiante [] arrayEstudiante =new Estudiante [2];
		arrayEstudiante[0]= new Estudiante();
		arrayEstudiante[1]= new Estudiante();
		arrayEstudiante[0].setApellido("Goncalves");
		arrayEstudiante[0].setNombre("Federico");
		arrayEstudiante[0].setComision(2);
		arrayEstudiante[0].setEmail("Caca@gmail");
		arrayEstudiante[0].setDireccion(123);
		arrayEstudiante[1].setApellido("Soto");
		arrayEstudiante[1].setNombre("Luciano");
		arrayEstudiante[1].setComision(3);
		arrayEstudiante[1].setEmail("Caca1234@gmail");
		arrayEstudiante[1].setDireccion(321);
		for(int i=0;i<=1;i++) {
			System.out.println(arrayEstudiante[i].tusDatos());
		}
	}

}
