# Graph

## Graph 정의

#### 1) 그래프란?
  + `Graph ` : 객체 간 연결 관계 표현
  +  G = (V,E)
    + `V(vertex)` : 정점들의 집합
    + `E(edge)` : 정점을 연결하는 간선들의 집합
  > |V|개 그래프에는 최대 |V|(|V|-1) / 2 개의 간선 가능
  + 선형과 트리 자료구조로 표현하기 어려운, N : N 관계의 객체 표현 용이
  <img src = "https://user-images.githubusercontent.com/71436576/126340242-9e719b1f-7c74-4fbf-b92e-38d36b83946c.png" width="50%" height="50%">
  
#### 2) 그래프의 종류
  + (1) 무방향 그래프(undirected)
    + `Sparse Graph(희소)` : vertex의 수보다 edge의 수가 적은 그래프, O(N)
    + `Dense Graph(밀집)` : vertex의 수보다 edge수가 많은 그래프, O(N^2)
    + `Complete Graph(완전)` : 모든 정점들이 edge로 연결되어 있는 그래프, O(N^2)
  <img src = "https://user-images.githubusercontent.com/71436576/126341410-5f5b0332-83f3-4146-8a59-be7101b0e73b.png" width="50%" height="50%">

  + (2) 방향 그래프(weighted)
    + `진입 차수(in-degree)` : 외부에서 오는 간선의 개수
    + `진출 차수(out-degree)` : 외부로 향하는 간선의 개수
       
#### 3) 그래프 용어
  + `adjacent` : 두 개의 정점이 엣지로 연결된 경우
    + 완전 그래프에 속한 임의의 두 정점들은 모두 인접해 있음!
    + `incident` : 같은 경우 엣지의 관점에서, 두 정점에 부속(incident)되었다고 함
  + `degree` : 해당 노드에 연결된 엣지의 수(혹은 엣지 가중치의 합)
  + `subgraph` : G=(V,E)가 주어졌을 때 다음을 만족하는 G′=(V′,E′)
    + E′ 는 V′에만 부속(=V′에 속한 모든 엣지가 G′에 있어야 함)되어 있으며 E의 부분집합
    + V′는 V의 부분집합
  + `Spanning tree` : 최소 edge로 모든 정점을 연결한 그래프
    + 트리의 특수한 형태이므로 **모든 정점들이 연결** 되어 있어야 하고, 2)**사이클을 포함해서는 안됌**
    + 그래프에 있는 n개의 정점을 정확히 (n-1)개의 간선으로 연결
    + 여러 개가 존재함

  + `연결 성분` : 연결된( 더 이상 확장 불가능)subgraph의 최대치
 
#### 4) 그래프 표현
> 인접 행렬(Adjacent matrix)
  + **두 정점을 연결하는 간선의 유무**를 행렬 형태로 표현
    + 두 정점이 인접 : 1, 인접 X : 0 으로 표현
  + |V| * |V| 크기의 2차원 리스트 이용하여 간선 정보 저장
    
<image src = "https://user-images.githubusercontent.com/71436576/126507515-d0c5cf61-e753-43b4-b561-2d11ebca9061.png" width="50%" height="50%">

  + 장점: 한 번의 배열 접근만으로 정점의 번호 u,v사이의 간선이 있는지 여부 확인 가능
  + 단점: 항상 O(∣V∣ ^2)크기의 공간을 사용함
  + `밀집 그래프(dense graph)`: 간선의 수가 ∣V∣^2에 비례하는 그래프 → 인접 행렬 사용
  
> 인접 리스트(Adjacent list)

  + 각 정점마다 인접 정점으로 나가는 간선 정보 저장
  + **각각의 정점에 인접한 정점**들을 연결 리스트로 표현
 
 <image src = "https://user-images.githubusercontent.com/71436576/126507429-f335c435-e2e0-4dbc-88c4-4e1de1b9ec8c.png" width="50%" height="50%">
     
  + 장점: 실제 간선 수만큼의 원소 O(∣V∣+∣E∣)의 공간만을 사용, 인접한 노드에 어떤것이 있는지 알기 쉬움
  + 단점: 정점의 번호 u,v사이의 간선이 있는지 여부를 연결리스트 adjacent[u]를 처음부터 일일이 확인해야함
  + 희소 그래프(sparse graph): 간선의 수가 ∣V∣^2 에 비해 훨씬 적은 그래프 → 인접 리스트 사용

## Graph 탐색(1) DFS

#### DFS(깊이 우선 탐색)정의
+ '더 나아갈 길이 보이지 않을 때까지 깊이 들어간다'를 원칙으로 그래프 내의 정점을 방문하는 알고리즘 
1) 시작 정점에서 한 방향을 택해 이미 방문했던 정점이 아니면 반복해서 깊이 들어감
2) 더 이상 방문해왔던 정점 말고는 다른 이웃을 갖고 있지 않은 정점을 만나면, 뒤로 돌아와 다른 경로로 뻗어있는 정점을 타고 방문을 재개
  
<image src = "https://user-images.githubusercontent.com/71436576/126510519-9b4bcbe8-db4b-4232-9d4e-889e6384ee8e.png" width="50%" height="50%">

#### DFS 특징
:heavy_check_mark: 자기 자신을 호출하는 순환 알고리즘(재귀)</br>
:heavy_check_mark: 모든 노드를 방문하고자 하는 경우에 이 방법을 선택! (완전 탐색 알고리즘에 자주 이용됨)</br>
:heavy_check_mark: 그래프 탐색시, 노드의 방문 여부를 반드시 검사해야함(무한 루프에 빠질 위험이 있음)
  
#### DFS 구현
> 재귀(순환 호출) 이용
  ```java
  public static void dfs(int v) { 
		if(visit[v]) {return;}    //이미 방문한 노드는 건너뛰기
		
		visit[v] = true;          //노드 방문 표시
		
		for(int node : graph[v]) {     //인접한 모든 노드에 대해 재귀
			dfs1(node);		
		}
	}
 ``` 
> 명시적 스택 사용

## Graph 탐색(2) BFS

#### BFS(넓이 우선 탐색)정의
+ 루트 노드(혹은 다른 임의의 노드)에서 시작한 인접 노드를 먼저 탐색하는 알고리즘
+ 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법 => 깊게 X(deep), 넓게(wide) 탐색

<image src = "https://user-images.githubusercontent.com/71436576/126510793-6895c88f-1a25-4df9-8cad-28574558d7ca.png" width="50%" height="50%">

#### BFS 특징
:heavy_check_mark: 재귀의 형태가 아니며, 선입선출 원칙의 큐를 사용</br>
:heavy_check_mark: 그래프 탐색시, 노드의 방문 여부를 반드시 검사해야함</br>
:heavy_check_mark: 두 노드 사이의 **최단 경로 / 임의의 경로**를 찾고 싶을 때 사용</br>

```
ex) 지구 상에 존재하는 모든 친구 관계를 그래프로 표현한 후 A와 B 사이에 존재하는 경로를 찾는 경우
DFS의 경우 - 모든 친구 관계를 다 살펴봐야 할지도 모른다.
BFS의 경우 - A와 가까운 관계부터 탐색한다.
```

> :star2: **BFS 이용한 최단 경로 찾기**(BOJ 미로탐색)
 + DFS 보다 BFS를 이용하여 최단 경로를 찾으면, 도착 지점에 도달하는 순간 최단 경로를 알 수 있기 때문에!
   + 반면 DFS는 모든 경로를 검색해봐야 함..
 + 가장 중요한 것은 **현재 단계의 칸수 + 1** 로 나아가는 것
   + 잘못된 길이여도 q.pop()을 통해 갈림길로 되돌아오며, 거기서부터 다시 +1 해나가다가 도착 지점에서의 return값이 최소값이 됌
   + **dist[nx][ny] = dist[x][y] + 1**


#### BFS 구현

> 큐 이용

 ```java
 public static void bfs(int v) {      
		
    queue.offer(v);             //큐에 시작 정점 추가
    visit[v] = true;
		
    while(!queue.isEmpty()) {    
	int n = queue.poll();    
		
	for(int node : graph[n]) {   //인접한 모든 정점 큐에 추가
		if(!visit[node]){
		  queue.add(node);  
		  visit[node] = true;           //큐 삽입시 노드 방문 표시
		}    
       }
    }	
    return;
}
 ```
#### 응용 
:pencil2: 아래의 두가지를 동시에 사용하지 않도록 주의(둘다 같은 것임)!</br>
  + 어떤 점을 방문 했음을 저장하기 위한 bool 배열(boolean check[])
  + 어떤 점까지의 최단 거리를 저장하기 위한 int 배열(dist[])
  
> 1)방문 여부만 알고 싶을 때 (거리 구할 필요없음!)
```java
boolean check[max_int];

// 방문했을때
if(!check[next]){
  check[next] = true;
}
```

> 2) 정점까지의 거리가 필요할때
```java
int check[max_int];

// 초기화
// BFS에서 최단 거리가 음수가 나올 수 없기 때문에 -1로 초기화
for(int i=0; i<=n; i++) check[i] = -1;

// 방문했을때
if(check[next] == -1){
  check[next] = check[node] + 1;
}
```
  + 어떤 정점(node)의 check[node] 가 -1 이라면, 그 정점은 아직 방문하지 않은 정점이됌(이걸로 boolean처럼 판별 가능)
## Disjoint Set
 + `서로소 집합(Disjoint Set)` : 상호 배타적으로 이루어진 집합(서로소 집합 : 공통 원소가 없는 두 집합)을 효율적으로 표현하기 위해 만들어진 자료구조
  + 서로소 집합은, 대상 원소가 각각 어떤 집합에 포함되어 있는지 번호를 주어 표시

### Make-Set
 + 대상 원소들을 우선 모두 각각 독립된 집합으로 분리하는 과정
 + 자기 자신이 가리키는 대상 = 자신이 속한 집합 = Parent(부모)
 <img src="https://user-images.githubusercontent.com/71436576/128872968-869ef3ef-792b-4dc3-852d-7bad3154faaa.png" width=50% height=50%>
 
 ```java
    for(int i = 1 ; i <=n ; i++) {
        parent[i]= i;
    }
```

### Union
 + 서로소 집합을 하나의 집합으로 합쳐주는 연산
 + 두 원소가 모두 **같은 부모(parent)를 가리키도록 값을 변경**해주면 됌
   + 이 경우, 보통 두 원소중 **작은 값**을 기준으로 가리키는 부모를 통일 시켜줌
   
<img src= "https://user-images.githubusercontent.com/71436576/128874394-4606aa0a-5f91-4cfc-8752-3549a2e565a6.png" width=50% height=50%>

```java
public static void union(int a, int b) {     //합치기
	a = find_Set(a);      //해당 속하는 집합의 부모 찾기(상위 부모)
	b = find_Set(b);
	
	//b의 수가 더 크면 b의 부모 아래 a 합치기(높이가 낮은 트리가 높은 트리 아래 합쳐짐)
	if(a < b) { parent[b] = a;}
	else { parent[a] = b;}
}

```
 
### Find-Set
 + 집합의 원소가 어떤 집합에 속해 있는지(부모가 누구인지)판단하는 연산
 
 1) 찾는 대상과 인덱스 번호가 같은 경우, 그 인덱스(=노드)가 해당 집합의 부모</br>
 2) 그렇지 않다면, 해당 인덱스가 가리키는 값(부모 노드)을 따라 최종 부모노드까지 재귀적으로 탐색</br>
 
```java

public static int find_Set(int n) {    //원소의 집합 대표(부모) 찾기 
	if(n == parent[n]) 
		return n;
	return parent[n] = find_Set(parent[n]);   //상위노드로 계속 올라가기
}

```

> 알고리즘 문제 풀이시 주의점
+ parent 배열은 '각 원소의 부모'를 나타내는 것일 뿐, 각 원소가 실제로 어떤 집합에 속해있는지를 표현해주지 X
  + 각 원소가 어떤 집합에 속해있는지를 파악하기 위해서는 반드시 Find 연산을 사용
  
# Graph 활용(1)_ MST

## Minimum Spanning Tree
 + `Minimum Spanning Tree` : Spanning Tree 중에서 사용된 간선들의 **가중치 합이 최소**인 트리
   + n개의 정점을 가지는 그래프에 대해 반드시 (n-1)개의 간선만을 사용해야 함
   + **사이클이 포함되어서는 안됌**
 + 최소 신장 트리는 프림, 크루스칼 알고리즘으로 구현 

## Prim Algorithm(MST)
+ 하나의 시작점을 잡고, **시작점과 연결된 정점들에 대해 가장 가중치가 작은 간선부터 연결**해주면서 MST를 만들어나가는 알고리즘
   + :pencil2: 연결하는 도중 **사이클이 생기게 된다면 가중치가 작은 간선이어도 무시**하여야함!
+ **정점** 선택 기반 

### :pushpin: 알고리즘 과정
 + 시작 정점을 spanning tree 집합에 추가
 + 앞 단계에서 만들어진 MST 집합에 인접한 정점들 중에서, 최소 간선으로 연결된 정점을 선택하여 트리를 확장
   + 즉, 가장 낮은 가중치를 먼저 선택
 + 이 과정을 간선이 n-1개가 되도록 반복
 
<img src="https://user-images.githubusercontent.com/71436576/128868995-6d9ac5ab-1be5-4523-b716-a4da08eff883.png" width=50% height=50%>


> 구현 코드 1(우선순위 큐 사용)
```java
PriorityQueue<Edge> pq = new PriorityQueue<>();    //우선 순위 큐

public static void prim() {
	    pq.add(new Edge(1, 0));     //시작 정점 추가
	    int count = 0;
		
	    while(!pq.isEmpty()) { 
	        Edge e = pq.poll(); 
			
		if(visit[e.v]) {continue;}     //방문했다면 패스
		
		visit[e.v] = true;  
		cnt+= e.w;               //현재 가중치(거리) 합산
		
		for(Edge next : graph.get(e.v)) {     //모든 인접 노드들에 대해서 방문하지 않았다면, 큐에 추가
		     if(!visit[next.v]) { pq.add(next);}
		}
		if(++count == v1) {break;}        //모든 정점을 순회하였다면 종료
	    }
	    System.out.println(cnt);
}
```
> 구현 코드 2(우선순위 큐 사용 X)



✔️ 언제 사용하면 좋을까?</br>
 + 시간 복잡도 : `O(ElgV)`
 + 따라서 **간선의 개수**가 많은 경우 사용


## Kruskal Algorithm(MST)
 + 모든 간선에 대해, **가장 가중치가 작은 간선**부터 연결해주면서 MST를 만들어 나가는 알고리즘
   + :pencil2: 연결하는 도중 **사이클이 생기게 된다면 가중치가 작은 간선이어도 무시**하여야함!
 + MST 를 찾기 위해서 **greedy 하게 접근**하는 알고리즘(비용이 가장 적은 간선 선택)
 + **간선** 선택 기반

### :pushpin: 알고리즘 과정
 + 우선 비용이 낮은 간선부터 선택해야 하니, 그래프를 가중치의 오름차순으로 정렬
 + 정렬된 간선 순서대로 선택하면서, 간선의 양 끝 정점을 Union 함 => **상호 베타 집합** 활용!
   + 단, 이때 선택된 두 정점이 같은 집합에 속해있다면 사이클(cycle)이 있다고 판단하고 포함시키지 X

 
> 구현 코드



✔️ 언제 사용하면 좋을까?</br>
 + 시간 복잡도 : `O(ElgV)`
 + 따라서 간선의 개수가 적은 경우 사용

# Graph 활용(2)_ 최단 경로 탐색
 + `최단 경로 알고리즘` : 가장 짧은 경로를 찾는 알고리즘
 + 다양한 문제 상황:
   + 한 지점에서 다른 한 지점까지의 최단 경로
   + 한 지점에서 다른 모든 지점까지의 최단 경로
   + 모든 지점에서 다른 모든 지점까지의 최단 경로
  
## Dijkstra Algorithm(최단 경로 탐색)
 + `다익스트라`: 특정한 노드에서 출발하여 **다른 모든 노드로 가는 최단 경로**를 계산하는 알고리즘
 + 음의 간선이 없을 때 정상적으로 동작
 + Greedy 알고리즘과 유사
   + 매 상황에서 가장 비용이 적은 노드를 선택해 임의의 과정을 반복

## BellmanFord Algorithm(최단 경로 탐색)
