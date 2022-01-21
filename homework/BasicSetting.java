package homework;

class BasicSetting {
	
	String name;
	int hp; // 체력
	int speed; // 속도
	int bodyMoisture; // 체내수분량
	int distance; // 거리
	final int DISTANCE = 50;
	Item[] item; // 아이템
	
	void userName(String name) {
		this.name = name;
	}

	void set() {
		this.hp = 5;
		this.speed = 5;
		this.bodyMoisture = (int) (Math.random() * 5);
		this.distance = 0;
		this.item = item;
	}

	// 상태창 메소드
	void status() {
		System.out.println("=============== 프로필 ===============");
		System.out.println("이름 : " + name);
		System.out.println("체력 : " + hp + "/" + hp);
		System.out.println("속도 : " + speed + "/" + speed);
		System.out.println("체내수분량 : " + bodyMoisture);
	}

	

}
