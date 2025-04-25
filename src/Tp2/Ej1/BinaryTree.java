package Tp2.Ej1;
import Tp1.Clases.Queue;
public class BinaryTree <T> {
    private T data;
    private BinaryTree<T> leftChild;   
    private BinaryTree<T> rightChild;
    
    public BinaryTree() {
   	 	super();
    }
    public BinaryTree(T data) {
   	 this.data = data;
   	 this.leftChild=null;
   	 this.rightChild=null;
    }

    public T getData() {
   	 return data;
    }

    public void setData(T data) {
   	 this.data = data;
    }
   
    public BinaryTree<T> getLeftChild() {
   	 return leftChild;
    }
    public BinaryTree<T> getRightChild() {
   	 return rightChild;
    }

    public void addLeftChild(BinaryTree<T> child){
   	 this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
      	 this.rightChild = child;
       }

    public void removeLeftChild() {
      	 this.leftChild = null;
       }
    public void removeRightChild() {
      	 this.rightChild = null;
       }

    public boolean isEmpty(){
      	 return (this.isLeaf() && this.getData() == null);
       }

    public boolean isLeaf() {
      	return (!this.hasLeftChild() && !this.hasRightChild());
       }
    public boolean hasLeftChild() {
      	 return this.leftChild!=null;
       }

    public boolean hasRightChild() {
      	 return this.rightChild!=null;
       }
    public void printLevelTraversal() {
      	 BinaryTree<T> ab = null;
      	 Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
      	 cola.enqueue(this);
         cola.enqueue(null);
      	 while (!cola.isEmpty()) {
      		 ab = cola.dequeue();
      		 if (ab != null) {
      			 System.out.print("["+ab.getData()+"]");
      			 if (ab.hasLeftChild()) 
      				 cola.enqueue(ab.getLeftChild());
      			 if (ab.hasRightChild()) 
      				 cola.enqueue(ab.getRightChild());
      			 
      		 } else if (!cola.isEmpty()) {
      			 System.out.println();
      			 cola.enqueue(null);
      		 }
      	 }
     }
     
    public void entreNiveles(int n,int m) {
     	 BinaryTree<T> ab = null;
     	 int nivel=0;
     	 Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
     	 cola.enqueue(this);
         cola.enqueue(null);
     	 while (!cola.isEmpty()) {
     		 ab = cola.dequeue();
     		 if (ab != null) {
     			 if(nivel >=n && nivel <=m)
     				 System.out.print(ab.getData());
     			 if (ab.hasLeftChild()) 
     				 cola.enqueue(ab.getLeftChild());
     			 if (ab.hasRightChild()) 
     				 cola.enqueue(ab.getRightChild());
     			 
     		 } else if (!cola.isEmpty()) {
     			if(nivel >=n && nivel <=m)
     				System.out.println();
     			 cola.enqueue(null);
     			 nivel++;
     		 }
     	 }
    }
    
    public int contarHojas() {
	    return private_contarHojas(this);
    	
    }
    private int private_contarHojas (BinaryTree<T> ab) {
    	if(ab==null)
    		return 0;
    	else 
    		if(ab.isLeaf())
    			return 1;
    		else 
    			return private_contarHojas(ab.getLeftChild()) + private_contarHojas(ab.getRightChild());
    }
    
    public BinaryTree<T> espejo(){
    	BinaryTree<T> Mirror= new BinaryTree<T>(this.getData());
    	if(this.hasLeftChild())
    		Mirror.addRightChild(this.leftChild.espejo());
    	if(this.hasRightChild())
			Mirror.addLeftChild(this.rightChild.espejo());
    	
    	return Mirror;
    }
    
    
    @Override
    public String toString() {
      	 return this.getData().toString();
       }
}
    