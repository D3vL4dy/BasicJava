package j_colletion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass { 
	//테이블 구조를 표현할 때 주로 사용 (컬럼명, 값)

	public static void main(String[] args) {
		/*
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * Object remove(Object key) : 저장된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet() : 저장된 모든 키를 Set으로 반환한다. 
		 */
		
		HashMap<String, Object> map = new HashMap<String, Object>(); //key, value 둘 다 타입을 지정해 (Object:아무 타입이나 가능)
		//인덱스로 저장되는 것이 아니기 때문에 순서의 개념이 없음(저장한 순서대로 저장되는 게 아님)
		map.put("age", 10);
		map.put("name", "홍길동");
		map.put("date", new Date());
		
		System.out.println(map);
		
		//수정> 같은 키로 한번 더 저장하면 덮어씀
		map.put("name", "이순신");
		System.out.println(map);
		
		map.remove("date"); //삭제> 키를 넘겨줌
		System.out.println(map);
		
		Object value = map.get("name"); //get을 통해 저장된 값을 얻을 수 있음(리턴타입을 Object로 지정했기 때문에 Object를 적어줌)
		
		System.out.println(((String)value).substring(0, 2)); //Object타입인 value를 형변환해야 사용할 수 있음
		String value2 = (String)map.get("name"); //위와 같은 의미
		
		
		Set<String> keys = map.keySet(); //key를 String으로 지정했기 때문에 꺼낸 값도 String으로 지정
		
		//keySet은 값을 하나씩 꺼낼 수 있는 메서드가 존재하지 않음
		for(String key : keys) {// 변수:여러개의 데이터(배열, set, ArrayList 등) 형태
			//keys에 담긴 데이터를 하나씩 꺼내서 for문을 실행
			System.out.println(key + " : " + map.get(key));
		}
		

		
		ArrayList<HashMap<String, Object>> lprodTable = new ArrayList<HashMap<String, Object>>();
		
		HashMap<String, Object> lprod = new HashMap<String, Object>();
		lprod.put("LPROD_ID", 1);
		lprod.put("LPROD_GU", "P101");
		lprod.put("LPROD_NM", "컴퓨터제품");
		lprodTable.add(lprod);
		
		lprod = new HashMap<String, Object>();
		lprod.put("LPROD_ID", 2);
		lprod.put("LPROD_GU", "P102");
		lprod.put("LPROD_NM", "전자제품");
		lprodTable.add(lprod);
		
		lprod = new HashMap<String, Object>();
		lprod.put("LPROD_ID", 3);
		lprod.put("LPROD_GU", "P201");
		lprod.put("LPROD_NM", "여성캐주얼");
		lprodTable.add(lprod);
		
		System.out.println(lprodTable);
		
		
		for(int i = 0; i < lprodTable.size(); i++) {
			lprod = lprodTable.get(i);
			for(String key : lprod.keySet()) {
				//keySet() : LPROD_ID, LPROD_GU, LPROD_NM
				System.out.println(lprod.get(key) + "\t"); //key에 해당하는 값을 꺼냄
			}
			System.out.println();
		}
				
		
		
	}

}
























