import java.io.*;
import java.util.*;

public class Main {
    public static int r;
    public static int c;
    public static int k;
    public static int[][] array = new int[100][100];
    public static int w = 3;
    public static int h = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = -1;
        for (int t = 0; t <= 100; t++) {
            if (array[r][c] == k) {
                result = t;
                break;
            }
            if (h >= w) {
                doR();
            } else {
                doC();
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }


    private static void doR() {
        int nw = 0;
        for (int i = 0; i < h; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                }
            });
            Map<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < w; j++) {
                int cur = array[i][j];
                array[i][j] = 0;
                if (cur == 0) {
                    continue;
                }
                if (map.containsKey(cur)) {
                    map.put(cur, map.get(cur) + 1);
                } else {
                    map.put(cur, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
            int cnt = 0;
            while (!pq.isEmpty()) {
                if (cnt == 100) {
                    break;
                }
                array[i][cnt] = pq.peek()[0];
                array[i][cnt + 1] = pq.peek()[1];
                pq.poll();
                cnt += 2;
            }
            nw = Math.max(nw, cnt);
        }
        w = nw;
    }

    private static void doC() {
        int nh = 0;
        for (int j = 0; j < w; j++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                }
            });
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < h; i++) {
                int cur = array[i][j];
                array[i][j] = 0;
                if (cur == 0) {
                    continue;
                }
                if (map.containsKey(cur)) {
                    map.put(cur, map.get(cur) + 1);
                } else {
                    map.put(cur, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }
            int cnt = 0;
            while (!pq.isEmpty()) {
                if (cnt == 100) {
                    break;
                }
                array[cnt][j] = pq.peek()[0];
                array[cnt + 1][j] = pq.peek()[1];
                pq.poll();
                cnt += 2;
            }
            nh = Math.max(nh, cnt);
        }
        h = nh;
    }
}