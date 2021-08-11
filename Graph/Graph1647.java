class Edge implements Comparable<Edge>{
	
	int s;  //시작 정점
	int e;  //끝 정점
	int w;  //가중치 정보
	
	public Edge(int s, int e, int w) {
		this.s = s;
		this.e = e;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {  
		return this.w - o.w;        		
	}
}

public class Main{
	static int N;  //정점
	static int M;   //엣지
	static int cost; //최소 가중치의 합
	static int[] parent;  //부모 배열
    
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge> list = new ArrayList<>(); 
		parent = new int[N+1];
		
		for(int i = 0 ; i < M ;i++) {   
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());  //시작 정점
			int v2 = Integer.parseInt(st.nextToken());  //끝 정점
			int w = Integer.parseInt(st.nextToken());   //가중치
			
			list.add(new Edge(v1,v2,w));
		}

		Collections.sort(list);   //엣지 오름차순으로 정렬
		
		for(int i = 0; i <= N ; i++) {
			parent[i] = i;
		}
		
	    int cnt = 0;
		for(int i = 0; i < M; i++) {   
			Edge edge = list.get(i);  
			int a = edge.s;
			int b = edge.e;

			if(find_Set(a) != find_Set(b)) {  //부모가 다르면(사이클 형성x)
				union(a,b);              			
				cost += edge.w;          
				cnt++;
			}
			if(cnt == N-2) { break;}    
		}
		System.out.println(cost);
	}
	
	public static void union(int a, int b) { 
		a = find_Set(a);
		b = find_Set(b);
		
		if(a < b) { parent[b] = a;}
		else { parent[a] = b;}
	}
	
	public static int find_Set(int n) {  
		if(n == parent[n]) 
			return n;
		return parent[n] = find_Set(parent[n]); 
	} 
}
