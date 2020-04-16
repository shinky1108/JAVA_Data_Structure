package Chapter4_���ð�_ť;

import java.util.Scanner;

public class IntStackTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while(true) {
			System.out.print("(1)Ǫ��    (2)��    (3)��ũ    (4)����    (5)�˻�    (6)�ʱ�ȭ    (7)�뷮    (8)����    (9)�����?    (10)��á��?    (0)����: ");
		
		int menu = stdIn.nextInt();
		if(menu == 0) break;
		
		int x;
		switch(menu){
			case 1: //Ǫ��
				System.out.print("������: ");
				x = stdIn.nextInt();
				try {
					s.push(x);
				}catch(IntStack.OverflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
			case 2: //��
				try {
					x=s.pop();
					System.out.println("���� �����ʹ� "+x+"�Դϴ�.");
				}catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �־��ϴ�.");
				}
				break;
			case 3:
				try {
					x = s.peek();
					System.out.println("��ũ�� �����ʹ�"+x+"�Դϴ�.");
				}catch(IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
				
			case 4:
				s.dump();
				break;
			
			case 5:
				System.out.print("�˻��� ��: ");
				int ky = stdIn.nextInt();
				int idx = s.indexOf(ky);
				if(idx == -1)
					System.out.println("�˻��� ���� �������� �ʽ��ϴ�.");
				else
					System.out.println(idx+"�� x["+idx+"]�� �ֽ��ϴ�.");
				break;
				
			case 6:
				s.clear();
				System.out.println("������ �ʱ�ȭ �߽��ϴ�.");
				break;
				
			case 7:
				int im_capacity = s.capacity();
				System.out.println("������ ���� �뷮��"+im_capacity+"�Դϴ�.");
				break;
				
			case 8:
				System.out.println("���ÿ�"+s.size()+"�� ����ֽ��ϴ�.");
				break;
				
			case 9:
				boolean empty = s.isEmpty();
				if(empty == true)
					System.out.println("������ ������ϴ�.");
				else
					System.out.println("������ ������� �ʽ��ϴ�.");
				break;
			case 10:
				boolean full = s.isFull();
				if(full == true)
					System.out.println("������ �� á���ϴ�.");
				else
					System.out.println("������ �� ���� �ʾҽ��ϴ�.");
				break;
			}
		}
	}
}
