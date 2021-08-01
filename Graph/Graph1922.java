import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    
	int v;   
	int w; 
	
	public Edge(int v, int w) {
		this.v = v;
		this.w=  w;		
	}
	@Override
	public int compareTo(Edge o) {   
		return this.w - o.w;        
	}
	
}

public class Main {
    static List<List<Edge>> graph;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(); 
    static boolean[] visit;
    static int v1;
    static int e;
    static int cnt;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
	  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken()); 
		st = new StringTokenizer(br.readLine());
		e = Integer.parseInt(st.nextToken()); 
		
		graph = new ArrayList<>(); 
		visit = new boolean[v1 + 1];
		
		for(int i = 0; i <= v1 ;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < e ; i++) { 
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(new Edge(v2 , w));
			graph.get(v2).add(new Edge(v1,  w)); 
			
		}
		prim();

	}

	public static void prim() {
		pq.add(new Edge(1, 0)); 
	    int count = 0;
		
		while(!pq.isEmpty()) { 
			Edge e = pq.poll(); 
			
			if(visit[e.v]) {continue;} 
			visit[e.v] = true;  
			cnt+= e.w;
		
			for(Edge next : graph.get(e.v)) {
				if(!visit[next.v]) { pq.add(next);}
			}
			if(++count == v1) {break;}  
		}
		System.out.println(cnt);
	}
}
