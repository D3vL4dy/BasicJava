package f_game;

public class Character {
	// 변수:대상의 속성. 대상이 가지고 있는 것 중에 우리가 조작할 수 있는 것(변하는 것)
	// ex) 이름, 체력, 공격력, 방어력, 레벨, 경험치
	// 메서드:대상이 하는 동작, 행동

	String name; // 이름 : 사용자가 직접 입력하므로 생성자(파라미터)로
	int maxHp; // 최대 체력
	int maxMp; // 최대 마나
	int hp; // 체력
	int mp; // 마나
	int att; // 공격력
	int def; // 방어력
	int level; // 레벨
	int exp; // 경험치
	Item[] items; // 보유아이템

	// 캐릭터 초기화
	Character(String name, int hp, int mp, int att, int def) { // 생성자
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.att = att;
		this.def = def;
		this.level = 1;
		this.exp = 0;
		this.items = new Item[10];
	}

	// 상태창 메소드
	void status() {
		System.out.println("=============== 상태 ===============");
		System.out.println("이름 : " + name);
		System.out.println("레벨 : " + level + "(" + exp + "/100)");
		System.out.println("체력 : " + hp + "/" + maxHp);
		System.out.println("마나 : " + mp + "/" + maxMp);
		System.out.println("공격력 : " + att);
		System.out.println("방어력 : " + def);
		System.out.println("=============== 아이템 ===============");
		for (int i = 0; i < items.length; i++) { // 캐릭터가 보유하고 있는 아이템을 하나씩 출력
			if (items[i] != null) { // null이 아닌 경우만 출력
				System.out.println(items[i]); // 타입이 아이템(클래스)이라 객체를 출력 > 주소가 출력됨
			}
		}
		System.out.println("====================================");
	}

	// 공격 메소드
	void attack(Monster m) { // 공격할 대상을 메소드 내부에서 고정적으로 정해줄 수 없기 때문에 파라미터로 받음
		int damage = att - m.def;
		damage = damage <= 0 ? 1 : damage; // 내 공격력 < 상대의 방어력:음수의 결과가 나올 때 최소 1의 데미지
		m.hp -= damage <= m.hp ? damage : m.hp; // 몬스터에 남아있는 체력보다 공격이 더 큰 경우 체력이 음수가 되므로 0이 되도록 해줌
		System.out.println(name + "가 공격으로 " + m.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(m.name + "의 남은 체력 : " + m.hp);
	}

	// 경험치를 얻는 메소드
	void getExp(int exp) { // 얼만큼의 경험치를 얻을건지 외부에서 결정하므로 파라미터 사용
		this.exp += exp;
		System.out.println(exp + "의 경험치를 획득하였습니다."); // 최대 경험치 100으로 설정창에서 미리 설정해줌

		while (100 <= this.exp) { // 경험치를 얻었을 대 최대치가 100인데 2-300씩 얻을 경우 2-3번 레벨업하는 반복문
			levelUp();
			this.exp -= 100;
		}
	}

	// 레벨업하는 메소드
	void levelUp() {
		level++; // 레벨이 증가하면 다른 능력치들도 조금씩 증가
		maxHp += 10;
		maxMp += 5;
		att += 2;
		def += 2;
		hp += maxHp;
		mp += maxMp;
		System.out.println("레벨업!!");
	}

	// 아이템을 얻는 메소드
	void getItem(Item item) { // 몬스터마다 다르기 때문에 어떤 아이템을 얻을 것인지 외부에서 받음
		System.out.println(item.name + "을 획득하였습니다.");
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) { // 배열을 돌면서 비어있는 공간에 아이템 저장
				items[i] = item;
				break;
			}
		}
		maxHp += item.hp; // 아이템을 가지고 있으면 아이템의 능력치가 캐릭터의 능력치에 바로 반영됨
		maxMp += item.mp;
		att += item.att;
		def += item.def;
	}

}