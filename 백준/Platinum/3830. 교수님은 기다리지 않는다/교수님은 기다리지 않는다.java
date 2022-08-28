import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static int[] par;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            par = new int[n + 1];
            dist = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                par[i] = i;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().charAt(0) == '!') {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    union(a, b, c);
                } else {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if (find(a) != find(b)) {
                        bw.write("UNKNOWN");
                        bw.newLine();
                    } else {
                        bw.write(String.valueOf(dist[b] - dist[a]));
                        bw.newLine();
                    }
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void union(int a, int b, int c) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        dist[rootB] = dist[a] - dist[b] + c;
        par[rootB] = rootA;
    }

    private static int find(int a) {
        if (par[a] == a) {
            return a;
        }
        int parent = find(par[a]);
        dist[a] += dist[par[a]];
        return par[a] = parent;
    }
}
