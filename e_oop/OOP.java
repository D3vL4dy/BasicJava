package e_oop;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programming)
		 * - 프로그래밍을 단순히 코드의 연속으로 보는 것이 아니라 객체간의 상호작용으로 보는 것
		 * - 코드의 재사용성이 높고 유지보수가 용이하다.
		 */
		
		//객체 생성을 먼저 해야 사용 가능
		SampleClass sc = new SampleClass();
		//객체를 계속 사용하기 위해 변수에 저장 (클래스 이름과 동일
		
		String returnValue = sc.method(5, "ABC");
		System.out.println(returnValue);
		
		sc.mehtod2();
		
		sc.flowTest1();
		
		
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		Calculator cal = new Calculator();
		//1. 123456+ + 654321
		long result = cal.add(123456, 654321);
		System.out.println("1번의 결과값 : " + result);
		//2. 1번의 결과값 * 123456
		result = cal.subtract(result, 123456);
		System.out.println("2번의 결과값 : " + result);
		//3. 2번의 결과값 / 123456
		result = cal.multiply(result, 123456);
		System.out.println("3번의 결과값 : " + result);
		//4. 3번의 결과값 - 654321
		result = cal.divide(result, 654321);
		System.out.println("4번의 결과값 : " + result);
		//5. 4번의 결과값 % 123456
		result = cal.mod(result, 123456);
		System.out.println("5번의 결과값 : " + result);
		
		
	}

}
