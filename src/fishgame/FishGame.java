package fishgame;

import java.util.Random;
import java.util.Scanner;

//class화 진행
//1. 물고기
//2. 호수
//3. 낚시꾼


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

	//디폴트 생성자
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
		// 호수의 물고기와 낚시꾼의 물고기가 둘다 서로 가지고 있게 됩니다.
		// 하나의 물고기를 서로가 가지는 상황이 발생합니다.
		// 얕은복사이기 때문입니다.

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
		
		System.out.println("남은 물고기 수 : " + count);
		
	}
	

}

class Fisher
{
	Fish f1 = null;
	Fish f2 = null;
	Fish f3 = null;

	int x;
	int y;

	void casting() // 4. 안주고 안받고
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("던질위치 입력 : ");
		x = sc.nextInt();
		y = sc.nextInt();
		if(x < 0 || x > 4 || y < 0 || y > 4)
		{
			System.out.println("범위를 넘어갔습니다 다시 입력하세요");
			casting(); // 반복문에 효과를 가집니다.
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

	//프로그램에 처음 시작하는 위치
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Hosu h = new Hosu();
		// 호수 객체가 생성 되면
		// 물고기가 3마리가 생성이됩니다.
		Fisher f = new Fisher();
		// 낚시꾼 객체를 생성합니다.
		f.casting(); // 낚시꾼이 캐스팅을 합니다. x, y 좌표가 나오게 됩니다.
		// 이렇게는 casting하고 나서는 이렇게 사용해도 됩니다.
		f.f1=h.sendFishCheck(f.x, f.y); // null or fish객체가 리턴됩니다.
		//낚시 위치 표시 값 지정

		// 낚시게임이 끝날때까지 나와야 하는 출력

		h.countingPrint();

		while(true)
		{

			for(int f1=0; f1<5; f1++){
				for(int f2=0; f2<5; f2++){
					if(f.y == f1 && f.x == f2)
						System.out.print(" ↓ ");//낚시를 하는위치
					else if(h.f1 != null && h.f1.y == f1 && h.f1.x == f2)
						System.out.print(" ■ ");//물고기가 있는위치
					else if(h.f2 != null && h.f2.y == f1 && h.f2.x == f2)
						System.out.print(" ■ ");//물고기가 있는위치
					else if(h.f3 != null && h.f3.y == f1 && h.f3.x == f2)
					System.out.print(" ■ ");//물고기가 있는위치
					else{
						System.out.print(" □ ");//물고기가 없는위치
					}
				}
				System.out.println();
			}
			System.out.print("방향 입력 : ");
			int dr = sc.nextInt();
			//1,2,3,4 다른값 이면 다시 입력(잘못입력 방지)
			if(dr > 4 || dr < 0){
				continue;
			}
			switch (dr) {
			case 1: // 위
				f.y -- ;
				if(f.y <0)
				{
					System.out.println("더이상 위로 움직일 수 없습니다.");
					f.y = 0;
				}
				break;
			case 2: // 아래
				f.y ++ ;
				if(f.y > 4)
				{
					System.out.println("더이상 아래로 움직일 수 없습니다.");
					f.y = 4;
				}
				break;
			case 3: // 왼쪽
				f.x -- ;
				if(f.x <0)
				{
					System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
					f.x = 0;
				}
				break;
			case 4: // 오른쪽
				f.x ++ ;
				if(f.x >4)
				{
					System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
					f.x = 4;
				}
				break;
			default :
				System.out.println("잘못된 입력입니다.");
				break;
			}

			//카운팅 무의미
			//이동 후에 물고기 전달을 받는지 체크
			f.reciveFish(h.sendFishCheck(f.x, f.y));
			
			
			//낚시꾼 물고기 변수의 객체가 모두 있으면 실행
			
			// 몇마리인지 알려주는 기능 추가 카운팅
			
			h.countingPrint();
			
			boolean check = f.checkFish(); 
			
			if(check)
			{
				System.out.println("모든 물고기를 잡았습니다.");
				break;
			}
		}


	}


}
