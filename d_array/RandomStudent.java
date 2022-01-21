package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStudent {

	public static void main(String[] args) {
		/*
		 * 25개 문자열을 저장할 수 있는 배열을 만들어 이름을 저장한다.
		 * 25명중 랜덤으로 몇 명을 뽑는다.(사용자 입력을 받은 만큼)
		 * 중복이 되면 안됨!!
		 * 1) 25명을 섞어서 앞에서부터 뽑기 
		 * 2) 이미 뽑은 사람과 다음에 뽑은 사람을 비교해서 겹치지 않으면 추가 
		 */
		
		String[] students = {"강동주", "강정인", "강현수", "곽성상", "김기웅",
						 "김민지", "김형돈", "노혜지", "박태정", "서난희",
						 "예현의", "오지현", "오혜지", "유정민", "이병진",
						 "이수민", "이슬기", "이유정", "이의찬", "이정규",
						 "이종민", "장문석", "정다영", "최민규", "최혁진"};
		
		
		//1번 방법
		for(int i = 0; i< students.length; i++) { //25번 반복
			int ran = (int)(Math.random() * students.length); //0~24 인덱스로 사용
			String temp = students[i];
			students[i] = students[ran];
			students[ran] = temp;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("뽑을 명 수를 입력해주세요. > ");
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < num; i++) {
			System.out.println(students[i]);
		}
		
		
		//2번 방법
		Scanner s = new Scanner(System.in);
		System.out.print("몇명? > ");
		int count = Integer.parseInt(s.nextLine());
		String[] pick = new String[count]; // 뽑은 사람을 저장할 배열
		int pickCount = 0; // 뽑힌 사람의 수를 확인하기 위한 변수

		do {
			int random = (int) (Math.random() * students.length); //0~24 : 25번

			boolean flag = true; // if문 안에 들어오는지 확인하기 위한 변수
			for (int i = 0; i < pick.length; i++) { //사용자가 입력한 수 만큼 반복
				if (students[random].equals(pick[i])) { // if(값이 중복이라면)
					// for문을 도는 동안 if문 안에 들어오면 중복이므로 pick[]에 추가하지 않는다.
					flag = false;
				}
			}
			if (flag) { // 값이 true일때는 중복되지 않았으므로 추가
				pick[pickCount++] = students[random];
			}

		} while (pickCount < count);
		System.out.println(Arrays.toString(pick));
	}
}
