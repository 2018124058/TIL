
public class Final_4 {

	public static void main(String[] args) {
		ShowInfo<Double> d1 = new ShowInfo<Double>(58.234);
		ShowInfo<String> d2 = new ShowInfo<String>("This");
		d1.info("Yes");
		d2.info(12);
	}

}

// your code here

class ShowInfo<T1>{
	T1 data; 
	
	public ShowInfo(T1 data) {
		this.data = data;
	}
	
	
	public <T2> void info(T2 data2) {
		System.out.println(data + " " + data2);
	}
}
