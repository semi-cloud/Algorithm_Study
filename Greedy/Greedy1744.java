
public class Main {
	static int n;    
	static int[] num;  
	static int total;  

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		num = new int[n];

		int sep = 0;                       //음수와 양수를 나누기 위한 index 
		for(int i = 0; i < num.length ; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if(num[i] <= 0) sep++;        //음수에 0까지 포함시킴
		}

		Arrays.sort(num);    //오름차순으로 정렬
		int left = 1;               //왼쪽 인덱스
		int right = n - 1;         //오른쪽 인덱스
		
		for( ; left < sep ; left += 2) {
			total += num[left - 1] * num[left];   
		}
		
		//음수 파트 홀수
		if( sep % 2 == 1 ) {
			total += num[sep - 1];
		}
		
		//양수 파트 홀수
		if( (n - sep) % 2 == 1) {
			total += num[sep];   
		}
        
		for( ; right > sep ; right -= 2){
			int sum = num[right] + num[right - 1];
			int mul = num[right] * num[right -1];
			
			if(mul > sum) {
				total += mul;
			}else {
				total += sum;
			}
		}	
		System.out.println(total);
	}
}
