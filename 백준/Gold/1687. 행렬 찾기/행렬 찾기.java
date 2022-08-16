import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static int[][] board;
    public static int[][] dp;
    public static int maxVal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 2];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(s.substring(j - 1, j));
                if (board[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            for (int j = 1; j <= m + 1; j++) {
                while (!stack.isEmpty() && dp[i][stack.peek()] > dp[i][j]) {
                    int tmp = stack.peek();
                    stack.pop();
                    maxVal = Math.max(maxVal, (j - stack.peek() - 1) * dp[i][tmp]);
                }
                stack.push(j);
            }
        }
        bw.write(String.valueOf(maxVal));
        bw.flush();
        br.close();
        bw.close();
    }
}
