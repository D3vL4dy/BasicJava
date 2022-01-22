package homework;

public class Setting {

	String name;
	int hp; // 체력
	int speed; // 속도
	int bodyMoisture; // 체내수분량
	int distance; // 거리
	final int DISTANCE = 50;
	int time = 10; // 시간
	Item[] item; // 아이템

	// 상태창 메소드
	void status() {
		System.out.println("이름 : " + name);
		System.out.println("체력 : " + hp + "/5");
		System.out.println("속도 : " + speed + "/5");
		System.out.println("체내수분량 : " + bodyMoisture + "/10");
		System.out.println("\n");
	}

}
