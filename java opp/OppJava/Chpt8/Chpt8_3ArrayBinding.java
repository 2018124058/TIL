
public class Chpt8_3ArrayBinding {
	int money = 1000;
	int point = 0;
	Product[] cart = new Product[10];
	int index = 0; // array ä���� ��
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("�� ����");
			return; // �Լ� ����
		}
		
		if (index>=10) {
			System.out.println("īƮ �� ��");
			return; // �Լ� ����
		}
		
		money -= p.price;
		point += p.point;
		cart[index++] = p;
	}
	
	void summary() {
		int sum = 0;
		String cartList = "";
		if (index==0) {
			System.out.println("�� �� ����");
			return;
		}
		for (int i = 0; i<index; i++) {
			Product p = (Product)cart[i];
			sum += p.price;
			cartList += p;
		}
		System.out.println("�� ����: " + sum + " �� ��: " + cartList);
	}
}

class Product {
	int price;
	int point; 
	
	public Product() {
		price = 0;
		point = 1;
	}
	
	public String toString() {
		return "product";
	}
}

class TV extends Product {
	int price = 10;
	int point = 2;
	
	public String toString() {
		return "tv";
	}
}

class Computer extends Product{
	int price = 50;
	int point = 3;
	
	public String toString() {
		return "computer";
	}
}
