package Baekjoon.week1.gytj2013;

import java.io.*;
import java.util.*;

class Node{
	int x, y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class TwoCoin_16197 {
	static int N, M;
	static int min = 11;
	static String[][] board;
	static Node coin[] = new Node[2];
	static int[] dx = {0, 0, -1, 1}; //오른, 왼, 위, 아
	static int[] dy = {1, -1, 0, 0};
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new String[N][M];
		int num = 0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			board[i] = str.split("");
			for(int j=0; j<M; j++) {
				if(board[i][j].equals("o")) {
					board[i][j] = ".";
					coin[num] = new Node(i, j);
					num++;
				}
			}
		}
		
		recurr(0, 0);
		if(min!=11) {
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
	}

	private static void recurr(int turn, int out) {
		if(turn>10) { return; }
			
		if(out==1) {
			min = Math.min(min, turn);
			return;
		} else if(out>1) {
			return;
		}
		int[] x = new int[2];
		int[] y = new int[2];
		for(int i=0; i<4; i++) {
			int block=0;
			for(int j=0; j<2; j++) {
				x[j] = coin[j].x;
				y[j] = coin[j].y;
				if(x[j]+dx[i]<0 | x[j]+dx[i]>=N | y[j]+dy[i]<0 | y[j]+dy[i]>=M) {
					out++;
				}
				else if(board[x[j]+dx[i]][y[j]+dy[i]].equals(".")) {
					coin[j].x += dx[i];
					coin[j].y += dy[i];
				}else {
					block++;
				}
			}
			if(block==2) {
				continue;
			}
			recurr(turn+1, out);
			for(int j=0; j<2; j++) {
				if(x[j]+dx[i]<0 | x[j]+dx[i]>=N | y[j]+dy[i]<0 | y[j]+dy[i]>=M) {
					out--;
				}
				else if(coin[j].x!=x[j] | coin[j].y!=y[j]) {
					coin[j].x -= dx[i];
					coin[j].y -= dy[i];
				}
			}
		}
		
	}
}
