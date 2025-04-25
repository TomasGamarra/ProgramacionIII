package Tp1.Clases;

public class DoubleEndedQueue<T> extends Queue <T> {
	
	    public void enqueueFirst(T dato) {
	        super.data.add(0, dato); // Agregar el elemento al principio de la cola
	    } 
}

