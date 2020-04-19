package Chapter6_����;

import java.util.Scanner;

public class QuickSort2 {
	
	static void swap(int []a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void quickSort2(int[] a, int left, int right) {
		IntStack lstack = new IntStack(right-left+1);
		IntStack rstack = new IntStack(right-left+1);
		
		lstack.push(left);
		rstack.push(right);
		
		while(lstack.isEmpty() != true) {
			int pl = left = lstack.pop(); //���� Ŀ��
			int pr = right = rstack.pop(); // ������ Ŀ��
			int x = a[(left+right)/2]; 
			
			do {
				while(a[pl]<x) pl++;
				while(a[pr]>x) pr--;
				if(pl<=pr)
					swap(a,pl++, pr--);
			}while(pl<=pr);
			
			if(left<pr) {
				lstack.push(left); // ���� �׷��� ����
				rstack.push(pr); // �ε����� Ǫ�� 
			}
			if(pl<right) {
				lstack.push(pl);	//������ �׷��� ����
				rstack.push(right); // �ε����� Ǫ�� 
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�� ����");
		System.out.print("��ڼ�:");
		int nx = stdIn.nextInt();
		int []x = new int[nx];
		for(int i=0; i<nx; i++) {
			System.out.print("x["+i+"]: ");
			x[i] = stdIn.nextInt();
		}
		
		quickSort2(x, 0, nx-1);
		
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0; i<nx; i++) {
			System.out.println("x["+i+"]="+x[i]);
		}
	}
}
