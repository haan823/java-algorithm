import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] array;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        array = new int[n][2];
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[i][0] = a;
            array[i][1] = b;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = array[i][0];
                int y = array[j][1];
                List<Integer> list = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    list.add(Math.abs(array[k][0] - x) + Math.abs(array[k][1] - y));
                }
                Collections.sort(list);
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += list.get(k);
                    dist[k] = Math.min(dist[k], sum);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            bw.write(dist[i] + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}