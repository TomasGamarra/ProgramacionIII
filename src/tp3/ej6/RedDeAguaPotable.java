package tp3.ej6;

import java.util.List;

import tp3.GeneralTree.GeneralTree;

public class RedDeAguaPotable<T> {
	private GeneralTree<T> ab;
	
	public RedDeAguaPotable(GeneralTree<T> ab) {
		setAb(ab);
	}
	public RedDeAguaPotable() {

	}
	public GeneralTree<T> getAb() {
		return ab;
	}

	public void setAb(GeneralTree<T> ab) {
		this.ab = ab;
	}
	//Que calcule el caudal de cada nodo y determine cuál es el caudal mínimo que recibe una casa. Asuma
	//que la estructura de caños de la red está representada por una variable de instancia de la clase
	//RedAguaPotable y que es un GeneralTree.
	public double minimoCaudal(double caudal) {
		return private_minimoCaudal(this.getAb(),caudal);
		
	}
	
	private double private_minimoCaudal(GeneralTree<T> ab,double caudal) {
		//Recorrer y calcular el minimo para devolverlo
		double min = caudal ,min2;
		if(ab.hasChildren()) {
			List<GeneralTree<T>> children = ab.getChildren();
			for (int i=0;i<children.size();i++) {
				min2=private_minimoCaudal(children.get(i),caudal/children.size());
				if (min2 <min)
					min=min2;
			}
		}
		return min;
	}

}
