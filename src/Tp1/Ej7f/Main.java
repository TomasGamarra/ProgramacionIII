package Tp1.Ej7f;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		ArrayList<Integer>lista=new ArrayList<>();
		for(String elto : args)
			lista.add(Integer.parseInt(elto));
		System.out.println(esCapicua(lista));

	}
	
	public static boolean esCapicua(ArrayList<Integer> lista) {
		int fin= lista.size()-1,pri=0;
				boolean resul=true;
		while(fin>= pri) {
			if(!(lista.get(fin)==lista.get(pri)))
					resul=false;
			fin--;pri++;
		}
		return resul;
	}

}
