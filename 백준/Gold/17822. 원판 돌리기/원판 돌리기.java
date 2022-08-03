import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int t;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            rotate(x, d, k);
            check();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += board[i][j];
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void check() {
        boolean flag = false;
        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || board[i][j] == 0) {
                    continue;
                }
                list.clear();
                int tmp = board[i][j];
                q.add(new int[]{i, j});
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    int cx = q.peek()[0];
                    int cy = q.peek()[1];
                    q.poll();
                    list.add(new int[]{cx, cy});
                    for (int k = 0; k < 4; k++) {
                        int nx = cx + dx[k];
                        int ny = cy + dy[k];
                        if (ny == -1) {
                            ny = m - 1;
                        } else if (ny == m) {
                            ny = 0;
                        }
                        if (inRange(nx, ny) && !visited[nx][ny] && board[nx][ny] == tmp) {
                            flag = true;
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
                if (list.size() > 1) {
                    for (int k = 0; k < list.size(); k++) {
                        board[list.get(k)[0]][list.get(k)[1]] = 0;
                    }
                }
            }
        }
        if (!flag) {
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] != 0) {
                        sum += board[i][j];
                        cnt++;
                    }
                }
            }
            double avg = (double)sum / cnt;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0) {
                        continue;
                    }
                    if (board[i][j] > avg) {
                        board[i][j] -= 1;
                    } else if (board[i][j] < avg) {
                        board[i][j] += 1;
                    }
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static void rotate(int x, int d, int k) {
        for (int i = 0; i < n; i++) {
            if ((i + 1) % x == 0) {
                if (d == 0) {
                    int[] tmp = new int[m];
                    for (int j = 0; j < m; j++) {
                        tmp[j] = board[i][(j + m - k) % m];
                    }
                    board[i] = tmp;
                } else if (d == 1) {
                    int[] tmp = new int[m];
                    for (int j = 0; j < m; j++) {
                        tmp[j] = board[i][(j + k) % m];
                    }
                    board[i] = tmp;
                }
            }
        }
    }
}