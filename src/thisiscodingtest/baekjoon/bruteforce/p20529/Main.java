package thisiscodingtest.baekjoon.bruteforce.p20529;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (map.containsKey(s[j])) {
                    map.put(s[j], map.get(s[j]) + 1);
                } else {
                    map.put(s[j], 1);
                }
            }
            List<String> list = new ArrayList<>();
            for (String key : map.keySet()) {
                if (map.get(key) >= 3) {
                    for (int j = 0; j < 3; j++) {
                        list.add(key);
                    }
                } else {
                    for (int j = 0; j < map.get(key); j++) {
                        list.add(key);
                    }
                }
            }
            bw.write(String.valueOf(minDistance(list)));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int minDistance(List<String> list) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    int d1 = calculateDistance(list.get(i), list.get(j));
                    int d2 = calculateDistance(list.get(j), list.get(k));
                    int d3 = calculateDistance(list.get(k), list.get(i));
                    if (minDistance > (d1 + d2 + d3)) {
                        minDistance = d1 + d2 + d3;
                    }
                }
            }
        }
        return minDistance;
    }

    private static int calculateDistance(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
