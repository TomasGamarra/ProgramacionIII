package Tp1.ej7hyj;

import java.util.ArrayList;

public class Ej7 {

	public static void main(String[] args) {
		ArrayList<Integer>lista=new ArrayList<>();
		for(String elto : args)
			lista.add(Integer.parseInt(elto));
		invertirArrayList(lista);
		for(Integer elto:lista)
			System.out.println(elto);
		ArrayList<Integer> lista2 = new ArrayList<>();
		ArrayList<Integer>listap=new ArrayList<>();
		listap.add(1);
		listap.add(2);
		listap.add(3);
		listap.add(4);
		lista2.add(0);
		lista2.add(4);
		lista2.add(7);
		lista2.add(10);
		ArrayList<Integer> lista3=combinarOrdenado(listap,lista2);
		System.out.println("Lista ordenada");
		for(Integer elto:lista3)
			System.out.println(elto);
	}
	public static  void invertirArrayList(ArrayList<Integer> lista) {
			if(lista.size()<=1)
				return;
			int n=lista.remove(0);
			invertirArrayList(lista);
			lista.add(n);
			return;
	}
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		ArrayList<Integer> lista3=new ArrayList<>();
		if(lista1.size()!= 0 && lista2.size()!=0 ) {
			int index1=0,index2=0;
			while (index1<lista1.size() && index2<lista2.size()) { //Aniado mientras haya en ambas 
				if(lista1.get(index1)<lista2.get(index2)) {
					lista3.add(lista1.get(index1));
					index1++;
				}
				else {
					lista3.add(lista2.get(index2));
					index2++;
				}		
			}
			while (index1 < lista1.size()) {
		        lista3.add(lista1.get(index1));
		        index1++;
		    }
			 while (index2 < lista2.size()) {
			        lista3.add(lista2.get(index2));
			        index2++;
			    }
			return lista3;
		}
			
		return lista3;
	}
}
