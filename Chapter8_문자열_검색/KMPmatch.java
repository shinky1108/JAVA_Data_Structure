package Chapter8_문자열_검색;

import java.util.Scanner;

// KMP 알고리즘
// 검사했던 위치 결과를 버리지 않고 이를 효율적으로 활용하는 알고리즘 
// 텍스트와 패턴의 겹치는 부분을 찾아내어 검사를 다시 시작할 위치를 구함 
// 몇 번째 문자부터 다시 검색할지에 대한 값을 미리 표로 만들어 이 문제를 해결해야함! 
public class KMPmatch {
	static int kmpMatch(String txt, String pat) {
		int pt=1;	//txt 커서 
		int pp=0;	//pat 커서
		int[] skip = new int[pat.length()+1]; // 건너뛰기 표
		
		// 건너뛰기 표를 만듬 
		skip[pt]=0;
		while(pt!=pat.length()) {
			if(pat.charAt(pt) == pat.charAt(pp))
				skip[++pt] = ++pp;
			else if (pp==0)
				skip[++pt]=pp;
			else
				pp=skip[pp];
		}
		// 검색
		pt = pp =0;
		while(pt != txt.length() && pp != pat.length()) {
			if(txt.charAt(pt) == pat.charAt(pp)) {
				pt++;
				pp++;
			}else if(pp==0)
				pt++;
			else
				pp = skip[pp];
		}
		if(pp==pat.length())
			return pt-pp;
		return -1;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.print("텍스트: ");
		String txt = stdIn.next();
		System.out.print("패턴: ");
		String pat = stdIn.next();
		
		kmpMatch(txt, pat);
		
	}
}
