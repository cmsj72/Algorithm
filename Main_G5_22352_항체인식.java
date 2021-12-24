package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_22352_항체인식 {
	
	static int N,M;
	static int[][] origin;
	static int[][] other;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		origin = new int[N][M];
		other = new int[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int c = 0; c < M; c++) {
				origin[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int c = 0; c < M; c++) {
				other[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		top:
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(origin[r][c] != other[r][c]) {
					//bfs
					BFS(r,c);
					break top;
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(origin[r][c] != other[r][c]) {
					System.out.println("NO");
					return;
				}
			}
		}
		
		System.out.println("YES");
	}
	
	static void BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		int num = origin[r][c];
		queue.offer(new int[] {r,c});
		origin[r][c] = other[r][c];
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(origin[nr][nc] == num) {
					queue.offer(new int[] {nr,nc});
					origin[nr][nc] = other[r][c];
				}
			}
		}
	}
	
//	StringBuilder sb= new StringBuilder();
//	for(int i = 0; i < N; i++) {
//		for(int j = 0; j < M; j++) {
//			sb.append(origin[i][j] + " ");
//		}
//		sb.append("\n");
//	}
//	System.out.println(sb.toString());

//	1 4
//	1 1 1 1
//	1 1 2 2
}
