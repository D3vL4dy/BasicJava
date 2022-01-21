package d_array;

import java.util.Arrays;

public class Score_me {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0~100 사이의 랜덤한 점수로 생성해주시고, 아래와 같이 출력해주세요.
		 * 
		 * 이름	   국어     영어   수학   사회    과학   Oracle   Java  합계   평균   석차
		 * 홍길동    90	   90    90    90     90     90      90    630  90.00   1
		 * 홍길동    90	   90    90    90     90     90      90    630  90.00   1
		 * 홍길동    90	   90    90    90     90     90      90    630  90.00   1
		 * 홍길동    90	   90    90    90     90     90      90    630  90.00   1
		 * 과목합계  450     450   450   450    450    450     450   
		 * 과목평균  90.00   90.00 90.00 90.00  90.00  90.00   90.00   
		 */
		//합계, 평균, 석차(순으로 정렬)
		
		String[] name = {"강동주", "강정인", "강현수", "곽성상", "김기웅",
				 "김민지", "김형돈", "노혜지", "박태정", "서난희",
				 "예현의", "오지현", "오혜지", "유정민", "이병진",
				 "이수민", "이슬기", "이유정", "이의찬", "이정규",
				 "이종민", "장문석", "정다영", "최민규", "최혁진"};

		int[][] scores = new int[25][7]; // int[학생수][과목수]
		int[] sum = new int[scores.length]; // 합계
		double[] avg = new double[scores.length]; // 평균
		int[] rank = new int[scores.length]; // 석차
		int[] sub_sum = new int[7]; // 과목합계
		double[] sub_avg = new double[7]; // 과목평균

		for (int i = 0; i < scores.length; i++) { //점수, 합계, 평균
			for (int j = 0; j < scores[i].length; j++) {
				scores[i][j] = (int) (Math.random() * 101);
				sum[i] += scores[i][j];
			}
			//System.out.println(Arrays.toString(scores[i]));
			avg[i] = (double)sum[i] / scores[i].length;
			//System.out.println("합계 : " + sum[i] + "  /  평균 : " + avg[i]);
		}

		for (int i = 0; i < scores.length; i++) { //석차
			rank[i] = 1;
		}
		for (int i = 0; i < scores.length; i++) { //석차
			for (int j = 0; j < scores.length; j++) {
				if (avg[i] < avg[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
		
		
		for (int i = 0; i < avg.length; i++) { //석차 정렬
			int min = i;
			for (int j = i+1; j < avg.length; j++) {
				if (avg[i] > avg[j]) {
					min = j;
				}
			}rank[min]++;
			int temp = rank[min];
			rank[min] = rank[i];
			rank[i] = temp;
		}
		System.out.println(Arrays.toString(avg));

		for (int i = 0; i < scores[i].length; i++) { // 과목별 점수를 기준으로
			for (int j = 0; j < scores.length; j++) { // 25번 반복
				sub_sum[i] += scores[j][i];
			}
			sub_avg[i] = (double)sub_sum[i] / scores.length;
		}
		
		System.out.println("이름     국어     영어     수학     사회     과학   Oracle    Java    합계     평균    석차");

		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i] + "\t");
			for (int j = 0; j < scores[i].length; j++) {
				System.out.print(scores[i][j] + "\t");
			}
			System.out.print(sum[i] + "\t");
			System.out.print((Math.round(avg[i] * 10)/10.0 + "\t"));
			System.out.print(rank[i] + "\t");
			System.out.println("");

		}
		System.out.print("과목합계\t");

		for (int i = 0; i < 7; i++) {
			System.out.print(sub_sum[i] + "\t");
		}

		System.out.println("");
		System.out.print("과목평균\t");

		for (int i = 0; i < 7; i++) {
			System.out.print((Math.round(sub_avg[i] * 10)/10.0 + "\t"));
		}

	}

}
