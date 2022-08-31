#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>

using namespace std;

int n, m, res = 987654321;
int map[10][10];
int rx, ry, bx, by, gx, gy;
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };

void dfs(int cnt, int rx, int ry, int bx, int by, int status) // status : 0=nothing, 1=red, 2=blue, 3=both, 4=nothing changed
{
    if (cnt > 10) {
        return;
    }
    else if (status == 1) {
        if (cnt < res) {
            res = cnt;
        }
        return;
    }
    else if (status == 2 || status == 3) {
        return;
    }
    else if (status == 0) {
        for (int i = 0; i < 4; i++) {
            int nrx = rx, nry = ry, nbx = bx, nby = by, nstatus;
            vector<pair<int, int>> red, blue;
            while (true) {
                if (nrx >= 0 && nrx < n && nry >= 0 && nry < m && map[nrx][nry] == 0) {
                    red.push_back({ nrx, nry });
                    nrx += dx[i];
                    nry += dy[i];
                }
                else {
                    nrx -= dx[i];
                    nry -= dy[i];
                    break;
                }
            }
            while (true) {
                if (nbx >= 0 && nbx < n && nby >= 0 && nby < m && map[nbx][nby] == 0) {
                    blue.push_back({ nbx, nby });
                    nbx += dx[i];
                    nby += dy[i];
                }
                else {
                    nbx -= dx[i];
                    nby -= dy[i];
                    break;
                }
            }
            if (nrx == nbx && nry == nby) {
                if (i == 0) {
                    if (rx < bx) {
                        nbx++;
                    }
                    else if (rx > bx) {
                        nrx++;
                    }
                }
                else if (i == 1) {
                    if (ry < by) {
                        nry--;
                    }
                    else if (ry > by) {
                        nby--;
                    }
                }
                else if (i == 2) {
                    if (rx < bx) {
                        nrx--;
                    }
                    else if (rx > bx) {
                        nbx--;
                    }
                }
                else if (i == 3) {
                    if (ry < by) {
                        nby++;
                    }
                    else if (ry > by) {
                        nry++;
                    }
                }
            }
            bool flag1 = false, flag2 = false;
            for (int i = 0; i < red.size(); i++) {
                if (red[i].first == gx && red[i].second == gy) {
                    flag1 = true;
                }
            }
            for (int i = 0; i < blue.size(); i++) {
                if (blue[i].first == gx && blue[i].second == gy) {
                    flag2 = true;
                }
            }
            if (!flag1 && !flag2) {
                nstatus = 0;
            }
            else if (flag1 && !flag2) {
                nstatus = 1;
            }
            else if (!flag1 && flag2) {
                nstatus = 2;
            }
            else if (flag1 && flag2) {
                nstatus = 3;
            }
            if (rx == nrx && ry == nry && bx == nbx && by == nby) {
                continue;
            }
            dfs(cnt + 1, nrx, nry, nbx, nby, nstatus);
        }
    }
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            char tmp;
            cin >> tmp;
            if (tmp == '#')
            {
                map[i][j] = 1;
            }
            else if (tmp == '.')
            {
                map[i][j] = 0;
            }
            else if (tmp == 'R')
            {
                map[i][j] = 0;
                rx = i;
                ry = j;
            }
            else if (tmp == 'B')
            {
                map[i][j] = 0;
                bx = i;
                by = j;
            }
            else if (tmp == 'O')
            {
                map[i][j] = 0;
                gx = i;
                gy = j;
            }
        }
    }
    dfs(0, rx, ry, bx, by, 0);
    if (res == 987654321) {
        cout << -1;
    }
    else {
        cout << res;
    }
}