package e_oop;

import java.util.Scanner;

public class ScanUtil {
	
	//스캐너를 사용하려면 스캐너 객체가 필요
	private static Scanner s = new Scanner(System.in);
	
	public static String nextLine() {
		return s.nextLine();
	}
	
	public static int nextInt() {
		return Integer.parseInt(s.nextLine());
	}

}
