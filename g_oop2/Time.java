package g_oop2;

public class Time {

	private int hour; // 변수에 직접 접근할 수 없도록 private 설정
	private int minute;
	private int second;

	// 변수에 메서드를 통해 간접 접근
	public int getHour() { // get : 변수의 값을 얻기 위한 메서드
		return hour;
	}

	public void setHour(int hour) { // set : 변수에 값을 저장하기 위한 메서드
		if (hour < 0) {
			this.hour = 0;
		}else if(23 < hour) {
			this.hour = 23;
		}else {
			this.hour = hour;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute < 0) {
			this.minute = 0;
		}else if(59 < minute) {
			this.minute = 59;
		}else {
			this.minute = minute;
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(second < 0) {
			this.second = 0;
		}else if(59 < second) {
			this.second = 59;
		}else {
			this.second = second;
		}
	}
	
	void clock() {
		while(true) {
			System.out.println(toString()); //현재시간
			stop(); //1초마다 멈춤
			setSecond(second + 1); //1초씩 증가
		}
	}
	
	private void stop() { //다른 클래스에서는 사용하지 않는 메소드이므로 private
		try {
			Thread.sleep(1000); //프로그램을 잠깐동안 멈추는 메소드 (파라미터로 넣은 만큼)
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public String toString() { // Object 클래스 (모든 클래스의 부모 클래스)에
		return hour + ":" + minute + ":" + second;
	}

}
