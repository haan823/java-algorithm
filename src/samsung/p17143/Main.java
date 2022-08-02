package samsung.p17143;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[][] board;
    public static int cur;
    public static int r;
    public static int c;
    public static int m;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static List<int[]> sharks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if (d - 1 == 0 || d - 1 == 1) {
                s %= (r - 1) * 2;
            } else {
                s %= (c - 1) * 2;
            }
            sharks.add(new int[]{m - 1, n - 1, s, d - 1, z});
        }

        int sum = 0;

        for (cur = 0; cur < c; cur++) {
            int idx = -1;
            int depth = Integer.MAX_VALUE;
            for (int i = 0; i < sharks.size(); i++) {
                if (sharks.get(i)[1] == cur) {
                    if (sharks.get(i)[0] < depth) {
                        depth = sharks.get(i)[0];
                        idx = i;
                    }
                }
            }
            if (depth != Integer.MAX_VALUE) {
                sum += sharks.get(idx)[4];
                sharks.remove(idx);
            }
            move();
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void move() {
        for (int i = 0; i < sharks.size(); i++) {
            int cx = sharks.get(i)[0];
            int cy = sharks.get(i)[1];
            int cs = sharks.get(i)[2];
            int cd = sharks.get(i)[3];
            int cz = sharks.get(i)[4];

            int nx = cx;
            int ny = cy;
            for (int j = 0; j < cs; j++) {
                nx += dx[cd];
                ny += dy[cd];
                if (nx == -1) {
                    nx = 1;
                    cd = 1;
                } else if (nx == r) {
                    nx = r - 2;
                    cd = 0;
                } else if (ny == -1) {
                    ny = 1;
                    cd = 2;
                } else if (ny == c) {
                    ny = c - 2;
                    cd = 3;
                }
            }
            sharks.set(i, new int[]{nx, ny, cs, cd, cz});
        }
        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = -1;
            }
        }
        List<Integer> alives = new ArrayList<>();
        for (int i = 0; i < sharks.size(); i++) {
            int cx = sharks.get(i)[0];
            int cy = sharks.get(i)[1];
            int cz = sharks.get(i)[4];
            if (board[cx][cy] == -1) {
                board[cx][cy] = i;
                alives.add(i);
            } else {
                if (sharks.get(board[cx][cy])[4] < cz) {
                    /**
                     * List에서 remove할 대상을 object로 찾지 않고 index로 찾아서 발생했던 IndexOutOfBound 오류
                     */
                    alives.remove((Object) board[cx][cy]);
//                    alives.remove(board[cx][cy]);
                    board[cx][cy] = i;
                    alives.add(i);
                }
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int alive : alives) {
            result.add(sharks.get(alive));
        }
        sharks = result;
    }
}