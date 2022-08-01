package baekjoon.p1389;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static ArrayList<Integer>[] array;
	public static int minVal = Integer.MAX_VALUE;
	public static int minIndex = 0;
	public static int n;
	public static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		array = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			array[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			array[a].add(b);
			array[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (i != j) {
					sum += bfs(i, j);
				}
			}
			if (sum < minVal) {
				minVal = sum;
				minIndex = i;
			} else if (sum == minVal) {
				if (i < minIndex) {
					minIndex = i;
				}
			}
		}
		bw.write(String.valueOf(minIndex));
		bw.flush();
	}

	private static int bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		q.add(new int[] { a, 0 });
		visited[a] = true;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int cnt = q.peek()[1];
			q.poll();
			if (x == b) {
				return cnt;
			}
			for (int i = 0; i < array[x].size(); i++) {
				q.add(new int[] { array[x].get(i), cnt + 1 });
				visited[array[x].get(i)] = true;
			}
		}
		return 0;
	}
}