package d_array;

import java.util.Arrays;

public class MultiDimensionalArray {

	public static void main(String[] args) {
		/*
		 * 다차원 배열
		 * - 배열 안에 배열이 저장되어 있는 형태이다.
		 */
		
		//2차원
		int[][] array2;
		
		//3차원
		int[][][] array3;
		
		int[][] arr = new int[2][3]; 
		/*
		 * 변수 = 100번지(주소)
		 * 
		 * 100번지
		 * {200번지, 300번지}
		 * 
		 * 200번지
		 * {0, 0, 0}
		 * 
		 * 300번지
		 * {0, 0, 0}
		 */
		
		int arr2[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		int[] arr3[] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// 자주 사용하지는 않음
		int[][] arr4 = new int[3][]; // 가변 배열. 1차원만 만들어진 상태로 길이를 지정해 2차열로 사용 가능
		arr4[0] = new int[3];
		arr4[1] = new int[4];
		arr4[2] = new int[10];

		// 2차원:배열이 저장. 1차원:값이 저장
//		arr[0] = 10; //값을 저장할 수 없다.
		arr[0] = new int[5]; // 1차원은 배열을 저장하는 곳이다.
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[1][0] = 100;

		System.out.println(arr[0][1]); // 값을 출력하기 위해서는 [][] 둘 다 인덱스를 지정해야함

		System.out.println(arr.length); // 1차원의 길이
		System.out.println(arr[0].length); // 2차원의 길이. (1차원 인덱스까지 접근해야 함)

		// 2차원 배열의 모든 인덱스에 접근하기 위해서는 for문 2개 필요
		for (int i = 0; i < arr.length; i++) { // 1차원 접근
			for (int j = 0; j < arr[i].length; j++) { // 2차원 접근
				System.out.println(i + "," + j + " : " + arr[i][j]);
				// int[][] arr = new int[2][3];
				// arr[0] = new int[5];
				// 결과 => arr[5][3]
			}
		}
		
		
		
		int[][] scores = new int[3][5]; // int[학생수][과목수]
		int[] sum = new int[scores.length]; // 합계
		double[] avg = new double[scores.length]; // 평균

		// 0~100사이 랜덤한 점수를 배열에 저장
		// 각 학생의 합계와 평균을 배열에 저장
		
		
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				scores[i][j] = (int) (Math.random() * 100 + 1);
				sum[i] += scores[i][j];

			}
			System.out.println(Arrays.toString(scores[i]));
			avg[i] = (double)sum[i] / scores[i].length;
			System.out.println("합계 : " + sum[i] + "  /  평균 : " + avg[i]);

		}

	}

}
