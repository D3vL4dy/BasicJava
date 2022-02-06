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

public class SelectOne {
	// 데이터베이스 접속 정보
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "system";
	private static String password = "java";

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	/*
	 * // String sql :쿼리	List<Object> param :물음표에 들어갈 값을 순서대로 ArrayList에 담아 파라미터로 넘김
	 * 
	 * // selectOne:조회 결과가 한 줄. 결과를 HashMap에 담아 리턴	
	 * Map<String, Object> selectOne(String sql) : 물음표 없을 때 사용
	 * Map<String, Object> selectOne(String sql, List<Object> param) : sql문 안에 물음표가 있을 때 사용
	 */
	
//	public static Map<String, Object> selectOne(String sql) {
//		
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		
//		try {
//			con = DriverManager.getConnection(url, user, password);
//			ps = con.prepareStatement(sql);
//			rs = ps.executeQuery();
//
//			ResultSetMetaData metaData = rs.getMetaData();
//			
//			while (rs.next()) {
//				Map<String, Object> map1 = new HashMap<String, Object>();
//				map1.put(metaData.getColumnName(1), rs.getObject(1));
//				map.put(sql, map1);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(rs != null) try {rs.close();} catch(Exception e) {}
//			if(ps != null) try {ps.close();} catch(Exception e) {}
//			if(con != null) try {con.close();} catch(Exception e) {}
//		}
//		return map;
//	}
	
	public static List<Map<String,Object>> selectOne(String sql, List<Object> param) {
		// 파라미터로 쿼리를 받는 메서드. 실행 결과를 ArrayList에 담아 리턴
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			con = DriverManager.getConnection(url, user, password);

			ps = con.prepareStatement(sql);

			// 파라미터로 받은 물음표에 들어갈 값이 ArrayList에 들어있음 (ArrayList는 값이 여러 개일 때 사용)
			for (int i = 0; i < param.size(); i++) { // for문을 돌면서 SetObject 메서드로 하나씩 채워 넣음
				ps.setObject(i + 1, param.get(i)); // 물음표의 인덱스는 1부터 시작하므로 i + 1
			}
			rs = ps.executeQuery();

			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(Exception e) {}
			if(ps != null) try {ps.close();} catch(Exception e) {}
			if(con != null) try {con.close();} catch(Exception e) {}
		}
		return list;
	}
	
}
