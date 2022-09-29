import java.io.*;

public class Main {

    public static int n;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[1000001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            int mn = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                mn = Math.min(mn, dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                mn = Math.min(mn, dp[i / 3] + 1);
            }
            mn = Math.min(mn, dp[i - 1] + 1);
            dp[i] = mn;
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        br.close();
        bw.close();
    }
}