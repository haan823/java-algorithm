import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] board;
    public static int[][] dp;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static List<int[]> list = new ArrayList<>();
    public static int maxVal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                list.add(new int[]{i, j, board[i][j]});
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        for (int i = 0; i < list.size(); i++) {
            int cx = list.get(i)[0];
            int cy = list.get(i)[1];
            int maxCnt = 0;
            for (int j = 0; j < 4; j++) {
                int nx = cx + dx[j];
                int ny = cy + dy[j];
                if (inRange(nx, ny) && board[nx][ny] > board[cx][cy]) {
                    maxCnt = Math.max(maxCnt, dp[nx][ny]);
                }
            }
            dp[cx][cy] = maxCnt + 1;
            maxVal = Math.max(maxVal, dp[cx][cy]);
        }
        bw.write(String.valueOf(maxVal));
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}