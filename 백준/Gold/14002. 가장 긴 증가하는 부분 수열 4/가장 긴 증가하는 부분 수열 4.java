import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[] array;
    public static int[] dp;
    public static LinkedList[] list;
    public static int maxVal;
    public static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        dp = new int[n];
        list = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new LinkedList();
        }
        Arrays.fill(dp, 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            list[i].add(array[i]);
        }
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        tmp = list[j];
                    }
                }
            }
            for (int j = tmp.size() - 1; j >= 0; j--) {
                list[i].addFirst(tmp.get(j));
            }
            if (dp[i] > maxVal) {
                maxVal = dp[i];
                idx = i;
            }
        }
        bw.write(String.valueOf(maxVal));
        bw.newLine();
        for (int i = 0; i < list[idx].size(); i++) {
            bw.write(list[idx].get(i) + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}