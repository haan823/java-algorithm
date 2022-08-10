import java.io.*;

public class Main {

    public static int n;
    public static int[] array;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = array[0];
        if (n >= 2) {
            dp[1] = array[0] + array[1];
        }
        if (n >= 3) {
            dp[2] = Math.max(array[0] + array[2], array[1] + array[2]);
        }
        bw.write(String.valueOf(recur(n - 1)));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int recur(int cur) {
        if (dp[cur] != -1) {
            return dp[cur];
        }
        return dp[cur] = Math.max(recur(cur - 2), recur(cur - 3) + array[cur - 1]) + array[cur];
    }
}