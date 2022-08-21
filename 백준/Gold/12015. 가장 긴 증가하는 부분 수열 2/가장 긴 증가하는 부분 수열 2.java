import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] array;
    public static int[] dp;
    public static int maxVal = 1;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = array[0];
        cnt = 1;
        for (int i = 1; i < n; i++) {
            int cur = array[i];
            if (cur > dp[cnt - 1]) {
                dp[cnt++] = cur;
                maxVal = Math.max(maxVal, cnt);
            } else {
                int s = 0;
                int e = cnt - 1;
                int idx = -1;
                while (s <= e) {
                    int mid = (s + e) / 2;
                    if (cur <= dp[mid]) {
                        idx = mid;
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                }
                if (idx != -1) {
                    dp[idx] = cur;
                }
            }
        }
        bw.write(String.valueOf(maxVal));
        bw.flush();
        br.close();
        bw.close();
    }
}
