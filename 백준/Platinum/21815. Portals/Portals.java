import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[] par;
    public static List<int[]> list;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        par = new int[2 * n + 1];
        for (int i = 0; i < 2 * n + 1; i++) {
            par[i] = i;
        }
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b, 0});
            list.add(new int[]{c, d, 0});
            list.add(new int[]{a, d, cost});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            int c = list.get(i)[2];
            if (find(x) == find(y)) {
                continue;
            }
            union(x, y);
            result += c;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        par[x] = y;
    }

    private static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }
}