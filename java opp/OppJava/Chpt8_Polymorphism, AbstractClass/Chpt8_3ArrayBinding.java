
public class Chpt8_3ArrayBinding {
	int money = 1000;
	int point = 0;
	Product[] cart = new Product[10];
	int index = 0; // array 채워진 양
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("돈 부족");
			return; // 함수 끝남
		}
		
		if (index>=10) {
			System.out.println("카트 다 참");
			return; // 함수 끝남
		}
		
		money -= p.price;
		point += p.point;
		cart[index++] = p;
	}
	
	void summary() {
		int sum = 0;
		String cartList = "";
		if (index==0) {
			System.out.println("산 것 없음");
			return;
		}
		for (int i = 0; i<index; i++) {
			Product p = (Product)cart[i];
			sum += p.price;
			cartList += p;
		}
		System.out.println("산 개수: " + sum + " 산 것: " + cartList);
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
