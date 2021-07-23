public class Dq1920 {

	static int n;   
	static int m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		///N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st;
                
				n = Integer.parseInt(br.readLine());
				Integer[] arr = new Integer[n]; 
				
				st =  new StringTokenizer(br.readLine());
				for(int i = 0; i < n; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				
				Arrays.sort(arr);                 //오름차순으로 정렬
				
				m = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());
				for(int i = 0; i < m ; i++) {      //검사 횟수 , o(m)
					int find = Integer.parseInt(st.nextToken());
					int low = 0, high = arr.length - 1, mid;
          int status = 0;
					
					while(low <= high) {     
						mid = (low + high) / 2;
						
						if(find == arr[mid]) {
							System.out.println(1);    //찾고자 하는 수가 존재한다는 1출력
							status = 1;
							break;
						}
						else if(find < arr[mid]) high = mid - 1;	  //찾고자 하는 수가 작으면				 
						else low = mid + 1;                         //찾고자 하는 수가 크면					
					}
					if(status == 0) System.out.println(0);
				}		

	}

}
