import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String[] arr = br.readLine().split("-");      
				
		int total = 0;		
		for(int i = 0; i < arr.length ; i++) {	
            
		  int temp= 0;
			String[] subArr = arr[i].split("\\+");  
			
			for(int j = 0; j < subArr.length ; j++) {
				temp += Integer.parseInt(subArr[j]); 
      }
			
			if(i == 0) { temp *= -1;}
			total = total - temp; 
		}
		System.out.println(total);	
	}
}
