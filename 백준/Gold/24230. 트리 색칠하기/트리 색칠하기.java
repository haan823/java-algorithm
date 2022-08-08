import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] color;
    public static List<Integer>[] adj;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        color = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            color[i] = Integer.parseInt(st.nextToken());
        }
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, -1, 0});
        while (!q.isEmpty()) {
            int cur = q.peek()[0];
            int prv = q.peek()[1];
            int clr = q.peek()[2];
            q.poll();
            if (clr != color[cur]) {
                cnt++;
            }
            for (int i = 0; i < adj[cur].size(); i++) {
                if (adj[cur].get(i) == prv) {
                    continue;
                }
                q.add(new int[]{adj[cur].get(i), cur, color[cur]});
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
    }
}