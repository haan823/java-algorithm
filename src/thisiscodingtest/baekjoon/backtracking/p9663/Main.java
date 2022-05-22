package thisiscodingtest.baekjoon.backtracking.p9663;

import java.util.Scanner;

public class Main {

    public static int[] array = new int[15];
    public static boolean[] visited = new boolean[15];
    static int n;
    static int cnt = 0;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        recur(0);
        System.out.println(cnt);
        sc.close();
    }

    private static void recur(int cur) {
        if (cur >= 2) {
            for (int i = 0; i < cur - 1; i++) {
                if (cur - 1 - i == Math.abs(array[cur - 1] - array[i])) {
                    return;
                }
            }
        }
        if (cur == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            array[cur] = i;
            visited[i] = true;
            recur(cur + 1);
            visited[i] = false;
        }
    }

}
