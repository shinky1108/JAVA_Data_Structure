package Chapter4_스택과_큐;

import java.util.Scanner;

public class IntStackTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while(true) {
			System.out.print("(1)푸시    (2)팝    (3)피크    (4)덤프    (5)검색    (6)초기화    (7)용량    (8)개수    (9)비었음?    (10)꽉찼음?    (0)종료: ");
		
		int menu = stdIn.nextInt();
		if(menu == 0) break;
		
		int x;
		switch(menu){
			case 1: //푸시
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					s.push(x);
				}catch(IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			case 2: //팝
				try {
					x=s.pop();
					System.out.println("팝한 데이터는 "+x+"입니다.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있씁니다.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("피크한 데이터는"+x+"입니다.");
				}catch(IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어 있습니다.");
				}
				break;
				
			case 4:
				s.dump();
				break;
			
			case 5:
				System.out.print("검색할 값: ");
				int ky = stdIn.nextInt();
				int idx = s.indexOf(ky);
				if(idx == -1)
					System.out.println("검색한 값은 존재하지 않습니다.");
				else
					System.out.println(idx+"은 x["+idx+"]에 있습니다.");
				break;
				
			case 6:
				s.clear();
				System.out.println("스택을 초기화 했습니다.");
				break;
				
			case 7:
				int im_capacity = s.capacity();
				System.out.println("스택의 남은 용량은"+im_capacity+"입니다.");
				break;
				
			case 8:
				System.out.println("스택에"+s.size()+"개 들어있습니다.");
				break;
				
			case 9:
				boolean empty = s.isEmpty();
				if(empty == true)
					System.out.println("스택이 비었습니다.");
				else
					System.out.println("스택이 비어있지 않습니다.");
				break;
			case 10:
				boolean full = s.isFull();
				if(full == true)
					System.out.println("스택이 꽉 찼습니다.");
				else
					System.out.println("스택이 꽉 차지 않았습니다.");
				break;
			}
		}
	}
}
