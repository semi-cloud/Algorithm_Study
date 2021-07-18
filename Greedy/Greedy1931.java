import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Session implements Comparable<Session>{  //회의 클래스
	
	private int start;
	private int end;
	
	public Session(int s, int e) {
		this.start = s;
		this.end = e;
	}

	@Override
	public int compareTo(Session o) {   //비교해서 정렬, 정렬 기준 설정, 오름차순
		
		if(this.end == o.end) {        //종료 시간이 같을 경우 시작 지점 기준으로 test
			return this.start - o.start; 			
		}
        return this.end - o.end;  //양수이면 자리바꿈 진행, 음수나 0이면 그냥 놔두기        
	}
}

public class Greedy_1931 {
	public static void main(String[] args) {		

		int count = 1;
		ArrayList<Session> arr = new ArrayList<Session>();   //정렬 활동(시간까지)

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();                             //회의의 수
		
		for(int i = 0; i < num ; i++) {
			arr.add(new Session(sc.nextInt(), sc.nextInt()));
		}				
		
		//제일 큰거끼리 비교해서 가장 빨리 끝나는 순으로 정렬
		Collections.sort(arr);		

		//그리디 알고리즘 사용=>제일 최적의 선택인 가장 회의 시간이 짧은거 먼저 택
    //새로운 부분집합의 탄생과 최적화
		int j = 0;
		for(int i = 1 ; i < num ; i++) {  
			if(arr.get(i).start >= arr.get(j).end) {
				count++;
				j = i;
			}
		}
		
    System.out.println(count);
		sc.close();
	}

}
