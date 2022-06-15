// �־��� integer array���� ���� ū element�� ����ϴ� ���α׷��� �ۼ��Ѵ�
public class Chpt10_HW2 {

	public static void main(String[] args) {
		
		int[] data1 = {7, 5, 8, 2, 13, 6, 9, 15, 4}; 
		int result1 = largest(data1, 0, data1.length - 1); 
		System.out.println(result1); 
		
		int[] data2 = {-12, 8, 3, 5, 7, 9, 4, 2};
		int result2 = largest(data2, 0, data2.length - 1); 
		System.out.println(result2); 
		
		int[] data3 = {3};
		int result3 = largest(data3, 0, data3.length - 1); 
		System.out.println(result3); 
		
	}
	
	// your code for method largest
	public static int largest(int[] data, int start, int last) {
		
		if (start == last)
			return data[start];
		
		int mid = (start + last)/2;
		int max1 = largest(data, start, mid);
		int max2 = largest(data, mid+1, last);
			
		if (max1 >= max2)
			return max1;
		else
			return max2;
		
		
	}
}
