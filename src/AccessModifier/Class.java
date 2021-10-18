package AccessModifier;

//public - 아무나 사용가능
//protectd - 같은 패키지와 자식 클래스 사용가능
//default - 같은 패키지 내에서만 사용 가능(선언을 하지 않은 경우)
//private - 나만 사용 가능

//static -> 전역 변수, 전역 메소드
//객체화를 진행하지 않아도 그냥 바로 메모리에 올라가는 명령어
//
//class A {
//	static int c; => 스태틱 변수(전역변수)
//	int d; => 인스턴스 변수
//}
//
//A a = new A();
//a.d = 10;
//A.c = 10; x
//
//final -> 마지막의 상수화
//final int a = 10; 변수
//a = 20;
//final class A 클래스 -> 상속 X 
//final int abc() 메소드 -> 오버라딩 X 
//파이널이 붙으면 그 뒤로 무언가를 할수 없음.
public class Class {

}
