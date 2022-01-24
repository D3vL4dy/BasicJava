package homework;

import java.util.Arrays;
import e_oop.ScanUtil;

public class Run extends Setting { // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음

	// 선수의 상태를 점검
	boolean check_status(Runner runner) { // boolean으로 해당 선수가 달릴 수 있는지 없는지를 판단
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (runner.hp == 0) { // || runner.hp == 1
				System.out.println(runner + "님의 체력이 바닥입니다. 10초 쉬어 가세요.");
				runner.hp += 2;
				System.out.print("(체력 +2) ");
				flag = false;
			}
			if (runner.bodyMoisture == 0) {// || runner.bodyMoisture == 1
				System.out.println(runner + "님이 탈진 직전입니다. 10초 쉬어 가세요");
				runner.bodyMoisture += 2;
				System.out.print("(체내수분량 +2) ");

				flag = false;
			}
		}
		return flag;
	}

	// 거리 정보 출력(10~40까지)
	void print_distance_info_40(Runner runner) { // 파라미터로 선수를 입력받음 (선수마다 값이 다르기 때문)
		if (check_status(runner)) {
			runner.distance += 10;
			System.out.println(runner.name + " 님이 " + runner.distance + "m지점에 도착하였습니다.");
			runner.hp -= 1;
			runner.bodyMoisture -= 1;
		} else {
			System.out.println("충전중입니다.//////////");
		}
		System.out.println("남은 거리는 " + (DISTANCE - runner.distance) + "m입니다.");
		System.out.println("체력 : " + runner.hp + "/5");
		System.out.println("속도 : " + runner.speed + "/5");
		System.out.println("체내수분량 : " + runner.bodyMoisture + "/10");
		System.out.println();
	}

	// 거리 정보 출력(50부터~)
	void print_distance_info_50(Runner runner) { // 파라미터로 선수를 입력받음 (선수마다 값이 다르기 때문)
		
		if (check_status(runner)) {
			runner.distance += 10;
			System.out.println(runner.name + " 님이 " + runner.distance + "m지점에 도착하였습니다.");
			if (runner.distance == DISTANCE) {
				System.out.println("축하합니다~!");
			}
			runner.hp -= 1;
			runner.bodyMoisture -= 1;
		} else {
			System.out.println("충전중입니다.//////////");
		}
		System.out.println("남은 거리는 " + (DISTANCE - runner.distance) + "m입니다.");
		System.out.println("체력 : " + runner.hp + "/5");
		System.out.println("속도 : " + runner.speed + "/5");
		System.out.println("체내수분량 : " + runner.bodyMoisture + "/10");
		System.out.println();
		
		if (runner.distance == DISTANCE) {
			System.out.println(runner.name + " 님이 결승점에 도착한 관계로 게임을 종료합니다.");
			System.exit(0);
		}
		
//		if (check_status(runner)) { // 상태가 괜찮으면 거리+10
//			runner.distance += 10;
//			if (runner.distance == DISTANCE) {
//				System.out.println(runner.name + " 님이 " + DISTANCE + "m지점에 도착하였습니다.");
//				System.out.println("축하합니다~!");
//				System.out.println("게임을 종료합니다.");
//				System.out.println();
//				System.exit(0);
//			} else {
//				System.out.println(runner.name + " 님이 " + runner.distance + "m지점에 도착하였습니다.");
//				runner.hp -= 1;
//				runner.bodyMoisture -= 1;
//				System.out.println("남은 거리는 " + (DISTANCE - runner.distance) + "m입니다.");
//				System.out.println("체력 : " + runner.hp + "/5");
//				System.out.println("속도 : " + runner.speed + "/5");
//				System.out.println("체내수분량 : " + runner.bodyMoisture + "/10");
//
//				System.out.println();
//			}
//		} else {
//			System.out.println("충전중입니다.//////////");
//			System.out.println("남은 거리는 " + (DISTANCE - runner.distance) + "m입니다.");
//			System.out.println("체력 : " + runner.hp + "/5");
//			System.out.println("속도 : " + runner.speed + "/5");
//			System.out.println("체내수분량 : " + runner.bodyMoisture + "/10");
//
//			System.out.println();
//		}
	}

	// 거리 표시
	String[] meter = new String[5];

	void meter() {
		for (int i = 0; i < meter.length; i++) {
			meter[i] = "       " + ((i + 1) * 10) + "m";
			System.out.print(meter[i]);
		}
		System.out.println();
	}

	// 선수의 위치 표시
	String[] lane = new String[DISTANCE];

	void running_lane(Runner runner) {
		for (int i = 1; i < lane.length; i++) {
			lane[i] = "=";
			if ((runner.distance % 10) == 0) {
				lane[runner.distance] = "0";
			}
			System.out.print(lane[i]);
		}
		System.out.println();
		
	}

	// 5초마다 10m씩 이동
	private void stop() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 반복문
	void run(Runner[] runner) { // Runner 타입의 runner 배열을 받음
		while (runner[0].distance <= DISTANCE || runner[1].distance <= DISTANCE || runner[2].distance <= DISTANCE
				|| runner[3].distance <= DISTANCE) {

			if (time == 10) { // 10초
//				stop();
				System.out.println("\n\n<" + time + "초> 지났습니다.");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_40(runner[i]);
				}
				time += 10;

			}

			if (time == 20) { // 20초
				meter();
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				System.out.println("\n\n\n\n\n");
				stop();
				System.out.println("<" + time + "초> 지났습니다.");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_40(runner[i]);
//					new Runner().getitem(runner[i]);
				}
				time += 10;

			}

			if (time == 30) { // 30초
				meter();
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				System.out.println("\n\n\n\n\n");
				stop();
				System.out.println("<" + time + "초> 지났습니다.");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_40(runner[i]);
				}
				time += 10;

			}

			if (time == 40) { // 40초
				meter();
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				System.out.println("\n\n\n\n\n");
				stop();
				System.out.println("<" + time + "초> 지났습니다.");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_40(runner[i]);
				}
				time += 10;

			}

			if (time == 50) { // 50초
				meter();
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				System.out.println("\n\n\n\n\n");
				stop();
				System.out.println("<" + time + "초> 지났습니다.");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_50(runner[i]);
				}
				time += 10;

			}

			if (time == 60) { // 60초
				meter();
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				System.out.println("\n\n\n\n\n");
				stop();
				System.out.println("<" + time + "초> 지났습니다.");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_50(runner[i]);
				}
				time += 10;

			}

			if (time == 70) {
				meter();
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				System.out.println("\n\n\n\n\n");
				stop();
				System.out.println("<" + time + "초> 지났습니다.");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_50(runner[i]);
				}
			}
			time += 10;
		}

	}

}
