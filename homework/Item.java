package homework;

public class Item { // Setting 클래스의 초기화블럭, 생성자를 제외한 나머지 상속받음

//	// 아이템 초기화
//	Item(String name, int hp, int speed, int bodyMoisture, int distance) { // 아이템이 가진 능력치가 다 다르기 때문에 외부에서 받아서
//		this.name = name;
//		this.hp = hp;
//		this.speed = speed;
//		this.bodyMoisture = bodyMoisture;
//		this.distance = distance;
//	}
//
//	public String toString(Runner runner) { // 아이템이 가진 정보를 리턴
//		String info = runner.name + " : ";
//		if (0 < runner.hp)
//			info += " 체력+" + hp; // 아이템이 올려주는 능력치만 적용하기 위해 if문으로 생성
//		if (0 < runner.speed)
//			info += " 속도+" + speed;
//		if (0 < runner.bodyMoisture)
//			info += " 체내수분량+" + bodyMoisture;
//		if (0 < runner.distance)
//			info += " 거리+" + distance;
//		return info;
}

//		Item itemChoose() {
//			return item[item_num];
//		}



//// 아이템을 랜덤으로 선택
//public int itemChoose() {
//	return item_num;
//}

//아이템을 얻는 메소드
//void getitem(Runner runner) {
//	System.out.println("아이템 뽑기!!");
//	System.out.println(runner.name + "님이 " + Integer.toString(itemChoose()) + "을 뽑았습니다.");
//	System.out.println("아이템은 바로 적용됩니다.");

//아이템을 가지고 있으면 아이템의 능력치가 캐릭터의 능력치에 바로 반영됨
//	runner.hp += item.hp; 
//	runner.bodyMoisture += item.bodyMoisture;
//	runner.distance += item.distance;
