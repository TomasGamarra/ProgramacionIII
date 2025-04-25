package Tp1.Clases;

public class CircularQueue<T> extends Queue<T>{

	public T shift() {
		data.add(data.get(0));
		return data.remove(0);
	}
}

