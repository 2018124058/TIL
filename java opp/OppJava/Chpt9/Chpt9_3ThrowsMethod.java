
public class Chpt9_3ThrowsMethod {


}

class ScoreNotSetException extends Exception{
	public ScoreNotSetException() {super("Score not set");}
	public ScoreNotSetException(String msg) {super("msg");}
}

class HighScore{
	private int score = 0;
	private boolean scoreSet = false;
	
	public HighScore() {score = 0; scoreSet = false;}
	public void setScore(int newScore) {score = newScore; scoreSet = true;}
	public int getScore() throws ScoreNotSetException{
		if(!scoreSet) throw new ScoreNotSetException();
		else return score;
	}
	
	public static void main(String[] args) {
		HighScore highscore = new HighScore();
		try {  //exception ¹ß»ý
			System.out.println(highscore.getScore());
		}
		
		catch(ScoreNotSetException e) {
			System.out.println(e.getMessage());
		}
		
		highscore.setScore(100);
		try { //no exception 
			System.out.println(highscore.getScore());
		}
		catch(ScoreNotSetException e) {
			System.out.println(e.getMessage());
		}
	}
}