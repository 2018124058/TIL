
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
	
		
		String order = "카페모카";
		int price = 0;
		
		switch(order) {
		case"카페모카":
		case"카푸치노":
		case"아이스초코":
			price = 1000;
			break;
		case"아메리카노":
			price = 2000;
			break;
		default: 
			System.out.println("메뉴에 없음");
		}
		if(price!=0)
			System.out.println(order+" : "+price);
	}	
}
