package Chapter6_����;

import java.util.Scanner;

public class QuickSort1 {
	
	static void swap(int []a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(left+right)/2];
		
		System.out.printf("a[%d]~a[%d]: {",left, right);
		for(int i=left; i<right; i++)
			System.out.printf("%d , ", a[i]);
		System.out.printf("%d}\n", a[right]);
		
		do {
			while(a[pl]<x) pl++;
			while(a[pr]>x) pr--;
			if(pl<=pr)
				swap(a,pl++,pr--);
		}while(pl<=pr);
		
		if(left<pr) quickSort(a,left,pr);
		if(pl<right) quickSort(a,left,pr);
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
		
		quickSort(x, 0, nx-1);
		
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0; i<nx; i++) {
			System.out.println("x["+i+"]="+x[i]);
		}
	}
}
