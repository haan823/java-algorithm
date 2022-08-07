import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] adj;
    public static int[] par;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        par = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(1, -1);
        for (int i = 2; i <= n; i++) {
            bw.write(String.valueOf(par[i]));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int cur, int prv) {
        for (int i = 0; i < adj[cur].size(); i++) {
            if (adj[cur].get(i) == prv) {
                continue;
            }
            par[adj[cur].get(i)] = cur;
            dfs(adj[cur].get(i), cur);
        }
    }
}