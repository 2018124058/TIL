public class Chpt11_HW2 {

	public static void main(String[] args) {
		Age132 age = new Age132(1998);       // born in 1998
		Score132 score = new Score132(85);  // score is 85
		Price132 price = new Price132(135);    // price is 135
		
		System.out.println("Born in " + age.getBirthYear() + ", age in 2022: " + age.compute(2022));
		System.out.println("Score is " + score.getScore() + ", (score-28)/10: " + score.compute(-28) + 
										  ", add 7: " + score.add(7));
		System.out.println("Price is " + price.getPrice() + ", price after 12% increase: " + price.compute(12) + 
										", add 5: " + price.add(5) + ", multiply 3: " + price.multiply(3));

	}

}

// your code for interfaces and classes 
interface Computable132 {int compute(int x);}

interface Addable132 extends Computable132 {int add(int x);}

interface Multiplyable132 extends Computable132 {int multiply(int x);}

class Age132 implements Computable132{
	private int bornYear;
	
	public Age132(int bornYear) {
		this.bornYear = bornYear;
	}
	
	public int compute(int currentYear) {
		return currentYear-bornYear;
	}
	
	public int getBirthYear() {return bornYear;}
}

class Score132 implements Addable132{
	private int score; 
	
	public Score132(int score) {
		this.score = score;
	}
	
	public int compute(int n) {
		return ((score+n)/10);
	}
	
	public int add(int n) {
		return (score + n);
	}
	
	public int getScore() {return score;}
}

class Price132 implements Addable132, Multiplyable132{
	private int price; 
	
	public Price132(int price) {
		this.price = price;
	}
	
	public int compute(int n) {
		return (int) (price * (1 + n * 0.01));
	}
	
	public int add(int n) {return (price + n);}
	
	public int multiply(int n) {return (price * n);}
	
	public int getPrice() {return price;}
}