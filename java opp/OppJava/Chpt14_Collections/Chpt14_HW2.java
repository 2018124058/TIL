import java.util.*;

/*나이가 45, 32, 15, 67, 17, 92, 8, 27, 56 인 9명의 사람이 있다.

이들을 나이가 많은 순으로 나이를 출력하는 프로그램을 작성하라.

적절한 Collection class를 찾아 implement해야 한다.
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
