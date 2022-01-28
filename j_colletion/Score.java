package j_colletion;

import java.util.ArrayList;

public class Score {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0~100사이의 랜덤한 점수로 생성해주시고, 아래와 같이 출력해주세요.
		 * 
		 * 이름		국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 과목합계	450		450		450		450		450		450		450
		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00
		 */
		
		String[] names = {"강동주", "강정인", "강현수", "곽성상", "김기웅"
				, "김민지", "김형돈", "노혜지", "박태정", "서난희"
				, "예현의", "오지현", "오혜지", "유정민", "이병진"
				, "이수민", "이슬기", "이유정", "이의찬", "이정규"
				, "이종민", "장문석", "정다영", "최민규", "최혁진"};
		String[] subjects = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		
		// 이름
		ArrayList<String> std = new ArrayList<String>();
		for (int i = 0; i < names.length; i++) {
			std.add(names[i]);
		}

		// 과목
		ArrayList<String> sub = new ArrayList<String>();
		for (int i = 0; i < subjects.length; i++) {
			sub.add(subjects[i]);
		}

		// 점수
		ArrayList<ArrayList<Integer>> score = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < std.size(); i++) {
			score.add(new ArrayList<Integer>());
			for (int j = 0; j < sub.size(); j++) {
				score.get(i).add((int) (Math.random() * 101));
			}
		}

		// 합계, 평균
		ArrayList<Integer> sums = new ArrayList<Integer>();
		ArrayList<Double> avgs = new ArrayList<Double>();
		for (int i = 0; i < score.size(); i++) {
			int sum = 0;
			for (int j = 0; j < score.get(i).size(); j++) {
				sum += score.get(i).get(j);
			}
			sums.add(sum);
			avgs.add(Math.round((double) sum / score.get(i).size() * 100) / 100.0);
		}
		
		//석차
		ArrayList<Integer> ranks = new ArrayList<Integer>();
		for(int i = 0; i < std.size(); i++) { 
			int rank = 1;
			for(int j = 0; j < score.size(); j++) { 
				if (sums.get(i) < sums.get(j)) {
					rank++;
				}
			}
			ranks.add(i, rank);
		}

		// 정렬
		for (int i = 0; i < ranks.size() - 1; i++) {
			int min = i;
			for (int j = i + 1; j < ranks.size(); j++) {
				if (ranks.get(j) < ranks.get(min)) {
					min = j;
				}
			}
			std.set(i, std.set(min, std.get(i)));
			score.set(i, score.set(min, score.get(i)));
			sums.set(i, sums.set(min, sums.get(i)));
			avgs.set(i, avgs.set(min, avgs.get(i)));
			ranks.set(i, ranks.set(min, ranks.get(i)));
		}

		// 과목합계, 과목평균
		ArrayList<Integer> subsums = new ArrayList<Integer>();
		ArrayList<Double> subavgs = new ArrayList<Double>();
		for (int i = 0; i < sub.size(); i++) {
			int subsum = 0;
			for (int j = 0; j < std.size(); j++) {
				subsum += score.get(j).get(i);
			}
			subsums.add(subsum);
			subavgs.add(Math.round((double) subsum / std.size() * 100) / 100.0);
		}

		// 출력
		System.out.print("이름");
		for (int i = 0; i < sub.size(); i++) {
			System.out.print("\t" + sub.get(i));
		}
		System.out.println("\t합계\t평균\t석차");

		for (int i = 0; i < score.size(); i++) {
			System.out.print(std.get(i) + "\t");
			for (int j = 0; j < score.get(i).size(); j++) {
				System.out.print(score.get(i).get(j) + "\t");
			}
			System.out.println(sums.get(i) + "\t" + avgs.get(i) + "\t" + ranks.get(i));
		}
		
		System.out.print("과목합계\t");
		for(int i = 0; i < subsums.size(); i++) { // 7과목
			System.out.print(subsums.get(i) + "\t");
		}
		System.out.println();
		
		System.out.print("과목평균\t");
		for(int i = 0; i < subavgs.size(); i++) { // 7과목
			System.out.print(subavgs.get(i) + "\t");
		}

	}

}
