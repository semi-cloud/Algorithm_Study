public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] check;
  static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	  sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m]; 
		check = new boolean[n];
		
		bt(0);
		System.out.println(sb.toString());		
	}
	
	public static void bt(int k) {
		
		if(k == m) {   
			for(int val : arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < n ; i++) {
			if(!check[i]) {
				check[i] = true;
				arr[k] = i + 1;    
				bt(k+1);
				check[i] = false;			
			}
		}			
	}
}
