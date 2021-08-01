import java.util.Collections;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;  
	static int m; 
	static int cnt;  
	static boolean[] visit; 
	static LinkedList<Integer>[] graph;  
	
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine()); 
		graph = new LinkedList[n+1];  
		visit = new boolean[n+1];
		
		for(int i = 0; i <= n ; i++) {
			graph[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < m ;i++) {  
            st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(v2);
			graph[v2].add(v1);
			
			Collections.sort(graph[v1]); 
			Collections.sort(graph[v2]);
		
		}
		dfs(1);  
		System.out.println(cnt - 1); 
	}
	
	public static void dfs(int v) {
		if(visit[v]) {return;}
		
		visit[v] = true;
		cnt+=1;
		
		for(int node : graph[v]) {
			dfs(node);			
		}	
	}
}
