package h_exception;

import java.io.IOException;

public class ThrowException {

	public static void main(String[] args) {

		/*
		 * 예외 발생시키기
		 * - throw new Exception();
		 */
		
		try {
			throw new IOException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		NullPointerException : null인데 그 안에 있는 무언가를 참조
//		String str = null;
//		System.out.println(str.equals("abc"));
		
		
//		ArrayIndexOutOfBoundsException : 배열이 인덱스의 범위를 벗어남
		int[] arr = new int[10];
		
//		for(int i = 0; i <= arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		
	}

}
