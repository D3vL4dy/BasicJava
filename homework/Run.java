package homework;

import e_oop.ScanUtil;

public class Run extends Setting { // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음

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
		if (check_status(runner)) { // 상태가 괜찮으면 거리+10
			runner.distance += 10;

			if (runner.distance == DISTANCE) {
				System.out.println(runner.name + " 님이 " + DISTANCE + "m지점에 도착하였습니다.");
				System.out.println("축하합니다~!");
				System.out.println("게임을 종료합니다.");
				System.out.println();
				System.exit(0);
			} else {
				System.out.println(runner.name + " 님이 " + runner.distance + "m지점에 도착하였습니다.");
				runner.hp -= 1;
				runner.bodyMoisture -= 1;
				print_distance_info_40(runner);
			}
		} else {
			System.out.println("충전중입니다.//////////");
			print_distance_info_40(runner);
		}
	}

	// 아이템을 얻는 메소드
	void getitem(Runner runner) {
		System.out.println("아이템 뽑기!!");
		System.out.println(runner + "님이 " + itemChoose() + "을 뽑았습니다.");
		System.out.println("아이템은 바로 적용됩니다.");

		// 아이템을 가지고 있으면 아이템의 능력치가 캐릭터의 능력치에 바로 반영됨
//		runner.hp += item.hp; 
//		runner.bodyMoisture += item.bodyMoisture;
//		runner.distance += item.distance;
	}

	Item itemChoose() {
		return item[item_num];
	}

	// 선수의 위치 표시
	String[][] lane = new String[4][25];
	// String[][] runner_location = new String[4][25];

	void running_lane(Runner runner) {
		for (int i = 0; i < lane.length; i++) { // 4
			for (int j = 0; j < lane[i].length; j++) { // 25
				lane[i][j] = "=";

				if (runner.distance == 10) {
					lane[i][5] = "0";
				} else if (runner.distance == 20) {
					lane[i][5] = "0";
				} else if (runner.distance == 30) {
					lane[i][5] = "0";
				} else if (runner.distance == 40) {
					lane[i][5] = "0";
				} else if (runner.distance == 50) {
					lane[i][5] = "0";
s
				}
				System.out.print(lane[i][j]);
			}
			System.out.println();
		}

	}

	// 반복문
	void run(Runner[] runner) { // Runner 타입의 runner 배열을 받음
		while (runner[0].distance != DISTANCE || runner[1].distance != DISTANCE || runner[2].distance != DISTANCE
				|| runner[3].distance != DISTANCE) {

			if (time == 10) { // 10초
				System.out.println("<" + time + "초> 지났습니다.");
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_40(runner[i]);
				}
				keep_going();
				time += 10;
			}

			if (time == 20) { // 20초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println("---------------------------");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_40(runner[i]);
//					getitem(runner[i]);
				}
				keep_going();
				time += 10;
			}

			if (time == 30) { // 30초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println("---------------------------");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_40(runner[i]);
				}
				keep_going();
				time += 10;
			}

			if (time == 40) { // 40초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println("---------------------------");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_40(runner[i]);
				}
				keep_going();
				time += 10;
			}

			if (time == 50) { // 50초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println("---------------------------");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_50(runner[i]);
				}
				keep_going();
				time += 10;
			}

			if (time == 60) { // 60초
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println("---------------------------");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_50(runner[i]);
				}
				keep_going();
				time += 10;
			}

			if (time == 70) {
				System.out.println("<" + time + "초> 지났습니다.");
				System.out.println("---------------------------");
				for (int i = 0; i < runner.length; i++) {
					print_distance_info_50(runner[i]);
				}
				keep_going();
				time += 10;
			}

		}

	}

}
