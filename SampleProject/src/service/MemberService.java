package service;

import java.util.HashMap;
import java.util.Map;

import dao.MemberDao;
import util.ScanUtil;
import util.View;

public class MemberService {

	// 싱글톤 패턴 : 하나의 객체를 돌려쓰게 만들어주는 디자인 패턴
	private MemberService() {
		// private으로 지정하면 생성자를 호출하지 못하기 때문에 객체 생성을 할 수 없음
		// private로 다른 클래스에서 객체생성을 못하게 접근 제한(객체가 여러개 생길 일이 없어짐)
		
	}

	private static MemberService instance; // 객체를 보관할 변수

	public static MemberService getInstance() {
		if (instance == null) { // 객체가 생성되지 않아 변수가 비어있을 경우
			instance = new MemberService(); // 객체를 새로 생성해 리턴
		} // 객체가 이미 instance에 있으면 그대로 주면됨
		return instance; // 객체 리턴
	}
	
	public static Map<String, Object> loginMember; // 로그인된 사용자 정보 저장

	private MemberDao memberDao = MemberDao.getInstance();

	public int join() {
		System.out.println("========= 회원가입 =========");
		System.out.println("아이디>");
		String memId = ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String password = ScanUtil.nextLine();
		System.out.println("이름>");
		String memName = ScanUtil.nextLine();

		// 아이디 중복 확인
		// 비밀번호 확인
		// 유효성 검사(정규표현식)

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("MEM_ID", memId);
		param.put("PASSWORD", password);
		param.put("MEM_NAME", memName);

		int result = memberDao.insertMember(param);
		// 같은 내용(insertMember)을 다른 화면에서도 사용할 수 있기 때문에 db에 접속하는 내용을 다른 클래스로 생성

		if (0 < result) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}

		return View.HOME;
	}

	public int login() {
		System.out.println("========= 로그인 =========");
		System.out.println("아이디>");
		String memId = ScanUtil.nextLine();
		System.out.println("비밀번호>");
		String mpassword = ScanUtil.nextLine();
		
		// 멤버테이블에서 입력받은 아이디, 비번과 일치하는 사람을 찾으면 로그인
		Map<String, Object> member = memberDao.selectMember(memId, mpassword);
		
		if(member == null) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		} else {
			System.out.println("로그인 성공");
			loginMember = member; // 로그인 상태이기 때문에 사용자정보 담아두기
			// 글 작성이나 수정 시 자신의 아이디에 맞는 것을 가져와야 하기 때문에 그때 사용하기 위해 담아두는 것
			return View.BOARD_LIST; // 로그에 성공하면 게시판이 나오게
		}
		
		return View.LOGIN; // 로그인에 실패한 경우 다시 로그인
		// 로그인에 실패하면 다시 로그인을 할 수 있게 로그인 화면을 리턴
	}
}
