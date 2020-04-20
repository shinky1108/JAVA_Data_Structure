package Chapter7_����;

public class IntSet {
	private int max; // ������ �ִ� ����
	private int num; // ������ ��� ����
	private int[] set; // ���� ��ü
	
	public IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max]; // ���� �迭 ����
		}
		catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	// ������ �ִ� ������ ��ȯ�ϴ� capacity �޼���
	public int capacity() {
		return max;
	}
	// ������ ���� ��� ������ ��ȯ�ϴ� size �޼��� 
	public int size() {
		return num;
	}
	// ���տ��� n�� �˻�
	public int indexOf(int n) {
		for(int i=0; i<num; i++)
			if(set[i] == n)
				return i;	// �˻� ����
		return -1; 			// �˻� ���� 
	}
	// ���տ� n�� �ִ��� ������ Ȯ�� 
	public boolean contains(int n) {
		return (indexOf(n) != -1) ? true : false;
	}
	
	//���տ� n�� �߰�
	public boolean add(int n) {
		if(num >=max || contains(n)==true) // ����á�ų� �̹� n�� ����
			return false;
		else {
			set[num++] = n; // ���� ������ �ڸ��� �߰�
			return true;
		}
	}
	//���տ��� n�� ���� 
	public boolean remove(int n) {
		int idx;
		
		if(num <=0 || (idx = indexOf(n)) == -1) // ��� �ְų� �̹� n�� ����
			return false;
		else {
			set[idx] = set[--num]; // ������ ��Ҹ� ������ ������ �ű� 
			return true;
		}
	}
	// ���� s�� ����
	public void copyTo(IntSet s) {
		int n = (s.max < num) ? s.max : num; // ������ ����� ���� 
		for(int i=0; i<n; i++)
			s.set[i] = set[i];
		s.num = n;
	}
	// ���� s�� ����
	public void copyFrom(IntSet s) {
		int n = (max < s.num) ? max : s.num;
		for(int i=0; i<n; i++)
			set[i] = s.set[i];
		num = n;
	}
	// ���� s�� ������ Ȯ�� 
	public boolean equalTo(IntSet s) {
		if(num != s.num) // ��� ������ ���� ������
			return false;
		
		for(int i=0; i<num; i++) {
			int j=0;
			for(;j<s.num; j++)
				if(set[i] == s.set[j])
					break;
			if(j == s.num)
				return false;
		}
		return true;
	}
	// ���� s1�� s2�� �������� ���� 
	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1);		//���� s1�� ����
		for(int i=0; i<s2.num; i++)	//���� s2�� ��Ҹ� �߰� 
			add(s2.set[i]);
	}
	//"{a b c}" ������ ���ڿ��� ǥ���� �ٲ�
	public String toString() {
		StringBuffer temp = new StringBuffer("{ ");
		for(int i=0; i<num; i++)
			temp.append(set[i]+" ");
		temp.append("}");
		return temp.toString();
	}
}
