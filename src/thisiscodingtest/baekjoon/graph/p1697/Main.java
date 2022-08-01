package baekjoon.p1697;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] sum = { -1, 1, 0 };
	public static int[] mul = { 1, 1, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { n, 0 });
		visited[n] = true;
		while (!q.isEmpty()) {
			int cur = q.peek()[0];
			int cnt = q.peek()[1];
			q.poll();
			if (cur == k) {
				bw.write(String.valueOf(cnt));
				break;
			}
			for (int i = 0; i < 3; i++) {
				int nxt = cur * mul[i] + sum[i];
				if (nxt <= 100000 && nxt >= 0 && !visited[nxt]) {
					visited[nxt] = true;
					q.add(new int[] { nxt, cnt + 1 });
				}
			}
		}
		bw.flush();
	}
}