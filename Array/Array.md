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
  
#### Array4344
