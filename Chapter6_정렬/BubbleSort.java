package Chapter6_정렬;

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
	// 어떤 패스에서 교환 횟수가 0이면 더 이상 정렬할 요소가 없다는 뜻!!
	static void bubbleSort2(int[] a, int n) {
		for(int i=0; i<n-1; i++) {
			int exchg=0; // 패스의 교환횟수를 기록 
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
		int k=0; //a[k]보다 앞쪽은 정렬을 마친 상태 
		while(k<n-1) {
			int last = n-1; // 마지막으로 요소를 교환한 위치 
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
		
		System.out.println("버블 정렬(버전1)");
		System.out.print("요솟수:");
		int nx = stdIn.nextInt();
		int []x = new int[nx];
		
		for(int i=0; i<nx; i++) {
			System.out.print("x["+i+"]: ");
			x[i] = stdIn.nextInt();
		}
		
		bubbleSort3(x, nx);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0; i<nx; i++) {
			System.out.println("x["+i+"]="+x[i]);
		}
	}
}
