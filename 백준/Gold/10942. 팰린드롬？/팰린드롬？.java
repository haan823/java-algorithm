import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[] array;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        array = new int[n + 1];
        dp = new int[n + 1][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());

        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                int s = i;
                int e = j;
                if (s + 1 <= e - 1) {
                    if (dp[s + 1][e - 1] == 1 && array[s] == array[e]) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    if (array[s] == array[e]) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        for (int tc = 0; tc < m; tc++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(dp[s][e]));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}