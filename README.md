# Algorithm_Study
BOJ 문제풀이 2020.01~

## Contents
|알고리즘 목차|
|------|
|Array|
|BackTracking|
|Divide And Conquer|
|Dynamic Programming|
|Graph|
|Greedy|


## References
 + BOJ
 + SW Expert Academy

## 입출력

### 1)입력_BufferedReader
 ```java
 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//선언

 String string = bufferedReader.readLine();      // 한줄식 받아옴
 StringTokenizer stringTokenizer = new StringTokenizer(string);   //토크나이져를 통해 파싱, 띄어쓰기 단위
 int a = Integer.parseInt(stringTokenizer.nextToken()); 
 ```
 > 여러 줄 입력 발을때
 ```java
 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

 String string;
 while((string=bufferedReader.readLine())!=null){
            // string 한줄
 }
 ```
 + `Buffered Stream` : 기본 입출력 스트림에 버퍼기능을 추가하는 스트림
   + 입력된 데이터가 중간에 버퍼링이 된 후에 전달되며, 출력도 마찬가지로 버퍼를 거쳐서 출력됌
   + 중간버퍼를 사용함으로써 시스템의 데이터처리 효율성이 높아짐!
### 2)입력_Scanner

### 3)출력_BufferedWriter
 ```java
 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); //선언

 bufferedWriter.write("Hello World!");됌

 bufferedWriter.flush(); 
 bufferedWriter.newLine();    // 줄바꿈이 필요할 경우 사용
 bufferedWriter.close();      // 버퍼 닫기

 ```
  + `write()` : 직접 출력 stream에 반영되는 것이 X
  + `flush()`: 성능을 위해 buffer에 저장해 두었다가 BufferedWriter가 flush되거나 close되었을 때 한번에 출력 stream에 반영!
  + `close()` : 아예 stream을 닫아버리기 때문에, 계속 출력을 원하면 `flush()` 사용

### 4)출력_System.out.println()
 + 콘솔 출력할때 사용, 기본적으로 디버그를 위한 출력 => `Logger` 사용 필요
 + But 시스템 리소스를 필요 이상으로 잡아먹는 한계가 존재
 
 > JAVA DOC 인용
 ```
 System은 Object 클래스를 상속받은 final 클래스이다. 인스턴스화 할수없다. out은 PrintStream 의 인스턴스   이다 println은 PrintStream의 메소드이다.
 ```
 + println은 println -> print -> write() + newLine() 순서로 처리됌
 
## 문자열 포멧팅

### String

### StringBuilder

### StringBuffer
