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
		// 생성자를 호출하지 못하면 객체 생성을 할 수 없기 때문에 private으로 지정

	}

	private static BoardService instance; // 객체를 보관할 변수

	public static BoardService getInstance() {
		if (instance == null) { // 객체가 생성되지 않아 변수가 비어있을 경우
			instance = new BoardService(); // 새로 생성해 리턴
		}
		return instance;
	}
	
	//boardList();
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
			System.out.print("게시글번호>");
			CurrentBoardNo = ScanUtil.nextInt();
			return View.BOARD_INSERT;
		case 2:
		case 0:
			MemberService.loginMember = null; // 변수에 들어있던 값을 지우면 로그아웃
			return View.HOME;
		}
		
		return View.BOARD_LIST; // 사용자가 잘못 입력한 경우 목록을 보여줌
	}
	
	int CurrentBoardNo;
	
	public int boardRead() {
		
		Map<String,Object> board = boardDao.selectBoard(CurrentBoardNo);
		
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
		case 1: return View.BOARD_UPDATE;
		case 2: return View.BOARD_DELETE;
		case 0: return View.BOARD_LIST;
		}
	}
	
	public int boardInsert() {
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		System.out.print("아이디>");
		String memId = (String) MemberService.loginMember.get("MEM_ID");
		
		int result = boardDao.insertBoard(title, content, memId);
		
		if(0 < result) {
			System.out.println("게시글 등록이 완료되었습니다.");
		}else {
			System.out.println("게시글 등록에 실패하였습니다.");
		}
		return View.BOARD_LIST;
	}
	

	public int boardUpdate() {
		int boardNo = CurrentBoardNo;
		System.out.println("제목>");
		String title = ScanUtil.nextLine();
		System.out.println("내용>");
		String content = ScanUtil.nextLine();
		
		int result = boardDao.updateBoard(boardNo, title, content);
		
		if(0 < result) {
			System.out.println("게시글 등록이 완료되었습니다.");
		}else {
			System.out.println("게시글 등록에 실패하였습니다.");
		}
		return View.BOARD_LIST;
		
	}
	
	public int boardDelete(int boardNo) {
		System.out.println("정말 삭제하시겠습니까?");
		String yn = ScanUtil.nextLine();
		
		if(yn.equals("Y")) {
			int boardNo = CurrentBoardNo;
			int result = boardDao.deleteBoard(boardNo);
			if(0 < result) {
			}
				System.out.println("게시글 삭제가 완료되었습니다.");
			}else {
				System.out.println("게시글 삭제에 실패하였습니다.");
			}
			return View.BOARD_LIST;
	}
	
}
