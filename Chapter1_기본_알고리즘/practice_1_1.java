package Chapter1_�⺻_�˰���;
import java.util.Scanner;

public class practice_1_1 {
	public static void main(String [] arg) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�� ������ �ִ밪�� ���մϴ�.");
		System.out.print("a�� ��: "); int a = stdIn.nextInt();
		System.out.print("b�� ��: "); int b = stdIn.nextInt();
		System.out.print("c�� ��: "); int c = stdIn.nextInt();
		
		int max = a;
		if(b>max) max = b;
		if (c>max) max = c;
		
		System.out.println("�ִ��� "+max+"�Դϴ�.");
		
	}
}
