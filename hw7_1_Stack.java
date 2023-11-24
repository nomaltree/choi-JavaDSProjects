package lab7_1;

import java.util.Scanner;

public class hw7_1_Stack {

	public static void main(String[] args) {
		System.out.println("hw7_1: 최성호");
		
		Scanner input = new Scanner(System.in);
		
		MyLinkedStack stack = new MyLinkedStack();		//정수형 공백 스택을 생성
		
		stack.push(30);				//스택에 30을 넣음
		stack.push(40);				//스택에 40을 넣음
				
		int x = stack.pop();		//스택에 가장 나중에 넣은 40을 제거하고 리턴한 값을 지정
		int y = stack.pop();		//스택에 가장 나중에 넣은 30을 제거하고 리턴한 값을 지정
		
		System.out.println(x - y);	//두 변수의 차를 출력
		
		String line = input.nextLine();		//한 줄의 후위수식을 입력받음
		
		String[] array = line.split(" ");	//문자열로 입력된 후위 수식을 공백을 기준으로 나눠 문자열 배열을 생성
		int opr1, opr2;						//연산에 사용될 연산자 변수 2개를 선언
	
		for(int i = 0; i < array.length; i++) {	//배열을 돌며 숫자문자열은 정수형으로 바꾸어 스택에 저장
			char onechar = array[i].charAt(0);	//각 원소의 첫번째 문자가 숫자인지 확인
			switch(onechar) {			
			case '0':							//숫자일 경우 정수형으로 바꾼뒤 그 값을 스택에 저장
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				int num = Integer.parseInt(array[i]);	//정수형 변수에 숫자 문자열을 정수형으로 바꾸어 저장
				stack.push(num);						
				break;
			case '+':									//연산 기호일 경우 연산자 변수를 이용해 각 기호에 맞게 연산 한 뒤 그 값을 스택에 저장
				opr1 = stack.pop();
				opr2 = stack.pop();
				stack.push(opr2 + opr1);
				break;
			case '-':
				opr1 = stack.pop();
				opr2 = stack.pop();
				stack.push(opr2 - opr1);
				break;
			case '*':
				opr1 = stack.pop();
				opr2 = stack.pop();
				stack.push(opr2 * opr1);
				break;
			case '/':
				opr1 = stack.pop();
				opr2 = stack.pop();
				stack.push(opr2 / opr1);
				break;
			}
		}
		System.out.println(stack.pop());			//후위 수식의 결과 값을 출력
		input.close();
	}
}
//연결 자료구조로 구현한 정수 스택
class MyLinkedStack {
	private Node top = null;		//꼭대기 노드를 가리키는 Node형 top변수를 선언
	
	private class Node {			//스택의 노드구조를 나타내는 클래스
		int data;					
		Node link;
	}
	public void push(int x) {		//스택에 새로운 값을 받아서 추가하는 클래스
		Node newnode = new Node();
		newnode.data = x;			//새로운 노드의 전달받은 데이터 x를 저장
		newnode.link = top;			//새로운 노드의 링크값에 top값을 저장
		top = newnode;				//top가 새로운 노드를 가리키게 함 
	}
	public int pop() {				//스택에 원소를 제거하는 클래스
		int temp = top.data;		//반환할 값을 저장할 변수temp를 선언 하고 반환할 값을 저장
		top = top.link;				//top가 꼭대기 다음 노드를 가리키게 함
		return temp;				//temp를 반환
	}
	
	public boolean isEmpty() {		//스택의 공백 여부를 확인하는 클래스
		return(top == null);		//꼭대기노드를 가리키는 변수 top가 null이면 true를 아니면 false를 반환
	}
}