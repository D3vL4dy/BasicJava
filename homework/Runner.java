package homework;

public class Runner{ // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음

	String name;
<<<<<<< HEAD
	int hp = (int) (Math.random() * 5) + 1; // 체력 1~5까지
	int bodyMoisture = (int) (Math.random() * 4) + 2; // 체내수분량 2~5 까지
=======
	int hp = (int) (Math.random() * 4) + 2; //체력 2~5까지
	int bodyMoisture = (int) (Math.random() * 5) + 3; //체내수분량 3~7 까지
>>>>>>> d76b7dda9402d72049422e40ebd544e005d2223a
	int distance = 0; // 거리
	

	boolean is_taking_rest = true; // 휴식중
	boolean arv = false;
<<<<<<< HEAD

	String[] lane = new String[50];
	
	
=======
	
	String[] lane = new String[50];

>>>>>>> d76b7dda9402d72049422e40ebd544e005d2223a
	

	@Override
	public String toString() {
		return name;
	}

}
