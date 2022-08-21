import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] array;
    public static int[] vector;
    public static int[] dp;
    public static int cnt;
    public static int maxVal = 1;
    public static int maxIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        vector = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        vector[0] = array[0];
        cnt = 1;
        dp[0] = cnt;
        for (int i = 1; i < n; i++) {
            int cur = array[i];
            if (array[i] > vector[cnt - 1]) {
                vector[cnt++] = cur;
                if (cnt > maxVal) {
                    maxVal = cnt;
                    maxIdx = i;
                }
                dp[i] = cnt;
            } else {
                int s = 0;
                int e = cnt - 1;
                int idx = -1;
                while (s <= e) {
                    int mid = (s + e) / 2;
                    if (vector[mid] >= cur) {
                        idx = mid;
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                }
                if (idx != -1) {
                    vector[idx] = cur;
                    dp[i] = idx + 1;
                } else {
                    dp[i] = 1;
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(array[maxIdx]);
        for (int i = maxIdx - 1; i >= 0; i--) {
            if (array[i] < array[maxIdx] && dp[i] + 1 == dp[maxIdx]) {
                maxIdx = i;
                stack.push(array[i]);
            }
        }
        bw.write(String.valueOf(maxVal));
        bw.newLine();
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}