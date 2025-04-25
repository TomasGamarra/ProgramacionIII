package tp3.GeneralTree;


import java.util.LinkedList;
import java.util.List;
import Tp1.Clases.Queue;


public class GeneralTree<T> {
	private T data;
	private List<GeneralTree<T>> children =new LinkedList<GeneralTree<T>>();
	
	public GeneralTree() {
		
	}
	
	public GeneralTree(T data) {
	this.data = data;
	}
	public GeneralTree(T data,List<GeneralTree<T>> children){
		this(data);
		this.children = children;
	}
	public boolean hasChildren() {
		return children!=null && !children.isEmpty();
	}
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	public void addChild(GeneralTree<T> child) {
		getChildren().add(child);
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public boolean isLeaf() {
		return !hasChildren();
	}
	public boolean isEmpty() {
		return data==null && !this.hasChildren();
	}
	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren()) {
			List<GeneralTree<T>> children=getChildren();
			if (children.contains(child))
				children.remove(child);
		}
	}
	public List<T> traversalLevel(GeneralTree<T> tree) {

		List<T> result = new LinkedList<T>();
		GeneralTree<T> tree_aux;
		Queue<GeneralTree<T>> queue = new Queue<GeneralTree<T>>();
		queue.enqueue(tree);
		while (!queue.isEmpty()) {
		 tree_aux = queue.dequeue();
		 result.add(tree_aux.getData());
		 List<GeneralTree<T>> children = tree_aux.getChildren();
		 for (GeneralTree<T> child: children) {
			 queue.enqueue(child);
		 	}
		 }
		 return result;
	}
	
	
	 public void printPreOrder() {
		 System.out.println(this.getData());
		 List<GeneralTree<T>> children = this.getChildren();
		 for (GeneralTree<T> child: children) {
			 child.printPreOrder();
		 }
	}
	
	 public void printPostOrder() {
		 List<GeneralTree<T>> children = this.getChildren();
		 for (GeneralTree<T> child: children) 
			 child.printPostOrder();
		 System.out.println(getData());
		 
	 }
	 
	 public void printInOrder() {
		 List<GeneralTree<T>> children = this.getChildren();
		 if(this.hasChildren())
			 children.get(0).printInOrder();
		 System.out.println(this.getData());
		 for(int i=1;i<children.size();i++)
			 children.get(i).printInOrder();
		 
	 }
	 public void printPorNiveles() {
		 Queue <GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		 cola.enqueue(this);
		 GeneralTree<T> aux;
		 while(!cola.isEmpty()) {
			aux= cola.dequeue();
			System.out.println(aux.getData());
			List<GeneralTree<T>> children = aux.getChildren();
			for(GeneralTree<T> child : children)
				cola.enqueue(child);
		 }
		 
	 }
	 
		// devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo
		//es la longitud del único camino de la raíz al nodo.

		public int nivel(T data) {
	            Queue<GeneralTree<T>> queue=new Queue<GeneralTree<T>>();
	            GeneralTree<T> aux;
	            queue.enqueue(this);
	            queue.enqueue(null);
	            int num=0;
	            while(!queue.isEmpty()) {
	                aux=queue.dequeue();
	                if(aux!=null) {
	                    if(aux.getData().equals(data))
	                        return num;
	                    if(aux.hasChildren()) { 
	                    	List<GeneralTree<T>> children = aux.getChildren();
	                        for(GeneralTree<T> child: children)
	                            queue.enqueue(child);
	                    }
	                }
	                else{
	                    if(!queue.isEmpty()) {
	                        queue.enqueue(null);
	                        num++;
	                        }
	                    
	                }

	            }
	            return -1;
	        }
		
	//devuelve la altura del árbol, es decir, la longitud del camino más largo
	//	desde el nodo raíz hasta una hoja.
		public int altura() {
			Queue <GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
			cola.enqueue(this);
			cola.enqueue(null);
			int num=0;
			GeneralTree<T> aux;
			while(!cola.isEmpty()) {
				
				aux=cola.dequeue();
				
				if (aux!= null) {
					if(aux.hasChildren()) {
						List<GeneralTree<T>> children = aux.getChildren();
						for(GeneralTree<T> child : children)
							cola.enqueue(child);
					}		
				}else
					{
					if(!cola.isEmpty()) {
						cola.enqueue(null);
						num++;
						}
				}
				
			}
			return num;
		}
		
		//la amplitud (ancho) de un árbol se define como la cantidad de nodos que
		//se encuentran en el nivel que posee la mayor cantidad de nodos.
		public int ancho() {
			Queue<GeneralTree<T>> cola = new Queue <GeneralTree<T>>();
			int max=1,ancho2=0;
			GeneralTree<T> aux;
			cola.enqueue(this);
			cola.enqueue(null);
			while(!cola.isEmpty()) {
				aux = cola.dequeue();
				
				if(aux!=null) {
					if(aux.hasChildren()) {
					List<GeneralTree<T>> children = aux.getChildren();
					for(GeneralTree<T> child :children) {
						cola.enqueue(child);
						ancho2++;}
					}
				}
				else {
					if(ancho2 > max)
						max=ancho2;
					if(!cola.isEmpty()) {
						cola.enqueue(null);
						ancho2=0;
					}
					
				}
				
			}
			return max;
		}
		
		
		//devuelve true si el valor “a” es ancestro del valor “b”.
		public boolean esAncestro(T a, T b) {
			if(a.equals(b))
				return false;
			GeneralTree<T> nodoA = private_buscarNodo(a,this);
			if (nodoA != null)
				return private_buscarDescendiente(b,nodoA);
			return false;
		}

		private GeneralTree<T> private_buscarNodo (T a, GeneralTree<T> arbol){
				if(arbol.getData().equals(a))
					return arbol;
				if (arbol.hasChildren())
					for (GeneralTree<T> child : arbol.getChildren()) {
						GeneralTree<T> aux= private_buscarNodo(a,child);
						if(aux != null)
							return aux;
					}
				return null;
		}
		
		private boolean private_buscarDescendiente(T b, GeneralTree<T> ab) {
			if (ab.getData().equals(b))
				return true;
			if (ab.hasChildren())
				for(GeneralTree<T> child : ab.getChildren()) {
					boolean aux = child.private_buscarDescendiente(b, child);
					if (aux)
						return aux;
				}
			return false;
		}


public boolean equals (GeneralTree<T> ab) {
	boolean resul =false;
	if (ab == null )
		return resul;
	if(this.hasChildren() && ab.hasChildren())
		if(ab.getData().equals(ab.getData()) && this.getChildren().equals(ab.getChildren()))
			resul=true;
	else
		if(!this.hasChildren() && !ab.hasChildren() && this.getData().equals(ab.getData()) )
			resul=true;
	return resul;	
	}
}