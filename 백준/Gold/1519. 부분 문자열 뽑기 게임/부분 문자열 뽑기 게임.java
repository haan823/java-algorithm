import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static int n;
    public static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        for (int i = 10; i <= n; i++) {
            String s = String.valueOf(i);
            Set<String> set = new HashSet<>();
            for (int start = 0; start < s.length(); start++) {
                for (int end = start + 1; end <= s.length(); end++) {
                    String tmp = s.substring(start, end);
                    if (s.equals(tmp) || tmp.charAt(0) == '0') {
                        continue;
                    }
                    set.add(tmp);
                }
            }
            Iterator<String> iterator = set.iterator();
            int minVal = Integer.MAX_VALUE;
            while (iterator.hasNext()) {
                int cur = Integer.valueOf(s);
                int nxt = Integer.valueOf(iterator.next());
                if (dp[cur - nxt] == 0) {
                    minVal = Math.min(minVal, nxt);
                }
            }
            if (minVal != Integer.MAX_VALUE) {
                dp[i] = minVal;
            }
        }
        if (dp[n] == 0) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(dp[n]));
        }
        bw.flush();
        br.close();
        bw.close();
    }
}