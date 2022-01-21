package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*
		 * 산술 연산자
		 * - 사칙연산 : +, -, *, /, %(나머지)
		 * - 복합연산 : +=, -=, *=, /=, %=
		 * - 증감연산 : ++, --
		 */
		
		int result = 10 + 20 - 30 * 40 / 50 %  60;
		
		result = 10 / 3;
		System.out.println(result);
		result = 10 % 3;
		System.out.println(result);
		
		//5개의 산술연산자를 사용해 5개의 연산을 수행 후 결과를 출력해주세요.
		int plus = 1+1;
		int minus = 2-1;
		int mul = 2*2;
		int div = 6/3;
		int a = 10%4;
		System.out.println(plus + "\n" + minus + "\n" + mul + "\n" + div + "\n" + a);
		
		//복합연산
		result = result + 3;
		
		result += 3;
		
		result -= 5;
		
		result *= 2;
		
		result /= 3 + 2; //우측(3+2) 연산이 끝난 후 /= 실행 
		
		//아래의 문장을 복합연산자를 사용한 문장으로 만들어주세요.
		//result = result + 10;
		result += 10;
		//result = result % 5;
		result %= 5;
		//result = result - 2 * 3;
		result -= 2 * 3;
		
		//증감연산
		//증가연산자(++) : 변수의 값을 1 증가시킨다.
		//감소연산자(--) : 변수의 값을 1 감소시킨다.
		
		int i = 0;
		
		++i; //전위형 : 변수의 값을 읽어오기 전에 1 증가된다.
		i++; //후위형 : 변수의 값을 읽어온 후에 1 증가된다.
		--i;
		i--;
		
		i = 0;
		System.out.println("++i = " + ++i); //1
		i = 0;
		System.out.println("i++ = " + i++); //0
		System.out.println(i);
		
		//피연산자의 타입이 서로 같아야만 연산이 가능하다.
		int _int = 10;
		double _double = 3.14;
		double result2 = (double)_int + _double; //int > double (작은>큰)자동으로 형변환
		
		byte _byte = 5;
		short _short = 10;
		_int = _byte + _short; //최소 4byte가 되어야 연산을 하기 때문에 byte > short는 형변환 X
		//int보다 작은 것은 int로 형변환 후 연산
		
		char _char = 'a'; //97
		char _char2 = 'b'; //98
		_int = _char + _char2; //char(2byte)이므로 int로 형변환 후 연산
		System.out.println(_int);
		
		
		//오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		byte b = 127; //byte : -128~127
		b++;
		System.out.println(b); //가장 큰 값을 벗어나면 가장 작은 값이 표현됨 (오버플로우)
		b--;
		System.out.println(b); //가장 작은 값을 벗어나면 가장 큰 값이 표현됨 (언더플로우)
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456 + 654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 654321
		//5. 4번의 결과값 % 132456
		
		long result3 = 123456 + 654321; //int는 오버플로우 발생
		System.out.println("rsult3 = " + result3);
		result3 *= 123456;
		System.out.println("rsult3 = " + result3);
		result3 /= 123456;
		System.out.println("rsult3 = " + result3);
		result3 -= 654321;
		System.out.println("rsult3 = " + result3);
		result3 %= 123456;
		System.out.println("rsult3 = " + result3);
		
		
		//3개의 int타입 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		int a1 = 10;
		int a2 = 50;
		int a3 = 100;
		int sum = a1 + a2 + a3;
		double avg = sum / 3.0; //sum/3은 둘 다 int 타입으로 소수점의 결과를 얻을 수 없음
		System.out.println("합계 : " + sum + ", 평균 : " + avg);

//==========================================================================================
		
		//반올림
		avg = Math.round(avg); //소수점 첫째자리에서 반올림해준다.
		
		System.out.println(avg);
		avg = Math.round(avg * 10) / 10.0; //소수점 둘째자리에서 반올림. (소수점 뒤로 한칸 이동 후 반올림 -> 소수점 앞으로 한칸 이동)
		System.out.println(avg);
		
		//랜덤 : Math.random() - 0.0 ~ 1.0 미만 (0.0 ~ 0.999..)
		int random = (int)(Math.random() * 100) + 1; //0.0~99.9 에서 int변환 후 +1 > 1~100
		System.out.println(random);
		
//==========================================================================================		
		
		}
	
}
