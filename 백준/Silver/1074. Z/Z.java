import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static int n, r, c;
	public static int cnt;
	public static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		recur(n, r, c);
		bw.write(String.valueOf(cnt));
		bw.flush();
		br.close();
		bw.close();
	}

	private static void recur(int cur, int cr, int cc) throws IOException {
		if (cur == 0) {
			return;
		}
		int half = (int) Math.pow(2, cur - 1);
		if(cr/half == 0 && cc/half == 0) {
			cnt+= half * half * 0;
			recur(cur - 1, cr % half, cc % half);
		} else if(cr/half == 0 && cc/half == 1) {
			cnt+= half * half * 1;
			recur(cur - 1, cr % half, cc % half);
		} else if(cr/half == 1 && cc/half == 0) {
			cnt+= half * half * 2;
			recur(cur - 1, cr % half, cc % half);
		} else if(cr/half == 1 && cc/half == 1) {
			cnt+= half * half * 3;
			recur(cur - 1, cr % half, cc % half);
		}
	}
}
