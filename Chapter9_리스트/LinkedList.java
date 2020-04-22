package Chapter9_리스트;

import java.util.Comparator;
// 포인터로 연결 리스트 만들기 
// Comparable : 객체 간의 일반적인 정렬이 필요할 때, Comparable 인터페이스를 확장해서 정렬의 기준을 정의하는 comparteTo()메서드를 구현
// Comparator : 객체 간의 특정한 정렬이 필요할 때, Comparator 인터페이스를 확장해서 특정 기준을 정의하는 compare() 메서드를 구현
// 차이점 : compareTo(Object o)메서드를 구현하느냐 compare(Object o1, Object o2)메서드를 구현하느냐의 차이 


public class LinkedList<E> {
	// 노드
	class Node<E>{
		private E data;	// data는 데이터 그 자체가 아니라 데이터에 대한 참조!! 
		private Node<E> next; // 뒤쪽 포인터(다음 노드 참조)
	
	// 생성자
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head; // 머리 노드
	private Node<E> crnt; // 선택 노드 
	
	public LinkedList() {
		head = crnt = null;
	}
	// obj : 검색할 때 key가 되는 데이터를 넣어둔 object 
	// ptr.data : 첫 번째 매개변수와 연결 리스트의 개별 노드 안에 있는 데이터를 비교하기 위한 comparator. 
	public E search(E obj, Comparator<? super E>c) {
		Node<E> ptr = head;	 // 현재 스캔 중인 노드 
		
		while(ptr != null) {
			if(c.compare(obj, ptr.data) == 0) { // 검색 성공 
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next; // 다음 노드를 선택 
		}
		return null; //검색 실패 
	}
	// 머리 노드에 삽입 
	public void addFirst(E obj) {
		Node<E> ptr = head; //삽입 전의 머리 노드
		head = crnt = new Node<E>(obj, ptr); 
	}
	
	//꼬리에 노드 삽입
	public void addLast(E obj) {
		if(head == null) // 리스트가 비어 있으면 
			addFirst(obj); // 머리에 삽입! 
		else {
			Node<E> ptr = head;
			// while문 종료 시, ptr은 꼬리 노드를 가리킴! 
			while(ptr.next != null)
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}
	// 머리 노드를 삭제
	public void removeFirst() {
		if(head!=null)	//리스트가 비어 있지 않으면 
			head = crnt = head.next;
	}
	// 꼬리 노드를 삭제 
	public void removeLast() {
		if(head != null) {
			if(head.next==null)	//노드가 하나만 있으면
				removeFirst();	// 머리 노드를 삭제 
			else {
				Node<E> ptr = head;	// 스캔 중인 노드
				Node<E> pre = head; // 스캔 중인 노드의 앞쪽 노드
				
			while(ptr.next != null) {
				pre = ptr;
				ptr = ptr.next;
			}
			pre.next = null;	//pre는 삭제 후의 꼬리 노드 
			crnt = pre; 
			}
		}
	}
	// 노드 p를 삭제 
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
	// 선택 노드를 삭제 
	public void removeCurrentNode() {
		remove(crnt);
	}
	//모든 노드를 삭제 
	public void clear() {
		while(head != null) // 노드에 아무것도 없을 때까지 
			removeFirst();	//머리 노드를 삭제 
		crnt=null;
	}
	// 선택 노드를 하나 뒤쪽으로 이동 
	public boolean next() {
		if(crnt == null || crnt.next == null)
			return false;	//이동할 수 없음
		crnt = crnt.next;
		return true;
	}
	// 선택 노드를 출력
	public void printCurrentNode() {
		if(crnt==null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}
	// 모든 노드를 출력
	public void dump() {
		Node<E> ptr = head;
		
		while(ptr!=null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
}
