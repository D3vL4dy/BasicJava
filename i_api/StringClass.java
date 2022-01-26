package i_api;

import java.util.Arrays;

public class StringClass {

	public static void main(String[] args) {

		/*
		 * String
		 * - 여러개의 문자를 사용하기 쉽게 만들어 놓은 클래스
		 * 
		 * String의 주요 메서드
		 * - equals() : 문자열의 내용이 같은지 반환한다.
		 * - length() : 문자열의 길이를 반환한다.
		 * - charAt() : 특정 인덱스에 위치한 문자를 반환한다.
		 * - substring() : 문자열의 특정 부분을 잘라서 반환한다.
		 * - indexOf() : 문자열 내의 특정 문자의 인덱스를 반환한다.
		 * - contains() : 문자열이 특정 문자열을 포함하고 있는지 여부를 반환한다. (boolean 타입)
		 * - split() : 문자열을 특정 문자를 기준으로 나누어 배열형태로 반환한다.
		 * - replace() : 문자열 내의 특정 문자를 다른 문자로 바꿔서 반환한다.
		 * - trim() : 문자열 앞뒤의 공백을 제거해 반환한다. (중간 공백은 포함X)
		 * - valueOf() : 다른 타입의 데이터를 문자열로 변환해 반환한다.
		 */
		
		String str = "12345"; // char 타입이 배열 형태로 존재하는 것이 String
		int length = str.length(); // 문자열 내용의 길이를 int 타입으로 반환
		for (int i = 0; i < length; i++) { // 문자열의 길이만큼 for문을 돌림
			char charAt = str.charAt(i); // 해당 인덱스에 존재하는 한 글자를 반환하기 때문에 char 타입에 저장
			System.out.println(charAt);
		}

		// 문자열 뒤집기
		String rev = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		}
		System.out.println(rev);

		str = "0123456789";
		String sub1 = str.substring(3); // 시작인덱스~끝까지 잘라서 반환
		System.out.println(sub1);
		String sub2 = str.substring(5, 8); // 시작인덱스 5부터 ~ 끝나는 인덱스 전 7까지 반환
		System.out.println(sub2);

		str = "수박 오렌지 귤 블루베리";
		int index = str.indexOf("오렌지"); // 파라미터로 넘긴 문자열이 어디에 위치해 있는지 문자열의 시작인덱스를 반환
		System.out.println(index); // 찾는 내용이 없을 때 (-1) 반환
		
		//substring과 indexOf를 조합해서 문자열 자르기
		String[] menu = {
				"수박 20000원",
				"오렌지 100000원",
				"귤 500원",
				"블루베리 3000원"
		};
		
		for (int i = 0; i < menu.length; i++) {
			String name = menu[i].substring(0, menu[i].indexOf(" "));
			System.out.println(name);

			int price = Integer.parseInt(menu[i].substring(menu[i].indexOf(" ") + 1, menu[i].indexOf("원")));
			System.out.println(price);
		}
		
		
		str = "a/b/c";
		String[] split = str.split("/");
		System.out.println(Arrays.toString(split));
		
		//메뉴명과 가격 나누기
		for(int i = 0; i < menu.length; i++) {
			String[] split2 = menu[i].split(" ");
			System.out.println(split2[0] + " : " + split2[1]);
		}
		
		
		str = "123123123";
		str = str.replace("3", "짝"); //문자열의 특정 내용을 다르게 바꾸는 것
		System.out.println(str);
		
		
		str = "문자열   ";
		String trim = str.trim(); //주로 사용자한테 입력을 받을 때 사용
		System.out.println("[" + str + "] -> [" + trim + "]"); 


		int num = 10;
		str = num + ""; //내용은 변화없고 타입만 String으로 바뀜
		str = String.valueOf(num); //파라미터로 넘긴 값을 String 타입으로 형변환
		
	}

}
