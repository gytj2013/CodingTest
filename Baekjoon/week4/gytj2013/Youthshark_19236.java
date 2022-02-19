package Baekjoon.week4.gytj2013;

import java.io.*;
import java.util.*;

class fish{
	int x, y, dir;
	fish(int x, int y, int dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

public class Youthshark_19236 {
	static int answer=0;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) throws IOException {
		int[][] ocean = new int[4][4];
		fish[] info = new fish[18];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				ocean[i][j] = num;
				info[num] = new fish(i, j, dir);
				//System.out.println(num+", "+dir);
			}
		}
		info[17] = new fish(0, 0, info[ocean[0][0]].dir);
		info[ocean[0][0]] = null;
		int n = ocean[0][0];
		ocean[0][0] = 17;
		prey(n, ocean, info);
		System.out.println(answer);
	}
	private static void prey(int ans, int[][] ocean, fish[] info) {	
		for(int i=1; i<=16; i++) {
			if(info[i]==null) {continue;}
			int x = info[i].x;
			int y = info[i].y;
			int dir = info[i].dir;
			for(int j=0; j<8; j++) {
				if(x+dx[dir]<0 | x+dx[dir]>=4 | y+dy[dir]<0 | y+dy[dir]>=4) {
					if(dir==7) { dir = 0;}
					else {dir++;}
				}else if(ocean[x+dx[dir]][y+dy[dir]]==17) {
					if(dir==7) { dir = 0;}
					else {dir++;}
				}else {
					int tmp = ocean[x+dx[dir]][y+dy[dir]];
					ocean[x+dx[dir]][y+dy[dir]] = i;
					info[i].x = x+dx[dir];
					info[i].y = y+dy[dir];
					info[i].dir = dir;
					ocean[x][y] = tmp;
					if(info[tmp]!=null) {
						info[tmp].x = x;
						info[tmp].y = y;
					}
					break;
				}
			}
		}
		int[][] otmp = new int[4][4];
		fish[] itmp = new fish[18];
		int xs = info[17].x;
		int ys = info[17].y;
		int dir = info[17].dir;
		boolean chk = false;
		for(int i=1; i<=3; i++) {
			int x = xs+i*dx[dir];
			int y = ys+i*dy[dir];
			if(x>=0 & x<4 & y>=0 & y<4) {
				int tmp = ocean[x][y];
				if(info[tmp]==null | tmp==17) {continue;}
				for(int a=0; a<4; a++) {
					for(int b=0; b<4; b++) {
						otmp[a][b] = ocean[a][b];
					}
				}
				for(int a=1; a<18; a++) {
					if(info[a]!=null) {
						itmp[a] = new fish(info[a].x, info[a].y, info[a].dir);
					}
				}
				int tmpD = itmp[tmp].dir;
				otmp[x][y] = 17;
				otmp[xs][ys] = 0;
				itmp[tmp] = null;
				itmp[17].x = x;
				itmp[17].y = y;
				itmp[17].dir = tmpD;
				chk = true;
				prey(ans+tmp, otmp, itmp);
			}
		}
		if(!chk) {
			answer = Math.max(answer, ans);
			return;
		}
	}
}
