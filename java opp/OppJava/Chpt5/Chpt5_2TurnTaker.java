
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
	
	public static int getTurn() { // static method에서는 static variable 접근 가능, instance variable은 X
		turn ++;
		return turn;} 
	
	public boolean isMyTurn() // non-static method은 instance val, static val 둘다 접근 가능 
	{return (turn == myTurn);}
	
	
}

