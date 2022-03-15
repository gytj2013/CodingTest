package Baekjoon.week7.gytj2013;

import java.util.*;

class V{
	int x, y, val;
	V(int x, int y, int val){
		this.x = x;
		this.y = y;
		this.val = val;
	}
}

public class Jailbreak_9376 {
	static int h, w;
	static char[][] map;
	static int[][][] case1;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			h = sc.nextInt();
			w = sc.nextInt();
			map = new char[h+2][w+2];
			case1 = new int[h+2][w+2][3];
			visited = new boolean[h+2][w+2];
			int a=0, b=0, c=0, d=0;
			boolean chk = false;
			for(int i=0; i<h+2; i++) {
				for(int j=0; j<w+2; j++) {
					map[i][j] = '.';
				}
			}
			for(int i=1; i<h+1; i++) {
				String s = sc.next();
				for(int j=1; j<w+1; j++) {
					map[i][j] = s.charAt(j-1);
					if(map[i][j]=='$') {
						map[i][j]='.';
						if(!chk) {
							a=i; b=j;
							chk = true;
						}else {
							c=i; d=j;
						}
					}
				}
			}
			for(int i=0; i<h+2; i++) {
				for(int j=0; j<w+2; j++) {
					case1[i][j][0] = Integer.MAX_VALUE;
					case1[i][j][1] = Integer.MAX_VALUE;
					case1[i][j][2] = Integer.MAX_VALUE;
				}
			}
			Queue<V> q = new LinkedList<>();
			q.add(new V(0,0,0));
			case1[0][0][0] = 0;
			while(!q.isEmpty()) {
				V v = q.poll();
				int x = v.x;
				int y = v.y;
				int val = v.val;
				for(int i=0; i<4; i++) {
					if(x+dx[i]>=0 & x+dx[i]<=h+1 & y+dy[i]>=0 & y+dy[i]<=w+1) {
						if(map[x+dx[i]][y+dy[i]]=='*') continue;
						if(!visited[x+dx[i]][y+dy[i]]) {
							visited[x+dx[i]][y+dy[i]] = true;
							if(map[x+dx[i]][y+dy[i]]=='.') {
								case1[x+dx[i]][y+dy[i]][0] = val;
								q.add(new V(x+dx[i], y+dy[i], val));
							} else {
								case1[x+dx[i]][y+dy[i]][0] = val+1;
								q.add(new V(x+dx[i], y+dy[i], val+1));
							}
						}else {
							if(map[x+dx[i]][y+dy[i]]=='.' & case1[x+dx[i]][y+dy[i]][0]>val) {
								case1[x+dx[i]][y+dy[i]][0] = val;
								q.add(new V(x+dx[i], y+dy[i], val));
							} else if(map[x+dx[i]][y+dy[i]]=='#' & case1[x+dx[i]][y+dy[i]][0]>val+1) {
								case1[x+dx[i]][y+dy[i]][0] = val+1;
								q.add(new V(x+dx[i], y+dy[i], val+1));
							}
						}
					}
				}
			}
			visited = new boolean[h+2][w+2];
			q.add(new V(a,b,0));
			case1[a][b][1] = 0;
			while(!q.isEmpty()) {
				V v = q.poll();
				int x = v.x;
				int y = v.y;
				int val = v.val;
				for(int i=0; i<4; i++) {
					if(x+dx[i]>=0 & x+dx[i]<=h+1 & y+dy[i]>=0 & y+dy[i]<=w+1) {
						if(map[x+dx[i]][y+dy[i]]=='*') continue;
						if(!visited[x+dx[i]][y+dy[i]]) {
							visited[x+dx[i]][y+dy[i]] = true;
							if(map[x+dx[i]][y+dy[i]]=='.') {
								case1[x+dx[i]][y+dy[i]][1] = val;
								q.add(new V(x+dx[i], y+dy[i], val));
							} else {
								case1[x+dx[i]][y+dy[i]][1] = val+1;
								q.add(new V(x+dx[i], y+dy[i], val+1));
							}
						}else {
							if(map[x+dx[i]][y+dy[i]]=='.' & case1[x+dx[i]][y+dy[i]][1]>val) {
								case1[x+dx[i]][y+dy[i]][1] = val;
								q.add(new V(x+dx[i], y+dy[i], val));
							} else if(map[x+dx[i]][y+dy[i]]=='#' & case1[x+dx[i]][y+dy[i]][1]>val+1) {
								case1[x+dx[i]][y+dy[i]][1] = val+1;
								q.add(new V(x+dx[i], y+dy[i], val+1));
							}
						}
					}
				}
			}
			visited = new boolean[h+2][w+2];
			q.add(new V(c,d,0));
			case1[c][d][2] = 0;
			while(!q.isEmpty()) {
				V v = q.poll();
				int x = v.x;
				int y = v.y;
				int val = v.val;
				for(int i=0; i<4; i++) {
					if(x+dx[i]>=0 & x+dx[i]<=h+1 & y+dy[i]>=0 & y+dy[i]<=w+1) {
						if(map[x+dx[i]][y+dy[i]]=='*') continue;
						if(!visited[x+dx[i]][y+dy[i]]) {
							visited[x+dx[i]][y+dy[i]] = true;
							if(map[x+dx[i]][y+dy[i]]=='.') {
								case1[x+dx[i]][y+dy[i]][2] = val;
								q.add(new V(x+dx[i], y+dy[i], val));
							} else {
								case1[x+dx[i]][y+dy[i]][2] = val+1;
								q.add(new V(x+dx[i], y+dy[i], val+1));
							}
						}else {
							if(map[x+dx[i]][y+dy[i]]=='.' & case1[x+dx[i]][y+dy[i]][2]>val) {
								case1[x+dx[i]][y+dy[i]][2] = val;
								q.add(new V(x+dx[i], y+dy[i], val));
							} else if(map[x+dx[i]][y+dy[i]]=='#' & case1[x+dx[i]][y+dy[i]][2]>val+1) {
								case1[x+dx[i]][y+dy[i]][2] = val+1;
								q.add(new V(x+dx[i], y+dy[i], val+1));
							}
						}
					}
				}
			}
			int ans = Integer.MAX_VALUE;
			for(int i=0; i<=h+1; i++) {
				for(int j=0; j<=w+1; j++) {
					case1[i][j][0] += case1[i][j][1]+case1[i][j][2];
					if(map[i][j]=='*') continue;
					if(map[i][j]=='#') case1[i][j][0] -=2;
					ans = Math.min(ans, case1[i][j][0]);
				}
			}
			System.out.println(ans);
		}
	}
}
