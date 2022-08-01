package thisiscodingtest.baekjoon.dijkstra.p1238;

import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int x;
    public static List<int[]>[] adj;
    public static int[] dist;
    public static boolean[] visited;
    public static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b, c});
        }


        for (int i = 1; i <= n; i++) {
            int sum = dijkstra(i, x) + dijkstra(x, i);
            if (sum > maxVal) {
                maxVal = sum;
            }
        }
        bw.write(String.valueOf(maxVal));
        bw.flush();
        br.close();
        bw.close();
    }

    public static int dijkstra(int s, int e) {
        dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{s, 0});
        dist[s] = 0;
        while (!pq.isEmpty()) {
            int cur = pq.peek()[0];
            int d = pq.peek()[1];
            pq.poll();
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for (int i = 0; i < adj[cur].size(); i++) {
                int nxt = adj[cur].get(i)[0];
                int nd = dist[cur] + adj[cur].get(i)[1];
                if (dist[nxt] > nd) {
                    dist[nxt] = nd;
                    pq.add(new int[]{nxt, nd});
                }
            }
        }
        return dist[e];
    }
}