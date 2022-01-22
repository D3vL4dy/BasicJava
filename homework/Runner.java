package homework;

public class Runner extends Setting { // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음

	// 생성자 : 변수 초기화
	Runner() {
		this.hp = (int) (Math.random() * 4) + 2; // 2~5까지
		this.speed = 5;
		this.bodyMoisture = (int) (Math.random() * 5) + 3; // 3~7 까지
		this.distance = 0;
		this.item = new Item[7];
	}

	// 랜덤으로 아이템 획득
	void getitem(Runner runner) {
		System.out.println("아이템 뽑기!!");
		 // 아이템을 랜덤으로 골라 리턴해줌
		System.out.println(runner + "님이 " + item[(int) (Math.random() * item.length)] + "을 뽑았습니다.");
		System.out.println("아이템은 바로 적용됩니다.");
	}

//	//아이템을 얻는 메소드
//	void getItem(Item item) { // 몬스터마다 다르기 때문에 어떤 아이템을 얻을 것인지 외부에서 받음
//		System.out.println(item.name + "을 획득하였습니다.");
//		for (int i = 0; i < 8; i++) {
//			if (item[i] == null) { // 배열을 돌면서 비어있는 공간에 아이템 저장
//				item[i] = item;
//				break;
//			}
//		}
//		hp += item.hp; // 아이템을 가지고 있으면 아이템의 능력치가 캐릭터의 능력치에 바로 반영됨
//		bodyMoisture += item.bodyMoisture;
//		distance += item.distance;
//	}

}
