import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static int[] par;
    public static char[] array;
    public static int result;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new char[n];
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = st.nextToken().charAt(0);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b, c});
        }
        while (!pq.isEmpty()) {
            int a = pq.peek()[0];
            int b = pq.peek()[1];
            int c = pq.peek()[2];
            pq.poll();
            if (find(a) == find(b)) {
                continue;
            }
            if (array[a] == array[b]) {
                continue;
            }
            union(a, b);
            cnt++;
            result += c;
        }
        if (cnt == n - 1) {
            bw.write(String.valueOf(result));
        } else {
            bw.write("-1");
        }
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