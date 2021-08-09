public class Main {
	static int map[][];
	static int copymap[][];
	static int n;  
	static int m;  
	static int[] dx = {-1, 1, 0, 0 }; static int[] dy = {0, 0 ,-1, 1}; 
	static Queue<int[] > q;
	static int depth, max = 0;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
        
		map = new int[n][m];   
		copymap = new int[n][m]; 
		q = new LinkedList<>();
		
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					q.add(new int[] {i, j}); 			
				}
			}
		}
		
	    setWall(0, 0);
	    System.out.println(max);

	}

    public static void setWall(int start, int depth) { 
    	
    	if(depth == 3) { 
    		copy();  
    		
    		for(int[] loc : q) { 
    			dfs(loc[0], loc[1]);  
    		}
   
    		max = Math.max(getResult(), max); 
    		return; 
    	}
    	
    	for(int i = start; i < n * m; i++) { 
    		int x = i / m;  
    		int y = i % m;  
    		
    		if(map[x][y] == 0) {   
    			map[x][y] = 1;   
    			setWall(i + 1, depth + 1);
    			map[x][y] = 0;   
    			
    		}
    	}
    }
    
    public static void copy() {
    	for(int i = 0; i < n ; i++ ) {
    		for(int j = 0; j < m ; j++) {
    			copymap[i][j] = map[i][j];
    		}
    	}
    }

	
	public static void dfs(int x, int y) { 
		  
		  for (int i = 0; i < 4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];

	            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
	                if (copymap[nx][ny] == 0) {
	                    copymap[nx][ny] = 2;
	                    dfs(nx, ny); 
	                }
	            }
	        }
	} 
	public static int getResult() { 
		int cnt = 0;
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0; j < m ; j++) {
				if(copymap[i][j] == 0) {
					cnt++; 
				}
			}
		}
		return cnt;
	}

}
