package Tp1.Ej5;

public class Calcular {
		 int max=-1;
		 int min=9999;
		 int avg=0;
		
		 public Calcular() {
		
			}
	public Calcular(int max, int min, int avg) {
		this.max=max;
		this.min=min;
		this.avg=avg;
	}
		
	public static int[] metodoA(int[] array) {
		int max=-1,min=Integer.MAX_VALUE,avg=0;
		int [] arrayResul = new int[3];
		for (int elto: array) {
			if(elto > max)
				max=elto;
			if(elto < min)
				min=elto;
			avg=avg+elto;
		}
		avg=avg/(array.length);
		arrayResul[0]=max;
		arrayResul[1]=min;
		arrayResul[2]=avg;
		return arrayResul;
	}
	
	public static void metodoB (int[] array , Calcular obj) {
		int max=Integer.MIN_VALUE , min=Integer.MAX_VALUE,avg=0;
		for (int elto: array) {
			if(elto > max)
				max=elto;
			if(elto < min)
				min=elto;
			avg=avg+elto;
		}
		avg=avg/(array.length);
		obj.setAvg(avg);
		obj.setMax(max);
		obj.setMin(min);
		
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	
	@Override
	public String toString() {
		return "Max: "+max+"\nMin: "+min+"\nAvg: "+avg;
	}
	
		
}
