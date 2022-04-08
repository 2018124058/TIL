import java.text.NumberFormat;  
import java.util.Locale; //argument�� Ư�� ���� ���� ���� 

/*import java.package.class;
 package: class�� ���� (default package: java.lang)
 import java.package.*; ��Ű���� ��� Ŭ���� import
 */

/* NumberFormat class: import �ʿ� 
 * NumberFormat class�� format method: �Ǽ��� ȭ������� �Բ� String���� ����
 * getCurrencyInstance()�� ���� NumberFormat�� object ���� 
   class�̸� object�̸� = class�̸�.getCurrencyInstance();
 * method ���) object�̸�.method()
 * */

public class Chpt2_2NumberFormat {
	
	public static void main (String[] args)
	{
		System.out.println("Default location:");
		NumberFormat moneyFormater = 
				NumberFormat.getCurrencyInstance(); //argument ������ ���� ��ġ�� ����
		
		System.out.println(moneyFormater.format(19.8)); //ȭ������� �°� �ݿø��� //����->utf-8 ���� 
		
		System.out.println("US as locaton:");
		NumberFormat moneyFormater2 =
				NumberFormat.getCurrencyInstance(Locale.US); //argument �̱� 
		
		System.out.println(moneyFormater2.format(19.8));
	}
}
