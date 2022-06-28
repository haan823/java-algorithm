package thisiscodingtest.baekjoon.binarysearch.p10815;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            int s = 0;
            int e = n - 1;
            int ans = 0;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (array[mid] == x) {
                    ans = 1;
                    break;
                } else if (array[mid] > x) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
            bw.write(ans + " ");
        }
        bw.flush();
    }
}
