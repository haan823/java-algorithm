import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static int[][] sparse;
    public static long[] dist;
    public static int[] depth;
    public static List<int[]>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        sparse = new int[n + 1][20];
        adj = new ArrayList[n + 1];
        dist = new long[n + 1];
        depth = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            sparse[i][0] = i;
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b, c});
            adj[b].add(new int[]{a, c});
        }
        dfs(1, -1, 0, 0);
        for (int j = 1; j < 20; j++) {
            for (int i = 1; i < n + 1; i++) {
                sparse[i][j] = sparse[sparse[i][j - 1]][j - 1];
            }
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            if (q == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int l = lca(a, b);
                bw.write(String.valueOf(dist[a] - dist[l] + dist[b] - dist[l]));
                bw.newLine();
            } else if (q == 2) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int l = lca(a, b);
                if (depth[a] - depth[l] + 1 >= c) {
                    bw.write(String.valueOf(find(a, c)));
                    bw.newLine();
                } else {
                    c = depth[a] - depth[l] + depth[b] - depth[l] + 1 + 1 - c;
                    bw.write(String.valueOf(find(b, c)));
                    bw.newLine();
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int find(int a, int c) {
        if (c == 1) {
            return a;
        }
        c--;
        for (int i = 19; i >= 0; i--) {
            int jump = 1 << i;
            if (jump <= c) {
                a = sparse[a][i];
                c -= jump;
            }
        }
        return a;
    }

    private static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        for (int i = 19; i >= 0; i--) {
            int jump = 1 << i;
            if (depth[b] - depth[a] >= jump) {
                b = sparse[b][i];
            }
        }
        if (a == b) {
            return a;
        }
        for (int i = 19; i >= 0; i--) {
            if (sparse[a][i] != sparse[b][i]) {
                a = sparse[a][i];
                b = sparse[b][i];
            }
        }
        return sparse[a][0];
    }

    private static void dfs(int cur, int prv, long d, int dep) {
        dist[cur] = d;
        depth[cur] = dep;
        for (int i = 0; i < adj[cur].size(); i++) {
            int nxt = adj[cur].get(i)[0];
            int nd = adj[cur].get(i)[1];
            if (nxt == prv) {
                continue;
            }
            sparse[nxt][0] = cur;
            dfs(nxt, cur, d + (long)nd, dep + 1);
        }
    }
}