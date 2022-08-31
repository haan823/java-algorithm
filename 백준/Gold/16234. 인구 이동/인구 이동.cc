#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, l, r, cnt;
int map[50][50];
int visit[50][50];
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int simulation() {
	vector<vector<pair<int, int>>> res;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			visit[i][j] = 0;
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!visit[i][j]) {
				vector<pair<int, int>> v;
				queue<pair<int, int>> q;
				q.push({ i, j });
				while (!q.empty()) {
					int x = q.front().first;
					int y = q.front().second;
					q.pop();
					v.push_back({ x, y });
					visit[x][y] = 1;
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny]) {
							int tmp = abs(map[x][y] - map[nx][ny]);
							if (tmp >= l && tmp <= r) {
								q.push({ nx, ny });
								visit[nx][ny] = 1;
							}
						}
					}
				}
				if (v.size() > 1) {
					res.push_back(v);
				}
				else if(v.size() == 1) {
					visit[v[0].first][v[0].second] = 0;
				}
			}
		}
	}
	for (int i = 0; i < res.size(); i++) {
		int total = res[i].size();
		int sum = 0;
		for (int j = 0; j < total;  j++) {
			sum += map[res[i][j].first][res[i][j].second];
		}
		int solve = sum / total;
		for (int j = 0; j < total; j++) {
			map[res[i][j].first][res[i][j].second] = solve;
		}
	}
	return res.size();
}

int main() {
	cin >> n >> l >> r;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
		}
	}
	while (true) {
		int i = simulation();
		if (!i) {
			break;
		}
		else {
			cnt++;
		}
	}
	cout << cnt;
}