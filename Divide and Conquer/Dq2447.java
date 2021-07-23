import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static char map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {

		     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	       StringBuilder sb = new StringBuilder();

	       int N = Integer.parseInt(br.readLine());
	       map = new char[N][N];   

	       divide(0, 0, N, false);

	       for(int i = 0; i < N; i++) {
          for(int j = 0; j < N ; j++) {
            sb.append(map[i][j]);
           }
           sb.append('\n');
         }

			   System.out.println(sb);
	    }

	    private static void divide(int x, int y, int n, boolean isBlank) throws IOException {
	    	
	    	if(isBlank) {
	    		for(int i = x; i < x + n ; i++) { 
	    			for(int j = y; j < y + n ;j++) {
	    				map[i][j] = ' ';    
	    			}
	    		}
	    		return;
	    	}
	    	
	    	if(n == 1) {
	    		map[x][y] = '*';
	    		return;
	    	}
	    	
	    	int size = n / 3;   
	    	for(int i = 0; i < 3 ; i++) {  
	    		for(int j = 0; j < 3 ; j++) {	 
            
	    			if(i == 1 && j== 1) {  
	    				divide(x + size*i, y + size*j, size, true);
	    			}else {
	    				divide(x + size*i, y + size*j, size, false);
	    			}
	    		}
	    	}
	    }    		
}
