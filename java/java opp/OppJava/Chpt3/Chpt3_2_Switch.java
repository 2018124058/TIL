
public class Chpt3_2_Switch {
	public static void main(String[] args) {
		int score = 95;
		char grade;
		
		switch(score/10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		default:
			grade = 'F';}
			
		System.out.println(grade);
	
		
		String order = "ī���ī";
		int price = 0;
		
		switch(order) {
		case"ī���ī":
		case"īǪġ��":
		case"���̽�����":
			price = 1000;
			break;
		case"�Ƹ޸�ī��":
			price = 2000;
			break;
		default: 
			System.out.println("�޴��� ����");
		}
		if(price!=0)
			System.out.println(order+" : "+price);
	}	
}
