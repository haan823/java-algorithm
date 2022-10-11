import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n, d, k, c;
    public static int[] array;
    public static int[] visited;
    public static int mx;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        array = new int[n];
        visited = new int[d + 1];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k; i++) {
            if (visited[array[i]] == 0) {
                cnt++;
            }
            visited[array[i]]++;
        }
        if (visited[c] > 0) {
            mx = cnt;
        } else {
            mx = cnt + 1;
        }
        for (int i = k; i < n + k; i++) {
            int s = i - k;
            int l = i % n;
            visited[array[s]]--;
            if (visited[array[s]] == 0) {
                cnt--;
            }
            if (visited[array[l]] == 0) {
                cnt++;
            }
            visited[array[l]]++;
            if (visited[c] > 0) {
                mx = Math.max(mx, cnt);
            } else {
                mx = Math.max(mx, cnt + 1);
            }
        }
        bw.write(String.valueOf(mx));
        bw.flush();
        br.close();
        bw.close();
    }
}