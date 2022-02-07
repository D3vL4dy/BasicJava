package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Select {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KJI97";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "select * "
					+ " from customer"
					+ " where mem_mileage > ?";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, 4000);
			
			rs = ps.executeQuery();

			ResultSetMetaData metaData = rs.getMetaData(); 

			int columnCount = metaData.getColumnCount();
			
			while (rs.next()) {
				for(int i = 1; i <= columnCount; i++) { // 컬럼의 인덱스는 1부터 시작
					// 타입에 맞는 메서드 호출 후 파라미터로 컬럼의 인덱스나 컬럼명을 넘겨주면 값을 얻을 수 있음
					// get(컬럼의 인덱스/컬럼명) 메서드를 통해 컬럼을 하나씩 가져옴
					System.out.print(rs.getObject(i) + "\t");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(rs != null) try { rs.close(); } catch(Exception e) {} 
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
	}
}