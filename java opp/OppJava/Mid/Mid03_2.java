
public class Mid03_2 {
	public static void main(String[] args) {
		int[][] m1Data = {{1, 2, 3}, {4}, {5, 6}}; 
		int[][] m2Data = {{7, 8}, {9, 10, 11}, {12}}; 
		Number[][] m1 = new Number[3][3];
		Number[][] m2 = new Number[3][3]; 
		
		fillData(m1, m1Data); 
		fillData(m2, m2Data); 
		showNumberMatrix(m1);
		System.out.println();
		showNumberMatrix(m2); 
		System.out.println(); 
		
		Number[][] m3 = addNumberMatrix(m1, m2); 
		showNumberMatrix(m3); 
	}
	// fillData showNumberMatrix addNumberMatrix
	
	public static void showNumberMatrix(Number[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]);
				if (j != m[i].length-1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void fillData(Number[][] m, int[][] data) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(j >= data[i].length)
					m[i][j] = new Number(0);
				else
					m[i][j] = new Number(data[i][j]);
			}
		}
	}
	
	public static Number[][] addNumberMatrix(Number[][] m1, Number[][] m2){
		Number[][] m3 = new Number[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				m3[i][j] = new Number(m1[i][j].getNumber()+ m2[i][j].getNumber());
			}
		}
		return m3;
	}
}

class Number{
	private int x;
	
	public Number() {
		x = 0;
	}
	
	public Number(int x) {
		this.x = x;
	}
	
	public String toString() {
		String str = "";
		str += x;
		return str;
		
	}
	public int getNumber() {
		return x;
	}
	public void setNumber(int x) {
		this.x = x;
	}
}
