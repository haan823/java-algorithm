package baekjoon.p7576;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static boolean[][] visited;
	public static int[][] array;
	public static int n;
	public static int m;
	public static int goal;
	public static int cnt;
	public static int day;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[n][m];
		array = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if (array[i][j] == 1) {
					visited[i][j] = true;
					q.add(new int[] { i, j, 0 });
				} else if (array[i][j] == 0) {
					goal++;
				}
			}
		}

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int c = q.peek()[2];
			day = c;
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (inRange(nx, ny) && !visited[nx][ny] && array[nx][ny] == 0) {
					visited[nx][ny] = true;
					cnt++;
					q.add(new int[] { nx, ny, c + 1 });
				}
			}
		}
		
		if(goal == 0) {
			bw.write(String.valueOf(0));
		} else if(goal > cnt) {
			bw.write(String.valueOf(-1));
		} else {
			bw.write(String.valueOf(day));
		}
		bw.flush();
	}

	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && nx < n && ny >= 0 && ny < m;
	}
}
