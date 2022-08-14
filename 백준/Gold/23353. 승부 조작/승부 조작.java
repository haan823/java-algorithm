import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] board;
    public static int[][][][] dp;
    public static int[][] dx = {{-1, -1, -1, 0}, {1, 1, 1, 0}};
    public static int[][] dy = {{-1, 0, 1, -1}, {1, 0, -1, 1}};
    public static int maxVal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n + 2][n + 2];
        dp = new int[4][2][n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        dp[k][0][i][j] = dp[k][0][i + dx[0][k]][j + dy[0][k]] + 1;
                        maxVal = Math.max(maxVal, dp[k][0][i][j]);
                    }
                }
            }
        }

        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        dp[k][1][i][j] = dp[k][1][i + dx[1][k]][j + dy[1][k]] + 1;
                        maxVal = Math.max(maxVal, dp[k][1][i][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        maxVal = Math.max(maxVal, dp[k][0][i + dx[0][k]][j + dy[0][k]] + dp[k][1][i + dx[1][k]][j + dy[1][k]] + 1);
                    }
                }
            }
        }
        bw.write(String.valueOf(maxVal));
        bw.flush();
        br.close();
        bw.close();
    }
}