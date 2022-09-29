import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static int n;
	public static int[][] cost;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		cost = new int[n][3];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = -1;
			}
		}
		bw.write(String.valueOf(Math.min(Math.min(recur(0, 0), recur(0, 1)), recur(0, 2))));
		bw.flush();
		br.close();
		bw.close();
	}

	public static int recur(int cur, int idx) {
		if (cur == n) {
			return 0;
		}
		if (dp[cur][idx] != -1) {
			return dp[cur][idx];
		}
		return dp[cur][idx] = Math.min(recur(cur + 1, (idx + 1) % 3) + cost[cur][idx],
				recur(cur + 1, (idx + 2) % 3) + cost[cur][idx]);
	}
}
