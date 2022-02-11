package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MemberDao { // Dao : 데이터에 접근하는 객체
	// 같은 내용(insertMember)을 다른 화면에서도 사용할 수 있기 때문에 db에 접속하는 내용을 다른 클래스로 생성
	
	// 싱글톤 패턴 : 하나의 객체를 돌려쓰게 만들어주는 디자인 패턴
	private MemberDao() {
		// 생성자를 호출하지 못하면 객체 생성을 할 수 없기 때문에 private으로 지정
	}

	private static MemberDao instance; // 객체를 보관할 변수

	public static MemberDao getInstance() {
		if (instance == null) { // 객체가 생성되지 않아 변수가 비어있을 경우
			instance = new MemberDao(); // 새로 생성해 리턴
		}
		return instance;
	}

	public int insertMember(Map<String, Object> param) {
		String sql = "	INSERT INTO TB_JDBC_MEMBER" + " 	VALUES (?, ?, ?)";
		List<Object> _param = new ArrayList<Object>();
		_param.add(param.get("MEM_ID"));
		_param.add(param.get("PASSWORD"));
		_param.add(param.get("MEM_NAME"));

		return JDBCUtil.update(sql, _param);
	}
	
	public Map<String, Object> selectMember(String memId, String password){
		String sql = "SELECT MEM_ID"
				+ "        , PASSWORD"
				+ "        , MEM_NAME"
				+ "     FROM TB_JDBC_MEMBER"
				+ "    WHERE MEM_ID = ?"
				+ "      AND PASSWORD = ?";
		
		List<Object> param = new ArrayList<Object>();
		param.add(memId);
		param.add(password);
		
		return JDBCUtil.selectOne(sql, param);
	}
	
	

}
