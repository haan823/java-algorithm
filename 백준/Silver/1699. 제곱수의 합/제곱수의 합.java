import java.io.*;

public class Main {

    public static int n;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int floor = (int) Math.floor(Math.sqrt(i));
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= floor; j++) {
                minVal = Math.min(minVal, dp[i - j * j]);
            }
            dp[i] = 1 + minVal;
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        br.close();
        bw.close();
    }
}