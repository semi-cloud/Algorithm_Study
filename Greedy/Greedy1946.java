public class Greedy1946 {
	public static void main(String[] args) {
		//한명씩 모든 사람과 비교해보는것은 o(n ^2)만큼의 시간이 걸려=> 그리디 알고리즘!!
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();  //총 테스트 케이스 개수
		int num = 0, max = 0;    
		Integer[] rank;
		
		for(int i = 0; i < test ; i++) {
			max = 1;                       //서류의 맨 앞사람은 무조건 합격=>1명부터 시작
			num = sc.nextInt();
			rank = new Integer[num + 1];    //순위 배열 생성
			
			for(int j = 1; j <= num ; j++) {
				int s = sc.nextInt(),  m = sc.nextInt();	
				rank[s]= m;     //인덱스가 성적 순위, 데이터가 면접 순위
				                //성적 순 대로  배열=> 앞사람과의 면접 순위만 고려!
			}
			
			int a = 1;
			for(int j = 1; j < num ; j++) {   //합격하기위해서는
				if(rank[j + 1] < rank[a]) {     //합격한 자의 면접 기준순위보다 높으면(성적에서는 이미 낮아므로)
					max++;
					a = j + 1;
				}
			}
			System.out.println(max);  
    }
		sc.close();	
	}
}
