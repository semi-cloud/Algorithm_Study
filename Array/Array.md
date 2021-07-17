#### Array3052

> 1년전 초기 코드
```java
public class Main {
	public static void main(String[] args) {
		Boolean arr[] = new Boolean[1000]; 
		int num = 0, total = 0;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10 ; i++) {
			num = sc.nextInt();
			arr[num % 42] = true;
		}
		
		sc.close();
		
		for(int i = 0; i < 1000 ; i++) {
			if(arr[i] != null) {
				total++;
			}
		}
		System.out.println(total);	
	}
}
```
  + 나머지 값을 기억하기 위한 배열 arr의 크기를 1000으로 잡음 => 메모리 낭비!
  + `Scanner` : 데이터 타입이 입력 받는 시점에서 결정되므로 별도의 Casting이 필요하지 않지만, 속도가 매우 느림
  + 메모리 14316KB, 116ms

> BufferReader을 사용하여 성능 개선(1차)
```java
public class Main {
	public static void main(String[] args) throws IOException {
        
		boolean arr[] = new boolean[42]; 
        int total = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 10 ; i++) {
			arr[Integer.parseInt(br.readLine()) % 42] = true;
		}
				
		for(boolean value : arr){
			if(value) {
                total++;
            }
		}
		System.out.println(total);	
	}
}
```
  + `BufferReader` : 일정한 크기의 데이터를 한번에 읽어와 버퍼에 보관 후 사용자 요청시에만 읽어들이며, 문자열 파싱 X => 속도 향상!
  +  어떤 수를 42로 나눠도 나머지는 모두 0-41 사이 => arr의 크기를 1000이 아닌 42로 해야 메모리 줄이기 가능

> HashSet + BufferReader을 사용하여 성능 개선(2차)
```java
public class Main {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> hset = new HashSet<Integer>();
 
		
		for (int i = 0; i < 10; i++) {
			hset.add(Integer.parseInt(br.readLine()) % 42);
		}
		
		System.out.print(hset.size());
	}
}
```
  + `HashSet.add()` : HashSet에 원소를 저장하는 메소드임. 값을 넣을 때 중복되는 값이 없으면 HashSet 에 저장되면서 True 를 반환하고, 중복이 발생하여 저장되지 않으면 False 반환
  + `HashSet.size() `: HashSet 의 크기(= 저장되어 있는 원소의 개수)를 반환
  + 메모리 11436KB, 84ms
  
#### Array16927
 + 배열을 반시계 방향으로 r회만큼 돌리는 프로그램

 > 1년전 초기 코드(미해결) + 생각한 문제 풀이법
 ```java
 	public static void swing(int x, int y) {
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) { 
			int[] a = q.poll();
			int x1 = a[0]; int y1 = a[1];
			
			for(int i = 0 ; i < 4 ; i++) { 
				 int nx = x1 + dx[i];
				 int ny = y1 + dy[i];
				 
				 if((nx <= 0 || ny <= 0 || nx > n || ny > m) || cp[nx][ny] != 0) { continue;}
				 
				 if(isCorner(x1 , y1)) {
					  do_Swing(i, x1, y1);
				      q.add(new int[] {nx, ny});
				      flag = i;
				      System.out.println(1);
				 }else {
					 do_Swing(flag, x1, y1);			    
					 q.add(new int[] {nx, ny});
				 }
			}
		}
	}
	
	public static void do_Swing(int num, int x, int y) {
		switch(num) {
		 case 0: cp[x][y-1] = arr[x][y]; 
		 case 1: cp[x + 1][y] = arr[x][y];
		 case 2: cp[x][y+1] = arr[x][y];  
		 case 3: cp[x-1][y] = arr[x][y];  	
		}
	}
   
	 public static boolean isCorner(int x, int y) {	 
    	 //모서리이면 방향 전환 시그널을 보내기 위해 true 반환
		 if((x == m-n && y == m-n) || (x == n && y == m-n)
				 || (x == m-n && y == m)|| (x == n && y == m)) {
			 return true;
		 }
		 return false;	
 
  ```
   + 반시계 방향인 왼쪽,아래쪽,오른쪽,위쪽 순서대로 탐색해나가다가, 배열의 끝에 다다르면 다음 순서 방향으로 전환(~~애초에 라인 단위로 구역을 나누고 시작했으면 상하좌우 라인마다 돌아야 하는 방향이 정해져서 고려 안해도 되는 부분..~~) 
   + 탐색 순서 : (1,1)에서 시작해 BFS를 이용하여 탐색(바깥,안쪽 구분 X)
 
 > 문제를 부분으로 쪼개어(DIVIDE) 생각해 해결(1차)
 ```java
 
 ```
##### :bulb: Solution
 + 박스의 수 만큼 r회 돌리기를 반복하며, 바깥쪽 박스를 반시계 방향으로 이동시킨후 안쪽 박스도 차례대로 이동
 + 박스의 수? : 전체 배열의 크기 (N,M)중 최솟값의 절반
 > 1. 바깥배열과 안쪽을 구분하여 바깥만 순환하는 방법?
  + 

 > 2. 배열을 반시계 방향으로 이동하는 방법?
  + 라인 단위로 이동함. 한 라인에 대해 먼저 이동한후, 반시계 방향 차례로 나머지 3개의 라인도 이동
  + 회전횟수를 r mod 박스칸수로 지정하여 r의 값이 무한정 커질때의 성능을 대비
  + (0,0)에서 (1,0)로 이동은 1번/13번/25번 회전하나 모두 같은 결과
 
