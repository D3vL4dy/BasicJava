package homework;

import e_oop.ScanUtil;

public class Run extends Setting { // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음
	
	// 거리 정보 출력
	void print_distance_info(Runner runner) { // 파라미터로 선수를 입력받음 (선수마다 값이 다르기 때문)

		System.out.println("남은 거리는 " + (DISTANCE - runner.distance) + "m입니다.");
		System.out.println("체력 : " + runner.hp + "/5");
		System.out.println("속도 : " + runner.speed + "/5");
		System.out.println("체내수분량 : " + runner.bodyMoisture + "/10");
		System.out.println();
	}

	// 10초에 10m씩 달리는 것으로 설정해 계속할 것인지 입력
	void keep_going() { 
		System.out.println("계속 달리시겠습니까?");
		System.out.println("1.달리기	 2.나가기");
		int num = ScanUtil.nextInt();
		switch (num) {
		case 1:
			System.out.println();
			break;
		case 2:
			System.out.println("게임이 종료되었습니다.");
			System.exit(0);
		}
		System.out.println();
	}

	// 선수의 상태를 점검
	boolean check_status(Runner runner) { // boolean으로 해당 선수가 달릴 수 있는지 없는지를 판단
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (runner.hp == 0) { // || runner.hp == 1
				System.out.println(runner + "님의 체력이 바닥입니다. 10초 쉬어 가세요.");
				runner.hp += 2;
				System.out.println("체력 +2");
				flag = false;
			}
			if (runner.bodyMoisture == 0) {// || runner.bodyMoisture == 1
				System.out.println(runner + "님이 탈진 직전입니다. 10초 쉬어 가세요");
				runner.bodyMoisture += 2;
				System.out.println("체내수분량 +2");
				flag = false;
			}
		}
		return flag;
	}

	
	// 반복문
	void run(Runner[] runner) { // Runner 타입의 runner 배열을 받음
		while (runner[0].distance != DISTANCE || runner[1].distance != DISTANCE || runner[2].distance != DISTANCE
				|| runner[3].distance != DISTANCE) {

			if (time == 10) { // 10초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println();
				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) {
						runner[i].distance += 10;
						System.out.println(runner[i].name + " 님이 " + runner[i].distance + "m지점에 도착하였습니다.");
						runner[i].hp -= 1;
						runner[i].bodyMoisture -= 1;
					} else {
						System.out.println("충전중입니다.//////////");
					}
					print_distance_info(runner[i]);
				}
				keep_going();
				time += 10;
			}

			if (time == 20) { // 20초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println();
				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) {
						runner[i].distance += 10;
						System.out.println(runner[i].name + " 님이 " + runner[i].distance + "m지점에 도착하였습니다.");
						runner[i].hp -= 1;
						runner[i].bodyMoisture -= 1;
					} else {
						System.out.println("충전중입니다.//////////");
					}
					print_distance_info(runner[i]);
//					runner[i].getitem(runner[i]);
//					runner[i].hp += item[i].hp; // 아이템을 가지고 있으면 아이템의 능력치가 캐릭터의 능력치에 바로 반영됨
//					runner[i].bodyMoisture += item[i].bodyMoisture;
//					runner[i].distance += item[i].distance;
				}
				keep_going();
				time += 10;
			}

			if (time == 30) { // 30초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println();
				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) {
						runner[i].distance += 10;
						System.out.println(runner[i].name + " 님이 " + runner[i].distance + "m지점에 도착하였습니다.");
						runner[i].hp -= 1;
						runner[i].bodyMoisture -= 1;
					} else {
						System.out.println("충전중입니다.//////////");
					}
					print_distance_info(runner[i]);
				}
				keep_going();
				time += 10;
			}

			if (time == 40) { // 40초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println();
				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) {
						runner[i].distance += 10;
						System.out.println(runner[i].name + " 님이 " + runner[i].distance + "m지점에 도착하였습니다.");
						runner[i].hp -= 1;
						runner[i].bodyMoisture -= 1;
					} else {
						System.out.println("충전중입니다.//////////");
					}
					print_distance_info(runner[i]);
				}
				keep_going();
				time += 10;
			}

			if (time == 50) { // 50초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println();

				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) { // 상태가 괜찮으면 거리+10
						runner[i].distance += 10;

						if (runner[i].distance == DISTANCE) {
							System.out.println(runner[i].name + " 님이 " + DISTANCE + "m지점에 도착하였습니다.");
							System.out.println("축하합니다~!");
							System.out.println("게임을 종료합니다.");
							System.out.println();
							System.exit(0);
						} else {
							System.out.println(runner[i].name + " 님이 " + runner[i].distance + "m지점에 도착하였습니다.");
							runner[i].hp -= 1;
							runner[i].bodyMoisture -= 1;
							print_distance_info(runner[i]);
						}
					} else {
						System.out.println("충전중입니다.//////////");
						print_distance_info(runner[i]);
					}
				}
				keep_going();
				time += 10;
			}

			if (time == 60) { // 60초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println();

				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) { // 상태가 괜찮으면 거리+10
						runner[i].distance += 10;

						if (runner[i].distance == DISTANCE) {
							System.out.println(runner[i].name + " 님이 " + DISTANCE + "m지점에 도착하였습니다.");
							System.out.println("축하합니다~!");
							System.out.println("게임을 종료합니다.");
							System.out.println();
							System.exit(0);
						} else {
							System.out.println(runner[i].name + " 님이 " + runner[i].distance + "m지점에 도착하였습니다.");
							runner[i].hp -= 1;
							runner[i].bodyMoisture -= 1;
							print_distance_info(runner[i]);
						}
					} else {
						System.out.println("충전중입니다.//////////");
						print_distance_info(runner[i]);
					}
				}
				keep_going();
				time += 10;
			}

			if (time == 70) {
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println();

				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) { // 상태가 괜찮으면 거리+10
						runner[i].distance += 10;

						if (runner[i].distance == DISTANCE) {
							System.out.println(runner[i].name + " 님이 " + DISTANCE + "m지점에 도착하였습니다.");
							System.out.println("축하합니다~!");
							System.out.println("게임을 종료합니다.");
							System.out.println();
							System.exit(0);
						} else {
							System.out.println(runner[i].name + " 님이 " + runner[i].distance + "m지점에 도착하였습니다.");
							runner[i].hp -= 1;
							runner[i].bodyMoisture -= 1;
							print_distance_info(runner[i]);
						}
					} else {
						System.out.println("충전중입니다.//////////");
						print_distance_info(runner[i]);
					}
				}
				keep_going();
				time += 10;
			}

		}

	}
}
