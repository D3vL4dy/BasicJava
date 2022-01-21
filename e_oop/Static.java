package e_oop;

public class Static {
	
	/*
	 * - static을 붙이면 프로그램 실행시 메모리에 올라간다.
	 * - 객체생성을 하지 않아도 사용할 수 있다.
	 * - static을 붙인 변수는 객체간에 변수의 값을 공유한다.
	 * - static이 붙은 멤버의 명칭 : 클래스 변수, 클래스 메서드
	 * - static이 붙지 않은 멤버의 명칭 : 인스턴스 변수, 인스턴스 메서드
	 * 전역변수는 같은 클래스에서만 사용하는 변수
	 * static이 붙으면 다른 클래스에서도 사용 가능
	 */
	
	//모두에게 적용되는 것은 static이 붙지만
	//각자에게 적용되는 것은 static을 붙이지 않는다.
	
	//변수의 위치 : 메서드 안에 있으면 지역변수, 밖에 있으면 전역변수
	//static 여부 : 전역변수 중에 static이 붙으면 클래스 변수, 붙지 않으면 인스턴스 변수
	//지역변수에는 static을 붙이지 않음
	
	//변수에 static을 붙이는 이유는 값을 공유하기 위함이다.
	
	public static void main(String[] args) {
		Marine m1 = new Marine();
		Marine m2 = new Marine();

		System.out.println("m1 HP : " + m1.hp);
		System.out.println("m2 HP : " + m2.hp);

		m1.hp -= 10;
		m2.hp -= 20;

		System.out.println("m1 HP : " + m1.hp);
		System.out.println("m2 HP : " + m2.hp);

		System.out.println("m1 ATT : " + m1.attack);
		System.out.println("m1 DEF : " + m1.defence);
		System.out.println("m2 ATT : " + m2.attack);
		System.out.println("m2 DEF : " + m2.defence);

		m1.attack += 1; // static은 객체끼리 변수를 공유. 모든 객체에 해당
		m2.defence += 1;

		System.out.println("m1 ATT : " + m1.attack);
		System.out.println("m1 DEF : " + m1.defence);
		System.out.println("m2 ATT : " + m2.attack);
		System.out.println("m2 DEF : " + m2.defence);

		
		
		
		// 객체 생성을 하지 않고 사용하는 메서드 : static이 붙어있음
		// static이 붙어있는 것들은 클래스명. 으로 호출
		System.out.println(Math.random());

		System.out.println("문자열 입력>"); // 스캐너없이 입력
		String str = ScanUtil.nextLine(); // 클래스명.메서드
		System.out.println("입력받은 문자열 : " + str);
		System.out.println("숫자 입력>");
		int num = ScanUtil.nextInt();
		System.out.println("입력받은 숫자 : " + num);
	}

}

//static을 메서드에 붙이는 이유는 객체 생성을 하지 않기 위함
//자주 사용해야 하는데 매번 생성하면 메모리 낭비

class Marine {
	int hp = 40; // 체력
	static int attack = 5; // 공격력:모두에게 적용되는 것
	static int defence = 0; // 방어력:모두에게 적용되는 것

}
