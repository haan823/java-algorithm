package thisiscodingtest.baekjoon.binarysearch.p2613;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        int s = 0;
        int e = 30000;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            s = Math.max(s, array[i]);
        }
        int ans = 0;
        while (s <= e) {
            int mid = (s + e) / 2;
            int check = check(mid);
            if (check > m) {
                s = mid + 1;
            } else {
                ans = mid;
                e = mid - 1;
            }
        }
        bw.write(String.valueOf(ans));
        bw.newLine();
        List<Integer> order = new ArrayList<>();
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
            if (sum > ans) {
                order.add(cnt);
                cnt = 0;
                sum = array[i];
            }
            cnt++;
        }
        order.add(cnt);
        while (order.size() < m) {
            for (int i = 0; i < order.size(); i++) {
                if (order.get(i) > 1) {
                    order.set(i, order.get(i) - 1);
                    order.add(i, 1);
                    break;
                }
            }
        }
        for (Integer o : order) {
            bw.write(o + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int check(int mid) {
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
            if (sum > mid) {
                cnt++;
                sum = array[i];
            }
        }
        cnt++;
        return cnt;
    }
}