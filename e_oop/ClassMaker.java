package e_oop;

public class ClassMaker {
	
	//전역변수 하나를 선언 및 초기화 해주세요.
	int a = 10;
	
	//리턴타입과 파라미터가 없는 메서드 하나를 만들어주세요.
	//메서드 안에서 전역변수를 출력해주세요.
	
	void method() {
		System.out.println(a);
		return; // 리턴타입이 없어 값을 넣으면 안돼.
		//메서드 종료의 역할
	}
	
	//전역변수와 동일한 타입의 리턴타입이 있고 파라미터는 없는 메서드 하나를 만들어주세요.
	//메서드 안에서 전역변수를 리턴해주세요.
	int method2() { //리턴타입이 있으면 반드시 리턴 해줘야 돼
		return a;
	}
	
	//리턴타입은 없고 파라미터가 있는 메서드 하나를 만들어주세요.
	//메서드 안에서 파라미터를 출력해주세요.
	void method3(String a) {
		if(a.equals("")) {
			return;
		}
		System.out.println(a);
	}
	
	//int타입의 리턴타입과 int타입의 파라미터 두개가 있는 메서드 하나를 만들어주세요.
	//메서드 안에서 두 파라미터를 곱한 결과를 리턴해주세요.
	int method4(int a, int b) {
		return a * b;
	}
	//return : 뒤의 값을 돌려줌 / 메서드 종료 
	//리턴타입이 없어도 리턴 사용 가능
	

}
