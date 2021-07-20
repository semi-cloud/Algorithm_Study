//ATM 문제
import java.util.Arrays;
import java.util.Scanner;

public class Greedy_11399 {
	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt(), times = 0;
		Integer[] atm = new Integer[num];    //atm 배열 생성 i
		
		for(int i = 0; i < num; i++) {      //돈을 인출하는데 걸리는 시간 pi
			atm[i] = sc.nextInt();
		}
	
		Arrays.sort(atm);                  //오름차순으로 정렬(합의 최솟값을 구해야 하기 때문에)
		
		for(int i = 1 ; i <= num ; i++) {   //총 합한 minimum 구하기
			if(i < num) {
			    atm[i] += atm[i-1];
			}
			times += atm[i-1];
		}
		
		System.out.println(times);
		sc.close();
	}
	
}
