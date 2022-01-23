package c_statement;

import java.util.Scanner;

public class prac {

	public static void main(String[] args) {
		// 1~9사이의 서로 중복되지 않는 숫자 3개를 맞추는 게임
		/*
		 * 123 
		 * 스트라이크:숫자와 자릿수까지 같은 경우 
		 * 볼:숫자는 같지만 자릿수가 다른 경우 
		 * 아웃:일치하는 숫자가 없는 경우 
		 * 135 -> 1S 1B 1O
		 * 
		 * 
		 * 379 : 0S 0B 3O 
		 * 124 : 1S 1B 1O 
		 * 248 : 1S 2B 0O 
		 * 842 : 0S 3B 0O 
		 * 428 : 3S
		 * 
		 * 
		 */
		
		int ran1 = 0;
		int ran2 = 0;
		int ran3 = 0;
		
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		int s = 0;
		int b = 0;
		int o = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			ran1 = (int)(Math.random() * 9) + 1;
			ran2 = (int)(Math.random() * 9) + 1;
			ran3 = (int)(Math.random() * 9) + 1;
		}while((ran1 == ran2)||(ran2 == ran3)||(ran3 == ran1));
		
		do {
			s = 0;
			b = 0;
			o = 0;
			
			System.out.print("1~9사이의 숫자를 입력하세요. 1> ");
			num1 = Integer.parseInt(sc.nextLine());
			System.out.print("1~9사이의 숫자를 입력하세요. 2> ");
			num2 = Integer.parseInt(sc.nextLine());
			System.out.print("1~9사이의 숫자를 입력하세요. 3> ");
			num3 = Integer.parseInt(sc.nextLine());
			
			
			if(num1 == ran1) s++;
			else if((num1 == ran2) || (num1 == ran3)) b++;
			else o++;
			
			if(num2 == ran2) s++;
			else if((num2 == ran1) || (num2 == ran3)) b++;
			else o++;
			
			if(num3 == ran3) s++;
			else if((num3 == ran1) || (num3 == ran2)) b++;
			else o++;
			
			System.out.println(s + "S\t" + b + "B\t" + o + "O");
			
		}while(s != 3);
		
		System.out.println("숫자게임 종료!");
	}

}
