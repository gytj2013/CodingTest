package Baekjoon.week1.gytj2013;

import java.io.*;
import java.util.*;

class Point {
	int r, c, cnt;
	Point(int r, int c, int cnt){
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class DeathKnight_16948 {
	static int N;
	static int r1, c1, r2, c2;
	static int min = 0;
	static int[] dx = {-2, -2, 0, 0, 2, 2};
	static int[] dy = {-1, 1, -2, 2, -1, 1};
	static boolean[][] visited;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N][N];
		
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		Queue<Point> q = new LinkedList<Point>();

		q.offer(new Point(r1, c1, 0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<6; i++) {
				int r = p.r+dx[i];
				int c = p.c+dy[i];
				if(r>=0 & r<N & c>=0 & c<N) {
					if(!visited[r][c]) {
						if(r==r2 & c==c2) {
							System.out.println(p.cnt+1);
							return;
						}
						visited[r][c] = true;
						q.offer(new Point(r, c, p.cnt+1));
					}
				}
			}
		}
		System.out.println(-1);
	}
	
}
