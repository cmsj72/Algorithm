#include<iostream>

using namespace std;

int N;
int arr[2200][2200];
int result[3];

//https://jaimemin.tistory.com/1521

void func(int r, int c, int size) {
	if (size == 1) {
		if (arr[r][c] == -1) {
			result[0]++;
		}
		else if (arr[r][c] == 0) {
			result[1]++;
		}
		else {
			result[2]++;
		}
	}
	else {
		int cur = arr[r][c];
		bool difFlag = false;
		bool loopFlag = false;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != cur) {
					difFlag = true;
					loopFlag = true;
					break;
				}
			}
			if (loopFlag) break;
		}
		if (difFlag) {
			int div = size / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					func(r + i * div, c + j * div, div);
				}
			}
		}
		else {
			if (cur == -1)
				result[0]++;
			else if (cur == 0)
				result[1]++;
			else
				result[2]++;
		}
	}
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}
	func(0, 0, N);
	for (int i = 0; i < 3; i++) {
		cout << result[i] << endl;
	}
}