package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		
		int [] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 5) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		
		
		int[] temp = new int[5]; //저장된 값
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			boolean flag = true;
			for(int j = 0; j < temp.length; j++) {
				if(arr[i] == temp[j]) { //중복된 값이 있다면 flag를 바꿈
					flag = false;
				}
			}
			if(flag) {
				temp[count++] = arr[i];
			}
		}
		System.out.println(Arrays.toString(temp));
		
		int[] result = new int[count]; //5개보다 적은 수가 발생했을 때 0을 제외하고 출력하기 위한 변수
		for(int i = 0; i < result.length; i++) {
			result[i] = temp[i];
		}
		System.out.println(Arrays.toString(result));
		
		
		/*
		 * 1~5사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
		 * [3, 1, 2, 1, 3, 5, 1, 3, 4, 2]
		 * [3, 1, 2, 5, 4]
		 * 값이 들어있는 순서 유지
		 */
		
//		int count = 0;
//		int[] num = new int[arr.length - count];
//		num[0] = arr[0];
//
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i + 1; j < arr.length - count; j++) {
//				if (num[i] != arr[j]) {
//					num[i + 1] = arr[j];
//				}
//			}
//		}
//		System.out.println(Arrays.toString(num));
		
		
		
		
		
		
		
		
		
//		==================================================================

		/*
		 * 1~5 사이의 숫자가 발생된 횟수 만큼 *을 사용해 그래프를 그려주세요.
		 * random = 20 (1~5사이의 랜덤 수 20개)
		 * 1 : *** 3
		 * 2 : **** 4
		 * 3 : ** 2
		 * 4 : ***** 5
		 * 5 : ****** 6
		 */
		
//		int[] arr = new int[20];
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = (int)(Math.random() * 5) + 1;	
//		}		
//		int[] count = new int [5]; //숫자의 갯수
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < 5; j++) {
//				if (arr[i] == j+1) {
//					count[j]++;
//				}
//			}
//		}
//
//		for (int i = 0; i < count.length; i++) {
//			System.out.print(i + " : ");
//			for (int j = 0; j < count[i]; j++) {
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
//		System.out.println(Arrays.toString(count));
		
		
		
		
//		int[] count = new int[5];
//		for(int i = 0; i < arr.length; i++) {
//			count[arr[i] - 1]++;
//		}
//		for(int i = 0; i < count.length; i++) {
//			System.out.println(i + 1 + " : ");
//			for(int j = 0; j < count[i]; j++) {
//				System.out.println("*");
//			}
//			System.out.println(" " + count[i]);
//		}
		
		
		
		
		
		
		
			
//		==================================================================	
//		int money = (int)(Math.random() * 500) * 10; //10~4990 사이
//		int[] coin = { 500, 100, 50, 10 }; //거스름돈이 담길 변수
//		System.out.println("거스름돈 : " + money);
//		
//		/*
//		 * 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력해주세요.
//		 * 
//		 * 거스름돈 : 2860원 > money
//		 * 500원 : 5개 2860/500 = 5 > money/coin[0] 
//		 * 100원 : 3개 (2860-(500*5))/100 = 3 
//		 * 50원 : 1개 (2860-((500*5)+(100*3))) /50 = 1 
//		 * 10원 : 1개
//		 */
//		
//		int[] count = new int [4]; //거스름돈의 갯수
//		for(int i = 0; i < coin.length; i++) {
//			count[i] = money / coin[i];
//			money -= count[i] * coin[i];
//			System.out.println(coin[i] + "원 : " + count[i] + "개");
//		}
//		
//		for(int i = 0; i < coin.length; i ++) {
//			int num = money / coin[i];
//			money %= coin[i];
//			System.out.println(coin[i] + "원 : " + num + "개");
//		}
//		
//		System.out.println("거스름돈 : " + money);
//		for(int i = 0; i < coin.length; i++) {
//			System.out.println(coin[i] + "원: " + money/coin[i] + "개");
//			money %= coin[i];
//		}
		
	}

}
















