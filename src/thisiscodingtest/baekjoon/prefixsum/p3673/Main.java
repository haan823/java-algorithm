package thisiscodingtest.baekjoon.prefixsum.p3673;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (c-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new TreeMap<>();
            map.put(0, 1);
            int result = 0;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                int x = Integer.parseInt(st.nextToken());
                sum = (sum + x) % d;
                if (map.containsKey(sum)) {
                    result += map.get(sum);
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }

            }
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}