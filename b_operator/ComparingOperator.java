package b_operator;

public class ComparingOperator {

	public static void main(String[] args) {
		/*
		 * 비교연산자
		 * - <, >, <=, >=, ==, !=
		 * - 문자열 비교 : equals() 
		 */
		
		int x = 10;
		int y = 20;
		
		boolean b = x < y;
		System.out.println(b);
		
		b = x <= y - 15; //산술 연산을 진행한 후 비교 연산
		
		
		String str1 = "abc";
		String str2 = "ABC";
		
		b = str1 == str2; //==는 문자의 내용이 아닌 주소를 비교한 것
		System.out.println(b); //false
		
		b = !str1.equals(str2); //연산의 결과를 뒤집는 것. (같지 않다)
		System.out.println(b); //true
		
		//다음의 문장들을 코드로 작성해주세요.
		boolean res;
		//x는 y보다 작거나 같다.
		res = x <= y;
		System.out.println(res);
		//x + 5와 y는 같다.
		res = x + 5 == y;
		System.out.println(res);
		//y는 홀수이다.
		res = y % 2 == 1;
		System.out.println(res);
		//"기본형"과 "참조형"은 다르다.
		str1 = "기본형";
		str2 = "참조형";
		res = !"기본형".equals("참조형");
		System.out.println(res);

	}

}
