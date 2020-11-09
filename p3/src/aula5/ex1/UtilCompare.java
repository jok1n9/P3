package aula5.ex1;

public class UtilCompare {	
	
	@SuppressWarnings("unchecked")
	public static <T> Comparable<T> findMax(Comparable<T> a[]) {
		int maxIndex = 0;
		for(int i = 1; i < a.length; i++) {
			if(a[i] != null && a[i].compareTo((T) a[maxIndex]) > 0)
				maxIndex = i;					
		}
		return a[maxIndex];
	}
	
	@SuppressWarnings("unchecked")
	public static <T>Comparable<T>[] sortArray(Comparable<T> a[]) {
		Comparable<T> tmp;
		boolean trade = true;
		while(trade) {
			trade = false;
			for(int i = 0; i<a.length-1; i++) {
				if(a[i].compareTo((T) a[i+1]) > 0) {
					tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
					trade = true;
				}
			}
		}
		return a;
	}
}
