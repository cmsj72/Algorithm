#include<iostream>
using namespace std;

#define MAX 6600

int N;
char arr[MAX][MAX];

void recur(int r, int c, int size) {
	int n_size = size / 3;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (i == 1 && j == 1) continue;
			if (size > 3) {
				recur(r + (n_size * i), c + (n_size * j), n_size);
			}
			else {
				arr[r + i][c + j] = '*';
			}
		}
	}
}

int main() {
	cin >> N;
	
	recur(0, 0, N);
	for (int r = 0; r < N; r++) {
		for (int c = 0; c < N; c++) {
			if (arr[r][c] == '*') {
				cout << arr[r][c];
			}
			else {
				cout << ' ';
			}
		}
		cout << endl;
	}
}