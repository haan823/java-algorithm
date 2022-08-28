import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static List<Integer>[] adj;
    public static int[] cnt;
    public static int[] time;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        cnt = new int[n + 1];
        time = new int[n + 1];
        dist = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            dist[i] = t;
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) {
                    break;
                }
                adj[x].add(i);
                cnt[i]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < adj[cur].size(); i++) {
                int nxt = adj[cur].get(i);
                dist[nxt] = Math.max(dist[nxt], dist[cur] + time[nxt]);
                cnt[nxt]--;
                if (cnt[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            bw.write(String.valueOf(dist[i]));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}