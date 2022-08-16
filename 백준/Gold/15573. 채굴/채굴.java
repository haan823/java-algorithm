import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n, m, k;
    public static int[][] board;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n + 1][m + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int s = 1;
        int e = 1000000;
        int answer = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (check(mid) >= k) {
                answer = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int check(int mid) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][m + 2];
        for (int j = 0; j < m + 2; j++) {
            q.add(new int[]{0, j});
            visited[0][j] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            q.add(new int[]{i, 0});
            visited[i][0] = true;
            q.add(new int[]{i, m + 1});
            visited[i][m + 1] = true;
        }
        while (!q.isEmpty()) {
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (inRange(nx, ny) && !visited[nx][ny] && board[nx][ny] <= mid) {
                    cnt++;
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < n + 1 && ny >= 0 && ny < m + 2;
    }
}