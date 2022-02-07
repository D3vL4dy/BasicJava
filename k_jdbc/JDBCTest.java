package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCTest {
	// JDBCUtil에서 만든 메서드 테스트
	// 메서드 호출 시 쿼리랑 물음표를 준비해서 파라미터로 넘겨주면 결과 리턴

	public static void main(String[] args) {
		
		// List<Map<String, Object>> selectList(String sql, List<Object> param)
		String sql = "select *"
				+ " from cart"
				+ " where cart_member = ?"
				+ " and cart_qty > ?";

		// 물음표에 들어갈 값을 리스트에 담아 넘겨야 함
		ArrayList<Object> param = new ArrayList<Object>();
		param.add("a001");
		param.add(5);

		List<Map<String, Object>> list = JDBCUtil.selectList(sql, param);

		System.out.println(list);
		
		
		// Map<String, Object> selectOne(String sql, List<Object> param)
		// 쿼리와 값만 있으면 메서드 호출 준비 완료
		sql = "select *"
				+ " from member"
				+ " where mem_id = ?";
		param = new ArrayList<Object>();
		param.add("a001");
		
		Map<String, Object> map = JDBCUtil.selectOne(sql, param);
		
		System.out.println(map);
	
		
		// int update(String sql, List<Object> param)
		sql = "insert into cart values (?, ?, ?, ?)";
		param = new ArrayList<Object>();
		param.add("a001");
		param.add("2005040100001");
		param.add("P201000019");
		param.add(3);
		
		int result = JDBCUtil.update(sql, param);
		System.out.println("영향받은 행 : " + result);
		
	}

}
