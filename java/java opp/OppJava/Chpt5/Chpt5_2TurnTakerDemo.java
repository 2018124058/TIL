
public class Chpt5_2TurnTakerDemo {
	public static void main(String[] args)
	{
		Chpt5_2TurnTaker lover1 = new Chpt5_2TurnTaker("Romeo", 1);
		Chpt5_2TurnTaker lover2 = new Chpt5_2TurnTaker("Juliet", 3);
		for (int i = 1; i < 5; i++)
		{
			System.out.println("Turn= " + Chpt5_2TurnTaker.getTurn() );
			if (lover1.isMyTurn())
				System.out.println("Love from " + lover1.getName());
			if (lover2.isMyTurn())
				System.out.println("Love from " + lover2.getName());
			
		}
	}
}
