package baekjoon.p2487;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static int n;
	public static int[] array;
	public static int cnt;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		array = new int[n + 1];
		visited = new boolean[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		long result = 1;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				cnt = 0;
				dfs(i);
				result = result * cnt / gcd(result, cnt);
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}

	private static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static void dfs(int i) {
		visited[i] = true;
		cnt++;
		if (!visited[array[i]]) {
			dfs(array[i]);
		}
	}
}