package Chapter3_검색;

// 인스턴스 메서드 : static을 붙이지 않고 선언한 메서드
// 클래스 메서드 : static을 붙여 선언한 메서드 
// 차이점 : 메서드가 인스턴스에 포함되는지의 여부에 있음 

class IdTester{
	private static int counter = 0;
	private int id;
	
	//생성자
	public IdTester() {id = ++counter;}
	
	//아이디를 반환하는 인스턴스 메서드
	public int getId() {return id;}
	
	// counter를 반환하는 클래스 메서드
	public static int getCounter() {return counter;}
}



public class Id {
	public static void main(String[] args) {
		IdTester a = new IdTester();
		IdTester b = new IdTester();		
		IdTester c = new IdTester();
		
		System.out.println("a의 아이디: "+a.getId());
		System.out.println("b의 아이디: "+b.getId());
		System.out.println("c의 아이디: "+c.getId());
		
		System.out.println("부여한 아이디의 개수: "+IdTester.getCounter());
	}
}