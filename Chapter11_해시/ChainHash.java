package Chapter11_해시;

// 배열의 키 값을 배열의 요솟수로 나눈 나머지를 값들을 => 해시 값!
// 해시 값이 인덱스가 되도록 원래의 키 값을 저장한 배열이 => 해시 테이블!
// 해시 테이블의 각 요소를 => 버킷 
// 예를 들어 
// 5 6 14 20 29 34 37 51 69 75 - - - => 배열의 요솟수 : 13 
// 5 6 1  7  3  8  11 12 4  10 - - - => 해시 값 
// - 14 - 29 69 5 6 20 34 - 75 37 51 => 해시 테이블 
// 만약에 35라는 숫자를 추가하고 싶으면 35 % 13 => 나머지 9 => 해시 테이블[9]번째에 삽입! 
// 충돌 : 해시값을 구해 넣으려고 하는데 그 자리에 숫자가 들어 있는 것! 
// 충동현상에 대한 대처
// (1) 체인법 : 같은 해시 값을 갖는 요소를 연결 리스트로 관리함 (=오픈 해시법)
// - 체인법은 인덱스 요소에 바로 넣는 것이 아니라 연결 리스트로 서로 참조하게 만듬! 몇개든 상관없음. 빈 인덱스는 null을 가리킴
// (2) 오픈 주소법 : 빈 버킷을 찾을 때까지 해시를 반복함 

public class ChainHash<K, V>{
	// 해시를 구성하는 노드
	class Node<K,V>{
		private K key;				// 키 값
		private V data;			// 데이터 
		private Node<K,V> next;		// 체인의 다음 노드에 대한 참조
		
		// 생성자
		Node(K key, V data, Node<K,V> next){
			this.key = key;
			this.data = data;
			this.next = next;
		}
		
		// 키 값을 반환
		K getKey() {
			return key;
		}
		
		// 데이터를 반환 
		V getValue() {
			return data;
		}
		
		// 키의 해시 값을 반환
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	private int size; 				// 해시 테이블의 크기 (table의 요솟수)
	private Node<K, V>[] table;		// 해시 테이블을 저장하는 배열 

	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
		}catch(OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	// 해시 값을 구함 
	public int hashValue(Object key) {
		return key.hashCode()%size;
	}
	
	// 키 값 key를 갖는 요소의 검색(데이터를 반환)
	public V search(K key) {
		int hash = hashValue(key);		// 검색할 데이터의 해시 값
		Node<K, V> p = table[hash];		// 선택 노드 
		
		while(p != null) {
			if(p.getKey().equals(key))
				return p.getValue();	// 검색 성공 
			p = p.next;					// 다음 노드에 주목
		}
		return null;					// 검색 실패
	}
	
	// 키 값 key, 데이터 data를 찾는 요소의 추가 
	public int add(K key, V data) {
		int hash = hashValue(key);		// 추가할 데이터의 해시 값 
		Node<K, V> p = table[hash];		// 선택 노드
		
		while( p!= null) {
			if(p.getKey().equals(key))	// 이 키 값은 이미 등록됨
				return 1;
			p = p.next;					// 다음 노드에 주목!
		}
		Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
		table[hash] = temp;				// 노드를 삽입 
		return 0;
	}
	
	// 키 값 key를 갖는 요소의 삭제
	public int remove(K key) {
		int hash = hashValue(key); 		// 삭제할 데이터의 해시 값
		Node<K,V> p = table[hash];		// 선택 노드
		Node<K,V> pp = null;			// 바로 앞의 선택 노드 
		
		while( p != null) {
			if(p.getKey().equals(key)) { 	// 찾으면
				if(pp == null)
					table[hash] = p.next;
				else
					pp.next = p.next;
				return 0;
			}
			pp = p;
			p = p.next; 				// 다음 노드를 가리킵니다.
		}
		return 1;						// 그 키 값은 없다. 
	}
	
	// 해시 테이블 덤프
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
