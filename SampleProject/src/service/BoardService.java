package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.BoardDao;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class BoardService {

	// 싱글톤 패턴 : 하나의 객체를 돌려쓰게 만들어주는 디자인 패턴
	private BoardService() {
		// private으로 지정하면 생성자를 호출하지 못하기 때문에 객체 생성을 할 수 없음
		// private로 다른 클래스에서 객체생성을 못하게 접근 제한(객체가 여러개 생길 일이 없어짐)
	}

	private static BoardService instance; // 객체를 보관할 변수

	public static BoardService getInstance() {
		if (instance == null) { // 객체가 생성되지 않아 변수가 비어있을 경우
			instance = new BoardService(); // 객체를 새로 생성해 리턴
		} // 객체가 이미 instance에 있으면 그대로 주면됨
		return instance; // 객체 리턴
	}
	
	private BoardDao boardDao = BoardDao.getInstance();
			
	public int boardList() {
		List<Map<String, Object>> boardList = boardDao.selectBoardList(); // 게시판 목록 불러오기
		System.out.println("==============================");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("------------------------------");
		for(Map<String, Object> board : boardList) {
			System.out.println(board.get("BOARD_NO")
					+ "\t" + board.get("TITLE")
					+ "\t" + board.get("MEM_NAME")
					+ "\t" + board.get("REG_DATE"));
		}
		System.out.println("==============================");
		System.out.println("1.조회  2.등록  0.로그아웃>");
		
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1:
			readBoard();
			break;
		case 2:
			insertBoard();
			break;
		case 0:
			MemberService.loginMember = null; // 변수에 들어있던 값을 지우면 로그아웃
			return View.HOME;
		}
		return View.BOARD_LIST; // 사용자가 잘못 입력한 경우 목록을 보여줌
	}
	
	int currentBoardNo;
	
	public int readBoard() {
		System.out.print("게시글 번호>");
		currentBoardNo = ScanUtil.nextInt();
		
		Map<String,Object> board = boardDao.readBoardList(currentBoardNo);
		
		System.out.println("---------------------------------");
		System.out.println("번호\t: " + board.get("BOARD_NO"));
		System.out.println("작성자\t: " + board.get("MEM_NAME"));
		System.out.println("작성일\t: " + board.get("REG_DATE"));
		System.out.println("제목\t: " + board.get("TITLE"));
		System.out.println("내용\t: " + board.get("CONTENT"));
		System.out.println("---------------------------------");
		
		System.out.println("1.수정  2.삭제  0.목록>");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			boardDelete(currentBoardNo);
			return View.BOARD_READ;
		case 2:
			boardUpdate();
			return View.BOARD_READ;
		}
		return View.BOARD_LIST;
	}
	
	public int insertBoard() {
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		String memId = (String) MemberService.loginMember.get("MEM_ID");
		
		int result = boardDao.insertBoardList(title, content, memId);
		
		if(0 < result) {
			System.out.println("게시글 등록 성공");
		}else {
			System.out.println("게시글 등록 실패");
		}		
		return View.BOARD_LIST;
	}
	

	public int boardUpdate() {
		String boardNo = (String)MemberService.loginMember.get("BOARD_NO");
		System.out.println("제목>");
		String title = ScanUtil.nextLine();
		System.out.println("내용>");
		String content = ScanUtil.nextLine();
		
		int result = boardDao.updateBoardList(boardNo, title, content);
		
		if(0 < result) {
			System.out.println("게시글 수정 성공");
		}else {
			System.out.println("게시글 수정 실패");
		}
		return View.BOARD_LIST;
	}
	
	public int boardDelete(int boardNo) {
		System.out.println("정말 삭제하시겠습니까?(y/n)>");
		String yn = ScanUtil.nextLine();
		
		if(yn.equals("Y")) {
			int result = boardDao.deleteBoardList(yn, currentBoardNo);
			if(0 < result) {
			}
				System.out.println("게시글 삭제 성공");
			}else {
				System.out.println("게시글 삭제 실패");
			}
			return View.BOARD_LIST;
	}
}
