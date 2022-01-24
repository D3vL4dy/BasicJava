package homework;

import java.util.Arrays;
import e_oop.ScanUtil;
 //상속받지 말고 MyGame으로 옮겨
//Runner 객체를 생성해 접근
public class Run extends Runner{ // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음

	// 선수의 상태를 점검
	boolean check_status(Runner runner) { // boolean으로 해당 선수가 달릴 수 있는지 없는지를 판단
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (runner.hp == 0 || runner.bodyMoisture == 0) { // || runner.hp == 1
				flag = false;
				runner.is_taking_rest = true;
			}
		}
		return flag;
	}
	
	void print_status(Runner[] runner) {
		for (int i = 0; i < runner.length; i++) {
			System.out.println(runner[i].name + " 님이 " + runner[i].distance + "m지점에 있습니다.");
			System.out.println("남은 거리는 " + (DISTANCE - runner[i].distance) + "m입니다.");
			System.out.println("체력 : " + runner[i].hp + "/5");
			System.out.println("속도 : " + runner[i].speed + "/5");
			System.out.println("체내수분량 : " + runner[i].bodyMoisture + "/10");
			System.out.println();
			if (runner[i].is_taking_rest) {
				if (runner[i].hp == 0) { // || runner.hp == 1
					runner[i].hp += 2;
					runner[i].is_taking_rest = false;
				}
				if (runner[i].bodyMoisture == 0) {// || runner.bodyMoisture == 1
					runner[i].bodyMoisture += 2;
					runner[i].is_taking_rest = false;
				}
			}
		}
	}

	// 거리 정보 출력(10~40까지)
	void plus_distance_40(Runner runner) { // 파라미터로 선수를 입력받음 (선수마다 값이 다르기 때문)
		runner.distance += 10;
		runner.hp -= 1;
		runner.bodyMoisture -= 1;
	}

	void rest(Runner runner) {
		if (runner.is_taking_rest) {
			if (runner.hp == 0) { // || runner.hp == 1
				runner.hp += 2;
			}
			if (runner.bodyMoisture == 0) {// || runner.bodyMoisture == 1
				runner.bodyMoisture += 2;
			}
		}
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
	}
	
	void running_lane(Runner runner) {
		for (int i = 0; i < runner.lane.length; i++) {
			runner.lane[i] = "=";
		}
		if ((runner.distance % 10) == 0) {
			runner.lane[runner.distance] = "0";
		}
	
		for (int i = 0; i< runner.lane.length; i++) {
				System.out.print(runner.lane[i]);
		}

		System.out.println();
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
	String[] lane_1 = new String[DISTANCE];
	String[] lane_2 = new String[DISTANCE];
	String[] lane_3 = new String[DISTANCE];
	String[] lane_4 = new String[DISTANCE];

	

	// 5초마다 10m씩 이동
	private void stop() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

	// 반복문
	void run(Runner[] runner) { // Runner라는 클래스로 만들어진 배열을 인자(runner)로 받음
		int time = 0; // 시간
		while (runner[0].distance <= DISTANCE || runner[1].distance <= DISTANCE || runner[2].distance <= DISTANCE
				|| runner[3].distance <= DISTANCE) {
			
			time += 10;
			
			if (time == 10) { // 10초
				stop();
				System.out.println("\n\n<" + time + "초> 지났습니다.");
				meter();
				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) {
						plus_distance_40(runner[i]); 
					}else {
						rest(runner[i]);
					}
				}
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				print_status(runner);
			}

			if (time == 20) { // 20초
				stop();
				System.out.println("\n\n<" + time + "초> 지났습니다.");
				meter();
				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) {
						plus_distance_40(runner[i]); 
					}else {
						rest(runner[i]);
					}
				}
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				print_status(runner);
			}

			if (time == 30) { // 30초
				stop();
				System.out.println("\n\n<" + time + "초> 지났습니다.");
				meter();
				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) {
						plus_distance_40(runner[i]); 
					}else {
						rest(runner[i]);
					}
				}
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				print_status(runner);
			}

			if (time == 40) { // 40초
				stop();
				System.out.println("\n\n<" + time + "초> 지났습니다.");
				meter();
				for (int i = 0; i < runner.length; i++) {
					if (check_status(runner[i])) {
						plus_distance_40(runner[i]); 
					}else {
						rest(runner[i]);
					}
				}
				for (int i = 0; i < runner.length; i++) {
					running_lane(runner[i]);
				}
				print_status(runner);
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
		}

	}

}