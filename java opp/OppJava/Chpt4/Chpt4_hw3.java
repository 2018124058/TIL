import java.util.StringTokenizer;
public class Chpt4_hw3 {

	public static void main(String[] args) {
		Splitter43 sp1 = new Splitter43("this/is/an/example/of/string/tokenizer", "/");
		Splitter43 sp2 = new Splitter43();
		Splitter43 sp3 = new Splitter43("Korea Seoul Busan Daegu Incheon");
		
		System.out.println("sp1 ---------------");
		sp1.split();
		System.out.println("sp2 ---------------");
		sp2.split();
		System.out.println("sp3 ---------------");
		sp3.split();
	}
}

class Splitter43{
	private String line;
	private String delimiter;
	 
	
	//constructors
	public Splitter43() {
		line = " ";
		delimiter = " ";
	}
		
	public Splitter43(String line) {
		this.line = line;
		delimiter = " ";
		}
	
	public Splitter43(String line, String delimiter) {
		this.line = line;
		this.delimiter = delimiter;
		
		}
	
	//split method
	public void split() {
		StringTokenizer splitter = new StringTokenizer(line, delimiter);
		while (splitter.hasMoreTokens()) {
			System.out.println(splitter.nextToken());  }
	 	}		
}
