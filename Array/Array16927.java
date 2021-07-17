import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	  static int[][] map;
    static int N;   //세로 ( 2<= <=300)
    static int M;   //가로  ( 2<= <=300)
    static int r;  //돌릴 횟수
    static int[] dx = {0, 1, 0, -1 };
    static int[] dy = {1, 0 ,-1, 0}; //우 하 좌 상(반시계 방향), 옮길 대상의 방향
    public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(br.readLine());

          N = Integer.parseInt(st.nextToken());
          M = Integer.parseInt(st.nextToken());
          r = Integer.parseInt(st.nextToken());
          int n = N, m = M;

          map = new int[N][M];

          for(int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M ; j++) {
              map[i][j] = Integer.parseInt(st.nextToken());
            }
          }

          int cnt = N < M ? N : M;
          //1. 박스 수 만큼  r회 돌리기를 반복, Rotate()에서는 배열 한번에 r개 돌리기

          for(int i = 0; i < cnt / 2 ; i++ ) {
            rotate(i, 2*n  + 2* m - 4);     //시작지점, 박스의 크기(길이)
            n-=2;
            m-=2;
          }     
          //출력

          for(int i = 0; i < N ; i++) {
            for(int j = 0; j < M ; j++) {
              System.out.print(map[i][j] + " ");
            }
            System.out.println();
          }

    }

    public static void rotate(int start, int len) {
      int rotate = r % len;
      for(int i = 0; i < rotate ; i++) {  //회전 횟수만큼 돌리기
        int startNum = map[start][start];
        int row = start;
        int col = start;

        int k = 0;
        while(k < 4) {      //4개의 라인 다 돌기
          int nrow = row + dx[k];
          int ncol = col + dy[k];

          if(nrow == start && ncol == start) {break;}  //루프 종료 조건(옮기려는 대상이 시작 위치)

          if(nrow >= start && ncol >= start && nrow < N-start && ncol < M-start) { 			//박스마다 배열의 범위 값이 변화
            map[row][col] = map[nrow][ncol];     //시계방향으로 이동
            row = nrow;
            col = ncol;                    
          }else {                      //한 라인이 끝날 시 방향 전환하고 다음 라인으로 이동
            k++;
          }
        }
        map[start+1][start] = startNum;  
      }

    }
}
	
