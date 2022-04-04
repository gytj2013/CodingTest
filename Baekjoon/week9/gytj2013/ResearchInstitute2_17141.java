package Baekjoon.week9.gytj2013;

import java.util.*;

class XY{
	int x, y;
	XY(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class ResearchInstitute2_17141 {
	static int N, M;
	static List<XY> list = new ArrayList<>();
	static int[][] map;
	static int[][] virus;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int ans = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		virus = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++){
				map[i][j] = sc.nextInt();
				if(map[i][j]==2) {
					list.add(new XY(i, j));
				}
				virus[i][j] = Integer.MAX_VALUE;
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}
	private static void comb(int cnt, int st) {
		if(cnt==M) {
			int t = -1;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++){
					if(map[i][j]==1) continue;
					else if(virus[i][j]==Integer.MAX_VALUE) return;
					t=Math.max(t, virus[i][j]);
					//System.out.print(virus[i][j]);
				}
				//System.out.println();
			}
			//System.out.println(t);
			if(ans==-1 & t!=-1) {
				ans = t;
			}else if(t!=-1){
				ans = Math.min(ans, t);
			}
			return;
		}
		for(int i=st; i<list.size(); i++) {
			int[][] tmp = new int[N][N];
			for(int l=0; l<N; l++) {
				for(int j=0; j<N; j++){
					tmp[l][j] = virus[l][j];
				}
			}
			Queue<XY> q = new LinkedList<>();
			q.add(list.get(i));
			virus[list.get(i).x][list.get(i).y] = 0;
			while(!q.isEmpty()) {
				XY xy = q.poll();
				for(int d=0; d<4; d++) {
					if(xy.x+dx[d]<0 | xy.x+dx[d]>=N | xy.y+dy[d]<0 | xy.y+dy[d]>=N) continue;
					if(map[xy.x+dx[d]][xy.y+dy[d]]==1) continue;
					if(virus[xy.x+dx[d]][xy.y+dy[d]] > virus[xy.x][xy.y]+1) {
						virus[xy.x+dx[d]][xy.y+dy[d]] = virus[xy.x][xy.y]+1;
						q.add(new XY(xy.x+dx[d], xy.y+dy[d]));
					}
				}
			}
			comb(cnt+1, i+1);
			for(int l=0; l<N; l++) {
				for(int j=0; j<N; j++){
					virus[l][j] = tmp[l][j];
				}
			}
		}
	}
}
