import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[] par;
    public static int[] rnk;
    public static int[] sz; //서브트리 사이즈
    public static int[] edge; //서브트리 총 간선 개수
    public static boolean[] visited;
    public static Map<Edge, Integer> map = new HashMap<>();

    public static class Edge{
        public Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return x == edge.x && y == edge.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        par = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            par[i] = i;
        }
        rnk = new int[n + 1];
        edge = new int[n + 1];
        sz = new int[n + 1];
        Arrays.fill(sz, 1);
        visited = new boolean[n + 1];
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(new Edge(a, b), 0);
        }
        for (Edge e : map.keySet()) {
            int a = e.x;
            int b = e.y;
            if (map.containsKey(new Edge(b, a))) {
                map.put(e, 1);
                edge[a]++;
            } else {
                visited[b] = true;
            }
        }
        for (Edge e : map.keySet()) {
            if (map.get(e) == 1) {
                union(e.x, e.y);
            }
        }
        boolean flag = true;
        for (int i = 1; i < n + 1; i++) {
            int x = find(i);
            if (edge[x] == 2 * sz[x] - 2 && !visited[x]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return;
        }
        if (rnk[x] < rnk[y]) {
            par[x] = y;
            sz[y] += sz[x];
            edge[y] += edge[x];
            visited[y] |= visited[x];
        } else if (rnk[x] > rnk[y]) {
            par[y] = x;
            sz[x] += sz[y];
            edge[x] += edge[y];
            visited[x] |= visited[y];
        } else {
            par[x] = y;
            rnk[y]++;
            sz[y] += sz[x];
            edge[y] += edge[x];
            visited[y] |= visited[x];
        }
    }
}