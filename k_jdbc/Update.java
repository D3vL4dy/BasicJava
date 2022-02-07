package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KJI97";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(url, user, password);
		
			String sql = "update customer"
				     + " set mem_mileage = ?"
				     + " where mem_id = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 1000);
			ps.setString(2, "a001");
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}

	}

}