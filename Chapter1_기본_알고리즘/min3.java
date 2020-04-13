package Chapter1_기본_알고리즘;

public class min3 {
	static int min3m(int a, int b, int c) {
		int min = a;
		if (b<min) min = b;
		if (c<min) min = c;
		
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println("min3(5,6,7)="+min3m(5,6,7));
		System.out.println("min3(6,5,7)="+min3m(6,5,7));
		System.out.println("min3(7,6,5)="+min3m(7,6,5));
	}
	
}



