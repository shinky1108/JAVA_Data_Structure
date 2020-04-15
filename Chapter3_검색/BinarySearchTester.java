package Chapter3_검색;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수: ");
		int num = stdIn.nextInt();
		int[]x = new int[num];
		
		System.out.println("오름차순으로 입력하세요.");
		for(int i = 0; i<num; i++) {
			System.out.print("x["+i+"]: ");
			x[i] = stdIn.nextInt();				
		}
		
		for(int i=1; i<num;i++) {
			if(x[i-1]>x[i]) {
				System.out.println("오름차순이 아닙니다.");
				System.exit(0);
			}
		}
		
		System.out.print("검색할 값: ");
		int ky = stdIn.nextInt();
		
		int idx = Arrays.binarySearch(x, ky);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky+"은 x["+idx+"]에 있습니다.");
	}
}
