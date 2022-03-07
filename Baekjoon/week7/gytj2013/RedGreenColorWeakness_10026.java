package Baekjoon.week7.gytj2013;

import java.io.*;
import java.util.*;

class Node {
	int x, y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class RedGreenColorWeakness_10026 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		Queue<Node> q = new LinkedList<>(); 
		int num = 0;
		for(int a=0; a<N; a++) {
			for(int b=0; b<N; b++) {
				if(visited[a][b]) continue;
				q.add(new Node(a,b));
				visited[a][b] = true;
				num++;
				while(!q.isEmpty()) {
					Node n = q.poll();
					int x = n.x;
					int y = n.y;
					for(int i=0; i<4; i++) {
						if(x+dx[i]>=0 & x+dx[i]<N & y+dy[i]>=0 & y+dy[i]<N) {
							if(visited[x+dx[i]][y+dy[i]]) continue;
							if(map[x+dx[i]][y+dy[i]]== map[x][y]) {
								visited[x+dx[i]][y+dy[i]] = true;
								q.add(new Node(x+dx[i],y+dy[i]));
							}
						}
					}
				}
			}
		}
		visited = new boolean[N][N];
		Queue<Node> q2 = new LinkedList<>(); 
		int num2 = 0;
		for(int a=0; a<N; a++) {
			for(int b=0; b<N; b++) {
				if(visited[a][b]) continue;
				q2.add(new Node(a,b));
				visited[a][b] = true;
				num2++;
				while(!q2.isEmpty()) {
					Node n = q2.poll();
					int x = n.x;
					int y = n.y;
					for(int i=0; i<4; i++) {
						if(x+dx[i]>=0 & x+dx[i]<N & y+dy[i]>=0 & y+dy[i]<N) {
							if(visited[x+dx[i]][y+dy[i]]) continue;
							if(map[x+dx[i]][y+dy[i]]!= map[x][y] & (map[x][y]=='B' | map[x+dx[i]][y+dy[i]]=='B')) continue;
							else {
								visited[x+dx[i]][y+dy[i]] = true;
								q2.add(new Node(x+dx[i],y+dy[i]));
							}
						}
					}
				}
			}
		}
		System.out.println(num+" "+num2);
	}
}
