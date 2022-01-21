package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열
		 * - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 * - 참조형 타입이다. (값이 아닌 주소를 저장)
		 * - 인덱스로 값을 구분한다.
		 * - 길이를 변경할 수 없다.
		 * 1) int[] array = new int[5];
		 * 2) int[] array = new int[] {1, 2, 3, 4, 5}
		 * 3) int[] array = {1, 2, 3, 4, 5};
		 */
		
		int[] array; // 배열의 주소를 저장할 공간이 만들어진다. (타입/변수명 뒤 모두 사용 가능)
		array = new int[5]; // 배열이 생성되고 그 주소가 저장된다.
		// 기본값이 저장된다.

		/*
		 * 변수 = 100번지(주소가 저장됨)
		 * 100번지
		 * (첫번째 값의 주소) {0, 0, 0, 0, 0}
		 */

		array = new int[] { 1, 2, 3, 4, 5 }; // 이런 경우 []에 숫자는 생략

//		array = {1, 2, 3, 4, 5}; //변수의 선언과 초기화를 동시에 진행해야 함
		int[] array2 = { 1, 2, 3, 4, 5 };

		array[0] = 10; // 변수명[인덱스] =값;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;

		System.out.println(array); // 인덱스가 없으면 배열의 주소가 출력됨
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);
		System.out.println();

		for (int i = 0; i < array.length; i++) {
			array[i] = (i + 1) * 10;
		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		// 10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.
		int[] arr = new int[10]; // 변수를 먼저 만들고 new int [숫자]로 초기화

		// 배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장해주세요.
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
		}

		System.out.println(Arrays.toString(arr)); // 배열에 있는 모든 값을 문자열로 묶어서 반환

		// 배열에 저장된 모든 값의 합계와 평균을 출력해주세요.
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double avg = (double) sum / arr.length; // 소수점을 얻기 위해서 둘 중 하나는 형변환
		System.out.println("합계 : " + sum + " / 평균 : " + avg);

		// **************배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.**************
		// 최소값을 저장할 변수를 만들고 배열의 첫번째 값을 저장한다.
		int min = arr[0];
		// 최대값을 저장할 변수를 만들고 배열의 첫번 값을 저장한다.
		int max = arr[0];
		// 변수에 저장된 값과 배열의 모든 인덱스의 값을 비교하기 위한 for문을 만든다.
		for (int i = 0; i < arr.length; i++) {
			// 최소값이 저장된 변수와 배열의 값을 비교해서 더 작은 값을 찾으면 변수에 저장한다.
			if (min > arr[i]) {
				min = arr[i];
			}
			// 최대값이 저장된 변수와 배열의 값을 비교해서 더 큰 값을 찾으면 변수에 저장한다.
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("min : " + min + "\tmax : " + max);

//		int max = 0;
//		int min = 0;
//		
//		for(int i = 0; i<arr.length; i++) {
//			max = arr[i];
//			if(max < arr[i+1]) {
//				max = arr[i+1];
//			}
//	
//			min = arr[i];
//			if(min > arr[i+1]) {
//				min = arr[i+1];
//			}
//		}			
//		System.out.println("최대 : " + max + " / 최소 : " + min);

		int[] shuffle = new int[10];
		for (int i = 0; i < shuffle.length; i++) {
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));
		// 배열의 값을 무작위로 섞어주세요.
		// 0~9 사이의 랜덤한 인덱스를 발생시킨다.
		// 랜덤 인덱스와 0번 인덱스의 자리를 여러번 바꾼다.
		for (int i = 0; i < shuffle.length * 10; i++) { //여러번 반복하기 위해 *10
			int random = (int) (Math.random() * shuffle.length);
			int temp = shuffle[random];
			shuffle[random] = shuffle[0];
			shuffle[0] = temp;
		}
		System.out.println(Arrays.toString(shuffle));
		
		//1~10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		int[] count = new int[10]; //1~10 사이의 수가 몇 개씩 있는지 확인하기 위한 변수

		for (int i = 0; i < 500; i++) { //랜덤 수 뽑는 과정을 500번 반복
			int ran = (int) (Math.random() * 10) + 1; //1~10
			// count[ran - 1]++;
			for (int j = 0; j < count.length; j++) { //랜덤한 수가 1~10 어디인지 찾아 count의 수를 올림
				if (ran == j + 1)
					count[j]++;
			}

		}
		System.out.println(Arrays.toString(count));

	}

}
