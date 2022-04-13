
public class Chpt6_HW2 {
	public static void main(String[] args) {
		int a[] = { 3, 9, 2, 5, 11, 6, 1, -3 };
		int b[] = { 8, -4, 10, 3, 8, 2, 12, 4 }; 
		printArray(a, "a"); 
		printArray(b, "b");
		int c[] = merge(a, b); 
		printArray(c, "c"); 
	}
	
	static void printArray(int[] a, String title) {
		System.out.print(title + " = [");
		for (int i = 0; i < a.length; i++) {
			if (i != a.length-1)
				System.out.print(a[i] + " ");
			else
				System.out.print(a[i] + "]\n");
		}
	}
	
	static int[] merge(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		for (int i=0; i < result.length; i++) {
			if (a.length>0 && b.length>0) {
				if (a[0] < b[0]) {
					result[i] = a[0];
					int temp[] = new int[a.length-1];
					for (int j=0; j<a.length-1; j++) {
						temp[j] = a[j+1]; 
					}
					a = temp;
				}
				else if (a[0] > b[0]) {
					result[i] = b[0];
					int temp[] = new int[b.length-1];
					for (int j=0; j<b.length-1; j++) {
						temp[j] = b[j+1]; 
					}
					b = temp;
				}
			}
			if (a.length == 0) {
				for (int x = 0; x < b.length; x++)
					result[result.length-b.length + x] = b[x];
			}
			if (b.length == 0) {
				for (int x = 0; x < b.length; x++)
					result[result.length-a.length + x] = a[x];
			}
		
		}
		return result;
	}
}
