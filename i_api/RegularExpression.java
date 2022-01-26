package i_api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {

		/*
		 * 정규표현식 : 문자열의 패턴을 검사하는 표현식
		 * 
		 * ^	뒷 문자로 시작
		 * $	앞 문자로 종료
		 * .	임의의 문자 1개(줄바꿈 제외)
		 * *	앞 문자가 0개 이상
		 * +	앞 문자가 1개 이상
		 * ?	앞 문자가 없거나 1개
		 * []	문자의 집합이나 범위([a-z]:a부터 z까지, [^a-z]:a부터 z가 아닌 것)
		 * {}	앞 문자의 개수({2}:2개, {2,4}:2개 이상 4개 이하)
		 * ()	그룹화
		 * |	OR 연산
		 * \s	공백, 탭, 줄바꿈
		 * \S	공백, 탭, 줄바꿈이 아닌 문자
		 * \w	알파벳이나 숫자
		 * \W	알파벳이나 숫자가 아닌 문자
		 * \d	숫자
		 * \D	숫자가 아닌 문자
		 * (?i)	뒷 문자의 대소문자 구분 안함
		 * \	정규표현식에서 사용되는 특수문자 표현
		 */
		//라이브러리 : 다른 누군가가 만들어 놓은 클래스
		
		
		String str = "abc123";
//		String regex = "[a-z]{3}[0-9]{1,3}"; //[a-z]:중에 1글자	{3}:3개가 와야 함	[0-9]:중 숫자 1개	{1,3}:1개 이상 3개 이하	{1,}:1개 이상을 의미
		
//		String regex = "[a-z0-9]+"; //a-z 0-9:중에 하나 (알파벳, 숫자 아무거나)	+:1개 이상을 의미
		String regex = "\\w*"; //\\w:알파벳이나 숫자가	*:0개 이상	\\w:\하나만 사용하면 탈출문자로 쓰이기 때문에 \\두개를 적어야 \를 의미
		
		Pattern p = Pattern.compile(regex);	 //정규표현식을 해석해 패턴으로 만들어 리턴해 줌
		Matcher m = p.matcher(str); 
//		System.out.println(m.matches()); //문자열과 정규표현식의 결과가 일치하면 true 반환
		
		
		//아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규표현식을 만들어주세요.
		
		//아이디 : 5~20자의 영문 소문자, 숫자와 특수기호 (_),(-)만 사용 가능합니다.
		String my_id = "kangji97";
		String id = "\\w{5,20}\\_\\-";
		//[a-z0-9_-]{5,20}
		
		//전화번호 : 11자의 숫자만 사용 가능합니다.
		//^0\\d{1,3}-\\d{3,4}-\\d{4}
		String my_num = "01096550766";
		String phone_num = "\\d{11}";
		
		//이메일 : @naver.com
		//[a-z0-9_-]{5,20}@[a-zA-Z]+\\.(?i)(com|net|org|([a-z]{2}\\.kr))$
		//@ 정규표현식에서 의미가 없기 때문에 그냥 적어주고 .은 이미 사용되어지는 문자로 \\를 적어줘야함
		String my_email = "kangji97@naver.com";
		String email = "[a-z]*\\d{2}\\@\\w{5}\\.\\[a-z]*";
		
	}

}
