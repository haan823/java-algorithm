import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static List<int[]>[] row = new ArrayList[1000002];
    public static List<int[]>[] col = new ArrayList[1000002];
    public static List<int[]> list = new ArrayList<>();
    public static int startX = Integer.MAX_VALUE;
    public static int endX;
    public static int startY = Integer.MAX_VALUE;
    public static int endY;
    public static int[] array = new int[1000002];
    public static int[] prefix = new int[1000002];
    public static int maxH;
    public static int maxV;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 500001;
            int y = Integer.parseInt(st.nextToken()) + 500001;
            list.add(new int[]{x, y});
            startX = Math.min(startX, x);
            endX = Math.max(endX, x);
            startY = Math.min(startY, y);
            endY = Math.max(endY, y);
        }
        for (int i = 1; i < 1000002; i++) {
            row[i] = new ArrayList<>();
            col[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int sx = list.get(i)[0];
            int sy = list.get(i)[1];
            int ex = list.get(i + 1)[0];
            int ey = list.get(i + 1)[1];
            if (sx == ex) {
                row[sx].add(new int[]{Math.min(sy, ey), Math.max(sy, ey)});
            } else if (sy == ey) {
                col[sy].add(new int[]{Math.min(sx, ex), Math.max(sx, ex)});
            }
        }
        int sx = list.get(n-1)[0];
        int sy = list.get(n-1)[1];
        int ex = list.get(0)[0];
        int ey = list.get(0)[1];
        if (sx == ex) {
            row[sx].add(new int[]{Math.min(sy, ey), Math.max(sy, ey)});
        } else if (sy == ey) {
            col[sy].add(new int[]{Math.min(sx, ex), Math.max(sx, ex)});
        }
        for (int i = startX; i <= endX; i++) {
            if (row[i].size() != 0) {
                Collections.sort(row[i], new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                });
            }
            for (int j = 0; j < row[i].size(); j++) {
                array[row[i].get(j)[0]] += 1;
                array[row[i].get(j)[1]] -= 1;
            }
        }
        for (int i = 1; i < 1000002; i++) {
            prefix[i] = prefix[i - 1] + array[i];
            maxV = Math.max(maxV, prefix[i]);
        }
        Arrays.fill(array, 0);
        Arrays.fill(prefix, 0);
        for (int i = startY; i <= endY; i++) {
            if (col[i].size() != 0) {
                Collections.sort(col[i], new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                });
            }
            for (int j = 0; j < col[i].size(); j++) {
                array[col[i].get(j)[0]] += 1;
                array[col[i].get(j)[1]] -= 1;
            }
        }
        for (int i = 1; i < 1000002; i++) {
            prefix[i] = prefix[i - 1] + array[i];
            maxH = Math.max(maxH, prefix[i]);
        }
        bw.write(String.valueOf(Math.max(maxH, maxV)));
        bw.flush();
        br.close();
        bw.close();
    }
}