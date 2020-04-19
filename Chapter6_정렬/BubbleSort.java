package Chapter6_����;

import java.util.Scanner;

public class BubbleSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void bubbleSort1(int[] a, int n) {
		for(int i=0; i<n-1; i++) {
			for(int j=n-1; j>i; j--) {
				if(a[j-1] > a[j])
					swap(a, j-1, j);
			}
		}
	}
	// � �н����� ��ȯ Ƚ���� 0�̸� �� �̻� ������ ��Ұ� ���ٴ� ��!!
	static void bubbleSort2(int[] a, int n) {
		for(int i=0; i<n-1; i++) {
			int exchg=0; // �н��� ��ȯȽ���� ��� 
			for(int j=n-1; j>i; j--)
				if(a[j-1]>a[j]) {
					swap(a,j-1,j);
					exchg++;
				}
			if (exchg == 0) break;
		}
	}
	
	// 
	static void bubbleSort3(int[] a, int n) {
		int k=0; //a[k]���� ������ ������ ��ģ ���� 
		while(k<n-1) {
			int last = n-1; // ���������� ��Ҹ� ��ȯ�� ��ġ 
			for(int j=n-1; j>k; j--)
				if(a[j-1]>a[j]) {
					swap(a,j-1,j);
					last = j;
				}
			k=last;
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("���� ����(����1)");
		System.out.print("��ڼ�:");
		int nx = stdIn.nextInt();
		int []x = new int[nx];
		
		for(int i=0; i<nx; i++) {
			System.out.print("x["+i+"]: ");
			x[i] = stdIn.nextInt();
		}
		
		bubbleSort3(x, nx);
		
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0; i<nx; i++) {
			System.out.println("x["+i+"]="+x[i]);
		}
	}
}
