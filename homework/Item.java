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

	public String toString(Runner runner) { // 아이템이 가진 정보를 리턴
		String info = runner.name + " : ";
		if (0 < runner.hp)
			info += " 체력+" + hp; // 아이템이 올려주는 능력치만 적용하기 위해 if문으로 생성
		if (0 < runner.speed)
			info += " 속도+" + speed;
		if (0 < runner.bodyMoisture)
			info += " 체내수분량+" + bodyMoisture;
		if (0 < runner.distance)
			info += " 거리+" + distance;
		return info;
	}

//		Item itemChoose() {
//			return item[item_num];
//		}

}
