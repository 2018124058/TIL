import java.util.*;

/*���̰� 45, 32, 15, 67, 17, 92, 8, 27, 56 �� 9���� ����� �ִ�.

�̵��� ���̰� ���� ������ ���̸� ����ϴ� ���α׷��� �ۼ��϶�.

������ Collection class�� ã�� implement�ؾ� �Ѵ�.
*/
public class Chpt14_HW2 {

	public static void main(String[] args) {
		PriorityQueue<Integer> ages = new PriorityQueue<Integer>(Collections.reverseOrder());
		ages.add(45);
		ages.add(32);
		ages.add(15);
		ages.add(67);
		ages.add(17);
		ages.add(92);
		ages.add(8);
		ages.add(27);
		ages.add(56);
		
		while (ages.size() != 0)
			System.out.println(ages.poll());
		
		
	}
}
