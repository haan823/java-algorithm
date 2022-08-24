import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int v, e;
    public static List<int[]>[] usedAdj;
    public static int sum;
    public static int result;
    public static int[] par;
    public static int[] depth;
    public static int[] parDistance;
    public static List<int[]> list = new ArrayList<>();
    ;
    public static boolean[] used;
    public static int gap = Integer.MAX_VALUE;
    public static int[][] sparse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        usedAdj = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            usedAdj[i] = new ArrayList<>();
        }
        par = new int[v + 1];
        depth = new int[v + 1];
        parDistance = new int[v + 1];
        sparse = new int[v + 1][20];
        for (int i = 0; i < v + 1; i++) {
            par[i] = i;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b, c});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        if (findMST()) {
            dfs(1, -1, 1);
            makeSparseTable();
            if (findSMST()) {
                bw.write(String.valueOf(result + gap));
            } else {
                bw.write("-1");
            }
        } else {
            bw.write("-1");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void makeSparseTable() {
        sparse[1][0] = 1;
        for (int p = 1; p < 20; p++) {
            for (int cur = 1; cur < v + 1; cur++) {
                sparse[cur][p] = sparse[sparse[cur][p - 1]][p - 1];
            }
        }
    }

    private static void dfs(int cur, int prv, int d) {
        for (int i = 0; i < usedAdj[cur].size(); i++) {
            int nxt = usedAdj[cur].get(i)[0];
            if (nxt == prv) {
                continue;
            }
            depth[nxt] = d;
            sparse[nxt][0] = cur;
            parDistance[nxt] = usedAdj[cur].get(i)[1];
            dfs(nxt, cur, d + 1);
        }
    }

    private static boolean findMST() {
        used = new boolean[list.size()];
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i)[0];
            int b = list.get(i)[1];
            int c = list.get(i)[2];
            if (find(a) == find(b)) {
                continue;
            }
            usedAdj[a].add(new int[]{b, c});
            usedAdj[b].add(new int[]{a, c});
            used[i] = true;
            cnt++;
            union(a, b);
            result += c;
        }
        if (cnt != v - 1) {
            return false;
        }
        return true;
    }

    private static int lca(int x, int y) {
        if (depth[x] > depth[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        for (int i = 19; i >= 0; i--) {
            int jump = 1 << i;
            if (depth[y] - depth[x] >= jump) {
                y = sparse[y][i];
            }
        }
        if (x == y) {
            return x;
        }
        for (int i = 19; i >= 0; i--) {
            if (sparse[x][i] == sparse[y][i]) {
                continue;
            }
            x = sparse[x][i];
            y = sparse[y][i];
        }
        return sparse[x][0];
    }

    private static boolean findSMST() {
        for (int i = 0; i < list.size(); i++) {
            if (!used[i]) {
                int a = list.get(i)[0];
                int b = list.get(i)[1];
                int c = list.get(i)[2];
                int tmp = lca(a, b);
                int maxCost = Integer.MIN_VALUE;
                while (true) {
                    if (a == tmp) {
                        break;
                    }
                    if (parDistance[a] < c && parDistance[a] > maxCost) {
                        maxCost = parDistance[a];
                    }
                    a = sparse[a][0];
                }
                while (true) {
                    if (b == tmp) {
                        break;
                    }
                    if (parDistance[b] < c && parDistance[b] > maxCost) {
                        maxCost = parDistance[b];
                    }
                    b = sparse[b][0];
                }
                if (maxCost != Integer.MIN_VALUE) {
                    gap = Math.min(gap, c - maxCost);
                }
            }
        }
        if (gap == 0 || gap == Integer.MAX_VALUE) {
            return false;
        }
        return true;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        par[a] = b;
    }

    private static int find(int a) {
        if (par[a] == a) {
            return a;
        }
        return par[a] = find(par[a]);
    }
}