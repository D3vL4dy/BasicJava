package j_colletion;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 * Collection Framework (모두가 사용하는 공통된 다수의 데이터를 위해 만들어진 것)
		 * - List (배열과 비슷하게 생김. 인덱스 순으로 데이터를 저장)
		 * - Map (데이터 저장시 사용자가 키를 설정해 키에 값을 저장)
		 * - Set (중복된 값이 저장되지 않음)
		 * 
		 * ArrayList의 주요 메서드 (읽는 속도가 빠름)
		 * - boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다. 
		 * 								(데이터의 수에 따라 크기가 유동적으로 변하는 배열)
		 * - void add(int index, Object obj) : 지정된 위치에 객체를 추가한다. 
		 * 										(데이터를 중간에 저장하기 때문에 뒤에 있는 것들은 한칸씩 뒤로 밀리게 됨)
		 * - Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다. 
		 * 										(수정하는 메서드. 인덱스를 지정해 Object obj로 덮어씀. 기존에 저장된 값은 리턴)
		 * - Object get(int index) : 지정된 위치의 객체를 반환한다. 
		 * 							(값을 읽는 메서드. 인덱스를 파라미터로 넣어주면 해당하는 데이터를 얻을 수 있음)
		 * - int size() : 저장된 객체의 수를 반환한다. (배열의 length와 같은 의미)
		 * - Object remove(int index) : 지정된 위치의 객체를 제거한다. 
		 * 								(인덱스를 넘겨주면 해당 인덱스의 값이 삭제됨. 삭제된 값을 리턴해줌. 삭제된 자리를 채우기 위해 뒤에 있던 값이 한칸씩 앞으로 이동)
		 */
		
		ArrayList sample = new ArrayList(); // 타입에 상관없이 저장 가능하지만 값을 꺼낼 때 어떤 타입인지 알기 어려움

		sample.add("abc"); // 저장하고 싶은 값을 파라미터로 넘겨줌
		sample.add(100);
		sample.add(new Scanner(System.in));

		ArrayList<Integer> list = new ArrayList<Integer>(); // < >에 저장될 데이터의 타입을 지정
		// <제네릭>을 지정하지 않으면 사용시 형변환을 해줘야함

		list.add(10);
//		list.add("abc"); //int 타입의 데이터만 저장 가능
		list.add(new Integer(20)); // 원래는 integer도 클래스이기 때문에 객체를 생성한 후 값을 저장해야 함
		/*
		 * Wrapper클래스 (서로 자동으로 형변환)
		 * - byte : Byte
		 * - short : Short
		 * - int : Integer
		 * - long : Long
		 * - float : Float
		 * - double : Double
		 * - char : Character
		 * - boolean : Boolean
		 */
		System.out.println(list.add(30)); // boolean 타입. 저장의 성공여부를 반환
		System.out.println(list); // 객체 자체를 출력했을 때 객체의 주소가 아닌 저장된 데이터가 출력됨

		list.add(1, 40); // 1번 인덱스에 40을 저장. 기존 인덱스에 저장된 값들은 뒤로 한칸씩 밀리게 됨
		// 현재 저장된 인덱스 내에서만 인덱스 지정이 가능
		System.out.println(list);

		// set : 수정하는 메서드. 기존에 저장되어 있던 값을 리턴
		int before = list.set(2, 50); // 2번 자리를 50으로 변경
		System.out.println("before : " + before);
		System.out.println(list);

		// get : 값을 얻기 위한 메서드
		int get = list.get(2);
		System.out.println(get);
		
		//size
//		for(int i = 0; i < list.size(); i++) { //값을 지우면서 뒤에 있는 값들이 앞으로 옮겨져 for문이 2번만 실행됨 
//			System.out.println(i + " : " + list.remove(i));
//		}
//		System.out.println(list);
		
		for (int i = list.size() - 1; i >= 0; i--) {// 여러개의 값을 지울 때는 감소하는 식으로 for문 작성
			System.out.println(i + " : " + list.remove(i));
		}
		System.out.println(list);

		// list에 1~100 사이의 랜덤값을 10개 저장해주세요.
		for (int i = 0; i < 10; i++) {
			list.add((int) (Math.random() * 100) + 1);
		}
		System.out.println(list);

		// list에 저장된 값의 합계와 평균을 구해주세요.
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		avg = (double) sum / list.size();
		System.out.println("합계 : " + sum + ", 평균 : " + avg);

		// list에서 최소값과 최대값을 구해주세요.
		int min = list.get(0);
		int max = list.get(0);
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i) < min) {
				min = list.get(i);
			}
			if (max < list.get(i)) {
				max = list.get(i);
			}
		}
		System.out.println("최소값 : " + min + ", 최대값 : " + max);

		// list를 오름차순으로 정렬해주세요.
		// 방법1
		int temp = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				if (list.get(i) < list.get(j)) {
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		System.out.println(list);

		// 방법2
		for (int i = 0; i < list.size() - 1; i++) {
			min = i;
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) < list.get(min)) {
					min = j;
				}
			}
			int temp2 = list.get(i);
			list.set(i, list.get(min));
			list.set(min, temp2);

			// 한줄로 정리
			list.set(i, list.set(min, list.get(i)));
			//list.get(i)의 값이 min으로 가고 list.set(i, min)
			//i에 min을 넣고 기존 i의 값은 사라짐

		}
		System.out.println(list);

		
		////////////////////////// 2차원
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();

		list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);

		list2.add(list);

		list = new ArrayList<Integer>();
		list.add(40);
		list.add(50);

		list2.add(list);
		System.out.println(list2);

		// 값을 하나씩 꺼내올 때
		for (int i = 0; i < list2.size(); i++) { // 2차원 list2만큼
			ArrayList<Integer> list3 = list2.get(i); //변수의 타입이 ArrayList<Integer>
			for (int j = 0; j < list3.size(); j++) {
				System.out.println(list3.get(j));
			}
		}
		// 특정한 하나의 값만 얻을 때
		Integer integer = list2.get(0).get(1); // list2.get(0) : 1차원 ArrayList
		System.out.println(integer);

		// 학생 3명의 5과목에 대한 0~100점의 랜덤한 점수를 2차원 ArrayList에 저장해주세요.
		list2 = new ArrayList<ArrayList<Integer>>(); // 2차원 ArrayList에 새로운 객체를 생성해 저장

		for (int i = 0; i < 3; i++) {
			list2.add(new ArrayList<Integer>());
			for (int j = 0; j < 5; j++) {
				// ArrayList<Integer>() = list2.get(i)
				list2.get(i).add((int) (Math.random() * 101));
			}
		}
		System.out.println(list2);

		// 각 학생별 합계와 평균을 구해주세요.
		ArrayList<Integer> sums = new ArrayList<Integer>();
		ArrayList<Double> avgs = new ArrayList<Double>();

		for (int i = 0; i < list2.size(); i++) { // 2차원 list2만큼
			sum = 0;
			for (int j = 0; j < list2.get(i).size(); j++) {
				sum += list2.get(i).get(j); // i=학생, j=점수 : 1차원 ArrayList
			}
			sums.add(sum);
			avgs.add((double) sum / list2.get(i).size());
		}
		System.out.println(sums);
		System.out.println(avgs);

	}

}
