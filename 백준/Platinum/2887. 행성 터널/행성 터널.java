import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int result;
	public static int[] par;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		par = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			par[i] = i;
		}
		List<int[]> tmp = new ArrayList<>();
		List<int[]> dist = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			tmp.add(new int[] { i + 1, a, b, c });
		}

		tmp.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		for (int i = 0; i < tmp.size() - 1; i++) {
			dist.add(new int[] { tmp.get(i)[0], tmp.get(i + 1)[0], tmp.get(i + 1)[1] - tmp.get(i)[1] });
		}

		tmp.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		for (int i = 0; i < tmp.size() - 1; i++) {
			dist.add(new int[] { tmp.get(i)[0], tmp.get(i + 1)[0], tmp.get(i + 1)[2] - tmp.get(i)[2] });
		}

		tmp.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[3] - o2[3];
			}
		});
		for (int i = 0; i < tmp.size() - 1; i++) {
			dist.add(new int[] { tmp.get(i)[0], tmp.get(i + 1)[0], tmp.get(i + 1)[3] - tmp.get(i)[3] });
		}

		Collections.sort(dist, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		for (int i = 0; i < dist.size(); i++) {
			int a = dist.get(i)[0];
			int b = dist.get(i)[1];
			int c = dist.get(i)[2];
			if (find(a) == find(b)) {
				continue;
			}
			union(a, b);
			result += c;
		}
		bw.write(String.valueOf(result));
		bw.flush();
		br.close();
		bw.close();
	}

	private static int find(int x) {
		if (par[x] == x) {
			return x;
		} else {
			return par[x] = find(par[x]);
		}
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		par[x] = y;
	}
}
