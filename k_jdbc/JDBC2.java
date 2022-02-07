package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {
	// 2. 발전된 형태
	// 쿼리 작성 시 물음표 사용
	// resultSet에서 값을 추출할 때 columnCount를 통해 한 번에 추출

	public static void main(String[] args) {

		// 데이터베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KJI97";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 연결 작업 > 커넥션 객체를 리턴받아 변수에 저장
			con = DriverManager.getConnection(url, user, password);

			String sql = "select *" 
					+ " from cart" 
					+ " where cart_member = ?" // 값을 물음표로 대신하고 나중에 채워 넣음(동적으로)
					+ " and cart_qty > ?"; // 줄바꿈 시 공백이 반드시 있어야 함

			ps = con.prepareStatement(sql); // 문자열로 된 쿼리를 오라클에 전송하기 적합한 형태로 바꿔서 리턴

			// 첫 번째 파라미터는 인덱스로 물음표의 순서를 의미, 두 번째 파라미터는 넣고 싶은 값을 적음
			// 물음표에는 값만 넣을 수 있음(테이블, 컬럼명 안돼)
			ps.setString(1, "a001"); // 첫 번째 물음표에 a001을 넣음 (VARCHAR2 -> String)
			ps.setInt(2, 5); // 두 번째 물음표에 5 넣음 (NUMBER-> int)
//			ps.setObject(0, sql); // 타입 상관없이 어떤 값이나 넣을 수 있음

			rs = ps.executeQuery(); // select인 경우 조회 결과를 resultSet으로 리턴

			// 조회된 결과 추출 (select만 해당) (line 47~57) 
			// 메타데이터 : 데이터에 대한 데이터. 조회된 결과에 대한 데이터 (컬럼명, 타입 등)
			ResultSetMetaData metaData = rs.getMetaData();

			// 컬럼의 갯수만 알면 모든 값을 한 번에 가져올 수 있음
			int columnCount = metaData.getColumnCount(); // 조회된 컬럼의 갯수

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) { // 컬럼의 인덱스는 1부터 시작
					// get(컬럼의 인덱스/컬럼명) 메서드를 통해 컬럼을 하나씩 가져옴
					System.out.print(rs.getObject(i) + "\t"); // 컬럼 인덱스를 파라미터로 넣음
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
	}

}
