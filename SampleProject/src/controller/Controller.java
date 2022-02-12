package controller;

import service.BoardService;
import service.MemberService;
import util.ScanUtil;
import util.View;

public class Controller {

	public static void main(String[] args) {
		/*
		 * Controller : 화면 이동 (화면을 이동하고 싶을 때 컨트롤러를 통해서 다른 화면 호출)
		 * Service : 화면 기능 (각각의 기능을 메서드로)
		 * Dao : 데이터베이스 접속
		 * 
		 * Controller : 화면 이동 (Controller를 통해서 화면을 이동한다.
		 *  하나의 기능을 수행하고 그 화면에서 바로 호출을 하는 것이 아닌 
		 *  기능을 수행 후 컨트롤러로 돌아가 컨트롤러에서 다시 다른 서비스를 호출)
		 *  
		 * Service : 화면 기능(하나하나의 기능이 Service), 화면에 나타나는 기능
		 * Dao : 데이터베이스 접속(데이터베이스에 접근해야 할 때 Dao를 사용한다.)
		 */
		
		new Controller().start();
	}
	
	private MemberService memberService = MemberService.getInstance();
	private BoardService boardService = BoardService.getInstance();
	
	private void start() {
		// 각 화면을 이동시켜주는 메서드
		int view = View.HOME; // 사용자가 첫 화면에서 로그인, 회원가입을 선택하는 화면

		while(true) { //이 구조를 숙지할것
			// 홈화면부터 시작 초기값 view = 0임
			switch (view) { // view 값에 따라 해당하는 화면 실행
			// 화면 다음에 다른 화면을 리턴해줄것이다.
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
		case 1: return View.LOGIN; //메서드를 호출하는 것이 아닌 리턴을 시켜주는것이다.
		case 2: return View.JOIN;
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		}
		// 사용자가 다른 숫자를 입력했을 경우를 대비해
		return View.HOME;
	}
}
