package Chapter3_�˻�;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("��ڼ�: ");
		int num = stdIn.nextInt();
		int[]x = new int[num];
		
		System.out.println("������������ �Է��ϼ���.");
		for(int i = 0; i<num; i++) {
			System.out.print("x["+i+"]: ");
			x[i] = stdIn.nextInt();				
		}
		
		for(int i=1; i<num;i++) {
			if(x[i-1]>x[i]) {
				System.out.println("���������� �ƴմϴ�.");
				System.exit(0);
			}
		}
		
		System.out.print("�˻��� ��: ");
		int ky = stdIn.nextInt();
		
		int idx = Arrays.binarySearch(x, ky);
		
		if(idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(ky+"�� x["+idx+"]�� �ֽ��ϴ�.");
	}
}
