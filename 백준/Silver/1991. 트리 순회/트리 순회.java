import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static char[][] arr;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new char[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            arr[a - 'A'][0] = b;
            arr[a - 'A'][1] = c;
        }
        order(0, 0);
        bw.newLine();
        order(0, 1);
        bw.newLine();
        order(0, 2);
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }

    public static void order(int cur, int option) throws IOException {
        if (cur + 'A' == '.') {
            return;
        }
        if (option == 0) {
            bw.write(cur + 'A');
        }
        order(arr[cur][0] - 'A', option);
        if (option == 1) {
            bw.write(cur + 'A');
        }
        order(arr[cur][1] - 'A', option);
        if (option == 2) {
            bw.write(cur + 'A');
        }
    }
}