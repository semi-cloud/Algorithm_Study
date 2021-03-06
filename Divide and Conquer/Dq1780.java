public class Main {
	private static int[][] paper;
	private static int zero = 0, minusone = 0, plusone = 0;  
	private static int num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    StringTokenizer st;
			int size = Integer.parseInt(br.readLine());  
			paper = new int[size][size];
			
			for(int i = 0; i < size ; i++) {  
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < size; j++) {				
					paper[i][j] = Integer.parseInt(st.nextToken());
				}
			}
	        
			cut(size, 0, 0);
			System.out.println(minusone);
			System.out.println(zero);
			System.out.println(plusone);
		}
	
		public static boolean check(int n, int x, int y) { //검사
			int a = paper[x][y];
			
			for(int i = x; i < x + n; i++) {   
				for(int j = y ; j < y + n; j++) {
					if(a != paper[i][j]) {
						return false;
					}
				}
			}
			num = paper[x][y];
			return true;

		}
		
		public static void cut(int n, int x, int y) {			
			if(check(n, x , y)) {    //1. 검사 한 뒤 종이가 모두 같은 수면 바로 최종합에 더하기
				if(num == 0) {
					zero++;
				}else if(num == -1) {
					minusone++;
				}else {
					plusone++;
				}
			
			}else {                //2.같은 수가 아닐때만 다시 9등분으로 분할
				n /= 3;
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3 ; j++) {
						cut(n, x + n * i, y + n * j );
					}
				}
			}
			return;
		}
	}
