public class Greedy5585 {
	public static void main(String[] args) {
		//500 100 10 5 1 엔=> 그리디 알고리즘 : 가장 높은 금액 선택

		Scanner sc = new Scanner(System.in);
		int pay = 1000 - sc.nextInt(), cnt = 0;
		int[] repay = {500, 100, 50, 10, 5, 1} ;  //내림차순으로
				
		int i = 0;

		while(pay != 0) {
			int change = pay / repay[i];    
			pay = pay - change * repay[i++];  
		  cnt += change;
		}
    
		System.out.println(cnt);
		sc.close();
    /*
    //그리디 알고리즘 사용 X
		int i = 0;
		while(pay != 0) {
			
		     if(pay >= repay[i]) {      	
		        cnt += pay / repay[i];
		       	pay %= repay[i];   
		        if(pay < repay[i]) {i++;}  
		     }
		     else {i++;}
		}
		*/
	}
}
