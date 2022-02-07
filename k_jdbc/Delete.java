package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KJI97";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(url, user, password);
		
			String sql = "delete "
					+ " from customer "
					+ " where mem_id = ?";
			
			// 문자열로 된 쿼리를 오라클에 전송하기 적합한 형태로 바꿔서 리턴
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "y001");
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}

	}

}