package e_oop;

public class WaterPurifier {
	
	//변수:대상의 속성. 대상이 가지고 있는 것 중에 우리가 조작할 수 있는 것(변하는 것)
	//ex) 냉수, 온수
	//메서드:대상이 하는 동작, 행동
	//ex) 냉수가 나오는 메서드, 온수가 나오는 메서드(버튼), 얼음이 나오는 메서드 (버튼1=메서드1)
	
	//파라미터는 외부에서 받는 정보이므로 없어도 됨
	//리턴타입이 없음. 버튼을 누른다고 나에게 피드백이 오지 않고 에어컨의 상태만 바뀜. 나의 변화는 없기 때문
	//final(상수):변수에 들어있는 값을 변경하지 않게 함
	
	
	boolean ice_button = false;
	boolean hot_button = false;
	int water = 300;
	final int MAX_WATER = 500;
	

	void ice() {
		ice_button = !ice_button;
		System.out.println(ice_button ? "냉수" : "꺼짐");
		System.out.println("현재 냉수의 양 : " + water);
	}
	
	void hot() {
		hot_button = !hot_button;
		System.out.println(hot_button ? "온수" : "꺼짐");
		System.out.println("현재 온수의 양 : " + water);
	}
	
	void water() {
		if (ice_button) {
			if (water < MAX_WATER) {
				water+=200;
			}
			System.out.println("현재 냉수의 양 : " + water);
		}
		if (hot_button) {
			if (water < MAX_WATER) {
				water+=200;
			}
			System.out.println("현재 온수의 양 : " + water);
		}
		
	}
	
	


	public static void main(String[] args) {
		WaterPurifier wp = new WaterPurifier();

		while (true) {
			System.out.println("1.냉수  2.온수  3.500ml  0.종료>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				wp.ice();
				break;
			case 2:
				wp.hot();
				break;
			case 3:
				wp.water();
				System.out.println("가득입니다.");
				System.exit(0);
			
			}
		}
	}

}
