package thisiscodingtest.baekjoon.dijkstra.p1504;

import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int e;
    public static List<int[]>[] adj;
    public static int[] dist;
    public static int x;
    public static int y;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b, c});
            adj[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int minVal = Integer.MAX_VALUE;
        int xToY = check(x, y);
        int toX = check(1, x);
        int toY = check(1, y);
        int xToN = check(x, n);
        int yToN = check(y, n);

        if (toX != Integer.MAX_VALUE && xToY != Integer.MAX_VALUE && yToN != Integer.MAX_VALUE) {
            minVal = Math.min(minVal, toX + xToY + yToN);
        }
        if (toY != Integer.MAX_VALUE && xToY != Integer.MAX_VALUE && xToN != Integer.MAX_VALUE) {
            minVal = Math.min(minVal, toY + xToY + xToN);
        }

        if (minVal == Integer.MAX_VALUE) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(minVal));
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int check(int s, int e) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        pq.add(new int[]{s, 0});
        dist[s] = 0;
        while (!pq.isEmpty()) {
            int d = pq.peek()[1];
            int cur = pq.peek()[0];
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