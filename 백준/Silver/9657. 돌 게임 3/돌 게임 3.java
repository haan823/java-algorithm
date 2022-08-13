import java.io.*;

public class Main {

    public static int n;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 3) {
            dp[3] = 1;
        }
        if (n >= 4) {
            dp[4] = 1;
        }
        for (int i = 5; i <= n; i++) {
            if (dp[i - 1] == 1 && dp[i - 3] == 1 && dp[i - 4] == 1) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }
        if (dp[n] == 1) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}