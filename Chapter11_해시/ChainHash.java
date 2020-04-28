package Chapter11_�ؽ�;

// �迭�� Ű ���� �迭�� ��ڼ��� ���� �������� ������ => �ؽ� ��!
// �ؽ� ���� �ε����� �ǵ��� ������ Ű ���� ������ �迭�� => �ؽ� ���̺�!
// �ؽ� ���̺��� �� ��Ҹ� => ��Ŷ 
// ���� ��� 
// 5 6 14 20 29 34 37 51 69 75 - - - => �迭�� ��ڼ� : 13 
// 5 6 1  7  3  8  11 12 4  10 - - - => �ؽ� �� 
// - 14 - 29 69 5 6 20 34 - 75 37 51 => �ؽ� ���̺� 
// ���࿡ 35��� ���ڸ� �߰��ϰ� ������ 35 % 13 => ������ 9 => �ؽ� ���̺�[9]��°�� ����! 
// �浹 : �ؽð��� ���� �������� �ϴµ� �� �ڸ��� ���ڰ� ��� �ִ� ��! 
// �浿���� ���� ��ó
// (1) ü�ι� : ���� �ؽ� ���� ���� ��Ҹ� ���� ����Ʈ�� ������ (=���� �ؽù�)
// - ü�ι��� �ε��� ��ҿ� �ٷ� �ִ� ���� �ƴ϶� ���� ����Ʈ�� ���� �����ϰ� ����! ��� �������. �� �ε����� null�� ����Ŵ
// (2) ���� �ּҹ� : �� ��Ŷ�� ã�� ������ �ؽø� �ݺ��� 

public class ChainHash<K, V>{
	// �ؽø� �����ϴ� ���
	class Node<K,V>{
		private K key;				// Ű ��
		private V data;			// ������ 
		private Node<K,V> next;		// ü���� ���� ��忡 ���� ����
		
		// ������
		Node(K key, V data, Node<K,V> next){
			this.key = key;
			this.data = data;
			this.next = next;
		}
		
		// Ű ���� ��ȯ
		K getKey() {
			return key;
		}
		
		// �����͸� ��ȯ 
		V getValue() {
			return data;
		}
		
		// Ű�� �ؽ� ���� ��ȯ
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	private int size; 				// �ؽ� ���̺��� ũ�� (table�� ��ڼ�)
	private Node<K, V>[] table;		// �ؽ� ���̺��� �����ϴ� �迭 

	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		}catch(OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	// �ؽ� ���� ���� 
	public int hashValue(Object key) {
		return key.hashCode()%size;
	}
	
	// Ű �� key�� ���� ����� �˻�(�����͸� ��ȯ)
	public V search(K key) {
		int hash = hashValue(key);		// �˻��� �������� �ؽ� ��
		Node<K, V> p = table[hash];		// ���� ��� 
		
		while(p != null) {
			if(p.getKey().equals(key))
				return p.getValue();	// �˻� ���� 
			p = p.next;					// ���� ��忡 �ָ�
		}
		return null;					// �˻� ����
	}
	
	// Ű �� key, ������ data�� ã�� ����� �߰� 
	public int add(K key, V data) {
		int hash = hashValue(key);		// �߰��� �������� �ؽ� �� 
		Node<K, V> p = table[hash];		// ���� ���
		
		while( p!= null) {
			if(p.getKey().equals(key))	// �� Ű ���� �̹� ��ϵ�
				return 1;
			p = p.next;					// ���� ��忡 �ָ�!
		}
		Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
		table[hash] = temp;				// ��带 ���� 
		return 0;
	}
	
	// Ű �� key�� ���� ����� ����
	public int remove(K key) {
		int hash = hashValue(key); 		// ������ �������� �ؽ� ��
		Node<K,V> p = table[hash];		// ���� ���
		Node<K,V> pp = null;			// �ٷ� ���� ���� ��� 
		
		while( p != null) {
			if(p.getKey().equals(key)) { 	// ã����
				if(pp == null)
					table[hash] = p.next;
				else
					pp.next = p.next;
				return 0;
			}
			pp = p;
			p = p.next; 				// ���� ��带 ����ŵ�ϴ�.
		}
		return 1;						// �� Ű ���� ����. 
	}
	
	// �ؽ� ���̺� ����
	public void dump() {
		for(int i=0; i<size; i++) {
			Node<K,V> p = table[i];
			System.out.printf("%20d ", i);
			while( p != null) {
				System.out.printf("-> %s (%s) ", p.getKey(), p.getValue() );
				p=p.next;
			}
			System.out.println();
		}
	}

}
