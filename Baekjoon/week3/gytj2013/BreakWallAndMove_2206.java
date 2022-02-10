package Baekjoon.week3.gytj2013;

import java.io.*;
import java.util.*;

class Node{
	int x, y, cnt, wall;
	Node(int x, int y, int cnt, int wall){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.wall = wall;
	}
}

public class BreakWallAndMove_2206 {
	static String[][] map;
	static int[][] visited;
	static int answer =-1;
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		visited = new int[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().split("");
			for(int j=0; j<M; j++) {
				visited[i][j]=N*M;
			}
		}
		q.add(new Node(0,0,1,0));
		visited[0][0]=1;
		while(!q.isEmpty()) {
			//System.out.println(q.size());
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			int cnt = n.cnt;
			int wall = n.wall;
			if(x==N-1 & y==M-1) {
				answer = cnt;
				break;
			}
			for(int a=0; a<4; a++) {
				if(x+dx[a]>=0 & x+dx[a]<N & y+dy[a]>=0 & y+dy[a]<M) {
					if(visited[x+dx[a]][y+dy[a]]>wall) {
						if(map[x+dx[a]][y+dy[a]].equals("0")) {
							q.add(new Node(x+dx[a],y+dy[a],cnt+1, wall));
							visited[x+dx[a]][y+dy[a]] = wall;
						} else if(wall==0) {
							q.add(new Node(x+dx[a],y+dy[a], cnt+1, 1));
							visited[x+dx[a]][y+dy[a]] = 1;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}
}
