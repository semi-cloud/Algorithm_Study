public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int n = 0, r = 0 , c = 0, cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
   
	  StringTokenizer st = new StringTokenizer(bf.readLine());
	  int n = Integer.parseInt(st.nextToken());
	  r = Integer.parseInt(st.nextToken());
	  c = Integer.parseInt(st.nextToken());
		int num = (int)Math.pow(2, n);   
        
		z_Divide(num, 0, 0);
		bf.close();
		bw.close();
	}
	
	public static void z_Divide(int n, int x, int y) throws IOException  {
      if(n == 1) {      
         bw.write(String.valueOf(cnt));
         return;
	    }
	   
	    n /= 2;  
	   
	    if(r < x + n && c < y + n) {  
		   z_Divide(n, x, y); 
		   
	    }else if(r < x + n && c >= y + n ) {         
		   cnt += (n * n) * 1 ;
		   z_Divide(n, x, y + n);
		   
	    }else if(r >= x + n && c < y + n) {          
		   cnt += (n * n) * 2 ;
		   z_Divide(n, x + n, y);
		   
	    }else {                          
		   cnt += (n * n) * 3 ;
		   z_Divide(n, x + n, y+ n);		  
	    }
    }
}
