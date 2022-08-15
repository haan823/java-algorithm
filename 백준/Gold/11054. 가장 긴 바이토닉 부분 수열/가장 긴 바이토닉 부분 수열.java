import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] array;
    public static int[] dp1;
    public static int[] dp2;
    public static int maxVal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        array = new int[n + 1];
        dp1 = new int[n + 1];
        dp2 = new int[n + 1];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (array[j] < array[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }
        for (int i = n; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (array[j] < array[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            maxVal = Math.max(maxVal, dp1[i] + dp2[i] - 1);
        }
        bw.write(String.valueOf(maxVal));
        bw.flush();
        br.close();
        bw.close();
    }
}
