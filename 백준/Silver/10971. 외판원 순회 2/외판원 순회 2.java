import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] adj;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        adj = new int[n][n];
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1 << n; j++) {
                dp[i][j] = -1;
            }
        }
        bw.write(String.valueOf(recur(0, 0)));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int recur(int cur, int visited) {
        if (cur == 0 && visited == (1 << n) - 1) {
            return 0;
        }
        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }
        int ret = 1<<30;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            if (adj[cur][i] == 0) {
                continue;
            }
            ret = Math.min(ret, recur(i, visited | (1 << i)) + adj[cur][i]);
        }
        return dp[cur][visited] = ret;
    }
}
