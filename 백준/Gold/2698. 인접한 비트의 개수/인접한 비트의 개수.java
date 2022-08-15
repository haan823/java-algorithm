import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int t;
    public static int n;
    public static int k;
    public static int[][][] dp = new int[101][101][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            dp[1][0][0] = 1;
            dp[1][0][1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                    if (j == 0) {
                        dp[i][j][1] = dp[i - 1][j][0];
                    } else {
                        dp[i][j][1] = dp[i - 1][j][0] + dp[i - 1][j - 1][1];
                    }
                }
            }
            bw.write(String.valueOf(dp[n][k][0] + dp[n][k][1]));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}