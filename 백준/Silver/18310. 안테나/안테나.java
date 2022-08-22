import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        bw.write(String.valueOf(array[(n - 1) / 2]));
        bw.flush();
        br.close();
        bw.close();
    }
}