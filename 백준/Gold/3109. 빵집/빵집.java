import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static boolean[][] visited;
	public static int[] dx = { -1, 0, 1 };
	public static int[] dy = { 1, 1, 1 };
	public static char[][] array;
	public static int r;
	public static int c;
	public static int cnt;
	public static boolean found;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		array = new char[r][c];
		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				array[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < r; i++) {
			found = false;
			dfs(i, 0);
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
	}

	private static void dfs(int x, int y) {
		if (found) {
			return;
		}
		visited[x][y] = true;
		if (y == c - 1) {
			cnt++;
			found = true;
		}
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (inRange(nx, ny) && !visited[nx][ny] && array[nx][ny] == '.') {
				if (i == 0 && visited[nx + 1][ny]) {
					continue;
				}
				dfs(nx, ny);
			}
		}
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}
}
