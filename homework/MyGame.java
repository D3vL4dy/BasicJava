package homework;

import e_oop.ScanUtil;

public class MyGame {

	BasicSetting user;
	Item[] item;
	String[] Names = { "선수1", "선수2", "선수3", "선수4" };
	BasicSetting[] com = new BasicSetting[Names.length];

	MyGame() {
		user = new BasicSetting();
		user.name = ScanUtil.nextLine();

		item = new Item[10];
		item[0] = new Item("체력up!", 2, 0, 0, 0);
		item[1] = new Item("체력down!", -2, 0, 0, 0);
		item[2] = new Item("속도up!", 0, 2, 0, 0);
		item[3] = new Item("속도down..", 0, -2, 0, 0);
		item[4] = new Item("꽝!!!", 0, 0, 0, 0);
		item[5] = new Item("물을 마십니다.", 0, 0, 2, 0);
		item[6] = new Item("잠시 쉬어가세요.", 0, 0, 0, -5);
		item[7] = new Item("출발점으로 돌아가세요.", 0, 0, 0, -50);
		item[8] = new Item("순간이동", 0, 0, 0, 10);
		item[9] = new Item("꽝!!!", 0, 0, 0, 0);
	}

	void start() {

		while (true) {

			System.out.println("!~!~ 50m 달리기 게임 ~!~!");
			System.out.println("1.프로필   2.참여   0.종료");
			int input = ScanUtil.nextInt();
			user.set();
			com[0].set();
			com[1].set();
			com[2].set();
			com[3].set();

			switch (input) {
			case 1:
				user.status();
				com[0].status();
				com[1].status();
				com[2].status();
				com[3].status();

				break;
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0); // 프로그램을 강제종료시키는 메소드
			}
		}
	}

	public static void main(String[] args) {

		MyGame mg = new MyGame();
		for (int i = 0; i < mg.Names.length; i++) {
			mg.com[i] = new BasicSetting(); // 객체를 생성해 배열에 저장
			mg.com[i].name = mg.Names[i];
			mg.com[i].set();
		}
	}
}
