package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	// 1. 기본적인 형태

	public static void main(String[] args) {
		/*
		 * JDBC(Java Database Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클 JDBC
		 * 
		 * JDBC 작성 단계
		 * 1. Connection 생성(DB 연결)
		 * 2. Statement 생성(쿼리 작성)
		 * 3. Query 실행 // select와 나머지로 구분
		 * 4. ResultSet에서 결과 추출(select인 경우) // 조회된 결과가 담겨진 ResultSet 객체를 얻음
		 * 5. ResultSet, Statement, Connection 닫기 // 한번 사용 후 객체는 닫아줘야 함
		 */

		// 데이터베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// jdbc:oracle:thin: jdbc의 버전 정보 / localhost:1521:xe 오라클 호스트 이름, 포트, SID
		String user = "system";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		// 데이터베이스 연결 시 예외 처리를 하게 되어 try-catch 사용
		// try, finally 모두 변수를 사용하므로 밖에 생성

		// DriverManager : 데이터베이스에 접속하기 위한 드라이버를 관리해주는 클래스
		// 서로 다른것들끼리 상호작용을 도와주는 것
		try {
			// 연결 작업 > 커넥션 객체를 리턴받아 변수에 저장
			con = DriverManager.getConnection(url, user, password);

			String sql = "select * from member"; // sql문 작성
			ps = con.prepareStatement(sql); // 문자열로 된 쿼리를 오라클에 전송하기 적합한 형태로 바꿔서 리턴

			rs = ps.executeQuery(); // select인 경우 조회 결과를 resultSet으로 리턴

			// 쿼리가 select냐 아니냐에 따라서 실행하는 메서드가 다름 (리턴타입의 차이)
			// 쿼리 작성은 같고 실행 메서드가 다름
			// select : 조회 결과를 resultSet으로 리턴
			// insert, update, delete : int 타입 (영향을 받은 행의 수) 리턴
			// select가 아니면 조회 결과가 없기 때문에 추출 X

//			int result = ps.executeUpdate();
			// result : 영향을 받은 행의 수

			// 결과가 resultSet 객체에 담겨 있어 출력하기 위해서는 하나씩 꺼내야 함 -> next() 메서드 사용
			// > 1번 행의 결과 가져옴. 반복할 때마다 2번, 3번 행 .... 행이 없을 때까지 while문 반복
			while (rs.next()) {
				// 컬럼을 하나씩 가져오는 방법 : get(컬럼의 인덱스/컬럼명) 메서드 사용 
				// 타입에 따라서 메서드 다름 (VARCHAR2 : String, NUMBER : int)
				// 타입에 맞는 메서드 호출 후 파라미터로 컬럼의 인덱스나 컬럼명을 넘겨주면 값을 얻을 수 있음
				
				String memId = rs.getString(1); // 파라미터 : 컬럼의 인덱스
				String memPass = rs.getString("MEM_PASS"); // 파라미터 : 컬럼명
				// (오라클은 대소문자를 구분하지 않기 때문에 mem_pass도 가능)

				// 컬럼을 하나씩 가져옴. resultSet 에 있는 객체들을 하나씩 추출해 출력
				System.out.println("MEM_ID : " + memId + " / MEM_PASS : " + memPass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 사용한 객체 닫기 rs -> ps -> con 순으로 (역순으로 닫음)
			// null이 아니다 라는 뜻은 객체가 생성되지 않았다는 의미
			// null이 아닐 때 실행. 객체가 생성되지 않았을 때 실행하면 nullpointexception 발생
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}
	
}
