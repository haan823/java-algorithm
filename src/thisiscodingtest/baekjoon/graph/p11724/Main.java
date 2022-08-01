package thisiscodingtest.baekjoon.graph.p11724;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] v = new ArrayList[1001];
    static boolean[] visited = new boolean[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
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
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            cnt++;
            dfs(i);
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        for (int i = 0; i < v[cur].size(); i++) {
            if (!visited[v[cur].get(i)]) {
                dfs(v[cur].get(i));
            }
        }
    }
}