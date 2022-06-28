package thisiscodingtest.baekjoon.binarysearch.p10816;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array, Comparator.comparingInt(o -> o));
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            int s = 0;
            int e = n - 1;
            int l = 0;
            int r = -1;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (array[mid] == x) {
                    s = mid + 1;
                    r = mid;
                } else if (array[mid] > x) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            s = 0;
            e = n - 1;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (array[mid] == x) {
                    e = mid - 1;
                    l = mid;
                } else if (array[mid] > x) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            bw.write((r - l + 1) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
