package thisiscodingtest.baekjoon.dijkstra.p13549;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int k;
    public static int[] dist;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        for (int i = 0; i < 100001; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[100001];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        pq.add(new int[]{n, 0});
        dist[n] = 0;
        while (!pq.isEmpty()) {
            int cur = pq.peek()[0];
            int d = pq.peek()[1];
            pq.poll();
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            int nxt = cur + 1;
            int nd = dist[cur] + 1;
            if (nxt < 100001 && nxt >= 0 && dist[nxt] > nd) {
                dist[nxt] = nd;
                pq.add(new int[]{nxt, nd});
            }
            nxt = cur - 1;
            nd = dist[cur] + 1;
            if (nxt < 100001 && nxt >= 0 && dist[nxt] > nd) {
                dist[nxt] = nd;
                pq.add(new int[]{nxt, nd});
            }
            nxt = cur * 2;
            nd = dist[cur];
            if (nxt < 100001 && nxt >= 0 && dist[nxt] > nd) {
                dist[nxt] = nd;
                pq.add(new int[]{nxt, nd});
            }
        }
        bw.write(String.valueOf(dist[k]));
        bw.flush();
        br.close();
        bw.close();
    }
}
