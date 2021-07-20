# Graph

## Graph 정의

#### 1) 그래프란?
  + `Graph ` : 객체 간 연결 관계 표현
  +  G = (V,E)
    + `V(vertex)` : 정점들의 집합
    + `E(edge)` : 정점을 연결하는 간선들의 집합
  > |V|개 그래프에는 최대 |V|(|V|-1) / 2 개의 간선 가능
  + 선형과 트리 자료구조로 표현하기 어려운, N : N 관계의 객체 표현 용이
  
  ![SYsNnEB](https://user-images.githubusercontent.com/71436576/126340242-9e719b1f-7c74-4fbf-b92e-38d36b83946c.png){: width="50%" height="50%"}
  
#### 2) 그래프의 종류
  + (1) 무방향 그래프(undirected)
    + `Sparse Graph(희소)` : vertex의 수보다 edge의 수가 적은 그래프, O(N)
    + `Dense Graph(밀집)` : vertex의 수보다 edge수가 많은 그래프, O(N^2)
    + `Complete Graph(완전)` : 모든 정점들이 edge로 연결되어 있는 그래프, O(N^2)
  ![image](https://user-images.githubusercontent.com/71436576/126341410-5f5b0332-83f3-4146-8a59-be7101b0e73b.png){: width="50%" height="50%"}
  + (2) 방향 그래프(weighted)

#### 그래프 용어
+ `adjacent` : 두 개의 정점이 엣지로 연결된 경우
    + 완전 그래프에 속한 임의의 두 정점들은 모두 인접해 있음!
    + `incident` : 같은 경우 엣지의 관점에서, 두 정점에 부속(incident)되었다고 함
+ `degree` : 해당 노드에 연결된 엣지의 수(혹은 엣지 가중치의 합)
+ `subgraph` : G=(V,E)가 주어졌을 때 다음을 만족하는 G′=(V′,E′)
    + E′ 는 V′에만 부속(=V′에 속한 모든 엣지가 G′에 있어야 함)되어 있으며 E의 부분집합
    + V′는 V의 부분집합
+ `Spanning tree` : 최소 edge로 모든 정점을 연결한 그래프
## Graph 탐색(1) DFS

## Graph 탐색(2) BFS

## 상호 베타 집합

# Graph 활용_최소 비용

## Minimum Spanning Tree

## Prim Algorithm

## Kruskal Algorithm

## Dijkstra Algorithm
