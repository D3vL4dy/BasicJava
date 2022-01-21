package f_game;

import e_oop.ScanUtil;

public class MyGame {

	// 변수 생성 : 게임에 등장하는 것. 몬스터는 사냥할 때 생성해서 사용
	Character c;
	Item[] items;

	// 생성자
	MyGame() {
		c = new Character("가렌", 100, 50, 20, 10);

		items = new Item[10];
		items[0] = new Item("무한의 대검", 0, 0, 10, 0);
		items[1] = new Item("가시갑옷", 0, 0, 0, 10);

	}

	public static void main(String[] args) { // 게임이 진행되는 내용
		// 메인에서 직접 코딩을 하게 되면 변수들을 사용할 때 그냥 사용이 아닌 객체를 생성 후 사용해야 됨 (main 메소드가 static 이라서)
		// 메인 메소드는 이미 메모리에 올라가 있는 상태 (변수는 객체 생성을 해야 올라감)
		// main 에서 사용하려면 갱체 생성을 먼저 해줘야 사용 가능
		// -> System.out.println(new MyGame().c);

		new MyGame().start(); // 따로 메소드에 만 내용을 만들어 호출. 객체를 생성하지 않아도 사용 가능
	}

	void start() {
		while (true) {

			System.out.println("1. 내정보 2.사냥 0.종료");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				c.status();
				break;
			case 2:
				hunt();
				break;
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0); // 프로그램을 강제종료시키는 메소드
			}
		}
	}

	// 사냥하는 메소드
	void hunt() {
		Monster m = new Monster("고블린", 20, 10, 15, 10, 1, 150, new Item[] { items[0], items[1] });
		System.out.println(m.name + "를 만났습니다. 전투를 시작합니다.");

		int input = 0;
		battle: while (true) {
			System.out.println("1공격 2.도망");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				c.attack(m); // 캐릭터가 공격
				if (m.hp <= 0) { // 몬스터의 체력이 끝나면 경험치, 아이템을 얻음
					System.out.println(m.name + "을 처치하였습니다.");
					c.getExp(m.exp);
					c.getItem(m.itemDrop());
					break battle;
				}
				m.attack(c); // 몬스터가 공격
				break;
			case 2:
				System.out.println(m.name + "으로부터 도망쳤습니다.");
				break battle;
			}
		}

	}

}
