package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14719_빗물 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		st = new StringTokenizer(in.readLine(), " ");
		
		for(int j = 0; j < W; j++) {
			int count = Integer.parseInt(st.nextToken());
			for(int i = H - 1; i >= 0; i--) {
				if(count > 0) {
					map[i][j] = 1;
					count--;
				}else {
					map[i][j] = 0;
				}
			}
		}
		
		int result = 0;
		for(int i = H-1; i>= 0; i--) {
			int count = 0;
			boolean flag = false;
			for(int j = 0; j < W; j++) {
				if(map[i][j] == 1) {
					if(flag) {
						result += count;
						count = 0;
					}else {
						flag = true;
					}
				}else {
					if(flag) {
						count++;
					}
				}
			}
		}
		System.out.println(result);
		
//		for(int i = 0; i < H; i++) {
//			for(int j = 0; j < W; j++) {
//				System.out.printf("%d ", map[i][j]);
//			}
//			System.out.println();
//		}
	}

}
