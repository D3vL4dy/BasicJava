package controller;

import service.BoardService;
import service.MemberService;
import util.ScanUtil;
import util.View;

public class Controller {

	public static void main(String[] args) {
		/*
		 * 빌표내용 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연 > 프로젝트 후기
		 * 반표인원 : 발표자 1명, ppt 및 시연 도우미 1명
		 * 발표 시간 : 15분 내외
		 * 
		 * Controller : 화면 이동 (화면을 이동하고 싶을 때 컨트롤러를 통해서 다른 화면 호출)
		 * Service : 화면 기능 (각각의 기능을 메서드로)
		 * Dao : 데이터베이스 접속
		 */
		
		new Controller().start();
	}
	
	private MemberService memberService = MemberService.getInstance();
	private BoardService boardService = BoardService.getInstance();
	
	private void start() {
		int view = View.HOME; // 사용자가 첫 화면에서 로그인, 회원가입을 선택하는 화면

		while(true) {
			switch (view) { // view 값에 따라 해당하는 화면 실행
			case View.HOME: view = home(); break; // home에서는 다음 실행할 화면을 리턴 (리턴되는 값에 따라 계속 바뀜)
			case View.LOGIN: view = memberService.login(); break;
			case View.JOIN: view = memberService.join(); break;
			case View.BOARD_LIST: view = boardService.boardList(); break;
			
			}
		}
	}

	private int home() {
		System.out.print("1.로그인  2.회원가입  0.프로그램 종료>");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		// 직접 호출하는 것이 아닌 리턴으로 while문으로 돌아가서 실행됨
		// switch 안에서는 메서드를 직접 호출하지 말고 리턴할 것
		case 1: return View.LOGIN;
		case 2: return View.JOIN;
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		}
		// 사용자가 다른 숫자를 입력했을 경우를 대비해
		return View.HOME;
	}

}
