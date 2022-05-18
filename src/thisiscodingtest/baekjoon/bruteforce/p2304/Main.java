package thisiscodingtest.baekjoon.bruteforce.p2304;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[1001];

        int maxHeight = 0;
        int maxHeightLeftPosition = 1000;
        int maxHeightRightPosition = 0;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int l = Integer.parseInt(s[0]);
            int h = Integer.parseInt(s[1]);
            array[l] = h;
            if (h > maxHeight) {
                maxHeight = h;
                maxHeightLeftPosition = l;
                maxHeightRightPosition = l;
            } else if (h == maxHeight) {
                if (l < maxHeightLeftPosition) {
                    maxHeightLeftPosition = l;
                } else if (l > maxHeightRightPosition) {
                    maxHeightRightPosition = l;
                }
            }
        }
        int sum = 0;
        int curHeight = 0;
        for (int i = 1; i < maxHeightLeftPosition; i++) {
            if (array[i] > curHeight) {
                sum += array[i];
                curHeight = array[i];
            } else {
                sum += curHeight;
            }
        }
        curHeight = 0;
        for (int i = 1000; i > maxHeightRightPosition; i--) {
            if (array[i] > curHeight) {
                sum += array[i];
                curHeight = array[i];
            } else {
                sum += curHeight;
            }
        }
        sum += (maxHeightRightPosition - maxHeightLeftPosition + 1) * maxHeight;
        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }
}
