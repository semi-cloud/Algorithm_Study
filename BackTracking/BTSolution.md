#### # 15649
 + 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하기
   + `조건` : 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 > 풀이 방법
 + 숫자 중복 체크를 위해 boolean 배열 사용
 + 방문하지 않은 숫자만 **depth+1**을 가지고 재귀호출, depth와 찾고자 하는 길이 M이 같아졌다면 종료
 + 종료 후(하나의 가지가 끝나면)에는, 방문 표시 제거
 
 <img src="https://user-images.githubusercontent.com/71436576/129450820-975a34a4-e223-440c-8a46-ddbe12671290.png" width=60% height=60%>

 > 성능 개선
  + 초기 코드 : `System.out.println()`
  + :star2: `StringBuilder 사용` :star2: : 2340ms -> 340ms
  
#### 9663
 + 크기가 N × N 인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수 구하기
 
 > 초기 풀이 방법
 + 문제를 아예 잘못 이해해서 방향을 못잡음
   + 공격 피하는 조건 : 현재 위치로부터 상하좌우,대각선 방향으로 쭉 퀸이 놓여있지 않으면 통과
   + ~~이걸 현재 위치로부터 인접한 딱 1칸에만 적용되는 조건이라고 생각..~~

 > 1차 풀이 방법: 2차원 배열 사용
 
 ```java
 public static void bt(int r) {  		
     if(r == N) {     
      queen++;
      return;
     }

    for(int c  = 0; c < N; c++) {   //열만 달라지고, 행은 항상 0부터 검사
        if(check(r, c)) {   //놓을 수 있는 자리면 재귀
         chess[r][c] = 1;
         bt(r + 1);  
         chess[r][c] = 0;
        }
    }
	}
```
 + :star2: `check(r,c)`조건을 for문 밖에 두어 false일때 종료하면 안되는 이유?
   + 다음열의 원소 하나만 체크하고, 조건에 맞지 않으면 바로 `chess[0][0]=0`가 되버림
   + _놓을 수 있는 자리면, 재귀 호출해야해!_
 
 ```java
 public static boolean check(int r, int c) { //인접한 자리에 퀸이 있는지 체크
	
		//1.왼쪽 대각선 검사
		for(int i = r, j = c ;i >=0 && j >=0 ; i--, j--) {
    if(chess[i][j] == 1) {
     return false;
    }
		}
		
  //2. 오른쪽 대각선 검사
		for(int i = r, j = c ; i >= 0 && j < N ; i--,j++) {
    if(chess[i][j] == 1) {
     return false;
    }		
		}
		
		//3.위쪽 검사(아래쪽은 없으니까 볼 필요 X)
		for(int i = r ; i >= 0 ; i--) { //아래로 내려가면서 검사
    if(chess[i][c] == 1) {
     return false;
    }
		}
		return true;
 ```
  + 시간: 🤨 `9900ms`
 
 
 > 2차 풀이 방법: 1차원 배열 사용
 + 각 원소의 index를 '열'이라 생각하고, 원소 값을 '행'이라 생각
   + ex)[2,0,3,1] => 2열 0행, 0열 1행, 3열 2행, 1열 3행에 퀸 존재
 + 행(row)이 아니라, 반대로 열(col) 기준으로 채운다는 개념
 + 시간 : `5584ms` 좀 줄어들었음
