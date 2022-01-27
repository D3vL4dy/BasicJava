package homework;

import e_oop.ScanUtil;
import java.util.Arrays;

public class MyGame { // 게임 내의 행위

	String winner; // 사용자가 입력한 정답
	final int DISTANCE = 50; // 결승선
	int time = 0; // 시간

	// 10m마다 거리 표시
	String[] meter = new String[5];

	void meter() {
		for (int i = 0; i < meter.length; i++) {
			meter[i] = "       " + ((i + 1) * 10) + "m";
			System.out.print(meter[i]);
		}
		System.out.println();
	}

	// 선수의 위치를 레인 위에 표시
	void running_lane(Runner runner) {

		for (int i = 0; i < 50; i++) {
			runner.lane[i] = "=";
		}
		if ((runner.distance != 0) && (runner.distance % 10 == 0)) {
			runner.lane[runner.distance - 1] = "0";
		}
		for (int i = 0; i < 50; i++) {
			System.out.print(runner.lane[i]);
		}
		System.out.println("\n");
	}

	// 3초마다 10m씩 이동
	private void stop() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 선수가 달릴 수 있는지 상태 점검
	boolean check_status(Runner runner) { // boolean으로 해당 선수가 달릴 수 있는지 없는지를 판단
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (runner.hp == 0 || runner.bodyMoisture == 0) { // 달릴 수 없음
				flag = false;
				runner.is_taking_rest = true;
			}
		}
		return flag;
	}

	// 휴식중인 선수의 능력 변화
	void rest(Runner runner) {
		if (runner.is_taking_rest) { // 선수 휴식중
			if (runner.hp == 0) {
				runner.hp += 2;
			}
			if (runner.bodyMoisture == 0) {
				runner.bodyMoisture += 2;
			}
		}
	}

	// 선수의 위치와 상태 출력 (10~40)
	void print_distance_info_40(Runner[] runner) {
		stop();
		System.out.println("\n\n\n<" + time + "초> 지났습니다.\n");
		for (int i = 0; i < runner.length; i++) {
			if (check_status(runner[i])) { // 달릴 수 있는 상태
				runner[i].distance += 10; // 현재 위치, 남은 거리와 능력 출력
				System.out.println(runner[i].name + " 님이 " + runner[i].distance + "m지점에 도착했습니다.");
				System.out.println("남은 거리는 " + (DISTANCE - runner[i].distance) + "m입니다.");
				runner[i].hp -= 1;
				runner[i].bodyMoisture -= 1;
				System.out.println("체력 (-1): " + runner[i].hp + "/5");
				System.out.println("체내수분량 (-1): " + runner[i].bodyMoisture + "/10");
				System.out.println("\n");
			} else {
				System.out.println(runner[i].name + " 님의 현재 위치는 " + runner[i].distance + "m 입니다.");
				System.out.println("\n...충전중...\n\n");
				rest(runner[i]); //
			}
		}
		meter();
		for (int i = 0; i < runner.length; i++) {
			running_lane(runner[i]);
		}
		System.out.println();
	}
	
	// 한명이라도 50m에 도착하면 게임 종료
		void arrival(Runner[] runner) {
			int arrival_num = 0;
			boolean winner_flag = false;
			System.out.println("\n\n");
			
			for (int i = 0; i < runner.length; i++) {
				if (runner[i].distance == DISTANCE) { // 한명이라도 50m에 도착하면 true
					System.out.println(runner[i].name + "님이 결승선에 도착했습니다.");
					arrival_num++;
					if (runner[i].name.equals(this.winner)) {
						winner_flag = true;
					}
				}
			}
			
			System.out.print("사용자가 입력한 1등 : ");
			String[] split = winner.split(" ");
			System.out.println(Arrays.toString(split));
			
			if (0 < arrival_num) {
				if (winner_flag == true) {
					
					System.out.println("\n정답을 맞췄습니다.  ~~~↖^ㅠ^↗~~~");
				} else {
					System.out.println("게임 실패! ....↙-___-↘....");
				}
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			}
		}

		// 선수의 위치와 상태 출력 (50부터~)
		void print_distance_info_50(Runner[] runner) {
		stop();
		System.out.println("\n\n\n<" + time + "초> 지났습니다.\n");
		for (int i = 0; i < runner.length; i++) {
			if (check_status(runner[i])) { // 달릴 수 있는 상태
				runner[i].distance += 10;
				System.out.println(runner[i].name + " 님이 " + runner[i].distance + "m지점에 도착하였습니다.");
				if (runner[i].distance == DISTANCE) { // 결승선 도착
					System.out.println("축하합니다~!\n\n");
				} else {
					runner[i].hp -= 1;
					runner[i].bodyMoisture -= 1;
					System.out.println("남은 거리는 " + (DISTANCE - runner[i].distance) + "m입니다.");
					System.out.println("체력 (-1) : " + runner[i].hp + "/5");
					System.out.println("체내수분량 (-1) : " + runner[i].bodyMoisture + "/10\n");
				}
				System.out.println();
			} else { // 달릴 수 없는 상태
				System.out.println(runner[i].name + " 님의 위치는 " + runner[i].distance + "m 입니다.");
				System.out.println("\n...충전중...\n\n");
				rest(runner[i]);
			}
		}
		meter();
		for (int i = 0; i < runner.length; i++) {
			running_lane(runner[i]);
		}
		arrival(runner);
		System.out.println();
	}

	

	// 10초마다 선수의 상태정보를 출력하는 반복문
	void run(Runner[] runner) { // Runner라는 클래스로 만들어진 배열을 인자(runner)로 받음

		while (runner[0].distance <= DISTANCE || runner[1].distance <= DISTANCE || runner[2].distance <= DISTANCE
				|| runner[3].distance <= DISTANCE) {

			time += 10;

			switch (time) {
			case 10:
			case 20:
			case 30:
			case 40:
				print_distance_info_40(runner);
				break;

			case 50:
			case 60:
			case 70:
			case 80:
				print_distance_info_50(runner);
				break;
			}
		}
	}

	// 게임 시작
	void start(Runner[] runner) {
		System.out.println("----------------------------");
		System.out.println("!~!~!~ 50m 달리기 게임 ~!~!~!");
		System.out.println("----------------------------");

		while (true) {
			System.out.println("1.참여  	0.종료");
			int input = ScanUtil.nextInt();
			System.out.println();

			switch (input) {
			case 1:
				System.out.println("어느 선수가 1등일까요? 이름을 입력해주세요!");
				System.out.println(Arrays.toString(runner));
				this.winner = ScanUtil.nextLine();
				System.out.println();
				System.out.println("---------------------------");
				System.out.println("         선수 프로필         ");
				System.out.println("---------------------------");
				for (int i = 0; i < runner.length; i++) {
					System.out.println("이름 : " + runner[i].name);
					System.out.println("체력 : " + runner[i].hp + "/5");
					System.out.println("체내수분량 : " + runner[i].bodyMoisture + "/10");
					System.out.println("\n");
				}
				System.out.println("---------------------------");
				ready(runner); //수정
				break;
			case 0:
				System.out.println("게임이 종료되었습니다.");
				System.exit(0);
			}
		}
	}

	void ready(Runner[] runner) {

		int a = 0;
		while (true) {
			System.out.println("달리기를 시작합니다.");
			System.out.println("모두 준비해주세요.");
			System.out.println();
			System.out.println("1.출발	2.종료");
			a = ScanUtil.nextInt();
			switch (a) {
			case 1:
				System.out.println("출발!");
				System.out.println("\n");
				run(runner);
				break;
			case 2:
				System.out.println("게임이 종료되었습니다.");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		String[] Names = { "강정인", "노혜지", "이유정", "오혜지" };

		Runner[] runner = new Runner[4]; // 객체를 참조하기 위한 참조변수 선언
		for (int i = 0; i < 4; i++) {
			runner[i] = new Runner(); // Runner클래스에 접근하기 위해 객체를 생성해 배열에 저장
			runner[i].name = Names[i];
		}

		MyGame mg = new MyGame();
		mg.start(runner);

//		new MyGame().start(runner);
	}

}