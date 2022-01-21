package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * - 석차구하기 : 점수를 비교해 작은 점수의 등수를 증가시키는 방식
		 * - 선택정렬 : 가장 작은 숫자를 찾아서 앞으로 보내는 방식
		 * - 버블정렬 : 바로 뒤의 숫자와 비교해 큰 수를 뒤로 보내는 방식
		 * - 삽입정렬 : 두번째 숫자부터 앞의 숫자들과 비교해서 큰수는 뒤로 밀고 중간에 삽입하는 방식
		 */
		
		int[] arr = new int[10]; // 점수가 저장될 변수
		for (int i = 0; i < arr.length; i++) { // 점수 생성
			arr[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));

		// 석차구하기
		// 석차를 저장할 배열을 만들고 1등부터 저장. for문 2개를 만들어 전체를 비교하면서 작은 점수의 등수를 증가
//		int[] rank = new int[arr.length]; // 석차를 저장할 배열
//		for (int i = 0; i < rank.length; i++) {
//			rank[i] = 1;
//		}
//
//		for (int i = 0; i < arr.length; i++) { // i=0일때 j=10번 실행
//			for (int j = 0; j < arr.length; j++) {
//				if (arr[i] < arr[j]) {
//					rank[i]++;
//				}
//			}
//		}
//
//		System.out.println(Arrays.toString(rank));
		
		
		// 선택정렬
		// 가장 작은 수를 1번과 자리 바꾸기
		// 그 다음 작은 수를 2번과 자리 바꾸기
		// 최소값의 인덱스를 알아야 자리바꾸기 가능
		
//		for (int i = 0; i < arr.length; i++) {// 최소값의 위치 찾기
//			if (arr[min] > arr[i]) {
//				int min = i;
//			}
//		}
//		System.out.println(arr[min]);

//		for (int i = 0; i < arr.length - 1; i++) { //정렬은 0~8에 이미 끝남. 0~9까지 하지 않음 
//			int min = i; //시작 인덱스   //최소값의 위치(인덱스)를 저장할 변수
//			for (int j = i + 1; j < arr.length; j++) { //i=0이면 0자리하고 1부터 비교하면 돼
//				if (arr[j] < arr[min]) {
//					min = j; //더 작은 값을 찾았을 경우 그 값의 인덱스를 저장
//				}
//			}
//			int temp = arr[i];
//			arr[i] = arr[min];
//			arr[min] = temp;
//		}
//		
//		System.out.println(Arrays.toString(arr));
		
		
		//버블정렬 : 가장 큰 수 하나가 맨 뒤로 가면 1회전 끝
		/*
		 * 0,1  1,2  2,3  3,4  4,5  5,6  6,7  7,8  8,9 
		 * 0,1  1,2  2,3  3,4  4,5  5,6  6,7  7,8 
		 * 0,1  1,2  2,3  3,4  4,5  5,6  6,7 
		 * 0,1  1,2  2,3  3,4  4,5  5,6   
		 * 0,1  1,2  2,3  3,4  4,5 
		 * 0,1  1,2  2,3  3,4  
		 * 0,1  1,2  2,3   
		 * 0,1  1,2  
		 * 0,1  
		 * 횟수가 9번이기 때문에 i에서 -1
		 * j, j+1을 비교하는데 j=8까지 오면 9,10비교가 필요없어서 -1을 해주고 
		 */
		
//		for (int i = 0; i < arr.length - 1; i++) { //회전 수가 줄어들게 되는데 마지막은 1,2 자리를 비교하게 됨
//			boolean flag = false;
//			for (int j = 0; j < arr.length - i - 1; j++) { //-i:회전 수를 줄이기 위해
//				if (arr[j] > arr[j + 1]) { //
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//					flag = true;
//				}
//			}
//			if (!flag) { //자리를 바꾸지 않으면 반복문 종료
//				break;
//			}
//		}
//		System.out.println(Arrays.toString(arr));
		
		
		
		// 삽입정렬
		// 3 41 27 25 38 3 27 49 19 34
		// 27을 기준으로 3 41과 비교
		// 작은 숫자와 큰 숫자 사이에 위치시킨다.
		// 3 41 27 25 38 3
		// 3 27 41 25 38 3
		// 앞과 비교해 크면 한칸 뒤로 밀고 작으면 빈칸에 넣는다.
		// 3 41 27 25 38 3 27 49 19 34
		// 3 41 27 28 38 3 27 49 19 34  : 1
		// 3 27 41 28 38 3 27 49 19 34  : 2
		// 3 27 28 41 38 3 27 49 19 34  : 3
		// 3 27 28 38 41 3 27 49 19 34  : 4
		// 3 3 27 28 38 41 27 49 19 34  : 5
		// 3 3 27 27 28 38 41 49 19 34  : 6
		// 3 3 19 27 27 28 38 41 49 34  : 7
		// 3 3 19 27 27 28 34 38 41 49  : 8
		
		/* (i,j) //i를 기준으로 j와 비교
		 * 1,0
		 * 2,1  2,0
		 * 3,2  3,1  3,0
		 * 4,3  4,2  4,1  4,0  
		 * 5,4  5,3  5,2  5,1  5,0  
		 * 6,5  6,4  6,3  6,2  6,1  6,0 
		 * 7,6  7,5  7,4  7,3  7,2  7,1  7,0 
		 * 8,7  8,6  8,5  8,4  8,3  8,2  8,1  8,0
		 * 9,8  9,7  9,6  9,5  9,4  9,3  9,2  9,1  9,0 
		 */
		for(int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = 0;
			for(j = i - 1; j >= 0 ; j--) {
				if(temp < arr[j]) {
					arr[j+1] = arr[j];
				}else { //더 작은 값을 만났을 경우, 반복문이 끝난 경우 빈칸을 채움
					break;
				}
			}arr[j + 1] = temp;
		} 
		System.out.println(Arrays.toString(arr));		
	}
}
