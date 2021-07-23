#### 1074
 + 2^N × 2^N인 2차원 배열을 Z모양으로 탐색
   + N > 1이면, 크기를 2^N-1 × 2^N-1로 4등분 한 후에 '재귀적'으로 순서대로 방문 => **분할 정복**
 < img src = "https://user-images.githubusercontent.com/71436576/126750600-265e9ae5-7cbd-4b21-9857-137cc294e29e.png" width=50% height=50%>
 
> 1차 풀이 방법
  + 방문 순서 저장할 2차원 배열을 사용하는 것은 메모리 초과 => 배열 대신 (x,y)좌표로만 접근해나감!
  + 구역을 네 사각형으로 나누어, 각 구역의 첫번째 원소부터 접근
    + 첫번째 원소에서부터 차례대로 자기자신, 하, 우, 대각선 방향으로 이동
  + 입력의 R행 C열에 도달하면 시스템 종료 

 ```java
	public static int[] row = {0, 0, 1, 1};   //자기 자신, 아래, 오른쪽, 대각선 방향 원소
	public static int[] col = {0, 1, 0, 1};
	
  int num = (int)Math.pow(2, n);        
	z_Divide(num, 0, 0);
 ```
 ```java
	public static void z_Divide(int n, int x, int y) throws IOException  {   
	    
		if(n == 2) {  
			for(int i = 0; i < 4; i++) {  
				int r2 = row[i] + x; 
			  int c2 = col[i] + y;
			  if(r2 == r && c2 == c) { 
			    	bw.write(String.valueOf(cnt));
			    	System.exit(0);
			  }
			  cnt++;      
			}
			return;
		}  
	  z_Divide(n/2, x, y);           // 왼쪽 사각형
		z_Divide(n/2, x, y + n/2);     // 오른쪽 사각형
		z_Divide(n/2, x + n/2, y);     // 아래쪽 사각형
		z_Divide(n/2, x + n/2, y+ n/2);   //대각선 방향 사각형
   }
}
```
  + :question: BOJ 기준 **시간 초과** 
    + (0,0)부터 배열의 모든 원소를 재귀방식으로 탐색하다가, (R,C)가 나오면 그때서야 종료
    + 문제에서 배열의 최대 크기는 2^15 * 2^15 까지 가능 => 만약 (R,C)가 마지막 원소로 주어지면 시간 초과 발생


> 2차 풀이 방법(성능 개선)
  + 가고자 하는 좌표가 네 구역중 어느 곳에 해당하는지 체크 한후, 해당 사각형에서만 재귀 돌리기
    + 문제풀이에 불필요한 범위까지 계산 X => 136ms로 단축!
 
  ```java
  public static void z_Divide(int n, int x, int y) throws IOException { 
       if(n == 1) {       //종료 조건 n이 1이 됬다는 소리는 그 범위 내에 속함, r와 c를 찾음
               bw.write(String.valueOf(cnt));
               return;
        }

		   n /= 2;    //divide
		   
		   if(r < x + n && c < y + n) {            //1사각형
			   z_Divide(n, x, y); 
			   
		   }else if(r < x + n && c >= y + n ) {            //2사각형
			   cnt += (n * n) * 1 ;
			   z_Divide(n, x, y + n);
			   
		   }else if(r >= x + n && c < y + n) {           //3사각형
			   cnt += (n * n) * 2 ;
			   z_Divide(n, x + n, y);
			   
		   }else {                           //4사각형
			   cnt += (n * n) * 3 ;
			   z_Divide(n, x + n, y+ n);		  
		   }
   }
   ```

#### 1992
