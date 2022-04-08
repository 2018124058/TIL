import java.util.Scanner;
public class Chpt3_1_Ifelse {

	public static void main(String[] args) {
		char grade;
		Scanner scoreKeyboard = new Scanner(System.in);
		
		System.out.print("Input your score (0~100):");
		int score = scoreKeyboard.nextInt();
		
		if (score>=90)
			grade = 'A';
		else if (score >= 80)
			grade = 'B';
		else if (score >= 70)
			grade = 'C';
		else if (score >= 60)
			grade = 'D';
		else
			grade = 'F';
		
		System.out.println("Your grade : " + grade);
				
		// IncomeTax 계산
		Scanner incomeKeyboard = new Scanner(System.in);
		double netIncome, tax, fivePercentTax, tenPercentTax;
		
		System.out.println("Enter net income.\n"+"no dolloar sign or commas");
		netIncome = incomeKeyboard.nextDouble();
		
		if (netIncome <= 15000)
			tax = 0;
		else if ((netIncome > 15000) && (netIncome <= 30000)) //&& 그리고
			tax = (0.05*(netIncome - 15000));
		else
		{	fivePercentTax = 0.05*(netIncome - 15000);
			tenPercentTax = 0.1*(netIncome - 30000);
			tax = fivePercentTax + tenPercentTax; }
		
		System.out.printf("Tax due = $%.2f", tax);
			
	}

}
