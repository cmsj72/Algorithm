package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2573_빙산 {
	static int R,C;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[][] tmap = new int[R][C];
		for(int r = 0; r < R; r++) {
			st= new StringTokenizer(in.readLine(), " ");
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		while(true) {
			//1.빙산이 녹는다
			boolean[][] visited = new boolean[R][C];
			for(int r = 1; r < R-1; r++) {
				for(int c = 1; c < C-1; c++) {
					if(map[r][c] != 0 && !visited[r][c]) {
						BFS1(r,c, map, tmap, visited);
					}
				}
			}
			
			visited = new boolean[R][C];
			int icount = 0;
			//2.빙산의 덩어리 개수 구한다.
			for(int r = 1; r < R-1; r++) {
				for(int c = 1; c < C-1; c++) {
					if(map[r][c] != 0 && !visited[r][c]) {
						BFS2(r,c, map, tmap, visited);
						icount++;
					}
				}
			}
			if(icount >= 2) {
				System.out.println(year);
				break;
			}else {
				if(icount == 0) {
					System.out.println(0);
					break;
				}
			}
			for(int r = 1; r < R-1; r++) {
				for(int c = 1; c < C-1; c++) {
					map[r][c] = tmap[r][c];
				}
			}
			year++;
		}
	}
	
	static void BFS1(int r, int c, int[][] map, int[][] tmap, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int count = 0;
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(map[nr][nc] == 0)  {
					count++;
				}else if(!visited[nr][nc]){
					visited[nr][nc] = true;
					queue.add(new int[] {nr,nc});
				}
			}
			if(map[cur[0]][cur[1]] - count > 0) {
				tmap[cur[0]][cur[1]] = map[cur[0]][cur[1]] - count;
			}else {  
				tmap[cur[0]][cur[1]] = 0;
			}
		}
	}
	
	static void BFS2(int r, int c, int[][] map, int[][] tmap, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {r,c});
		visited[r][c] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if(map[nr][nc] != 0 && !visited[nr][nc]){
					visited[nr][nc] = true;
					queue.add(new int[] {nr,nc});
				}
			}			
		}
	}

}
