package c_statement;

import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {
		//탄수화물 중독 자가진단 테스트 
//		1. 아침을 배불리 먹은 후 점심시간 전에 배가 고프다.
//		2. 밥, 빵, 과자 등 음식을 먹기 시작하면 끝이 없다.
//		3. 음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다.
//		4. 정말 배고프지 않더라도 먹을 때가 있다.
//		5. 저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다.
//		6. 스트레스를 받으면 자꾸 먹고 싶어진다.
//		7. 책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있다.
//		8. 오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다.
//		9. 과자, 초콜릿 등 단 음식은 상상만해도 먹고 싶어진다.
//		10. 다이어트를 위해 식이조절을 하는데 3일도 못 간다.
//		3개> 주의! 위험한 수준은 아니지만 관리 필요
//		4~6개> 위험! 탄수화물 섭취 줄이기 위한 식습관 개선이 필요함
//		7개 이상> 중독! 전문의 상담이 필요함
		
		Scanner sc = new Scanner(System.in);
		int count = 0;

		System.out.println("아침을 배불리 먹은 후 점심시간 전에 배가 고프다. yes:1 / no:2 >");
		int anw = Integer.parseInt(sc.nextLine());
		if (anw == 1) {
			count++;
		}

		System.out.println("밥, 빵, 과자 등 음식을 먹기 시작하면 끝이 없다. yes:1 / no:2 >");
		anw = Integer.parseInt(sc.nextLine());
		if (anw == 1) {
			count++;
		}

		System.out.println("음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다. yes:1 / no:2 >");
		anw = Integer.parseInt(sc.nextLine());
		if (anw == 1) {
			count++;
		}

		System.out.println("정말 배고프지 않더라도 먹을 때가 있다. yes:1 / no:2 >");
		anw = Integer.parseInt(sc.nextLine());
		if (anw == 1) {
			count++;
		}

		System.out.println("저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다. yes:1 / no:2 >");
		anw = Integer.parseInt(sc.nextLine());
		if (anw == 1) {
			count++;
		}

		System.out.println("스트레스를 받으면 자꾸 먹고 싶어진다. yes:1 / no:2 >");
		anw = Integer.parseInt(sc.nextLine());
		if (anw == 1) {
			count++;
		}

		System.out.println("책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있다. yes:1 / no:2 >");
		anw = Integer.parseInt(sc.nextLine());
		if (anw == 1) {
			count++;
		}

		System.out.println("오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다. yes:1 / no:2 >");
		anw = Integer.parseInt(sc.nextLine());
		if (anw == 1) {
			count++;
		}

		System.out.println("과자, 초콜릿 등 단 음식은 상상만해도 먹고 싶어진다. yes:1 / no:2 >");
		anw = Integer.parseInt(sc.nextLine());
		if (anw == 1) {
			count++;
		}

		System.out.println("다이어트를 위해 식이조절을 하는데 3일도 못 간다. yes:1 / no:2 >");
		anw = Integer.parseInt(sc.nextLine());
		if (anw == 1) {
			count++;
		}

		switch (count) {
		case 0:
		case 1:
		case 2:
			System.out.println("건강합니다.");
			break;
		case 3:
			System.out.println("주의! 위험한 수준은 아니지만 관리 필요");
			break;
		case 4:
		case 5:
		case 6:
			System.out.println("위험! 탄수화물 섭취 줄이기 위한 식습관 개선이 필요함");
			break;
		case 7:
		case 8:
		case 9:
		case 10:
			System.out.println("중독! 전문의 상담이 필요함..");
			break;
		}
		
		
	}

}
