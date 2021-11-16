package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_2589_보물섬 {
	
	static int result = Integer.MIN_VALUE;
	static char[][] map;
	static int R,C;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r = 0; r < R; r++) {
			String line = in.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 'L') {//육지일때
					BFS(r,c);
				}
			}
		}
		System.out.println(result);
	}
	
	static void BFS(int r, int c) {
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c,0});
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(nr <0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != 'L'
						|| visited[nr][nc]) continue;
				queue.offer(new int[] {nr,nc, cur[2]+1});
				visited[nr][nc] = true;
			}
			result = Integer.max(result, cur[2]);
		}
	}

}
