package homework;

public class Runner extends Setting { // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음

	// 생성자 : 변수 초기화
	Runner() {
		this.hp = (int) (Math.random() * 4) + 2; // 2~5까지
		this.speed = 5;
		this.bodyMoisture = (int) (Math.random() * 5) + 3; // 3~7 까지
		this.distance = 0;
	}
	

	
}
