package Chapter2_기본_자료구조;

public class IntArray {
	public static void main(String[] args) {
		int[]a = new int[5];
		int[]b = {1,2,3,4,5};
		
		a[1]=37;
		a[2]=51;
		a[4]=a[1]*2;
		
		for (int i=0; i<a.length; i++) {
			System.out.println("a["+i+"]="+a[i]);
		}
		
		for (int i=0; i<b.length; i++) {
			System.out.println("b["+i+"]="+b[i]);
		}
	}
}
