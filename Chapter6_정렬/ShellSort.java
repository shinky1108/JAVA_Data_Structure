package Chapter6_����;

import java.util.Scanner;

public class ShellSort {
	
	static void shellSort1(int[] a, int n) {
		for(int h =n/2; h>0; h /=2) // h�� ������ ����, ���������� ������ 2�� �ݾ� �ٿ�����! 
			for(int i=h; i<n; i++) {
				int j;
				int tmp = a[i];
				for(j=i-h; j>=0 && a[j]>tmp; j-=h)
					a[j+h] = a[j];
				a[j+h] = tmp;
			}
	}
	
	static void shellSort2(int[] a, int n) {
		int h;
		for(h=1; h<n/9;h=h*3+1); // h�� �ʱⰪ�� ����! 1���� �����Ͽ� ���� 3���ϰ� 1�� ���ϸ鼭 n/9�� ���� �ʴ� ���� ū ���� h�� ���� 
		for(; h>0; h/=3) 
			for(int i=h; i<n; i++) {
				int j;
				int tmp = a[i];
				for(j=i-h; j>=0 && a[j]>tmp; j-=h)
					a[j+h] = a[j];
				a[j+h]=tmp;
			}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("�� ����(���� 1): ");
		System.out.print("��ڼ�: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for(int i=0; i<nx; i++) {
			System.out.print("x["+i+"]:");
			x[i] = stdIn.nextInt();
		}
		shellSort1(x, nx);
		System.out.println("������������ �����߽��ϴ�.");
		for(int i=0; i<nx; i++) {
			System.out.println("x["+i+"]="+x[i]);
		}
	}
}
