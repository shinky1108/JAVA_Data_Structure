package Chapter6_����;

import java.util.Scanner;
// �ܼ� ���� ���� 
// �������� ������ �ƴ�! 

public class SelectionSort {
	
	static void swap(int[]a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void selectionSort(int[]a, int n) {
		for(int i=0; i<n; i++) {
			int min = i;
			for(int j=i+1; j<n; j++)
				if(a[min] > a[j])
					min = j;
			swap(a,i,min);
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�ܼ� ���� ����");
		System.out.print("��ڼ�:");
		int nx = stdIn.nextInt();
		int []x = new int[nx];
		
		for(int i=0; i<nx; i++) {
			System.out.print("x["+i+"]: ");
			x[i] = stdIn.nextInt();
		}
		
		selectionSort(x, nx);
		
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0; i<nx; i++) {
			System.out.println("x["+i+"]="+x[i]);
		}
	}
	
}
