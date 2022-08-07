import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static ArrayList<int[]>[] adj;
    public static int minDist = -1;
    public static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
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
        dfs(1, -1, 0);
        dfs(idx, -1, 0);
        bw.write(String.valueOf(minDist));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int cur, int prv, int dist) {
        if (dist > minDist) {
            minDist = dist;
            idx = cur;
        }
        for (int i = 0; i < adj[cur].size(); i++) {
            if (adj[cur].get(i)[0] == prv) {
                continue;
            }
            dfs(adj[cur].get(i)[0], cur, dist + adj[cur].get(i)[1]);
        }
    }
}
