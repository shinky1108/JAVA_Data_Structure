package Chapter6_정렬;

import java.util.Scanner;

public class ShellSort {
	
	static void shellSort1(int[] a, int n) {
		for(int h =n/2; h>0; h /=2) // h는 간격을 설정, 지속적으로 나누기 2로 반씩 줄여나감! 
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
		for(h=1; h<n/9;h=h*3+1); // h의 초기값을 구함! 1부터 시작하여 값을 3배하고 1을 더하면서 n/9을 넘지 않는 가장 큰 값을 h에 대입 
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
		
		System.out.println("셸 정렬(버전 1): ");
		System.out.print("요솟수: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];
		
		for(int i=0; i<nx; i++) {
			System.out.print("x["+i+"]:");
			x[i] = stdIn.nextInt();
		}
		shellSort1(x, nx);
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0; i<nx; i++) {
			System.out.println("x["+i+"]="+x[i]);
		}
	}
}
