public class Main {
	static int r; //세로
	static int c;  //가로
	static int cnt = 0; //최대 이동 횟수
	static boolean[] visit;  //지나온 길 저장
	static int[][] board;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

	    board = new int[r][c];    
	    visit = new boolean[26];   //A - Z  알파벳 정보 저장
	    
	    for(int i = 0; i < r ; i++) { 
	    	String s = br.readLine();
	    	for(int j = 0 ; j < c ;j++) {
	    		board[i][j] = s.charAt(j) - 'A';  //아스키 코드값로 저장
	    	}
	    }
	
	    dfs(0, 0, 0);    
	    System.out.println(cnt);   
	}
	
	public static void dfs(int n, int m, int k) { 
		
        if(0 <= n && n < r && 0 <= m && m < c) {
        	
        	if(visit[board[n][m]]) {   //알파벳이 중복되면 경로 개수 갱신후 종류
              cnt = Math.max(cnt, k);  
              return;
    		  }else {                  //방문 안한 숫자이면 다른 방향으로 이동			
              visit[board[n][m]] = true;  

              dfs(n, m+1, k+1);   //오른 방향 
              dfs(n+1, m, k+1);   //아래 방향 
              dfs(n-1, m ,k+1);   //위쪽 방향  
              dfs(n, m-1, k+1);   //왼쪽 방향  	

              visit[board[n][m]] = false;		//방문 표시 제거	
    		  }
       }
       else {return;}		
	}
}
