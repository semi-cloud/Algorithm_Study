import java.util.Scanner;

// 수 10개를 42로 나눈 후 서로 다른 값이 몇 개 있는지 출력하는 프로그램
// boolean 배열로 기억
public class Main {
	public static void main(String[] args) {
        
		boolean arr[] = new boolean[42]; 
		int num = 0, total = 0;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10 ; i++) {
			num = sc.nextInt();
			arr[num % 42] = true;
		}
		
		sc.close();
		
		for(boolean value : arr){
			if(value) total++;
		}
		System.out.println(total);	
	}
}
