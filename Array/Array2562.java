import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);       
	int[] arr = new int[9];  	
	for(int i  = 0; i < 9 ; i++) {
		arr[i] = sc.nextInt();
    }
   
	int Max = arr[0], index = 0; 
	for(int i = 0; i < 8; i++) {
		if(Max < arr[i + 1]) {
			Max = arr[i + 1];
			index = i + 1; 
		}
	}
	System.out.println(Max);
    System.out.println(index + 1);	
    sc.close();
    }
}
