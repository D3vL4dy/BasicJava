package b_operator;

import java.util.Scanner;

public class cal {

	public static void main(String[] args) {
		// 두개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그램을 만들어주세요.
		// +, -, *, /, %
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자1 입력 >");
		int a = Integer.parseInt(sc.nextLine());
		System.out.println("연산자 입력 >");
		String op = sc.nextLine();
		System.out.println("숫자2 입력 >");
		int b = Integer.parseInt(sc.nextLine());
		int result = op.equals("+") ? a + b
				: (op.equals("-") ? a - b
						: (op.equals("*") ? a * b 
								: (op.equals("/") ? a / b 
										: (op.equals("%") ? a % b : 0))));
		System.out.println(a + op + b + " = " + result);
		

	}

}
