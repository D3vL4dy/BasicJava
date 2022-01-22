package homework;

public class Item extends Setting { // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음

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
			info += " 체내수분량+" + bodyMoisture;
		if (0 < distance)
			info += " 거리+" + distance;
		return info;
	}

}
