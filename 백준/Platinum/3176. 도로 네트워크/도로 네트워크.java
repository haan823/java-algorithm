import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int k;
    public static List<int[]>[] adj;
    public static int[] depth;
    public static int[][] sparse;
    public static int[][] mn;
    public static int[][] mx;
    public static int root = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        depth = new int[n + 1];
        sparse = new int[n + 1][20];
        sparse[root][0] = root;
        mn = new int[n + 1][20];
        mx = new int[n + 1][20];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new int[]{b, c});
            adj[b].add(new int[]{a, c});
        }
        dfs(1, -1, 0);
        for (int j = 1; j < 20; j++) {
            for (int i = 1; i < n + 1; i++) {
                sparse[i][j] = sparse[sparse[i][j - 1]][j - 1];
                if (mn[sparse[i][j - 1]][j - 1] != 0) {
                    mn[i][j] = Math.min(mn[i][j - 1], mn[sparse[i][j - 1]][j - 1]);
                }
                mx[i][j] = Math.max(mx[i][j - 1], mx[sparse[i][j - 1]][j - 1]);
            }
        }
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int minVal = Integer.MAX_VALUE;
            int maxVal = 0;
            if (depth[a] > depth[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            for (int j = 19; j >= 0; j--) {
                int jump = 1 << j;
                if (depth[b] - depth[a] >= jump) {
                    minVal = Math.min(minVal, mn[b][j]);
                    maxVal = Math.max(maxVal, mx[b][j]);
                    b = sparse[b][j];
                }
            }
            if (a != b) {
                for (int j = 19; j >= 0; j--) {
                    if (sparse[a][j] == sparse[b][j]) {
                        continue;
                    }
                    minVal = Math.min(minVal, mn[a][j]);
                    maxVal = Math.max(maxVal, mx[a][j]);
                    minVal = Math.min(minVal, mn[b][j]);
                    maxVal = Math.max(maxVal, mx[b][j]);
                    a = sparse[a][j];
                    b = sparse[b][j];
                }
                minVal = Math.min(minVal, mn[a][0]);
                maxVal = Math.max(maxVal, mx[a][0]);
                minVal = Math.min(minVal, mn[b][0]);
                maxVal = Math.max(maxVal, mx[b][0]);
            }
            bw.write(minVal + " " + maxVal);
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int cur, int prv, int d) {
        depth[cur] = d;
        for (int i = 0; i < adj[cur].size(); i++) {
            int nxt = adj[cur].get(i)[0];
            int dist = adj[cur].get(i)[1];
            if (nxt == prv) {
                continue;
            }
            sparse[nxt][0] = cur;
            mn[nxt][0] = dist;
            mx[nxt][0] = dist;
            dfs(nxt, cur, d + 1);
        }
    }

}