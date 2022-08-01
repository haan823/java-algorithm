package thisiscodingtest.baekjoon.dijkstra.p1753;

import java.io.*;
import java.util.*;

public class Main {

    public static int v;
    public static int e;
    public static List<int[]>[] adj;
    public static int s;
    public static int[] dist;
    public static int[] result;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(br.readLine());
        adj = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        dist = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{c, b});
        }
        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        pq.add(new int[]{0, s});
        while (!pq.isEmpty()) {
            int d = pq.peek()[0];
            int cur = pq.peek()[1];
            pq.poll();

            if (visited[cur]) {
                continue;
            }

            visited[cur] = true;

            for (int i = 0; i < adj[cur].size(); i++) {
                int nxt = adj[cur].get(i)[1];
                int nd = dist[cur] + adj[cur].get(i)[0];

                if (dist[nxt] > nd) {
                    dist[nxt] = nd;
                    pq.add(new int[]{nd, nxt});
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                bw.write("INF");
                bw.newLine();
            } else {
                bw.write(String.valueOf(dist[i]));
                bw.newLine();
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}