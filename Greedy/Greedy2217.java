public class Greedy2217 {
	public static void main(String[] args) {	
		
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt(), w = 0;
		Integer[] rope = new Integer[k]; 
		
		for(int i = 0; i < k ; i++) {
			rope[i] = sc.nextInt();      //들수있는 최대 무게 배열 값으로 넣기
		}
		
		Arrays.sort(rope, Collections.reverseOrder());   //내림차순 정렬
		for(int i = 0 ; i < k ;i++) {
			System.out.println(rope[i]);
		}
		
		for(int i = 1; i <= k ; i++) {
			w = Math.max(w, rope[i-1]* i);
		}
		
		System.out.println(w);
		sc.close();
    /*
		int max = rope[0];
		for(int i = 1 ; i < k ; i++) {
			if(max < rope[i] * i+1) {
				max = rope[i] * i+1;
			}			
		}
		*/
	}

}
