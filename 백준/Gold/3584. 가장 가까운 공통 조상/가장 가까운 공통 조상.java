import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int t;
    public static int n;
    public static int[] par = new int[10010];
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < par.length; i++) {
                par[i] = -1;
            }
            visited = new boolean[10010];
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                par[b] = a;
            }
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while (x != -1) {
                visited[x] = true;
                x = par[x];
            }
            while (y != -1) {
                if (visited[y]) {
                    bw.write(String.valueOf(y));
                    break;
                }
                y = par[y];
            }
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
