public class Main {
	static int[] arr;
	static int N, S, cnt = 0;

	public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
	
		arr = new int[N];         //실제 배열

		//n 개의 수 입력받기
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    
    Arrays.sort(arr);
        
		recur(0, 0);
		System.out.print(S == 0? --cnt : cnt);
     
	}
  
  private static void recur(int v, int su) {
		if(v == N) {
			if(su == S) cnt++;
			return;
		}

		recur(v + 1, su + arr[v]);
		recur(v + 1, su);
	}
	
}
