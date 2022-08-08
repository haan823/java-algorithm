import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] array;
    public static int[] size;
    public static int[][] par;
    public static int[] depth;
    public static List<Integer>[] list;
    public static int[] idx;
    public static int result = 0;
    public static int maxVal = -1;
    public static int root = 1;
    public static List<Integer> order = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        array = new int[n + 1][2];
        size = new int[n + 1];
        par = new int[n + 1][2];
        depth = new int[n + 1];
        idx = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            array[a][0] = b;
            array[a][1] = c;
            if (b != -1) {
                par[b][0] = a;
                par[b][1] = 0;
            }
            if (c != -1) {
                par[c][0] = a;
                par[c][1] = 1;
            }
        }
        while (true) {
            if (par[root][0] != 0) {
                root = par[root][0];
            } else {
                break;
            }
        }
        dfs(root, 1);
        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        idx[root] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int i = q.poll();
            if (par[i][1] == 0) {
                int childSize = 0;
                if (array[i][1] != -1) {
                    childSize = size[array[i][1]];
                }
                idx[i] = idx[par[i][0]] - childSize - 1;
            } else {
                int childSize = 0;
                if (array[i][0] != -1) {
                    childSize = size[array[i][0]];
                }
                idx[i] = idx[par[i][0]] + childSize + 1;
            }
            for (int j = 0; j < 2; j++) {
                int nxt = array[i][j];
                if (nxt != -1) {
                    q.add(nxt);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            list[depth[i]].add(idx[i]);
        }

        for (int i = 1; i < list.length; i++) {
            if (list[i].size() != 0) {
                Collections.sort(list[i]);
                int mn = list[i].get(0);
                int mx = list[i].get(list[i].size() - 1);
                if (mx - mn > maxVal) {
                    result = i + 1;
                    maxVal = mx - mn;
                }
            }
        }
        bw.write((result - 1) + " " + (maxVal + 1));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int cur, int d) {
        depth[cur] = d;
        if (array[cur][0] != -1) {
            dfs(array[cur][0], d + 1);
            size[cur] += size[array[cur][0]];
        }
        if (array[cur][1] != -1) {
            dfs(array[cur][1], d + 1);
            size[cur] += size[array[cur][1]];
        }
    }
}