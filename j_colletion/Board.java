package j_colletion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

		new Board().start();
	}

	ArrayList<HashMap<String, Object>> boardTable = new ArrayList<HashMap<String, Object>>();
	SimpleDateFormat format = new SimpleDateFormat("MM-dd");

	void start() {
		while (true) {
			System.out.println("===========================");
			System.out.println("번호\t제목\t작성자\t작성일");
			for (int i = boardTable.size() - 1; i >= 0; i--) { // 새로운 글이 위에 보이게 거꾸로 출력
				System.out.println("-----------------------");
				HashMap<String, Object> board = boardTable.get(i);
				System.out.println(board.get("BOARD_NO") + "\t" + board.get("TITLE") + "\t" + board.get("USER_NAME")
						+ "\t" + format.format(board.get("REG_DATE")));
			}
			System.out.println("===========================");

			System.out.println("1.조회  2.등록  0.종료>");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				read();
				break;
			case 2:
				insert();
				break;
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}
		}

	}

	private void insert() { // 등록
		HashMap<String, Object> board = new HashMap<String, Object>();

		int max = 0;
		// 게시글의 최댓값을 찾아 +1해준 값을 글번호로 사용
		for (int i = 0; i < boardTable.size(); i++) {
			if (max < (int) boardTable.get(i).get("BOARD_NO")) {
				max = (int) boardTable.get(i).get("BOARD_NO");
			}
		}

		board.put("BOARD_NO", max + 1); // 글번호도 자동으로 붙여지기 때문에 적지 않음

		System.out.println("<제목>");
		board.put("TITLE", ScanUtil.nextLine());

		System.out.println("<내용>");
		board.put("CONTENT", ScanUtil.nextLine());

		System.out.println("<작성자>");
		board.put("USER_NAME", ScanUtil.nextLine());

		board.put("REG_DATE", new Date()); // Date 객체를 생성하면 현재 날짜를 저장할 수 있음

		// 필요한 내용을 전부 해쉬맵에 저장 후 그 내용을 테이블에 추가
		boardTable.add(board);

		System.out.println("게시글이 등록되었습니다.");
	}

	private void read() {
		// 조회를 하기 위해서는 목록에서 사용자 입력(게시물 번호)을 받아 게시글 하나를 선택
		System.out.println("조회할 게시물 번호>");
		int boardNo = ScanUtil.nextInt();

		HashMap<String, Object> board = null; // 게시글 번호 저장할 변수
		for (int i = 0; i < boardTable.size(); i++) {
			if (boardNo == (int) (boardTable.get(i).get("BOARD_NO"))) {
				board = boardTable.get(i);
				break;
			} // 테이블을 돌면서 사용자가 입력한 번호랑 테이블에 있는 수랑 같은 것을 찾아 변수에 저장
		}

		System.out.println("==========================");
		System.out.println("번호\t: " + board.get("BOARD_NO"));
		System.out.println("--------------------------");
		System.out.println("작성자\t: " + board.get("USER_NAME"));
		System.out.println("--------------------------");
		System.out.println("작성일\t: " + board.get("REG_DATE"));
		System.out.println("--------------------------");
		System.out.println("제목\t: " + board.get("TITLE"));
		System.out.println("--------------------------");
		System.out.println("내용\t: " + board.get("CONTENT"));
		System.out.println("==========================");

		System.out.println("1.수정  2.삭제  0.목록>");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			update(board); // 파라미터를 넣어준 이유는 무엇을 삭제, 수정을 할건지 알아야하기 때문에 사용자가 선택한 게시글을 파라미터로 넘겨줌
			break;
		case 2:
			delete(board);
			break;
		case 0:

			break;
		}
	}

	private void delete(HashMap<String, Object> board) {

		// 사용자에게 다시 묻고 삭제를 한다고 하면 삭제함.
		System.out.println("정말 삭제 하시겠습니까?(Y/N)");
		String input = ScanUtil.nextLine();

		// 테이블을 돌면서 파라미터로 받은 게시물과 같은 것을 찾음
		if (input.equals("Y")) {
			for (int i = 0; i < boardTable.size(); i++) {
				if (board.get("BOARD_NO") == boardTable.get(i).get("BOARD_NO")) {
					boardTable.remove(i);
					System.out.println("게시글이 삭제되었습니다.");
					break;
				}
			}
		}

	}

	private void update(HashMap<String, Object> board) {
		// 파라미터로 받은 보드가 테이블에 들어있는 게시물에 주소가 들어있음
		// 내용이 아니라 주소가 들어있어서 주소를 참조하고 들어가면 테이블에 들어있는거나
		// 보드에 들어있는거나 같은 내용이기 떄문에 보드를 수정하면 테이블도 수정됨
		System.out.println("제목>");
		board.put("TITLE", ScanUtil.nextLine());
		System.out.println("내용>");
		board.put("CONTENT", ScanUtil.nextLine());

		System.out.println("게시글이 수정되었습니다.");
	}

}
