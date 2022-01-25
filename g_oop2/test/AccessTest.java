package g_oop2.test;

import g_oop2.AccessModifier;

public class AccessTest extends AccessModifier{

	public static void main(String[] args) {
		AccessModifier am = new AccessModifier(); // static이 붙어서 객체 생성 후 사용

		System.out.println(am.publicVar); // 접근제한 없음
		am.publicMethod();

//		System.out.println(am.protectedVar); // 같은 패키지 + 상속받은 패키지에서 접근 가능
//		am.protectedMethod();
		//나를 통해서 사용해야 하는데 am 객체를 생성해 접근해서 사용 불가

//		System.out.println(am.defaultVar); // 같은 패키지에서 접근 가능
//		am.defaultMethod();

//		System.out.println(am.privateVar); //다른 클래스에서 접근 불가
//		am.privateMethod();
		
		AccessTest at = new AccessTest(); //나의 AccessTest 클래스 객체 생성 후 사용 
		
		System.out.println(at.protectedVar);
		at.protectedMethod();
		
		

	}

}
