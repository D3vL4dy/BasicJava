package j_colletion;

import java.util.ArrayList;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board {

	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 컬럼 : 번호, 제목, 내용, 작성자, 작성일 
		 * 
		 * 목록 - 조회(상세), 등록
		 * 조회 - 수정, 삭제
		 */

		ArrayList<HashMap<String, Object>> boardTable = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> board = new HashMap<String, Object>();
		board.put("번호", 1);
		board.put("제목", "JAVA");
		board.put("작성자", "강정인");
		board.put("작성일", "01/28");
		boardTable.add(board);
		
		board = new HashMap<String, Object>();
		board.put("번호", 2);
		board.put("제목", "Oracle");
		board.put("작성자", "강정인");
		board.put("작성일", "01/27");
		boardTable.add(board);
		
		
		System.out.println("목록");
		for(int i = 0; i < boardTable.size(); i++) {
			board = boardTable.get(i);
			for(String key : board.keySet()) {
				System.out.print(board.get("번호") + "\t");
				System.out.println(board.get(key) + "\t"); //key에 해당하는 값을 꺼냄
			}
			System.out.println("\n");
		}
		
		System.out.println("1.조회    2.등록");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			for(int i = 0; i < boardTable.size(); i++) {
				board = boardTable.get(i);
				for(String key : board.keySet()) {
					System.out.println(board.get(key) + "\t");
				}
				System.out.println();
			}
			

		}
		
		
		

	}

}
