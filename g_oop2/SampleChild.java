package g_oop2;

public class SampleChild extends SampleParent{

	
	void childMethod() {
		//상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var); //상속받은 변수
		System.out.println(method(7, 13)); //상속받은 메서드
	}
	
	// 오버라이딩:상속받은 메서드의 내용을 바꾸는 것
	// super:부모클래스와 자식클래스 멤버의 이름이 같을 때 둘을 구분하기 위해 사용
	// super():자식클래스의 생성자에서 부모클래스의 생성자를 호출할 때
	// 다형성:부모타입의 변수로 자식타입의 객체를 사용

	
	// 오버라이딩 : 상속받은 메서드의 내용을 재정의 하는 것
	@Override //어노테이션 : 클래스, 변수, 메서드 등에 표시해 놓는 것
	int method(int a, int b) { // 리턴타입 메서드명 파라미터 모두 같아야 한다.
		return a * b;
	}

	// super, super()
	int var; // 인스턴스 변수

	void test(double var) {
		System.out.println(var); // 지역변수
		System.out.println(this.var); // 인스턴스 변수
		System.out.println(super.var); // 부모 클래스의 인스턴스 변수
		// super : 부모클래스의 멤버와 자식클래스의 멤버가 이름이 중복될 때 둘을 구분하기 위해 사용한다.
	}

	SampleChild() { // 생성자 내 첫번째 줄에 사용해야 하므로 둘을 같이 사용할 수 없음
//		this(); //같은 클래스 내의 다른 생성자 호출
		super(); // 부모클래스의 생성자 호출.
		// this가 없는 생성자에서만 super()를 호출한다.
	}
	
	// 다형성 : 부모타입의 변수로 자식타입의 객체를 사용하는 것
	public static void main(String[] args) {
		SampleChild sc = new SampleChild();

		SampleParent sp = new SampleChild(); // 다형성
		// 변수가 SampleParent라서 SampleParent 변수에 있는 것만 사용 가능
		// 변수(부모)의 타입에 있는 멤버만 사용할 수 있다.
		System.out.println(sp.var);
		sp.method(10, 20);

		// 객체(자식)의 타입에 있는 멤버는 사용할 수 없다.
//		sp.childMethod(); //사용불가
//		sp.test(); //사용불가
		
	}

}
