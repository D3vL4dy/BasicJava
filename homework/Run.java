package homework;

public class Run extends BasicSetting{
	
	// 달리는 메소드
		void run() {
			
			System.out.println("============달리기를 시작합니다.============");
			System.out.println("=============모두 준비하세요.=============");
			if (distance < DISTANCE) {
				distance += 10;
				hp -= 2;
				bodyMoisture -= 1;
				System.out.println(name + " 님이 " + distance + "지점에 도착하였습니다.");
				System.out.println("남은 거리는 " + (DISTANCE - distance) + "입니다.");
				System.out.println("체력 : " + hp);
				System.out.println("속도 : " + speed);
				System.out.println("체내수분량 : " + bodyMoisture);
			}
			if (hp <= 1) {
				System.out.println("체력이 바닥입니다. 잠시 쉬어 가세요.");
				distance -= 7;
				hp += 1;
			}
			if (bodyMoisture <= 1) {
				System.out.println("탈진 직전입니다. 물을 마셔야 합니다.");
				distance -= 5;
				bodyMoisture += 1;
			}

		}

}
