#### 1074
 + 2^N × 2^N인 2차원 배열을 Z모양으로 탐색
   + N > 1이면, 크기를 2^N-1 × 2^N-1로 4등분 한 후에 '재귀적'으로 순서대로 방문 => **분할 정복**

<img src = "https://user-images.githubusercontent.com/71436576/126750600-265e9ae5-7cbd-4b21-9857-137cc294e29e.png" width=50% height=50%>
 
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

#### 2447
 + 재귀적 패턴으로 별 찍기 : N( N = 3^k ) * N 정사각형 크기
   + if n > 3 : 가운데 공백으로 된 (n/3 * n/3) 정사각형을 크기 n/3 패턴으로 둘러싼 형태
 ```
 ***
 * *
 ***
 ```
 
 > 1차 풀이 방법
  + `분할 정복` : N/3 크기로 계속해서 나누어 , 젤 작은 크기의 부분문제인 N = 1에 도달해야함
  + 9칸으로 나눈다 가정했을때, **각 칸의 젤 첫번째 원소**로 접근해야함!
    + N = 3 / 가로 i = 0,1,2 세로 i = 0,1,2 /(0,0)시작을 가정했을때, 두번째 칸의 위치의 X좌표 0(x) + 1(n/3) * 2(i) 
  ```java
  private static void divide(int x, int y, int n, boolean isBlank) throws IOException {
	  if(n == 1) {              //n = 1이 되었을때 * 출력
	      map[x][y] = '*';
	      return;
	  }

	  int size = n / 3;
	  for(int i = 0; i < 3 ; i++) {  //총 9 곳, row 로 3칸 col로 3칸이므로 각각의 인덱스를i = 0,1,2로 잡기
	      for(int j = 0; j < 3 ; j++) {	    			
		    if(i == 1 && j== 1) {        //가운데 칸
			divide(x + size*i, y + size*j, size, true);
		    }else {
			divide(x + size*i, y + size*j, size, false);
		    }
	       }
	  }
  }
  ```
  + 가운데 칸(i = 1, j = 1)만 공백이여야 함으로, 나머지 칸들과 boolean값으로 구분
  ```java
  if(isBlank) {
      for(int i = x; i < x + n ; i++) { 
	   for(int j = y; j < y + n ;j++) {
	    	map[i][j] = ' ';    
	    }
       }
       return;
  }
  ```

 > 2차 풀이 방법
  + `*` 이 4번 나오고 난 후에 공백이 출력, 즉 공백 칸의 시작 위치는 5번째 부터임
    + `*` 출력을 센 값을 cnt에 담고, cnt가 5가 되면 공백을 입력
  ```java
        int size =  n / 3;  
    	int cnt = 0;
    	for(int i = x; i < x + n ; i += size) {   //전체에 대해서 실행
    		for(int j = y ; j < y + n ; j += size) {
    			cnt++;                   // cnt = 젤 작은 단위의 블럭 실행 
    			if(cnt == 5) {          
    				printStar(i, j, size, true);   //가운데 블럭의 시작 위치
    			}else {
    				printStar(i, j, size, false);   
    			}
    			
    		}
    	}
  ```

#### 1992
