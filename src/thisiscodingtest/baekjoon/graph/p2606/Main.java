package thisiscodingtest.baekjoon.graph.p2606;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static ArrayList<Integer>[] v = new ArrayList[101];
    public static boolean[] visited = new boolean[101];
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < v.length; i++) {
            v[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            v[a].add(b);
            v[b].add(a);
        }
        dfs(1);
        bw.write(String.valueOf(cnt - 1));
        bw.flush();
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        cnt++;
        for (int i = 0; i < v[cur].size(); i++) {
            if (!visited[v[cur].get(i)]) {
                dfs(v[cur].get(i));
            }
        }

    }
}