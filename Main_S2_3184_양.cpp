#include<iostream>
#include<queue>
using namespace std;

#define MAX 250

int R, C;
int r_sheep = 0, r_wolf = 0;
char Map[MAX][MAX];
bool visited[MAX][MAX];

int dr[] = { -1,1,0,0 };
int dc[] = { 0,0,-1,1 };

void BFS(int r, int c) {
	int sheep = 0;
	int wolf = 0;
	queue<pair<int, int>> que;
	que.push(make_pair(r, c));
	visited[r][c] = true;
	while (que.empty() == 0) {
		int cur_r = que.front().first;
		int cur_c = que.front().second;
		que.pop();

		if (Map[cur_r][cur_c] == 'v') {
			wolf++;
		}
		if (Map[cur_r][cur_c] == 'o') {
			sheep++;
		}

		for (int i = 0; i < 4; i++) {
			int nr = cur_r + dr[i];
			int nc = cur_c + dc[i];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if (!visited[nr][nc] && Map[nr][nc] != '#') {
				visited[nr][nc] = true;
				que.push(make_pair(nr, nc));
			}
		}
	}
	
	if (sheep > wolf) r_sheep += sheep;
	else r_wolf += wolf;
}

int main() {
	cin >> R >> C;
	for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
			cin >> Map[r][c];
		}
	}

	for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
			if (!visited[r][c]) {
				BFS(r, c);
			}
		}
	}

	cout << r_sheep << " " << r_wolf;
}