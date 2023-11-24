package lab10_1;

public class hw10_1_ListGraph {
	public static void main(String[] args) {
		System.out.println("hw10_2:최성호");

		// 정점은 6개이고 간선은 없는 방향 그래프 생성
		ListGraph graph = new ListGraph(6);  

		// 7개의 간선 삽입 후 인접행렬 출력
		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(0, 4);
		graph.insertEdge(0, 5);
		graph.insertEdge(3, 2);
		graph.insertEdge(5, 0);
		graph.insertEdge(5, 1);
		
		graph.printAdjMatrix();
		
		//그래프의 모든 정점에 대해 각 정점의 진출차수를 출력
		for(int i = 0; i < 6; i++)
				System.out.print(graph.outDegree(i) + " ");
				
		System.out.println();
		//다음 7개의 간선에 대해 간선의 존재 여부를 출력
		System.out.print(graph.hasEdge(5, 1) + " ");
		System.out.print(graph.hasEdge(1, 2) + " ");
		System.out.print(graph.hasEdge(0, 3) + " ");
		System.out.print(graph.hasEdge(0, 2) + " ");
		System.out.print(graph.hasEdge(0, 1) + " ");
		System.out.print(graph.hasEdge(0, 5) + " ");
		System.out.print(graph.hasEdge(3, 2) + " ");
		System.out.println();
		
		//다음 4개의 간선을 삭제
		graph.deleteEdge(0, 3);
		graph.deleteEdge(1, 2);
		graph.deleteEdge(0, 2);
		graph.deleteEdge(0, 1);
		graph.deleteEdge(0, 5);
		graph.deleteEdge(3, 2);
		
		//인접리스트 출력
		graph.printAdjMatrix();
	}
}
// 인접행렬로 그래프를 구현하는 클래스 
class ListGraph { 
	//단순 연결리스트 노드 구조
	private class Node {
		int vertex;
		Node link;
	}
	// 인스턴스 변수
	private Node[] list;
	private int n;

	// 생성자 - 정점이 n개이고, 간선이 없는 그래프 생성
	public ListGraph(int n) {
		this.n = n;
		list = new Node[n];
	}
	// 그래프에 간선 <v1, v2> 삽입
	public void insertEdge(int v1, int v2) {   
		if(v1<0 || v1>=n || v2<0 || v2>=n)  
			System.out.println("그래프에 없는 정점입니다!");
		else {
			Node newNode = new Node();
			newNode.vertex = v2;
			newNode.link = list[v1];
			list[v1] = newNode;
		}
	}
	// 구현을 확인하기 위해 인접행렬 출력
	public void printAdjMatrix() {  
		for(int i=0; i<n; i++) {
			System.out.print("정점 " + i + "의 인접리스트");
			for(Node temp = list[i]; temp != null; temp = temp.link) {
				System.out.print("-> " + temp.vertex);
			}
			System.out.println();
		}
	}
	//정점을 매개변수로 받아 진출차수를 리턴
	public int outDegree(int v1) {
		int num = 0;				//진출차수를 셀 num변수 선언
		Node temp = list[v1];		//전달받은 간선의 인접 리스트를 돌 노드형 변수 선언
		while(temp != null) {
			num += 1;				//리스트를 하나 돌때마다 1증가
			temp = temp.link;
		}	
		return num;					//해당 진출차수 개수를 리턴
	}
	//간선을 매개변수로 받아 존재 여부를 리턴
	public boolean hasEdge(int v1, int v2) {
		Node temp = list[v1];				//전달받은 간선의 인접 리스트를 돌 노드형 변수 선언
		while(temp != null) {
			if(temp.vertex == v2)			//리스트를 돌며 간선이 있으면 true리턴
				return true;
			temp = temp.link;
		}
		return false;						//반복문을 다돌았음에도 간선이 없으면 false리턴
	}
	//간선을 매개변수로 받아 삭제	
	public void deleteEdge(int v1, int v2) {
		Node temp = list[v1];				//전달받은 간선의 인접리스트를 돌 노드형 변수 선언
		Node pasttemp = list[v1];			//temp의 이전 노드를 가리킬 노드형 변수를 하나 더 선언
		if(temp == null)					//전달받은 간선의 진출차수가 없는 경우 리턴
			return;
		if(temp.vertex == v2) {				//전달받은 간선의 첫번째 노드가 v2인 경우 
			list[v1] = list[v1].link;		//해당 노드의 링크를 바꿔주고 리턴
			return;
		}
		while(true) {				//전달받은 간선이 비어있지도 않고 첫번째 노드가 v2도 아닌경우
			pasttemp = temp;				//pasttemp는 temp의 이전 노드를 가리키게 함
			temp = temp.link;				//첫번째 노드가 v2가 아니니 검사할 필요없이 두번쨰 노드부터 검사
			if(temp == null)				//간선 v2가 없어서 끝까지 갔다면 리턴
				return;
			if(temp.vertex == v2) {			//간선 v2가 존재할 경우
				pasttemp.link = temp.link;	//이전 노드의 링크에 현재 노드의 링크를 연결해줌
				return;						//계속 돌면 널포인터 에러가 나므로 리턴
			}
		}
	}
}