#### 1699

 + 주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수 구하기
  + ex) 11=3^2+1^2+1^2(3개 항) 11=2^2+2^2+1^2+1^2+1^2(5개 항)
 
 > 풀이 방법
  + 현재의 제곱수의 최소값을 위해, **이전의 최소값을 이용**하여서 최소값을 만들어야함 
    + Botton-UP을 이용한 DP!(Memoization 기법 사용)
  + 1 ~ N 까지의 수 중 제곱수인 수 + (n - 제곱수) 의 최소 제곱수 갯수 중 최소인 값
    + EX) 7 => (7-1^2) 의 값과 (7-2^2)의 최소 제곱수의 합 중 가장 작은 값 + 1
  + **DP[i] = DP[i - (j * j)] + 1**
    + DP[i] = 제곱수 합의 최소 개수
 