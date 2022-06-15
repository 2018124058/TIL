
public class Chpt11_2Comparable {
	
	// precondition: numberUsed는 length보다 작거나 같다 
	// Comparable[]: Comparable interface를 implemenets한 것이면 뭐든 넘길 수 있다 
	// sort: array를 크기 순으로 정렬
	public static void sort(Comparable[] a, int numberUsed) {
		int index, indexOfNextSmallest;
		for (index = 0; index < numberUsed - 1; index++) {
			indexOfNextSmallest = indexOfSmallest(index, a, numberUsed);
			interchange(index, indexOfNextSmallest, a);
		}
	}
	
	private static int indexOfSmallest(int startIndex, Comparable[] a, int numberUsed) {
		Comparable min = a[startIndex];
		int indexOfMin = startIndex;
		int index;
		for (index = startIndex + 1; index < numberUsed; index++)
			if (a[index].compareTo(min)<0) {
				min = a[index];
				indexOfMin = index;
			}
		return indexOfMin; 
	}
	
	private static void interchange(int i, int j, Comparable[] a) {
		Comparable temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

class Chpt11_2Demo {
	
	public static void main(String[] args) {
		
		Double[] d = new Double[10]; // Double은 Comparable interface를 implement하고 있다
		for (int i = 0; i < d.length; i++)
			d[i] = new Double(d.length-i);
		
		System.out.println("before sorting");
		for (int i=0; i<d.length; i++)
			System.out.println(d[i].doubleValue() + " ");
		
		Chpt11_2Comparable.sort(d, d.length);
		System.out.println("after sorting");
		for (int i = 0; i < d.length; i++)
			System.out.println(d[i].doubleValue() + " ");
		
	}
}
