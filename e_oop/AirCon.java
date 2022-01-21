package e_oop;

public class AirCon {
	//변수:대상의 속성. 대상이 가지고 있는 것 중에 우리가 조작할 수 있는 것(변하는 것)
	//ex) 전원, 온도, 풍향
	//메서드:대상이 하는 동작, 행동
	//ex) 전원을 켜는/끄는 메서드, 온도를 올리는/내리는 메서드, 풍향을 변경하는 메서드 (버튼1=메서드1)
	
	//파라미터는 외부에서 받는 정보이므로 없어도 됨
	//리턴타입이 없음. 버튼을 누른다고 나에게 피드백이 오지 않고 에어컨의 상태만 바뀜. 나의 변화는 없기 때문
	//final(상수):변수에 들어있는 값을 변경하지 않게 함
	
	
	boolean power = false;
	int temperature = 24;
	int wind = 2;

	final int MIN_TEMPERATURE = 18;
	final int MAX_TEMPERATURE = 30;
	final int MIN_WIND = 1;
	final int MAX_WIND = 3;

	void power() {
		power = !power;
		System.out.println(power ? "켜짐" : "꺼짐");
	}

	void temperatureUp() {
		if (power) {
			if (temperature < MAX_TEMPERATURE) {
				temperature++;
			}
			System.out.println("현재온도 : " + temperature);
		}
	}

	void temperatureDown() {
		if (power) {
			if (MIN_TEMPERATURE < temperature) {
				temperature--;
			}
			System.out.println("현재온도 : " + temperature);
		}
	}

	void changeWind() {
		wind++;
		if (MAX_WIND < wind) {
			wind = MIN_WIND;
		}
		System.out.println("현재풍량 : " + wind + "단계");
	}

	public static void main(String[] args) {
		AirCon ac = new AirCon();

		while (true) {
			System.out.println("1.전원  2.온도+  3.온도-  4.풍량  0.종료>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				ac.power();
				break;
			case 2:
				ac.temperatureUp();
				break;
			case 3:
				ac.temperatureDown();
				break;
			case 4:
				ac.changeWind();
				break;
			case 0:
				System.out.println("종료되었습니다.");
				System.exit(0);
			}
		}
	}

}
