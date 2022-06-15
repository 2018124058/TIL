
public class Chpt11_3InnerClass { // outer class
	
	private class Money{ // inner class
		private long dollars;
		private int cents;
		
		public Money(String stringAmount) {
			abortOnNull(stringAmount); // null�̸� exit
			int length = stringAmount.length();
			// dollar: �Ҽ��� ���ڸ������� ǥ��
			// Long.parseLong, Integer.parseInt: ���� long, int�� ���ڿ��� ��ȯ 
			dollars = Long.parseLong(stringAmount.substring(0, length-3));
			cents = Integer.parseInt(stringAmount.substring(length-2, length));
		}
		
		public String getAmount() {
			// cent: ���ڸ�������, 9���� ������ ���ڸ����� 0�� �ʿ�  
			if (cents > 9) return (dollars + "." + cents);
			else return (dollars + ".0" + cents);
		}
		
		public void addIn(Chpt11_3InnerClass secondAmount) {
			abortOnNull(secondAmount);
			int newCents = (cents + secondAmount.cents)%100; // only cents
			long carry = (cents + secondAmount.cents)/100; // if cents>100
			cents = newCents;
			dollars = dollars + secondAmount.dollars + carry;
		}
		
		private void abortOnNull(Object o) {
			if (o == null) {
				System.exit(0);
			}
		}
	}
	
	private Chpt11_3InnerClass balance;
	
	public Chpt11_3InnerClass() {
		balance = new Chpt11_3InnerClass("0.00");
	}
	
	public String getBalance() {
		return balance.getAmount();
	}
	
	public void makeDeposit(String depositAmount) {
		balance.addIn(new Chpt11_3InnerClass(depositAmount));
	}
	
	public void closeAccount() {
		balance.dollars = 0;
		balance.cents = 0;
	}
	
	public static void main(String[] args) {
		
	}
}
