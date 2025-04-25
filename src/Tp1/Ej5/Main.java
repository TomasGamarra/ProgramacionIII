package Tp1.Ej5;


public class Main {

	public static void main(String[] args) {
		int [] arrayInt = {6,4,8,7,9,0};
		Calcular obj= new Calcular();
		int[] array=Calcular.metodoA(arrayInt);
		for(int elto: array)
			System.out.println(elto);
		Calcular.metodoB(arrayInt,obj);
		System.out.println(obj.toString());

	}

}
