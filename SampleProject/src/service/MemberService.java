package service;

import java.util.HashMap;
import java.util.Map;

import dao.MemberDao;
import util.ScanUtil;
import util.View;

public class MemberService {

	// 싱글톤 패턴 : 하나의 객체를 돌려쓰게 만들어주는 디자인 패턴
	private MemberService() {
		// 생성자를 호출하지 못하면 객체 생성을 할 수 없기 때문에 private으로 지정

	}

	private static MemberService instance; // 객체를 보관할 변수

	public static MemberService getInstance() {
		if (instance == null) { // 객체가 생성되지 않아 변수가 비어있을 경우
			instance = new MemberService(); // 새로 생성해 리턴
		}
		return instance;
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
		
		Map<String, Object> member = memberDao.selectMember(memId, mpassword);
		
		if(member == null) {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		} else {
			System.out.println("로그인 성공");
			loginMember = member;
			return View.BOARD_LIST;
		}
		
		return View.LOGIN; // 로그인에 실패한 경우 다시 로그인
	}
}
