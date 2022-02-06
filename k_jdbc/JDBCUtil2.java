package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil2 {
	
	// selectList:조회 결과가 여러 줄. 결과가 여러 줄이면 HashMap을 List에 담아(List<Map<String, Object>>) 리턴
	// List<Map<String, Object>> selectList(String sql) : 물음표 없을 때 사용

	// 데이터베이스 접속 정보
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "system";
	private static String password = "java";

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static List<Map<String, Object>> selectList(String sql){
		List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql); 
			rs = ps.executeQuery();

			ResultSetMetaData metaData = rs.getMetaData();
			
//			while (rs.next()) {
//				Map<String, Object> map1 = new HashMap<String, Object>();
//				map1.put(metaData.getColumnName(1), rs.getObject(1));
//				map.put(sql, map1);
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return map;
		
	}
}