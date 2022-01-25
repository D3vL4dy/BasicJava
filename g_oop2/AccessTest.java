package g_oop2;

public class AccessTest {

	public static void main(String[] args) {
		AccessModifier am = new AccessModifier(); // static이 붙어서 객체 생성 후 사용

		System.out.println(am.publicVar);
		am.publicMethod();

		System.out.println(am.protectedVar);
		am.protectedMethod();

		System.out.println(am.defaultVar);
		am.defaultMethod();

//		System.out.println(am.privateVar); //다른 클래스에서 접근 불가
//		am.privateMethod();

	}

}
