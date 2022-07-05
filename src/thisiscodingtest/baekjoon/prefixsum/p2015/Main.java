package thisiscodingtest.baekjoon.prefixsum.p2015;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] prefix = new int[n + 1];
        Map<Integer, Integer> map = new TreeMap<>();
        long result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
            if (prefix[i] == k) {
                result++;
            }
            if (map.containsKey(prefix[i] - k)) {
                result += map.get(prefix[i] - k);
            }
            if (map.containsKey(prefix[i])) {
                map.put(prefix[i], map.get(prefix[i]) + 1);
            } else {
                map.put(prefix[i], 1);
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
