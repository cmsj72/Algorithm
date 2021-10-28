package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_6593_상범빌딩 {
	static int L,R,C;
	static char[][][] map;
	static boolean[][][] visited;
	static int[] dl = {-1,1,0,0,0,0};
	static int[] dr = {0,0,-1,1,0,0};
	static int[] dc = {0,0,0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0) break;
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			int start_L = 0, start_R = 0, start_C = 0;
			for(int i = 0; i < L; i++) {
				for(int r = 0; r < R; r++) {
					String line = in.readLine();
					for(int c = 0; c < C; c++) {
						map[i][r][c] = line.charAt(c);
						if(map[i][r][c] == 'S') {
							start_L = i;
							start_R = r;
							start_C = c;
						}
					}
				}
				in.readLine();
			}
			
			int result = BFS(start_L, start_R, start_C);
			if(result == -1) {
				System.out.println("Trapped!");
			}else {
				System.out.printf("Escaped in %d minute(s).\n", result);
			}
		}		
		//입력배열 확인용
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0; i < L; i++) {			
//			for(int r = 0; r < R; r++) {
//				for(int c = 0; c < C; c++) {
//					sb.append(map[i][r][c]);
//				}
//				sb.append("\n");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb.toString());
	}
	
	static int BFS(int l, int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {l,r,c, 0});
		visited[l][r][c] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0; i < 6; i++) {
				int nl = cur[0] + dl[i];
				int nr = cur[1] + dr[i];
				int nc = cur[2] + dc[i];
				int count = cur[3];
				if(nl < 0 || nl >= L || nr < 0 || nr >= R || nc < 0 || nc >= C  
						|| visited[nl][nr][nc]) continue;
				if(map[nl][nr][nc] == '.') {
					visited[nl][nr][nc] = true;
					queue.offer(new int[] {nl,nr,nc, count+1});
				}else if(map[nl][nr][nc] == 'E') {
					return count+1;
				}
			}
		}
		return -1;
	}
}
