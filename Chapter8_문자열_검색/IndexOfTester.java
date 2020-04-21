package Chapter8_문자열_검색;

import java.util.Scanner;

public class IndexOfTester {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("텍스트: ");
		String s1 = stdIn.next();
		
		System.out.print("패턴: ");
		String s2 = stdIn.next();
		
		int idx1 = s1.indexOf(s2); // 문자열 s1에서 s2를 검색, idx1=3
		int idx2 = s1.lastIndexOf(s2); // 문자열 s1에서 s2를 검색, idx2 = -1, 뒤에서 부터 찾는데 반환할 때는 왼쪽에서부터 인덱스를 세서 반환! 
		System.out.println(idx1);
		System.out.println(idx2);
		// 검색에 실패하면 -1 반환, 성공하면 찾은 문자열의 인덱스를 반환! 
		if(idx1 == -1)
			System.out.println("텍스트 안에 패턴이 없습니다.");
		else { // 찾아낸 문자열의 바로 앞까지의 문자 개수를 구함 
			int len1 = 0;
			for(int i=0; i<idx1; i++)
				// substring(시작위치, 끝위치) 
				len1+=s1.substring(i,i+1).getBytes().length;
			len1+=s2.length();
			
			int len2 = 0;
			for(int i=0; i<idx2; i++)
				len2+=s1.substring(i,i+1).getBytes().length;
			len2+=s2.length();
			
			System.out.println("텍스트: "+s1);
			System.out.printf(String.format("패턴:%%%ds\n", len1), s2);
			System.out.println("텍스트: "+s1);
			System.out.printf(String.format("패턴:%%%ds\n", len2),s2);
		}
	}
}
