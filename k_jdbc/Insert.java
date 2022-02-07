package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KJI97";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(url, user, password);
		
			String sql = "insert into customer(mem_id, mem_name, mem_mileage)"
					+ " values (?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "y001");
			ps.setString(2, "이유정");
			ps.setInt(3, 10000);
			
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}

	}

}