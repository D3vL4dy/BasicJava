package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * 조건문
		 * - if문
		 * - switch문
		 * 
		 * if문
		 * - if(조건식){} : 조건식의 결과가 true이면 블럭안의 문장을 수행한다.
		 * - else if(조건식){} : 다수의 조건이 필요할 때 if 뒤에 추가한다.
		 * - else{} : 조건식 이외의 경우를 위해 추가한다. 
		 */
		
		int a = 4;
		
		if (a == 1) {
			System.out.println("조건식의 연산결과가 true이면 수행된다.");
		}

		if (a == 1) { // if문은 여러개의 조건식중에 하나만 실행됨
			System.out.println("a == 1");
		} else if (a == 2) {
			System.out.println("a == 2");
		} else if (a == 3) {
			System.out.println("a == 3");
		} else {
			System.out.println("else");
		}
		
		//점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 80;

		if (score >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

		//점수에 등급을 부여
		score = 90;
		String grade = null; 
		//null : 참조형 타입의 기본값 (String)
		//기본값 : 자동으로 저장되는 값
		//boolean : false가 기본
		
		if (90 <= score && score <= 100) {
			grade = "A";
		} else if (80 <= score) {
			grade = "B";
		} else if (70 <= score) {
			grade = "C";
		} else if (60 <= score) {
			grade = "D";
		} else {
			grade = "F";
		}

		System.out.println(score + "점 : " + grade);
		
		
		score = 90;
		grade = null;
		//정렬 : Ctrl + Shift + f
		if (90 <= score && score <= 100) {
			grade = "A";
			if (97 <= score) {
				grade += "+";
			} else if (score <= 93) {
				grade += "-";
			}
		} else if (80 <= score) {
			grade = "B";
			if (87 <= score) {
				grade += "+";
			} else if (score <= 83) {
				grade += "-";
			}
		} else if (70 <= score) {
			grade = "C";
			if (77 <= score) {
				grade += "+";
			} else if (score <= 73) {
				grade += "-";
			}
		} else if (60 <= score) {
			grade = "D";
			if (67 <= score) {
				grade += "+";
			} else if (score <= 63) {
				grade += "-";
			}
		} else {
			grade = "F";
		}
		System.out.println(score + "점 : " + grade);
		
		
		/*
		 * switch문
		 * - switch(int/String){ case 1: break; }
		 * - 조건식의 결과는 정수와 문자열만(JDK1.7부터 문자열 허용) 허용한다.
		 * - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 */
		
		a = 10;

		switch (a) {
		case 10:
			System.out.println("a == 10");
			break;
		case 20:
			System.out.println("a == 20");
			break;
		default:
			System.out.println("default");
		}

		// 월에 해당하는 계절을 출력
		int month = 3;
		String season = null;

		switch (month) {
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		default:
			System.out.println("default");
		}
		System.out.println(month + "월 : " + season);

		
		score = 85;
		grade = null;

		switch (score / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		System.out.println(score + "점 : " + grade);
		
		
		
		//숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력> ");
		int num = Integer.parseInt(sc.nextLine());
		 
//		if(num % 2 == 0) {
//			System.out.println("짝수");
//		}else (num % 2 == 1) {
//			System.out.println("홀수");
//		}
		
		switch (num % 2) {
		case 0:
			System.out.println("짝수");
			break;
		case 1:
			System.out.println("홀수");
			break;
		}
		
		
		//1~100사이의 랜덤한 값을 3개 발생시키고 합계, 평균, 등급을 출력해주세요.
		//랜덤 : Math.random() - 0.0 ~ 1.0 미만
		int random1 = (int) (Math.random() * 100) + 1; // 0.0~99.9 에서 int 변환 후 +1 > 1~100
		int random2 = (int) (Math.random() * 100) + 1;
		int random3 = (int) (Math.random() * 100) + 1;

		int sum = random1 + random2 + random3;
		double avg = Math.round(sum / 3.0 * 10) / 10.0;    //*10은 소수점 첫째자리까지 보기 위함
		grade = null;
		
		
		System.out.println("랜덤한 수 3개> " + random1 + ", " + random2 + ", " + random3);
		System.out.println("합계 : " + sum + ", 평균 : " + avg + ", 등급 : " + grade);
		
		
		//1~100 사이의 랜덤한 수를 3개 발생시키고 내림차순으로 출력해주세요.
		/*
		 * int number1 = (int) (Math.random() * 100) + 1; int number2 = (int)
		 * (Math.random() * 100) + 1; int number3 = (int) (Math.random() * 100) + 1;
		 * 
		 * System.out.println("랜덤한 수 3개>" + number1 + ", " + number2 + ", " + number3);
		 * 
		 * if (number1 < number2) { if (number2 < number3) {
		 * System.out.println("내림차순 정렬>" + number3 + ", " + number2 + ", " + number1); }
		 * else if (number1 < number3) { System.out.println("내림차순 정렬>" + number2 + ", "
		 * + number3 + ", " + number1); } else { System.out.println("내림차순 정렬>" + number2
		 * + ", " + number1 + ", " + number3); } } else if (number3 < number1) { if
		 * (number2 < number3) { System.out.println("내림차순 정렬>" + number1 + ", " +
		 * number3 + ", " + number2); } else { System.out.println("내림차순 정렬>" + number1 +
		 * ", " + number2 + ", " + number3); } } else { if (number2 < number3) {
		 * System.out.println("내림차순 정렬>" + number3 + ", " + number1 + ", " + number2); }
		 * }
		 * 
		 * if(number1 < number2 && number2 < number3) { System.out.println("내림차순 정렬>" +
		 * number3 + ", " + number2 + ", " + number1); }else if(number1 < number2 &&
		 * number3 < number2) { if(number1 < number3) { System.out.println("내림차순 정렬>" +
		 * number2 + ", " + number3 + ", " + number1); }else {
		 * System.out.println("내림차순 정렬>" + number2 + ", " + number1 + ", " + number3); }
		 * }else if(number3 < number1 && number2 < number1) { if(number3 < number2) {
		 * System.out.println("내림차순 정렬>" + number1 + ", " + number2 + ", " + number3);
		 * }else { System.out.println("내림차순 정렬>" + number1 + ", " + number3 + ", " +
		 * number2); } }else { System.out.println("내림차순 정렬>" + number3 + ", " + number1
		 * + ", " + number2); }
		 */
		
		
		//1~100 사이의 랜덤한 수를 3개 발생시키고 오름차순으로 출력해주세요.
		
		/*
		 * int x = 0; int y = 0; int z = 0;
		 * 
		 * int q = (int) (Math.random() * 100) + 1; int w = (int) (Math.random() * 100)
		 * + 1; int e = (int) (Math.random() * 100) + 1;
		 * 
		 * if (q < w && q < e) { if(w < e) { x = q; y = w; z = e; }else { x = q; y = e;
		 * z = w; } }else if(w < q && w < e) { if(q < e) { x = w; y = q; z = e; }else {
		 * x = w; y = e; z = q; } }else if(e < q && e < w){ if(q < w) { x = e; y = q; z
		 * = w; }else { x = e; y = w; z = q; } }
		 * 
		 * System.out.println("오름차순>" + x + ", " + y + ", " + z);
		 */
		
		int x = (int) (Math.random() * 100) + 1;
		int y = (int) (Math.random() * 100) + 1;
		int z = (int) (Math.random() * 100) + 1;
		
		
		if(x > y) { //temp=큰 > x=작 > y=큰
			int temp = x; 
			x = y;
			y = temp;
		}
		
		if(x > z) { //temp=큰 > x=작 > y=큰
			int temp = x;
			x = z;
			z = temp;
		}
		
		if(y > z) { //temp=큰 > y=작 > z=큰
			int temp = y;
			y = z;
			z = temp;
		}
		
		System.out.println("오름차순>" + x + ", " + y + ", " + z);  //작은것부터
		
		
	}

}
