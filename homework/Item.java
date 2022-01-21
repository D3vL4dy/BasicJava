package homework;

public class Item {
	
	String name; // 이름 : 사용자가 직접 입력하므로 생성자(파라미터)로
	int hp; // 체력
	int speed; //속도
	int bodyMoisture = (int) (Math.random() * 5); //체내수분량
	int distance; //거리
	
	
	// 아이템 초기화
	Item(String name, int hp, int speed, int bodyMoisture, int distance) { // 아이템이 가진 능력치가 다 다르기 때문에 외부에서 받아서
		this.name = name;
		this.hp = hp;
		this.speed = speed;
		this.bodyMoisture = bodyMoisture;
		this.distance = distance;
	}

	// toString() 메소드 : 객체를 출력했을 때 주소가 아닌 메소드에서 리턴된 내용이 출력되게 함
	public String toString() { // 아이템이 가진 정보를 리턴
		String info = name + " : ";
		if (0 < hp)
			info += " 체력+" + hp; // 아이템이 올려주는 능력치만 적용하기 위해 if문으로 생성
		if (0 < speed)
			info += " 속도+" + speed;
		if (0 < bodyMoisture)
			info += " 수분+" + bodyMoisture;
		if (0 < distance)
			info += " 거리+" + distance;
		return info;
	}

}
