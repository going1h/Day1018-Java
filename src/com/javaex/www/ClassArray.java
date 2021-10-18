package com.javaex.www;

public class ClassArray {

	class A {
		int a;
	}
	public static void main(String[] args) {
		// 자료형이 기본형 배열
		int []a = new int[10];
		a[0] = 20;
		for(int i = 0; i < 10; i++) {
			System.out.println(a[i]);
		}
		
		A[] b = new A[10]; // 클래스 배열 생성
		// b[0] = new A();
		b[0].a = 20; // b의 인덱스 0에 a변수에 20을 대입 // 에러표시가 안나는데 에러 안되는것 배열의 객체인것.
		for(int i = 0; i<10; i++) { // 반복문 돌려서 출력
			// 여기서 에러가 나는 이유 ???
			// 전체 배열을 돌리면서 a의 값을 출력
			// 1~9번까지는 객게츨 안만들어 줬음.
			// 객체를 안만들어 주고 a변수를 접근하려고 하니까 에러가 발생함
			System.out.println(b[i]);
		}
	}

}
