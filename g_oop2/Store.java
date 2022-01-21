package g_oop2;

public class Store {

	public static void main(String[] args) {
		
		Desktop d1 = new Desktop("삼성 컴퓨터", 1000000);
		Desktop d2 = new Desktop("LG 컴퓨터", 1500000);
		
		AirCon ac1 = new AirCon("삼성 에어컨", 2000000);
		AirCon ac2 = new AirCon("LG 에어컨", 2500000);

		TV tv1 = new TV("삼성 TV", 3000000);
		TV tv2 = new TV("LG TV", 3500000);
		
		Customer c = new Customer(); //객체를 생성해 c라는 변수에 저장
		
		c.buy(d1); //items[0]
		
		c.buy(ac2);
		
		c.buy(tv2); //타입이 Product 였으나 값은 다른 타입을 넣어줌. 상속을 받아서 다형성을 사용했기 때문에 가능
		
		((Desktop)c.items[0]).programming(); //items은 product 타입이라 Desktop 메소드를 사용하려면 형변환 필요
		
	}

}

class Product{
	String name; //이름
	int price; //가격
	
	//생성자
	Product(String name, int price){//물건마다 이름과 값이 달라서 외부에서 값을 받아서 초기화
		this.name = name;
		this.price = price;
	}
	
	//상품의 정보를 반환하는 메서드
	String getInfo() {
		return name + "(" + price + "원)";
	}
}

class Desktop extends Product{
	Desktop(String name, int price){
		super(name, price);
	}
	
	void programming() {
		System.out.println("프로그램을 만듭니다.");
	}
}

class AirCon extends Product{
	AirCon(String name, int price){
		super(name, price); //부모클래스의 생성자를 호출해 값을 넘겨줌
	}
	
	void setTemperature() {
		System.out.println("온도를 설정합니다.");
	}
}


class TV extends Product{
	TV(String name, int price){
		super(name, price);
	}
	
	void setChannel() {
		System.out.println("채널을 변경합니다.");
	}
}

class Customer {
	int money = 100000000;

	// 여러개를 저장하기 위해 배열 생성
	Product[] items = new Product[10]; // (다형성) TV, AirCon, Desktop 모두 저장해야 하기 때문에 Product 타입으로 생성

	// 구매하는 메서드
	void buy(Product p) { // (다형성) 어떤 물건을 구매할 것인가 파라미터로 받음 (파라미터에는 모든 물건을 받아야 하므로 Product 타입 사용)
		if (money < p.price) {
			System.out.println("잔돈이 부족한니다.");
			return;
		}
		
		money -= p.price;

		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = p; //배열에 물건 저장
				break;
			}
		}
		System.out.println(p.getInfo() + "를 구매하였습니다.");
	}
}
