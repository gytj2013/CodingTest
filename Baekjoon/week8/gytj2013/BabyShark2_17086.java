package Baekjoon.week8.gytj2013;

import java.util.*;

class Loc{
	int x, y, num;
	Loc(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class BabyShark2_17086 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,-1,-1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Queue<Loc> q;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) continue;
				else {
					q = new LinkedList<>();
					q.add(new Loc(i, j, 0));
					visited = new boolean[N][M];
					while(!q.isEmpty()) {
						Loc a = q.poll();
						if(map[a.x][a.y]==1) {
							ans = Math.max(ans, a.num);
							
							break;
						}
						for(int l=0; l<8; l++) {
							if(a.x+dx[l]<0 | a.x+dx[l] >=N | a.y+dy[l]<0 | a.y+dy[l]>=M) continue;
							if(visited[a.x+dx[l]][a.y+dy[l]]) continue;
							visited[a.x+dx[l]][a.y+dy[l]] = true;
							q.add(new Loc(a.x+dx[l], a.y+dy[l], a.num+1));
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}
