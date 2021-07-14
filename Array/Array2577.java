import java.util.Arrays; 
import java.util.Scanner;

public class Array2577 {
	public static void main(String[] args) {	
    
		    @SuppressWarnings("resource")
		    Scanner sc = new Scanner(System.in);
		    int n1 = sc.nextInt(); int n2 = sc.nextInt(); int n3 = sc.nextInt();
        int total = n1 * n2 * n3;
        int[] arr = new int[10];
        int[] Numtab = new int[10];   //초기화 안해도 자동 0 초기화
              
        for(int i = 0; total > 0 ; i++) {
        	arr[i] = total % 10;
        	total /= 10;
        }
        
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
        	index = arr[i];
        	Numtab[index] += 1;
        }

        System.out.println(Arrays.toString(Numtab));  
        /*
        for(int i = 0; i < 10 ; i++) {
        	System.out.println(Numtab[i]);
        }
        */
	}   
}
