package lab5_1;

import java.util.Scanner;

public class hw5_1_ArrayList {
	public static void main(String[] args) {
		System.out.println("hw5_1:최성호");

		Scanner input = new Scanner(System.in); 
		
		// 단어 갯수를 입력받음
		int n = input.nextInt();

		// 단어를 저장할 MyArrayList형 리스트 객체 list를 생성하되, 초기 용량을 n*2로 함
		MyArrayList list = new MyArrayList(n*2);
		
		//아무것도 없는 배열 출력
		System.out.println(list); 
		
		// list에 n개 만큼의 문자를 입력받음
		for(int i = 0; i < n; i++) { 
			list.add(input.next());
		}
		// list 내용을 출력
		System.out.println(list);
	
		// 단어 x를 입력받고 list에 같은 단어가 있으면 삭제하고 없으면 추가
		String x = input.next();
		if(list.contains(x) == true) { 		//단어 x와 list에 중복문자가 있는지 확인하는 contains메소드 호출
			list.remove(x);				//만약 중복 단어가 있다면 제거하는 remove메소드 호출
		}
		else {
			list.add(x);					//만약 중복 단어가 없다면 추가하는 add메소드 호출
		
		}
		System.out.println(list); 						//list출력
		
		// 단어 y를 입력받고 list에 같은 단어가 있으면 삭제하고 없으면 추가
		String y = input.next();
		if(list.contains(y) == true) {		//단어 y와 list에 중복문자가 있는지 확인하는 contains메소드 호출
			list.remove(y);				//만약 중복 단어가 있다면 제거하는 remove메소드 호출
		}
		else {
			list.add(y);					//만약 중복 단어가 없다면 추가하는 add메소드 호출
		}
		
		// 최종 list를 출력
		System.out.println(list);

		input.close();
	}
}	
//배열을 이용하여 단어 리스트를 구현하는 클래스
class MyArrayList {
	private String[] array;							//단어를 저장할 배열
	private int size;								//배열의 입력받은 단어의 수 즉 배열안에 null값이 아닌 마지막 인덱스의 번호
	public MyArrayList(int n) {						//배열 용량을 매개변수로 받음
		array = new String[n];						//입력받은 크기만큼의 배열을 생성
		size = 0;									//배열에서 처음으로 빈자리의 인덱스 번호
		
	}
	public boolean contains(String word) {		//중복단어가 있는지 검사해주는 함수
		boolean sameword = false;				//참 거짓 여부를 저장할 부울변수 sameword를 생성 초기값은 중복단어가 없을 경우 이므로 false로 저장
		for(int i = 0; i < size; i++) {			//배열의 단어와 같은 원소가 있는지 확인
			if(array[i].equals(word)) {			//있다면 sameword에 true값을 저장하고 그 값을 반환
				sameword = true;
				return sameword;
			}			
		}
	return sameword;							//중복단어가 없다면 초기값인 false를 반환
	}
	public void remove(String word) {					//중복단어를 삭제해주는 함수
		int length = array.length;						//증감연산을 위해 array의 길이를 나타내는 변수를 하나 선언
		 for(int i = 0; i < size; i++) {				//현재 배열안의 단어 수 만큼 반복문 시행
			  if(array[i].equals(word))	{				//만약 배열을 돌며 입력받은 단어와 같은단어가 있는지 확인
				for(int f = i+1; f < length; f++)		//있으면 그 앞의 단어들을 저장하는 방식으로 해당 인덱스내용을 삭제함
			  		array[f-1] = array[f];
			  		length--;
			  size--;									//그 후 size의 크기를 1감소시켜서 빈자리의 인덱스번호를 지정	
			  return;									//중복단어가 2개 이상일수 있으므로 한 번 시행후 바로 리턴
			  }
		}
		 return;
	}	 
	public void add(String word) {			//배열의 빈자리에 단어를 추가
		array[size++] = word;				//추가한뒤 size를 ++해주어 추가할 배열의 번호를 한칸 올려줌
	}
	
	@Override
	public String toString() {
		if(size == 0) return "[]";
	
		StringBuffer result = new StringBuffer("[");
		for(int i = 0; i < size - 1; i++) {
			result.append(array[i]+ ",");
			}
		result.append(array[size - 1]+"]");
		return result.toString();
	}
}