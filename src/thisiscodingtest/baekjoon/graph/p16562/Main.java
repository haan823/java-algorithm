package thisiscodingtest.baekjoon.graph.p16562;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static int[] cost;
    public static ArrayList<Integer>[] v = new ArrayList[10001];
    public static boolean[] visited = new boolean[10001];
    public static int minVal = Integer.MAX_VALUE;
    public static int sum;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < v.length; i++) {
            v[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v[a].add(b);
            v[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            minVal = Integer.MAX_VALUE;
            if (!visited[i]) {
                dfs(i);
            }
            if (minVal != Integer.MAX_VALUE) {
                sum += minVal;
            }
        }
        if (cnt != n || sum > k) {
            bw.write("Oh no");
        } else {
            bw.write(String.valueOf(sum));
        }
        bw.flush();
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        cnt++;
        minVal = Math.min(cost[cur], minVal);
        for (int i = 0; i < v[cur].size(); i++) {
            if (!visited[v[cur].get(i)]) {
                dfs(v[cur].get(i));
            }
        }
    }
}
