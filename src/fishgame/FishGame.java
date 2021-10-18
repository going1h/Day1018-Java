package fishgame;

import java.util.Random;
import java.util.Scanner;

//classȭ ����
//1. �����
//2. ȣ��
//3. ���ò�


class Fish
{
	int x;
	int y;
}

class Hosu
{
	Fish f1;
	Fish f2;
	Fish f3;

	//����Ʈ ������
	public Hosu() {
		// TODO Auto-generated constructor stub
		Random rand = new Random();
		f1 = new Fish();
		f2 = new Fish();
		f3 = new Fish();

		f1.x = rand.nextInt(5);
		f1.y = rand.nextInt(5);

		f2.x = rand.nextInt(5);
		f2.y = rand.nextInt(5);

		while(f2.x == f1.x && f2.y == f1.y)
		{
			f2.x = rand.nextInt(5);
			f2.y = rand.nextInt(5);
		}

		f3.x = rand.nextInt(5);
		f3.y = rand.nextInt(5);

		while((f3.x == f1.x && f3.y == f1.y) || (f3.x == f2.x && f3.y == f2.y))
		{
			f3.x = rand.nextInt(5);
			f3.y = rand.nextInt(5);
		}


	}


	Fish sendFishCheck(int x, int y)
	{
		// ȣ���� ������ ���ò��� ����Ⱑ �Ѵ� ���� ������ �ְ� �˴ϴ�.
		// �ϳ��� ����⸦ ���ΰ� ������ ��Ȳ�� �߻��մϴ�.
		// ���������̱� �����Դϴ�.

		if(f1 != null && f1.x == x && f1.y == y)
		{
			Fish f = new Fish();
			f.x = f1.x;
			f.y = f1.y;
			f1 = null;
			return f;
		}
		else if(f2 != null &&f2.x == x && f2.y == y)
		{
			Fish f = new Fish();
			f.x = f2.x;
			f.y = f2.y;
			f2 = null;
			return f;
		}
		else if(f3 != null && f3.x == x && f3.y == y)
		{
			Fish f = new Fish();
			f.x = f3.x;
			f.y = f3.y;
			f3 = null;
			return f;
		}
		else
		{
			return null;
		}
	}


	void countingPrint()
	{
		int count = 0;
		if(f1 != null)
		{
			count++;
		}
		if(f2 != null)
		{
			count++;
		}
		if(f3 != null)
		{
			count++;
		}
		
		System.out.println("���� ����� �� : " + count);
		
	}
	

}

class Fisher
{
	Fish f1 = null;
	Fish f2 = null;
	Fish f3 = null;

	int x;
	int y;

	void casting() // 4. ���ְ� �ȹް�
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������ġ �Է� : ");
		x = sc.nextInt();
		y = sc.nextInt();
		if(x < 0 || x > 4 || y < 0 || y > 4)
		{
			System.out.println("������ �Ѿ���ϴ� �ٽ� �Է��ϼ���");
			casting(); // �ݺ����� ȿ���� �����ϴ�.
		}
	}
	void reciveFish(Fish f)
	{
		if(f1 == null)
		{
			f1 = f;
		}
		else if(f2 == null)
		{
			f2 = f;
		}
		else
		{
			f3 = f;
		}
	}
	
	boolean checkFish()
	{
		if(f1 != null && f2 != null && f3 != null)
		{
			return true;
		}
		else
			return false;
	}

}




public class FishGame {

	//���α׷��� ó�� �����ϴ� ��ġ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Hosu h = new Hosu();
		// ȣ�� ��ü�� ���� �Ǹ�
		// ����Ⱑ 3������ �����̵˴ϴ�.
		Fisher f = new Fisher();
		// ���ò� ��ü�� �����մϴ�.
		f.casting(); // ���ò��� ĳ������ �մϴ�. x, y ��ǥ�� ������ �˴ϴ�.
		// �̷��Դ� casting�ϰ� ������ �̷��� ����ص� �˴ϴ�.
		f.f1=h.sendFishCheck(f.x, f.y); // null or fish��ü�� ���ϵ˴ϴ�.
		//���� ��ġ ǥ�� �� ����

		// ���ð����� ���������� ���;� �ϴ� ���

		h.countingPrint();

		while(true)
		{

			for(int f1=0; f1<5; f1++){
				for(int f2=0; f2<5; f2++){
					if(f.y == f1 && f.x == f2)
						System.out.print(" �� ");//���ø� �ϴ���ġ
					else if(h.f1 != null && h.f1.y == f1 && h.f1.x == f2)
						System.out.print(" �� ");//����Ⱑ �ִ���ġ
					else if(h.f2 != null && h.f2.y == f1 && h.f2.x == f2)
						System.out.print(" �� ");//����Ⱑ �ִ���ġ
					else if(h.f3 != null && h.f3.y == f1 && h.f3.x == f2)
					System.out.print(" �� ");//����Ⱑ �ִ���ġ
					else{
						System.out.print(" �� ");//����Ⱑ ������ġ
					}
				}
				System.out.println();
			}
			System.out.print("���� �Է� : ");
			int dr = sc.nextInt();
			//1,2,3,4 �ٸ��� �̸� �ٽ� �Է�(�߸��Է� ����)
			if(dr > 4 || dr < 0){
				continue;
			}
			switch (dr) {
			case 1: // ��
				f.y -- ;
				if(f.y <0)
				{
					System.out.println("���̻� ���� ������ �� �����ϴ�.");
					f.y = 0;
				}
				break;
			case 2: // �Ʒ�
				f.y ++ ;
				if(f.y > 4)
				{
					System.out.println("���̻� �Ʒ��� ������ �� �����ϴ�.");
					f.y = 4;
				}
				break;
			case 3: // ����
				f.x -- ;
				if(f.x <0)
				{
					System.out.println("���̻� �������� ������ �� �����ϴ�.");
					f.x = 0;
				}
				break;
			case 4: // ������
				f.x ++ ;
				if(f.x >4)
				{
					System.out.println("���̻� ���������� ������ �� �����ϴ�.");
					f.x = 4;
				}
				break;
			default :
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}

			//ī���� ���ǹ�
			//�̵� �Ŀ� ����� ������ �޴��� üũ
			f.reciveFish(h.sendFishCheck(f.x, f.y));
			
			
			//���ò� ����� ������ ��ü�� ��� ������ ����
			
			// ������� �˷��ִ� ��� �߰� ī����
			
			h.countingPrint();
			
			boolean check = f.checkFish(); 
			
			if(check)
			{
				System.out.println("��� ����⸦ ��ҽ��ϴ�.");
				break;
			}
		}


	}


}
