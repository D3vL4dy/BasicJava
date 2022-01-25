package score2;

public class Score {

	public static void main(String[] args) {
		String[] studentNames = { "김기웅", "박태정", "이정규", "오지현" };
		Student[] students = new Student[studentNames.length]; // Student[]타입의 학생을 저장할 배열 생성

		// 학생 수 만큼 생성하는 반복문
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(); //객체를 생성해 배열에 저장
			students[i].name = studentNames[i];
			students[i].randomScore();
			students[i].getSum();
			students[i].getAverage();

		}

		// 석차
		for (int i = 0; i < students.length; i++) {
			students[i].getRank(students);
		}

		// 정렬
		for (int i = 0; i < students.length; i++) {
			int min = i;
			for (int j = i + 1; j < students.length; j++) {
				if (students[j].rank < students[min].rank) {
					min = j;
				}
			}
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

		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차");
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].getInfo());
		}

		System.out.print("과목합계");
		for (int i = 0; i < subSum.length; i++) {
			System.out.print("\t" + subSum[i]);
		}

		System.out.print("\n과목평균");
		for (int i = 0; i < subAvg.length; i++) {
			System.out.print("\t" + subAvg[i]);
		}

	}

}




