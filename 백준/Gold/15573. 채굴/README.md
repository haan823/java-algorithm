# [Gold III] 채굴 - 15573 

[문제 링크](https://www.acmicpc.net/problem/15573) 

### 성능 요약

메모리: 310740 KB, 시간: 1612 ms

### 분류

너비 우선 탐색(bfs), 이분 탐색(binary_search), 자료 구조(data_structures), 깊이 우선 탐색(dfs), 그래프 이론(graphs), 그래프 탐색(graph_traversal), 매개 변수 탐색(parametric_search)

### 문제 설명

<p>땅 위에 놓여있는 세로 <em>N</em>, 가로 <em>M</em> 길이의 광산에 1 × 1 광물 <em>N</em> × <em>M</em>개가 있으며, 각 광물은 고유의 강도<em>S</em><sub><em>i</em>, <em>j</em></sub>를 가진다.</p>

<p style="text-align:center"><br>
<img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/15573/1.png" style="height:139px; width:200px"></p>

<p>채굴기를 이용하여 이 광물들을 채굴하려고 한다. 채굴기는 공기와 맞닿아 있는 광물 하나를 골라 채굴할 수 있다. 바닥과 광물과만 맞닿아 있으면 채굴할 수 없다. 채굴기의 성능 <em>D</em>에 대해, 채굴기는 강도가 <em>D</em> 이하인 광물들만 채굴할 수 있다. 원하는 광물의 수 <em>K</em> 이상을 채굴할 수 있는 최소의 <em>D</em>를 구하여라.</p>

### 입력 

 <p>첫째 줄에 <em>N</em>, <em>M</em>, <em>K</em>가 주어진다. (1 ≤ <em>N</em>, <em>M</em> ≤ 1000, 1 ≤ <em>K</em> ≤ <em>N</em> × <em>M</em>) 둘째 줄부터 맨 위의 광물들부터 순서대로 <em>N</em>줄 동안 <em>M</em>개의 광물의 강도 <em>S</em><sub><em>i</em>, <em>j</em></sub>가 주어진다.(<em>i</em> = 1, 2, ..., <em>N</em>, <em>j</em> = 1, 2, ..., <em>M</em>) (1 ≤ <em>S</em><sub><em>i</em>, <em>j</em></sub> ≤ 10<sup>6</sup>)</p>

### 출력 

 <p><em>K</em>개 이상의 광물을 채굴할 수 있는 최소의 <em>D</em>를 구하여라.</p>

