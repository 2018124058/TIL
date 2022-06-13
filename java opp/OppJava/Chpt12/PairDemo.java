// Chapter12. Generic Class example 
import java.util.Scanner;

public class PairDemo{
	public static void main(String[] args) {
		Pair<String, Integer> rating = new Pair<String, Integer>("hey", 1);
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("���� �Է�: ");
		String subject = keyboard.nextLine();
		rating.setFirst(subject);
		System.out.println(rating);
	}
}

class Pair <T1, T2>{ // generic class with multiple type parameters 
	private T1 first;
	private T2 second;
	
	public Pair() { // consturctor heading�� <T> ����x 
		first = null;
		second = null;
	}
	
	public Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}
	
	public void setFirst(T1 first) {
		this.first = first;
	}
	
	public T1 getFirst() { // return type�� T
		return first;
	}
	
	public String toString() {
		return ("first: " + first);
	}
	
	public boolean equals(Object other) {
		if (other == null)
			return false;
		else if (getClass() != other.getClass())
			return false;
		else {
			Pair<T1, T2> otherPair = (Pair<T1, T2>)other;
			return (first.equals(otherPair.first)
					&& second.equals(otherPair.second));	
		}
	}
	
}


