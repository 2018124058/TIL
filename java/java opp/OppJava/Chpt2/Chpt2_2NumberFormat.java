import java.text.NumberFormat;  
import java.util.Locale; //argument에 특정 국가 지정 위해 

/*import java.package.class;
 package: class의 모음 (default package: java.lang)
 import java.package.*; 패키지의 모든 클래스 import
 */

/* NumberFormat class: import 필요 
 * NumberFormat class의 format method: 실수를 화폐단위와 함께 String으로 리턴
 * getCurrencyInstance()를 통해 NumberFormat의 object 생성 
   class이름 object이름 = class이름.getCurrencyInstance();
 * method 사용) object이름.method()
 * */

public class Chpt2_2NumberFormat {
	
	public static void main (String[] args)
	{
		System.out.println("Default location:");
		NumberFormat moneyFormater = 
				NumberFormat.getCurrencyInstance(); //argument 없으면 현재 위치한 국가
		
		System.out.println(moneyFormater.format(19.8)); //화폐단위에 맞게 반올림됨 //오류->utf-8 설정 
		
		System.out.println("US as locaton:");
		NumberFormat moneyFormater2 =
				NumberFormat.getCurrencyInstance(Locale.US); //argument 미국 
		
		System.out.println(moneyFormater2.format(19.8));
	}
}
