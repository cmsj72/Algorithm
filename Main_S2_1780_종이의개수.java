package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_1780_종이의개수 {
	
	static int[][] arr;
	static int[] result = new int[3];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 0번째 인덱스 : -1, 1번째 : 0, 2번째 : 1
		int N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		func(0,0, N);
		for(int i = 0; i < 3; i++) {
			System.out.println(result[i]);
		}
	}
	
	
	static void func(int r, int c, int size) {
		if(size == 1) {
			if(arr[r][c] == -1) {
				result[0]++;
			}else if(arr[r][c] == 0) {
				result[1]++;
			}else {
				result[2]++;
			}
		}else {
			int cur = arr[r][c];
			boolean flag = false;
			top:
			for(int i = r; i < r + size; i++) {
				for(int j = c; j < c + size; j++) {
					if(arr[i][j] != cur) {
						flag = true;
						break top;
					}
				}
			}
			if(flag) {// 다르다면
				int div = size/ 3;
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						func(r + i * div, c + j * div, div);
					}
				}
			}else {//같다면
				if(cur == -1) {
					result[0]++;
				}else if(cur == 0) {
					result[1]++;
				}else {
					result[2]++;
				}
			}
		}		
	}
}
