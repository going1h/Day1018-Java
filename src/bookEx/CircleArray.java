package bookEx;

class Circle {
   int radius;
   public Circle(int radius) {
      this.radius = radius;
   }
   public double getArea() {
      return 3.14*radius*radius;
   }
}
public class CircleArray {
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Circle [] c;   // Circle 배열에 대한 레퍼런스 c 선언
      c = new Circle[5];   // 5개의 레퍼런스 배열 생성
      
      for(int i=0;i<c.length;i++)   // 배열의 개수 만큼
         c[i] = new Circle(i);   // i 번째 원소 객체 생성
      
      for(int i=0;i<c.length;i++)   // 배열의 모든 Circle 객체의 면적 출력
         System.out.print((int)(c[i].getArea()) + " ");
   }
}
   
//메소드
//
//인자
//class A
//class B
//
//void abc(int a, int b) -> 매개변수 정수 값이 2개가 전달 되어서 오는거
//void abc(A a, B b) -> 2개의 객체가 전달 되어서 오는거