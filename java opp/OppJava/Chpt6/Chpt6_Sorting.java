
public class Chpt6_Sorting {
	/*sorting
	 precondition: numberUsed <= a.length;
	 postcondition: a[0]<=a[1]<=...<=a[numberUsed-1]
	 */
	
	//sort method: 재정렬
	//void: 다른 클래스에서 쉽게 클래스네임으로 호출 가능 
	public static void sort(double[] a, int numberUsed)
	{
		int index, indexOfNextSmallest; 
		//index-1까지만 반복해도 sorting 완료됨 
		for (index=0; index<numberUsed-1;index++)
		{
			indexOfNextSmallest = indexOfSmallest(index,a,numberUsed);
			interchange(index,indexOfNextSmallest,a);
		}		
	}
	//indexOfSmallest: 주어진 범위 내 가장 작은 value의 index(indexOfMin) 리턴
	//파라미터: 시작 인덱스, array, numberUsed
	private static int indexOfSmallest(int startIndex, double[] a, int numberUsed)
	{
		double min = a[startIndex]; //일단 min에 첫번째 value 할당 
		int indexOfMin = startIndex; // 일단 할당 
		int index;
		for (index = startIndex + 1; index<numberUsed; index++)
		// stratIndex는 이미 할당했으니까 +1부터 반복문 실행
		{
			if (a[index] < min)
			{
				min = a[index];
				indexOfMin = index; 
				// min은 startIndex부터 index까지 값 중 가장 작은 것
			}
		}
		return indexOfMin;
	}
	
	//interchange: a[i]와 a[j] 위치 바꿔줌
	private static void interchange(int i, int j, double[] a)
	{
		double temp = a[i]; // a[i]값 잃어버릴까봐 맡겨두기
		a[i] = a[j];
		a[j] = temp;
	}
	
	//test
	public static void main(String[] args) {
		double [] a = {5,4,3,2,1};
		sort(a, 5);
		for (int i = 0; i < 5; i++)
			System.out.println(a[i]);
	}
}
