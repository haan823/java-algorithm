package baekjoon.p2178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int n;
	public static int m;
	public static char[][] array;
	public static boolean[][] visited;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		array = new char[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				array[i][j] = s.charAt(j);
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 1 });
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cnt = q.peek()[2];
			if (x == n - 1 && y == m - 1) {
				bw.write(String.valueOf(cnt));
				break;
			}
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (inRange(nx, ny) && !visited[nx][ny] && array[nx][ny] == '1') {
					visited[nx][ny] = true;
					q.add(new int[] { nx, ny, cnt + 1 });
				}
			}
		}
		bw.flush();
	}

	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && nx < n && ny >= 0 && ny < m;
	}
}
