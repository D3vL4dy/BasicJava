package i_api;

import java.util.Arrays;

import e_oop.ScanUtil;

public class SetComma {

	public static void main(String[] args) {

		// 숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마를 붙여 출력해주세요.
		// 1234567 -> 1,234,567

		System.out.print("숫자를 입력해주세요. > ");
		String num = ScanUtil.nextLine();
		String res = "";

		int count = 0;
		for (int i = num.length() - 1; i >= 0; i--) { // 뒤부터 접근
			res = num.charAt(i) + res; // 기존의 값 앞에 새로 가져온 값을 저장해야 거꾸로 나오지 않음
			count++;
			if (count % 3 == 0 && count != num.length()) { // 맨 앞인 경우는 ,를 추가하지 않음
				res = "," + res; // 3번 반복했을 때 ,를 추가해줌
			}
		}
		System.out.println(res);

	}

}

/*
System.out.print("숫자를 입력해주세요. > ");
String str = ScanUtil.nextLine();
int length = str.length();
String num = "";

for (int i = 0; i < length; i++) { // 문자열의 길이만큼 for문을 돌림
	char charAt = str.charAt(i); // 해당 인덱스에 존재하는 1글자를 반환하기 때문에 char 타입에 저장
	System.out.print(charAt);
}
System.out.println();

// 문자열 뒤집기
String rev = "";
for (int i = str.length() - 1; i >= 0; i--) {
	rev += str.charAt(i);
}
System.out.println(rev);

do {
	num = rev.substring(0, 3);
	System.out.print(num + ",");
	rev = rev.substring(3);
	if(rev.length() < 3) {
		num = rev;
	}
} while (rev != null);
*/