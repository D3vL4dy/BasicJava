package homework;

public class Runner { // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음

	String name;
	int hp; // 체력
	int bodyMoisture; // 체내수분량
	int distance = 0; // 거리

	boolean is_taking_rest = true; // 휴식중

	String[] lane = new String[50];

	// 생성자 : 변수 초기화
	public Runner() {
		this.hp = (int) (Math.random() * 4) + 2; // 2~5까지
		this.bodyMoisture = (int) (Math.random() * 5) + 3; // 3~7 까지
		this.distance = 0;
	}

	@Override
	public String toString() {
		return name;
	}

	
}
