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
      Circle [] c;   // Circle �迭�� ���� ���۷��� c ����
      c = new Circle[5];   // 5���� ���۷��� �迭 ����
      
      for(int i=0;i<c.length;i++)   // �迭�� ���� ��ŭ
         c[i] = new Circle(i);   // i ��° ���� ��ü ����
      
      for(int i=0;i<c.length;i++)   // �迭�� ��� Circle ��ü�� ���� ���
         System.out.print((int)(c[i].getArea()) + " ");
   }
}
   
//�޼ҵ�
//
//����
//class A
//class B
//
//void abc(int a, int b) -> �Ű����� ���� ���� 2���� ���� �Ǿ ���°�
//void abc(A a, B b) -> 2���� ��ü�� ���� �Ǿ ���°�