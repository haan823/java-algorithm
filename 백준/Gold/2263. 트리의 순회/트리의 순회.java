import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] in;
    public static int[] post;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }
        getPreOrder(0, n - 1, 0, n - 1);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void getPreOrder(int ps, int pe, int is, int ie) throws IOException {
        if (ps > pe || is > ie || ps < 0 || is < 0) {
            return;
        }
        bw.write(String.valueOf(post[pe] + " "));
        int pos = 0;
        for (int i = is; i <= ie; i++) {
            if (in[i] == post[pe]) {
                pos = i;
                break;
            }
        }
        getPreOrder(ps, pe - (ie - pos) - 1, is, pos - 1);
        getPreOrder(pe - (ie - pos), pe - 1, pos + 1, ie);
    }
}