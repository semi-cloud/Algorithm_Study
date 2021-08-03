public class Main {
	static int n; 
	static int m; 
	static int v; 
	static LinkedList<Integer>[] graph;  
	static boolean[] visit;    
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		queue = new LinkedList<>(); 
		
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken()); 
		v = Integer.parseInt(st.nextToken()); 
		
		graph = new LinkedList[n + 1]; 
		
		for(int i = 0; i <= n ; i++) {
			graph[i] = new LinkedList<Integer>();   //객체 연결
		}
		
		for(int i = 0; i < m ; i++) {     //데이터 입력, 간선
			 st = new StringTokenizer(br.readLine());
			 int v1 = Integer.parseInt(st.nextToken());
			 int v2 = Integer.parseInt(st.nextToken());
			 
			 graph[v1].add(v2);       //양방향으로 연결
			 graph[v2].add(v1);		 
		}
		
		for(int i = 0; i <=n ; i++) {
			 Collections.sort(graph[i]);    //연결 리스트 노드들 순서대로 다시 정렬(작은거부터 탐색)
		}
        
        visit = new boolean[n + 1]; 
		dfs1(v);
        System.out.println();
        
	    visit = new boolean[n+1];
		bfs(v);		
	}
	
	public static void dfs1(int v) { 
		if(visit[v]) {return;}  
		
		visit[v] = true;  
		System.out.print(v + " ");
        
        for(int node : graph[v]) {  
            if(!visit[node]){
               dfs1(node);	
            }	
		}		
	}
	
	public static void bfs(int v) {         
		
		queue.offer(v);   
        visit[v] = true;
		
		while(!queue.isEmpty()) {   
			int n = queue.poll();   
			
			System.out.print(n + " ");
			
			for(int node : graph[n]) {  
               if(!visit[node]){
                   queue.add(node);
                   visit[node] = true;
               }			
			}
		}	
		return;
	}
}
