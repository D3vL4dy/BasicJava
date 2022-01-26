package homework;

public class Runner {

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	void arrival(Runner[] runner){
//		int winner_num = 0;
//		
//		for(int i = 0; i < runner.length; i++) {
//			if (runner[i].distance == DISTANCE) { //한명이라도 50m에 도착하면 true
//				runner[i].arv = true;
//				System.out.println(runner[i]+"님이 결승선에 도착한 관계로 게임을 종료합니다.");
//				winner_num ++;
//			}
//		}
//		if(0 < winner_num) {
//			System.exit(0);
//		}
//	}


}

















