package score2;

public class Student { // 학생 1명의 데이터
	// 학생이 할 수 있는 일을 메서드로 생성

	String name;
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	int rank;

	void randomScore() {// 파라미터가 없는 이유 : 선언이 되어있고 값을 입력할 필요가 없기 때문에(랜덤으로 생성) 
		kor = (int) (Math.random() * 101);
		eng = (int) (Math.random() * 101);
		math = (int) (Math.random() * 101);
	}

	// 한번에 하나의 일만 하도록 각각의 메서드 생성
	// 합계
	int getSum() {
		return sum = kor + eng + math;
	}

	// 평균
	double getAverage() {
		return avg = Math.round(getSum() / 3.0 * 100) / 100.0; // getSum():sum 변수는 전에 발생된 값이 저장되어 있어 새로 값을 리턴해주는 메서드를
																// 사용하는 게 더 좋음
	}

	// Student[]:변수의 타입	students:변수의 이름
	int getRank(Student[] students) { // 파라미터: 학생들의 정보를 받음. 다른 사람의 점수가 있어야 비교가 가능하기 때문에 다른 사람의 점수를 외부에서 받음
		rank = 1;

		for (int i = 0; i < students.length; i++) {
			if (getSum() < students[i].getSum()) { // 파라미터로 받은 학생들의 합계와 내 합계를 비교해 석차를 구함
				rank++;
			}
		}

		return rank; // 학생의 석차가 필요할수도 있어 리턴해줌

	}

	String getInfo() {// 학생 한줄의 데이터를 제공하는 메서드 생성
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg + "\t" + rank;
	}

}
