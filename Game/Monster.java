package f_game;

public class Monster {

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

	// 몬스터 초기화
	Monster(String name, int hp, int mp, int att, int def, int level, int exp, Item[] items) { // 생성자로 파라미터를 받아 변수 초기화
		this.name = name;
		this.maxHp = hp;
		this.maxMp = mp;
		this.hp = this.maxHp;
		this.mp = this.maxMp;
		this.att = att;
		this.def = def;
		this.level = level;
		this.exp = exp;
		this.items = items;
	}

	// 공격 메소드 (공격 대상만 다르고 캐릭터와 공격 방식은 같음)
	void attack(Character c) { // 공격할 대상을 메소드 내부에서 고정적으로 정해줄 수 없기 때문에 파라미터로 받음
		int damage = att - c.def;
		damage = damage <= 0 ? 1 : damage; // 내 공격력 < 상대의 방어력:음수의 결과가 나올 때 최소 1의 데미지
		c.hp -= damage <= c.hp ? damage : c.hp; // 몬스터에 남아있는 체력보다 공격이 더 큰 경우 체력이 음수가 되므로 0이 되도록 해줌
		System.out.println(name + "가 공격으로 " + c.name + "에게 " + damage + "만큼 데미지를 주었습니다.");
		System.out.println(c.name + "의 남은 체력 : " + c.hp);
	}

	// 몬스터가 죽으면 아이템을 줍는 행위
	Item itemDrop() {
		return items[(int) (Math.random() * items.length)]; // 몬스터가 가진 아이템을 랜덤으로 골라 리턴해줌
	}

}





























