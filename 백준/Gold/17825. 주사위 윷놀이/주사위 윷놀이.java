import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[] input = new int[10];
    public static int[] array = new int[10];
    public static int[] loc = new int[5];
    public static int[] route = {0, 2, 4, 6, 8, 10, 13, 16, 19, 12, 14, 16, 18, 20, 22, 24, 25, 22, 24, 26, 28, 30, 28, 27, 26, 30, 35, 32, 34, 36, 38, 40, 0};
    public static int[] board = new int[33];
    public static List<Integer>[] adj = new ArrayList[33];
    public static int maxScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<33;i++){
            adj[i] = new ArrayList<>();
        }
        adj[0].add(1);adj[1].add(2);adj[2].add(3);adj[3].add(4);adj[4].add(5);adj[5].add(9);adj[5].add(6);adj[9].add(10);adj[10].add(11);adj[11].add(12);adj[12].add(13);
        adj[6].add(7);adj[7].add(8);adj[8].add(16);adj[13].add(17);adj[13].add(14);adj[17].add(18);adj[18].add(19);adj[19].add(20);adj[20].add(21);adj[14].add(15);adj[15].add(16);
        adj[21].add(27);adj[21].add(22);adj[22].add(23);adj[23].add(24);adj[24].add(16);adj[27].add(28);adj[28].add(29);adj[29].add(30);adj[30].add(31);adj[31].add(32);
        adj[16].add(25);adj[25].add(26);adj[26].add(31);
        recur(0);
        bw.write(String.valueOf(maxScore));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void recur(int cur) {
        if (cur == 10) {
            loc = new int[5];
            board = new int[33];
            calculateScore();
            return;
        }
        for (int i = 1; i <= 4; i++) {
            array[cur] = i;
            recur(cur + 1);
        }
    }

    private static void calculateScore() {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            int cl = loc[array[i]];
            int step = input[i];
            int nl = go(cl, step, 0);
            if (nl != 32 && board[nl] != 0) {
                return;
            }
            score += route[nl];
            loc[array[i]] = nl;
            board[cl] = 0;
            board[nl] = array[i];
        }
        maxScore = Math.max(maxScore, score);
    }

    private static int go(int cl, int step, int cnt) {
        if (cl == 32) {
            return cl;
        }
        if (cnt == step) {
            return cl;
        }
        int d = 0;
        if (cnt == 0) {
            if (cl == 5 || cl == 13 || cl == 21) {
                d = 1;
            }
        }
        return go(adj[cl].get(d), step, cnt + 1);
    }
}
