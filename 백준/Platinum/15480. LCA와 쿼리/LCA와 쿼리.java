import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int[][] sparse;
    public static int[] depth;
    public static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        sparse = new int[n + 1][20];
        adj = new ArrayList[n + 1];
        depth = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            sparse[i][0] = i;
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(1, -1, 0);
        for (int j = 1; j < 20; j++) {
            for (int i = 1; i < n + 1; i++) {
                sparse[i][j] = sparse[sparse[i][j - 1]][j - 1];
            }
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            LinkedList<Integer> list = new LinkedList<>();
            list.add(lca(a, b));
            list.add(lca(b, c));
            list.add(lca(c, a));
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return depth[o1] - depth[o2];
                }
            });
            bw.write(String.valueOf(list.getLast()));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
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

    private static void dfs(int cur, int prv, int dep) {
        depth[cur] = dep;
        for (int i = 0; i < adj[cur].size(); i++) {
            int nxt = adj[cur].get(i);
            if (nxt == prv) {
                continue;
            }
            sparse[nxt][0] = cur;
            dfs(nxt, cur, dep + 1);
        }
    }
}