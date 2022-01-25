package g_oop2;

// 추상클래스
public abstract class SampleAbstractParent {
	// 추상메서드가 있는 클래스는 추상클래스가 되어 객체 생성을 못함. abstract 붙음

	void method() {

	}

	// 추상메서드 : {내용}이 없는 메서드 (블럭 자체가 없음)
	abstract void abstractMethod(); // abstract 라는 제어자가 붙음
	// 내용이 없어 호출이 안됨
	
	//다른 클래스가 상속받기 위해 추상클래스를 사용 (부모클래스로)
	//상속을 받는 클래스들이 메서드는 똑같이 있는데 내용이 다를 때 
	
	
	class SampleAbstractChild extends SampleAbstractParent{
		//추상메서드를 상속받으면 반드시 내용을 만들어 줘야 함(오버라이딩을 해주기)

		@Override
		void abstractMethod() { //자식클래스에서 상속받은 추상메서드를 강제로 만들어줘야 함
			
	
			
		}
		
	}

}
