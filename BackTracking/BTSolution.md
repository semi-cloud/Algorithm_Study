#### # 15649
 + 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하가
   + `조건` : 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 > 풀이 방법
 + 숫자 중복 체크를 위해 boolean 배열 사용
 + 방문하지 않은 숫자만 **depth+1**을 가지고 재귀호출, depth와 찾고자 하는 길이 M이 같아졌다면 종료
 + 종료 후(하나의 가지가 끝나면)에는, 방문 표시 제거
 
 <img src="https://user-images.githubusercontent.com/71436576/129450820-975a34a4-e223-440c-8a46-ddbe12671290.png" width=60% height=60%>

 > 성능 개선
  + 초기 코드 : `System.out.println()`
  + :star2: `StringBuilder 사용` :star2: : 2340ms -> 340ms
