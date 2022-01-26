package f_game;

public class Item {

	String name; // 이름 : 사용자가 직접 입력하므로 생성자(파라미터)로
	int hp; // 체력
	int mp; // 마나
	int att; // 공격력
	int def; // 방어력

	// 아이템 초기화
	Item(String name, int hp, int mp, int att, int def) { // 아이템이 가진 능력치가 다 다르기 때문에 외부에서 받아서
		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.att = att;
		this.def = def;
	}

	// toString() 메소드 : 객체를 출력했을 때 주소가 아닌 메소드에서 리턴된 내용이 출력되게 함
	public String toString() { // 아이템이 가진 정보를 리턴
		String info = name + " : ";
		if (0 < hp)
			info += " 체력+" + hp; // 아이템이 올려주는 능력치만 적용하기 위해 if문으로 생성
		if (0 < mp)
			info += " 마나+" + mp;
		if (0 < att)
			info += " 공격력+" + att;
		if (0 < def)
			info += " 방어력+" + def;
		return info;
	}

}
