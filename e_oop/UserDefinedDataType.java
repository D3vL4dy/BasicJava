package e_oop;

public class UserDefinedDataType {

	public static void main(String[] args) {
		/*
		 * 사용자 정의 데이터 타입
		 * - 데이터의 최종 진화 형태이다. (기본형 -> 배열 -> 클래스)
		 * - 서로 다른 타입의 데이터를 묶어서 사용하는 것이다.
		 * - 변수와 메서드로 구성할 수 있다.
		 */
		
		
		//기본형
		int kor;
		int eng;
		int math;
		int sum;
		double avg;
		
		//배열
		int[] scores;
		int sum2;
		double avg2;


		//클래스
		Student student = new Student(); // new Student() : 클래스 초기화. 객체 생성(인스턴스화)
		//클래스의 이름이 타입이 되고 뒤는 변수명을 적는다.
		//Student:타입
		student.kor = (int)(Math.random() * 101); //.을 통해 클래스 내부로 접근
		student.eng = (int)(Math.random() * 101);
		student.math = (int)(Math.random() * 101);
		student.sum = student.kor + student.eng + student.math;
		student.avg = Math.round(student.sum / 3.0 * 100) / 100.0;
		
		System.out.println("합계 : " + student.sum);
		System.out.println("평균 : " + student.avg);
	}

}

class Student{ //객체 생성 : 클래스의 내용을 사용할 수 있게 메모리에 올려놓는 작업
	//클래스:설계도	객체:물건
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
}
