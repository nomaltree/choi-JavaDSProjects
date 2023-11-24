package lab9_1;

import java.util.Scanner;

public class hw9_1_BinarySearchTreeInsert {
	public static void main(String[] args) {
		System.out.println("hw9_1: 최성호");
		Scanner scanner = new Scanner(System.in);
		
		// 공백 이진탐색트리를 생성(tree)
		MySampleBinarySearchTree tree = new MySampleBinarySearchTree();

		int num = scanner.nextInt();	//입력받을 key, value값 개수를 입력받음
		
		for(int i = 0; i < num; i++) {	//key, value값 개수만큼 key값과 value값을 입력받음
			int key = scanner.nextInt();
			int value = scanner.nextInt();
			tree.insert(key, value);	//입력받은 값을 트리에 삽입
		}
		// 트리를 중순위 순회
		tree.inorder();
		scanner.close();
	}
}
class MySampleBinarySearchTree {
	// 트리 구현을 위한 변수와 클래스를 선언하고, inorder 메소드를 구현
	private Node root = null;			//트리의 루트노드를 지정할 필드
	
	//연결리스트로 트리를 구현하기 위한 노드 클래스
	private class Node {
		int key;			//노드의 key값 필드
		int value;			//노드의 value값 필드
		Node leftChild;		//노드의 왼쪽 링크 필드
		Node rightChild;	//노드의 오른쪽 필드
	}
	//중순위로 트리를 출력하기 main메소드에서 사용할 메소드
	public void inorder() {
		inorder(root);
	}
	//실제로 트리의 중순위 출력을 담당하는 메소드
	private void inorder(Node p) {
		if(p != null) {
			inorder(p.leftChild);					//트리의 왼쪽 루프부터 차례대로 출력
			System.out.print("(" + p.key + ", " + p.value + ") ");
			inorder(p.rightChild);					//왼쪽루프가 다끝나면 오른쪽 루프를 차례대로 출력
		}
	}
	//트리에 key를 삽입
	public void insert(int key, int value) {
		root = insertkey(root, key, value);
	}
	//p를 루트로 하는 트리에 key와 value를 삽입하고 삽입 후 루트 리턴(재귀 알고리즘)
	private Node insertkey(Node p, int key, int value) {
		if(p == null) {								//p가 null인 경우 새로운 노드를 삽입
			Node newNode = new Node();				//새 노드를 선언하고 전달받은 값들을 저장해주고 양쪽 링크필드는 null로 설정
			newNode.key = key;
			newNode.value = value;
			newNode.leftChild = null;
			newNode.rightChild = null;
			return newNode;							//해당 노드가 루트노드이므로 해당 노드를 리턴
		}
		else if(key < p.key) {						//전달받은 key값이 해당 노드의 key값보다 작을 경우
			p.leftChild = insertkey(p.leftChild, key, value);	//해당 노드의 왼쪽으로 이동 후 루트노드를 반환
			return p;											//루트노드는 바뀌지 않으므로 그대로 반환
		}
		else if(key > p.key) {						//전달받은 key값이 해당 노드의 key값보다 클 경우
			p.rightChild = insertkey(p.rightChild, key, value);	//해당 노드의 오른쪽으로 이동 후 루트노드를 반환
			return p;											//루트노드는 바뀌지 않으므로 그대로 반환				
		}
		else {										//전달받은 key값이 이미 존재할 경우
			p.value = value;						//전달받은 value값으로 해당 노드의 value값을 바꿔줌
			return p;								//루트노드는 바뀌지 않으므로 그대로 반환
		}
	}
}