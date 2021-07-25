import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int[][] tree;  
	private static int m;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());   
		tree = new int[size][size];
		
		for(int i = 0; i < size ; i++) { 
			String s = br.readLine();
			for(int j = 0; j < size ; j++) {			
				tree[i][j] =Character.getNumericValue(s.charAt(j)); 
			}	
		}
		
		divide(size, 0, 0);	
	}
	
	public static boolean isEqual(int n, int x, int y) {  
		
	    int a = tree[x][y]; 
	    
	    for(int i = x; i < x + n ; i++) {   //x = 열
	    	for(int j = y; j < y + n ; j++) {  //y = 행  	
	    		if(a != tree[i][j]) { 
	    			return false;	
	    		}
	    	}
	    }
	    m = tree[x][y];  
	    return true;
	}
	
    public static void divide(int n, int x, int y) { 	
    	
    	if(isEqual(n, x, y) == false) {   //다른 문자가 존재하므로 재귀
            System.out.print("(");
            n /= 2;
            for(int i = 0 ; i < 2 ; i++) {    //4등분 분할
              for(int j = 0; j < 2; j++) {
                divide(n, x + n * i , y + n * j );

              }
            }
            System.out.print(")");
    	}
		else System.out.print(m);
    }
}
