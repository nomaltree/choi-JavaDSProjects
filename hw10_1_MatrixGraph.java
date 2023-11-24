package lab10_1;

public class hw10_1_MatrixGraph {
	public static void main(String[] args) {
		System.out.println("hw10_1:최성호");
		
		// 정점은 6개이고 간선은 없는 방향 그래프 생성
		MatrixGraph graph = new MatrixGraph(6);  

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
		
		//다음 4개 간선을 삭제
		graph.deleteEdge(0, 2);
		graph.deleteEdge(0, 1);
		graph.deleteEdge(0, 5);
		graph.deleteEdge(3, 2);
		
		//인접행렬 출력
		graph.printAdjMatrix();
	}
}
//인접행렬로 그래프를 구현하는 클래스 
class MatrixGraph {  
	// 인스턴스 변수
	private int[][] matrix;		//방향그래프를 구현할 2차원 인접행렬필드	
	private int n;				//인접행렬의 크기필드

	// 생성자 - 정점이 n개이고, 간선이 없는 그래프 생성
	public MatrixGraph(int n) {
		this.n = n;						//정점을 n개로 지정
		matrix = new int[n][n];			//크기가 n인 2차원 배열 설정;
	}
	// 그래프에 간선 <v1, v2> 삽입
	public void insertEdge(int v1, int v2) {   
		if(v1<0 || v1>=n || v2<0 || v2>=n)  		//그래프의 존재하지 않는 간선인 경우
			System.out.println("그래프에 없는 정점입니다!");
		else {										//해당 간선의 값을 1로 지정
			matrix[v1][v2] = 1;
		}
	}
	// 구현을 확인하기 위해 인접행렬 출력
	public void printAdjMatrix() {  
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {  
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	//정점을 매개변수로 받아 진출차수를 리턴하는 메소드
	public int outDegree(int v1) {
		int num = 0;						//진출차수를 나타내는 필드
		for(int i = 0; i < matrix[v1].length; i++) {
			if(matrix[v1][i] == 1)			//간선이 존재하는 경우 num의 값 1증가
				num += 1;
		}
		return num;							//전달받은 간선의 진출차수를 리턴
	}
	//간선을 매개변수로 받아 존재 여부를 리턴하는 메소드
	public boolean hasEdge(int v1, int v2) {
		return matrix[v1][v2] == 1;			//간선의 존재 유무를 리턴
	}
	//간선을 매개변수로 받아 삭제하는 메소드
	public void deleteEdge(int v1, int v2) {
		matrix[v1][v2] = 0;					//전달받은 간선 삭제
	}
}