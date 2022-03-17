package Baekjoon.week8.gytj2013;

import java.util.*;

class Node{
	int x, y, cnt, hor;
	Node(int x, int y, int cnt, int hor){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.hor = hor;
	}
}

public class MonkeyWannabeHorse_1600 {
	static int K, W, H;
	static int[][] map;
	static int ans = -1;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static boolean[][][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,0,0));
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int x = curr.x;
			int y = curr.y;
			int cnt = curr.cnt;
			int hor = curr.hor;
			if(ans!=-1 & ans<cnt) continue;
			if(x==H-1 & y==W-1) {
				ans = cnt;
				continue;
			}
			for(int i=0; i<4; i++) {
				if(x+dx[i]<0 | x+dx[i]>=H | y+dy[i]<0 | y+dy[i]>=W) continue;
				if(map[x+dx[i]][y+dy[i]]==1) continue;
				if(visited[x+dx[i]][y+dy[i]][hor]) continue;
				visited[x+dx[i]][y+dy[i]][hor] = true;
				q.add(new Node(x+dx[i], y+dy[i], cnt+1, hor));
			}
			for(int i=0; i<8; i++) {
				if(hor==K) break;
				if(x+hx[i]<0 | x+hx[i]>=H | y+hy[i]<0 | y+hy[i]>=W) continue;
				if(map[x+hx[i]][y+hy[i]]==1) continue;
				if(visited[x+hx[i]][y+hy[i]][hor+1]) continue;
				visited[x+hx[i]][y+hy[i]][hor+1] = true;
				q.add(new Node(x+hx[i], y+hy[i], cnt+1, hor+1));
			}
			
		}
		System.out.println(ans);
	}
}
