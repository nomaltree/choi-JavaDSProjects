package lab6_1;

import java.util.Scanner;

public class hw6_1_MyLinkedList {
	public static void main(String[] args) {
		System.out.println("hw6_1:최성호");
		Scanner input = new Scanner(System.in);

		// (1) 단어를 저장할 MyLinkedList 객체 list를 생성
		MyLinkedList list = new MyLinkedList();

		// (2) 단어 수(n)와 n개의 단어를 입력받아 list의 맨 뒤에 차례대로 삽입 후, list 출력
		int n = input.nextInt();

		for (int i = 0; i < n; i++) {
			String word = input.next();
			list.add(word);
		}
		System.out.println(list);
		
		// (3) 단어 w, x, y, z를 입력받음
		String w =input.next();
		String x =input.next();
		String y =input.next();
		String z =input.next();
		
		// (4) w, x, y, z가 각각 list에 몇번 째 원소인지 인덱스(0, 1, 2, ...)를 알아내어 출력
		System.out.print(list.indexOf(w) + " ");
		System.out.print(list.indexOf(x) + " ");
		System.out.print(list.indexOf(y) + " ");
		System.out.println(list.indexOf(z));				

		// (5) w, x, y, z를 list에서 지우고 출력함 만약 list에 없는 단어라면 아무일도 안일어남
		list.remove(list, w);
		list.remove(list, x);
		list.remove(list, y);
		list.remove(list, z);
		input.close();
	}
}
// 문자열 리스트를 단순 연결리스트로 구현하는 클래스
class MyLinkedList {
	// private 인스턴스 변수 선언(head, size)
	private Node head;				//리스트의 첫번째 노드를 가리키는 변수
	private int size;				//리스트 길이(원소 갯수)

	// 리스트의 노드 구조를 나타내는 클래스
	private class Node { 
		String data;
		Node llink;			//왼쪽 노드와 연결되는 링크필드
		Node rlink;			//오른쪽 노드와 연결되는 링크필드
	}
	// 공백 리스트를 생성하는 생성자
	public MyLinkedList() {
		head = null;		//리스트의 시작을 나타내는 변수 초기값은 공백이므로 null로지정
		size = 0;			//리스트의 길이를 나타내는 변수
	}
	// 리스트의 맨 뒤에 data를 삽입하는 메소드
	public void add(String data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(head == null) 				// 공백리스트일 경우 head가 newNode를 가리키게 함	
			head = newNode;
		else {
			Node temp = head;			// 변수 temp를 선언해 리스트의 노드들을 처음부터 끝까지 하나씩 가리키게 함
			while(temp.rlink != null) 	// temp가 마지막 노드를 가리킬 때까지
				temp = temp.rlink;	
			temp.rlink = newNode;		//마지막 Node를 가리킬 경우 오른쪽 필드에 newNode를 가리키게 함
			newNode.llink = temp;		//추가된 newNode의 왼쪽 링크필드가 temp를 가리키게하여 이중연결리스트로 만듬
		}
		size++;							//단어가 하나 추가 될때마다 리스트의 길이도 1추가
	}
	// 리스트안에 있는 원소의 인덱스 번호를 반환하는 메소드 없으면 -1을 반환
	public int indexOf(String word) {
		Node temp = head;				//노드를 처음부터 하나씩 가리킬 변수 temp를 선언
		int indexnum = 0;				//인덱스의 번호
		while(temp != null) {			//리스트의 끝까지 돌며 단어를 찾음
			if(temp.data.equals(word)) {	
				break;					//일치하는 단어를 찾았을 경우 반복문 탈출
			}
			temp = temp.rlink;			//못찾을 경우 계속 리스트를 돌며 인덱스번호를 1증가시킴;
			indexnum++;
		}
		if(indexnum == size)			//만일 리스트를 끝까지 다돌았음에도 찾지 못했으면 -1을 반환하게 
			indexnum = -1;
		return indexnum;				//인덱스 번호 혹은 -1을 반환
	}
	// 리스트 안에 있는 원소를 삭제하는 메소드
	public void remove(MyLinkedList list, String word) {
		Node old = head;					//삭제할 노드를 지정할 변수 old를 선언
		while (old != null) {				//리스트의 끝까지 돌며 원소들을 비교
			if(word.equals(old.data)) {		//삭제할 단어가 나오면 해당 노드를 삭제
				if(old.llink == null) {		//삭제할 노드가 첫번째 노드인 경우	
					head = old.rlink;		//head가 삭제할 노드의 다음 노드를 가리키게 함
					old.rlink.llink = null;	//첫번째 노드가 삭제되어 첫번째가 된 두번째 노드의 왼쪽 필드를 null로 만듬
				}
				else if(old.rlink == null)			//삭제할 노드가 마지막 노드인 경우
					old.llink.rlink = null;			//삭제할 노드의 전 노드의 오른쪽 링크에 null값을 저장
				else {								//삭제할 노드가 마지막도 첫번째도 아닌 경우
					old.llink.rlink = old.rlink;	//삭제할 노드의 전 노드의 오른쪽 링크를 삭제할 노드의 다음 링크로 연결	
					old.rlink.llink = old.llink;	//삭제할 노드의 다음 노드의 왼쪽 링크를 삭제할 노드의 전 링크로 연결
				}
				size--;							//리스트의 크기가 1 감소
				break;							//중복 문자가 2개 이상일수 있으므로 바로 반복문을 탈출함
			}
			old = old.rlink;					//old가 리스트의 다음 노드로 이동
		}
		System.out.println(list);		//원소를 삭제한 후 리스트를 출력
	}
	@Override
	public String toString() {  // LinkedList와 구분하기 위해 [] 대신에 ()를 사용할 것
		StringBuffer result = new StringBuffer("(");
		Node temp = head;
		if(size > 0) {
			for(int i = 0; i < size - 1; i++) {
				result.append(temp.data + ", ");
				temp = temp.rlink;
			}
			result.append(temp.data);
		}
		result.append(")");
		return result.toString();
	}
}