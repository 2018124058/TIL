
public class Chpt6_Sorting {
	/*sorting
	 precondition: numberUsed <= a.length;
	 postcondition: a[0]<=a[1]<=...<=a[numberUsed-1]
	 */
	
	//sort method: ������
	//void: �ٸ� Ŭ�������� ���� Ŭ������������ ȣ�� ���� 
	public static void sort(double[] a, int numberUsed)
	{
		int index, indexOfNextSmallest; 
		//index-1������ �ݺ��ص� sorting �Ϸ�� 
		for (index=0; index<numberUsed-1;index++)
		{
			indexOfNextSmallest = indexOfSmallest(index,a,numberUsed);
			interchange(index,indexOfNextSmallest,a);
		}		
	}
	//indexOfSmallest: �־��� ���� �� ���� ���� value�� index(indexOfMin) ����
	//�Ķ����: ���� �ε���, array, numberUsed
	private static int indexOfSmallest(int startIndex, double[] a, int numberUsed)
	{
		double min = a[startIndex]; //�ϴ� min�� ù��° value �Ҵ� 
		int indexOfMin = startIndex; // �ϴ� �Ҵ� 
		int index;
		for (index = startIndex + 1; index<numberUsed; index++)
		// stratIndex�� �̹� �Ҵ������ϱ� +1���� �ݺ��� ����
		{
			if (a[index] < min)
			{
				min = a[index];
				indexOfMin = index; 
				// min�� startIndex���� index���� �� �� ���� ���� ��
			}
		}
		return indexOfMin;
	}
	
	//interchange: a[i]�� a[j] ��ġ �ٲ���
	private static void interchange(int i, int j, double[] a)
	{
		double temp = a[i]; // a[i]�� �Ҿ������� �ðܵα�
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
