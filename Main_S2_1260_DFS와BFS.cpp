#include<iostream>
#include<queue>
using namespace std;
#define MAX 1001

int N, M, V;
int map[MAX][MAX];
bool visited[MAX];
queue<int> q;

void reset() {
	//정점의 방문을 체크하는 배열을 초기화
	for (int i = 1; i <= N; i++) {
		visited[i] = false;
	}
}

void DFS(int v) {
	visited[v] = true;
	cout << v << " ";

	for (int i = 1; i <= N; i++) {
		if (map[v][i] == 1 && visited[i] == 0) {
			//현재 정점과 연결되어있고 방문되지 않았으면 
			DFS(i);
		}
	}
}

void BFS(int v) {
	q.push(v);
	visited[v] = true;
	cout << v << " ";

	while (!q.empty()) {
		v = q.front();
		q.pop();

		for (int w = 1; w <= N; w++) {
			if (map[v][w] == 1 && visited[w] == 0) {
				q.push(w);
				visited[w] = true;
				cout << w << " ";
			}
		}
	}
}

int main() {
	cin >> N >> M >> V;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		map[a][b] = 1;
		map[b][a] = 1;
	}

	reset();
	DFS(V);

	cout << '\n';

	reset();
	BFS(V);

	return 0;
}