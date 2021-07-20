## :bulb: Solution

#### 1541
 + 괄호를 적절히 배치하여 식의 값을 **'최소'** 로 만들기 => Greedy!
 
 > 최적해(조건)
 + 식의 결과 값이 최소가 되려면, **가장 큰 수를 빼면 됌**
  + ex) 1 + 3 - 8 + 4 의 식에서 (1+3) - (8+4) = 4 - 12 = -8

 > 풀이방법
 1. 뺄셈(-)을 기준으로, 1차적으로 문자열 분리 </br>
 2. 분리된 문자열들 각각에 포함 된 정수 값들 덧셈(+) </br>
 3. 각 더해진 값들을 뺀다.
 
 > :pencil2: 주의할 점
  + 문제의 조건에서 식의 맨 앞에 숫자는 양수이므로, 그냥 빼버리면 문제가 생김 
    + ex) 55-90 => 0 - 55 - 90 = -145 로 잘못된 값이 나온다.
  ```java
      int total = 0;
      ...
      if(i == 0) { temp *= -1;}  //이 조건이 꼭 필요하다!
      total = total - temp;
  ```   

#### 11047
 + N 종류의 동전의 합을 K로 만들때, 필요한 동전 개수의 **'최솟값'** => Greedy!
 
 > 최적해(조건)
 + 동전의 갯수를 줄이려면, 최적의 선택은 **가장 큰 금액의 동전을 택하는것**

 > 초기 풀이방법
 + 1.큰 금액 순서대로 동전 배열 정렬</br>
 + 2.k보다 작은 동전 중 가장 큰 것 을 계속 택하고, (k - 동전의 합)이 현재 동전의 금액보다 작으면 중지</br>
 + 3.다음 큰 금액의 동전을 택하기를 반복.. 동전의 합이 k 와 같아지면 반복문 종료
  
 ```java   
	n = Integer.parseInt(st.nextToken());    //금액이 서로 다른 동전의 갯수
	k = Integer.parseInt(st.nextToken());    //동전의 합
	coinVal = new int[n];
		
	for(int i = 0; i < coinVal.length; i++) {	 //동전 종류 입력 	
             coinVal[i] = Integer.parseInt(br.readLine());
	}
    
        Integer[] temp = Arrays.stream(coinVal).boxed().toArray(Integer[] :: new);  	//int형 배열 내림차순, 이 부분이 필요가 x
        Arrays.sort(temp, Collections.reverseOrder());
        coinVal = Arrays.stream(temp).mapToInt(i -> i).toArray();
   ```
   ```java
	  int val = 0;  
	  int i = coinVal.length-1 ;
	  while(i >= 0 ) {
	 	
	    	if(coinVal[i] <= k && (k - val) >= coinVal[i]) {
    			val += coinVal[i];
    			minCoin++;
    		}else { i--;} 
    		
    		if(val == k) { break; }          //목표 금액과 같아지면 반복 중지
	  }
   ```
  + :star2: 항상 **문제의 조건**을 잘보자!!!
    + 애초에 배열 입력 조건이 오름차순이므로, 정렬이 필요 없었음(배열 뒤에서부터 검사하면 됌)
  + 목표 금액과 같아질때까지 반복문을 계속해서 돌아야 하므로 시간이 많이 소요됌(328ms)
  
 > 2차 풀이방법
 
  + 목표 금액이 4200 이라 했을때, 1000+1000+1000+1000+100+100 보다 1000 * 4 + 200 * 2 의 코드가 훨씬 간결
  + 현재 가치의 동전으로 구성 가능한 최대 갯수를 구하고, 차액만 가지고 다시 반복하는게 시간도 적게 소요됌(136ms)
 ```java
  for(int i = n - 1; i >= 0 ; i--) {	
  
			if(coinVal[i] <= k) {              //k 가 0 이되면 자동으로 반복문 종료		
				minCoin += (k / coinVal[i]);  //현재 가치의 동전으로 구성할 수 있는 개수 더해주기
				k %= coinVal[i];
			}
	}	
 ```
#### 1744
  + 수열의 두 수를 위치 상관없이 묶어서(두 수는 곱셈으로 처리) 모두 더한 수열의 합의 **최댓값** 구하기 => greedy!
