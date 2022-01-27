package homework;

public class Runner { // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음

	String name;
	int hp = (int) (Math.random() * 4) + 1; // 체력 1~4까지
	int bodyMoisture = (int) (Math.random() * 4) + 1; // 체내수분량 1~4 까지
	int distance = 0; // 거리

	boolean is_taking_rest = true; // 휴식중

	String[] lane = new String[50];

	@Override
	public String toString() {
		return name;
	}

}
