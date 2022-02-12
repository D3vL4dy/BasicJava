package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDao {

	// 싱글톤 패턴 : 하나의 객체를 돌려쓰게 만들어주는 디자인 패턴
	private BoardDao() {
		// private으로 지정하면 생성자를 호출하지 못하기 때문에 객체 생성을 할 수 없음
		// private로 다른 클래스에서 객체생성을 못하게 접근 제한(객체가 여러개 생길 일이 없어짐)
	}

	private static BoardDao instance; // 객체를 보관할 변수

	public static BoardDao getInstance() {
		if (instance == null) { // 객체가 생성되지 않아 변수가 비어있을 경우
			instance = new BoardDao(); // 객체를 새로 생성해 리턴
		} // 객체가 이미 instance에 있으면 그대로 주면됨
		return instance; // 객체 리턴
	}
	
	
	// 게시판 조회 메서드
	public List<Map<String, Object>> selectBoardList(){
		String sql = "SELECT A.BOARD_NO"
				+ "			, A.TITLE"
				+ "			, B.MEM_NAME"
				+ "			, TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "		FROM TB_JDBC_BOARD A"
				+ "		LEFT OUTER JOIN TB_JDBC_MEMBER B ON A.MEM_ID = B.MEM_ID"
				+ "		ORDER BY A.BOARD_NO DESC";
		
		return JDBCUtil.selectList(sql);
	}

	
	public Map<String, Object> readBoardList(int BoardNo){
		String sql =  "SELECT A.BOARD_NO"
				+ "			, A.TITLE"
				+ "			, A.CONTENT"//내용도 추가함
				+ "			, B.MEM_NAME"
				+ "			, TO_CHAR(A.REG_DATE, 'MM/DD') AS REG_DATE"
				+ "		FROM TB_JDBC_BOARD A"
				+ "		LEFT OUTER JOIN TB_JDBC_MEMBER B ON A.MEM_ID = B.MEM_ID"
				+ "	   WHERE A.BOARD_NO = ?";
		
		List<Object> param = new ArrayList<Object>();
		param.add(BoardNo);
		
		return JDBCUtil.selectOne(sql, param);	
	}
	

	public int insertBoardList(String title, String Content, String memId){
		String sql =  "INSERT INTO TB_JDBC_BOARD"
				+ " VALUES ("
				+ "		(SELECT NVL(MAX(BOARD_NO), 0) + 1"
				+ "		   FROM TB_JDBC_BOARD)"
				+ "		, ?, ?, ?"
				+ "		,SYSDATE"
				+ " )";	
		
		List<Object> param = new ArrayList<Object>();
		param.add(title);
		param.add(Content);
		param.add(memId);

		return JDBCUtil.update(sql, param);
	}
	

	public int updateBoardList(String boardNo, String title, String content) {
		String sql = "UPDATE TB_JDBC_BOARD"
				+ "		 SET TITLE = ?"
				+ "		   , CONTENT = ?"
				+ "	   WHERE BOARD_NO = ?";
		
		List<Object> param = new ArrayList<Object>();
		param.add(title);
		param.add(content);
		param.add(boardNo);
				
		return JDBCUtil.update(sql, param);		
	}
	

	public int deleteBoardList(String yn, int boardNo) {
		String sql = "DELETE FROM TB_JDBC_BOARD"
				+ "	   WHERE BOARD_NO = ?";
		List<Object> param = new ArrayList<Object>();
		
		if(yn.equals("y")) {
			param.add(boardNo);
		}

		return JDBCUtil.update(sql, param);
	}
}
