
public class Chpt5_2TurnTaker {
	
	private static int turn = 0; // static variable 
	
	private int myTurn; // instance variable
	private String name;
	
	public Chpt5_2TurnTaker(String name, int myTurn) // constructor
	{
		this.name = name;
		if (myTurn >= 0)
			this.myTurn = myTurn;
		else
		{
			System.out.println("fatal error");
			System.exit(0);
		}
	}
	
	public String getName()
	{return name;}
	
	public static int getTurn() { // static method������ static variable ���� ����, instance variable�� X
		turn ++;
		return turn;} 
	
	public boolean isMyTurn() // non-static method�� instance val, static val �Ѵ� ���� ���� 
	{return (turn == myTurn);}
	
	
}

