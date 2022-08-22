import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] array;
    public static int x, y;
    public static long sum;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = sc.nextInt();
        sc.nextLine();
        array = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        x = array[(n - 1) / 2][0];
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        y = array[(n - 1) / 2][1];
        for (int i = 0; i < n; i++) {
            sum += (long) Math.abs(x - array[i][0]) + (long) Math.abs(y - array[i][1]);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
