package e_oop.score;

import java.util.Arrays;

public class Score {

	public static void main(String[] args) {
		String[] studentNames = { "김기웅", "박태정", "이정규", "오지현" };
		Student[] students = new Student[studentNames.length]; // 학생을 저장할 배열

		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(); // 객체 생성 (타입은 클래스 이름과 같음) -> 배열에 저장

			students[i].name = studentNames[i];
			students[i].kor = (int) (Math.random() * 101);
			students[i].eng = (int) (Math.random() * 101);
			students[i].math = (int) (Math.random() * 101);
			students[i].rank = 1;
		}

		// 합계, 평균
		for (int i = 0; i < students.length; i++) {
			students[i].sum = students[i].kor + students[i].eng + students[i].math;
			students[i].avg = Math.round(students[i].sum / 3.0 * 100) / 100.0;
		}

		// 석차
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[i].sum < students[j].sum) {
					students[i].rank++;
				}
			}
		}

		// 정렬
		for (int i = 0; i < students.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < students.length; j++) {
				if (students[j].rank < students[min].rank) {
					min = j;
				}
			}
			// 배열 안에 들어있는 객체 자체를 바꿔주면 모든 변수가 바뀜. (클래스의 위치만 바꿔주면 돼)
			Student temp = students[i];
			students[i] = students[min];
			students[min] = temp;
		}

		// 과목합계
		int[] subSum = new int[3];
		for (int i = 0; i < students.length; i++) {
			subSum[0] += students[i].kor;
			subSum[1] += students[i].eng;
			subSum[2] += students[i].math;
		}

		// 과목평균
		double[] subAvg = new double[3];
		for (int i = 0; i < subAvg.length; i++) {
			subAvg[i] = Math.round((double) subSum[i] / students.length * 100) / 100.0;
		}

		// 출력
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].name + "\t" + students[i].kor + "\t" + students[i].eng + "\t"
					+ students[i].math + "\t" + students[i].sum + "\t" + students[i].avg + "\t" + students[i].rank);
		}

		System.out.print("과목합계");
		for (int i = 0; i < subSum.length; i++) {
			System.out.print("\t" + subSum[i]);
		}
		System.out.println();
		System.out.print("과목평균");
		for (int i = 0; i < subAvg.length; i++) {
			System.out.print("\t" + subAvg[i]);
		}

	}

}
