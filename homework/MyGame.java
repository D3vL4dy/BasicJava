package homework;

import e_oop.ScanUtil;

public class MyGame {

	String[] Names = { "", "선수1", "선수2", "선수3" };
	Runner[] runner = new Runner[Names.length]; // 객체를 참조하기 위한 참조변수 선언

	Item[] item; // ?????????????????????????????????????????????????????????????????????? 이곳에 적은
					// 이유?

	// 생성자
//	MyGame() {
//		// 아이템 초기화
//		item = new Item[7];
//		item[0] = new Item("체력up!", 2, 0, 0, 0);
//		item[1] = new Item("체력down!", -2, 0, 0, 0);
//		item[2] = new Item("꽝!!!", 0, 0, 0, 0);
//		item[3] = new Item("물을 마십니다.", 0, 0, 2, 0);
//		item[4] = new Item("잠시 쉬어가세요.", 0, 0, 0, -10);
//		item[5] = new Item("출발점으로 돌아가세요.", 0, 0, 0, -50);
//		item[6] = new Item("순간이동", 0, 0, 0, 10);
//	}

	void start() {
		System.out.println("----------------------------");
		System.out.println("!~!~!~ 50m 달리기 게임 ~!~!~!");
		System.out.println("----------------------------");

		for (int i = 0; i < Names.length; i++) {
			runner[i] = new Runner(); // Runner클래스에 접근하기 위해 객체를 생성해 배열에 저장
			runner[i].name = Names[i];
		}

		while (true) {
			System.out.println("1.참여  	0.종료");
			int input = ScanUtil.nextInt();
			System.out.println();

			switch (input) {
			case 1:
				System.out.println("게임에 참여할 이름을 입력하세요.");
				runner[0].name = ScanUtil.nextLine(); // 사용자 이름을 입력받음
				System.out.println();
				System.out.println("---------------------------");
				System.out.println("         선수 프로필         ");
				System.out.println("---------------------------");
				for (int i = 0; i < runner.length; i++) {
					runner[i].status();
				}
				System.out.println("---------------------------");
				ready();
				break;
			case 0:
				System.out.println("게임이 종료되었습니다.");
				System.exit(0); // 프로그램을 강제종료시키는 메소드
			}
		}

	}

	void ready() {

		int a = 0;
		ready: while (true) {
			System.out.println("달리기를 시작합니다.");
			System.out.println("모두 준비해주세요.");
			System.out.println();
			System.out.println("1.출발	2.종료");
			a = ScanUtil.nextInt();
			switch (a) {
			case 1:
				System.out.println("출발!");
				System.out.println("\n");
				new Run().run(runner);
				break;
			case 2:
				System.out.println("게임이 종료되었습니다.");
				System.exit(0);
			}
		}

	}

	public static void main(String[] args) {

		new MyGame().start();
	}

}
