package lab11_1;
import java.util.Scanner;

public class hw11_1_MeetingSort {
	public static void main(String[] args) {
		System.out.println("hw11_1: 최성호");
		System.out.println("정렬 알고리즘 bubble sort");

		// (1) 사용자가 원하는 갯수의 양의 정수를 입력받음
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();					//회의 정보 갯수를 입력받음
		Meeting[] array = new Meeting[n];			//회의 정보 갯수만큼의 크기의 Meeting형 배열을 선언
		
		//회의 정보 갯수만큼 회의 정보를 입력
		for (int i = 0; i < array.length; i++) {
			String Meeting = scanner.next();	//회의명을 입력받음
			int start = scanner.nextInt();		//시작시간을 입력받음
			int finish = scanner.nextInt();		//종료시간을 입력받음
			array[i] = new Meeting(Meeting, start, finish);	//Meeting형 배열에 입력받은 정보들을 전달해 초기화
		}

		// (2) 배열 원소들을 정렬
		bubbleSort(array);

		// (3) 정렬 결과 출력
		System.out.println("종료시간 기준 정렬 결과");
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i].getMeeting() + " " + array[i].getstart() + " " + array[i].getfinish());
		}
		scanner.close();
	}

	// 배열 원소들을 오름차순 버블 정렬
	public static void bubbleSort(Meeting[] array) {
		for (int last = array.length - 1; last >= 1; last--) {	//인접 원소 크기비교로 맨 앞부터  제일 큰값으로 채워나감
			for (int i = 0; i < last ; i++) {					//여기서는 종료시간을 기준으로 버블정렬을 시행
				if (array[i].getfinish() > array[i+1].getfinish()) {	//앞의 원소가 뒤에 원소보다 크면 위치를 바꿔줌
					swap(array, i, i+1);
				}
			}
		}
	}
	// 원소들의 자리를 바꿔주는 메소드
	public static void swap(Meeting[] array, int i, int j) {
		Meeting temp = array[i];		//Meeting형 변수를 저장해 array[i]의 값을 저장
			
		array[i] = array[j];			//배열의 바로 앞 원소와 뒷 원소를 교환

		array[j] = temp;

	}
}
//회의명, 시작시간, 종료시간을 반환해주는 메소드
class Meeting{
	private String Meeting;		//회의명을 나타내는 필드
	private int start;			//시작시간을 나타내는 필드
	private int finish;			//종료시간을 나타내는 필드
	
	//전달받은 값들로 각 정보들을 초기화
	public Meeting(String Meeting, int start, int finish) {
		this.Meeting = Meeting;		//회의명 초기화
		this.start = start;			//시작시간 초기화
		this.finish = finish;		//종료시간 초기화
	}
	//회의명을 리턴하는 메소드
	public String getMeeting() {
		return this.Meeting;
	}
	//시작시간을 리턴하는 메소드
	public int getstart() {
		return this.start;
	}
	//종료시간을 리턴하는 메소드
	public int getfinish() {
		return this.finish;
	}
}