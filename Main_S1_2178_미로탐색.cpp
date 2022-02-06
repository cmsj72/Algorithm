#include<iostream>
#include<queue>
using namespace std;

#define MAX 100

struct elemt
{
	int r;
	int c;
	int num;
};

int R, C;
char Map[MAX][MAX];
bool visited[MAX][MAX];

int dr[] = { -1,1,0,0 };
int dc[] = { 0,0,-1,1 };

void BFS(int r, int c) {
	/*queue<pair<int, int>> que;*/
	queue<elemt> que;
	que.push(elemt { r,c,1 });
	visited[r][c] = true;
	while (que.empty() == false) {
		int cur_r = que.front().r;
		int cur_c = que.front().c;
		int cur_num = que.front().num;
		que.pop();
		if (cur_r == R - 1 && cur_c == C - 1) {
			cout << cur_num;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = cur_r + dr[i];
			int nc = cur_c + dc[i];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc]) continue;
			if (Map[nr][nc] == '1') {
				que.push(elemt{ nr,nc, cur_num + 1 });
				visited[nr][nc] = true;
			}
		}
	}
}

int main() {
	cin >> R >> C;

	for (int r = 0; r < R; r++) {
		for (int c = 0; c < C; c++) {
			cin >> Map[r][c];
		}
	}
	BFS(0, 0);
}
