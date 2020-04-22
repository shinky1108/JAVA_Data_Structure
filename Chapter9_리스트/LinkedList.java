package Chapter9_����Ʈ;

import java.util.Comparator;
// �����ͷ� ���� ����Ʈ ����� 
// Comparable : ��ü ���� �Ϲ����� ������ �ʿ��� ��, Comparable �������̽��� Ȯ���ؼ� ������ ������ �����ϴ� comparteTo()�޼��带 ����
// Comparator : ��ü ���� Ư���� ������ �ʿ��� ��, Comparator �������̽��� Ȯ���ؼ� Ư�� ������ �����ϴ� compare() �޼��带 ����
// ������ : compareTo(Object o)�޼��带 �����ϴ��� compare(Object o1, Object o2)�޼��带 �����ϴ����� ���� 


public class LinkedList<E> {
	// ���
	class Node<E>{
		private E data;	// data�� ������ �� ��ü�� �ƴ϶� �����Ϳ� ���� ����!! 
		private Node<E> next; // ���� ������(���� ��� ����)
	
	// ������
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head; // �Ӹ� ���
	private Node<E> crnt; // ���� ��� 
	
	public LinkedList() {
		head = crnt = null;
	}
	// obj : �˻��� �� key�� �Ǵ� �����͸� �־�� object 
	// ptr.data : ù ��° �Ű������� ���� ����Ʈ�� ���� ��� �ȿ� �ִ� �����͸� ���ϱ� ���� comparator. 
	public E search(E obj, Comparator<? super E>c) {
		Node<E> ptr = head;	 // ���� ��ĵ ���� ��� 
		
		while(ptr != null) {
			if(c.compare(obj, ptr.data) == 0) { // �˻� ���� 
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next; // ���� ��带 ���� 
		}
		return null; //�˻� ���� 
	}
	// �Ӹ� ��忡 ���� 
	public void addFirst(E obj) {
		Node<E> ptr = head; //���� ���� �Ӹ� ���
		head = crnt = new Node<E>(obj, ptr); 
	}
	
	//������ ��� ����
	public void addLast(E obj) {
		if(head == null) // ����Ʈ�� ��� ������ 
			addFirst(obj); // �Ӹ��� ����! 
		else {
			Node<E> ptr = head;
			// while�� ���� ��, ptr�� ���� ��带 ����Ŵ! 
			while(ptr.next != null)
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	// �Ӹ� ��带 ����
	public void removeFirst() {
		if(head!=null)	//����Ʈ�� ��� ���� ������ 
			head = crnt = head.next;
	}
	// ���� ��带 ���� 
	public void removeLast() {
		if(head != null) {
			if(head.next==null)	//��尡 �ϳ��� ������
				removeFirst();	// �Ӹ� ��带 ���� 
			else {
				Node<E> ptr = head;	// ��ĵ ���� ���
				Node<E> pre = head; // ��ĵ ���� ����� ���� ���
				
			while(ptr.next != null) {
				pre = ptr;
				ptr = ptr.next;
			}
			pre.next = null;	//pre�� ���� ���� ���� ��� 
			crnt = pre; 
			}
		}
	}
	// ��� p�� ���� 
	public void remove(Node p) {
		if(head != null) {
			if(p==head)
				removeFirst();
			else {
				Node<E> ptr = head;
				
				while(ptr.next != p) {
					ptr = ptr.next;
					if(ptr == null) return;
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}
	// ���� ��带 ���� 
	public void removeCurrentNode() {
		remove(crnt);
	}
	//��� ��带 ���� 
	public void clear() {
		while(head != null) // ��忡 �ƹ��͵� ���� ������ 
			removeFirst();	//�Ӹ� ��带 ���� 
		crnt=null;
	}
	// ���� ��带 �ϳ� �������� �̵� 
	public boolean next() {
		if(crnt == null || crnt.next == null)
			return false;	//�̵��� �� ����
		crnt = crnt.next;
		return true;
	}
	// ���� ��带 ���
	public void printCurrentNode() {
		if(crnt==null)
			System.out.println("������ ��尡 �����ϴ�.");
		else
			System.out.println(crnt.data);
	}
	// ��� ��带 ���
	public void dump() {
		Node<E> ptr = head;
		
		while(ptr!=null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
}
