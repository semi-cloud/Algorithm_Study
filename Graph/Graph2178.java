public class Main {
	static int[][] arr;
	static boolean[][] visit;
	static Queue<int[]> queue; 
	static int n;
	static int m;
	static int cnt = 0;  
	static int[] dx = {-1, 1, 0, 0 }; static int[] dy = {0, 0 ,-1, 1}; 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		queue = new LinkedList<>();  
		n = sc.nextInt(); m = sc.nextInt();
    visit = new boolean[n][m];    
		arr = new int[n][m];
		
		for(int i = 0; i < n ; i++){  
			String s = sc.next();
			for(int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}			
		}

	    bfs_m(0, 0);
	    System.out.println(arr[n - 1][m - 1]);  
        sc.close();
        
	}

	public static void bfs_m(int x, int y) {
		
		queue.offer(new int[] {x, y});  
		
		while(!queue.isEmpty()) {  	
			int[] location = queue.poll();  
			visit[x][y] = true;
			int x1 = location[0]; int y1 = location[1];	
				
			for(int i = 0; i < 4 ; i++) {    
				int x2 = x1 + dx[i];
				int y2 = y1 + dy[i];
	            
				if(x2 >= 0 && y2 >= 0 && x2 < n && y2 < m) {  
					if(!visit[x2][y2] && arr[x2][y2] != 0) {				
						queue.add(new int[] {x2, y2});  
						visit[x2][y2] = true;
						arr[x2][y2] = arr[x1][y1] + 1;						
					}				
				}			
			}		
		}				
	}
}
