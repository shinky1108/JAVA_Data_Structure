package Chapter3_�˻�;

// �ν��Ͻ� �޼��� : static�� ������ �ʰ� ������ �޼���
// Ŭ���� �޼��� : static�� �ٿ� ������ �޼��� 
// ������ : �޼��尡 �ν��Ͻ��� ���ԵǴ����� ���ο� ���� 

class IdTester{
	private static int counter = 0;
	private int id;
	
	//������
	public IdTester() {id = ++counter;}
	
	//���̵� ��ȯ�ϴ� �ν��Ͻ� �޼���
	public int getId() {return id;}
	
	// counter�� ��ȯ�ϴ� Ŭ���� �޼���
	public static int getCounter() {return counter;}
}



public class Id {
	public static void main(String[] args) {
		IdTester a = new IdTester();
		IdTester b = new IdTester();		
		IdTester c = new IdTester();
		
		System.out.println("a�� ���̵�: "+a.getId());
		System.out.println("b�� ���̵�: "+b.getId());
		System.out.println("c�� ���̵�: "+c.getId());
		
		System.out.println("�ο��� ���̵��� ����: "+IdTester.getCounter());
	}
}