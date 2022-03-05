import java.io.*;
import java.util.*;

class Ball {
	int rx, ry, bx, by, cnt;
	Ball(int rx, int ry, int bx, int by, int cnt){
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.cnt = cnt;
	}
}

public class MarbleEscape2_13460 {
	static int N, M;
	static char[][] loc;
	static Boolean[][][][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] bdx = {1, 0, -1, 0};
	static int[] bdy = {0, -1, 0, 1};
	static int ans=-1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		loc = new char[N][M];
		visited = new Boolean[N][M][N][M];
		int RX = 0, RY = 0, BX = 0, BY = 0;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				loc[i][j] = s.charAt(j);
				if(loc[i][j]=='R') {
					RX = i; RY = j;
					loc[i][j] = '.';
				}else if(loc[i][j]=='B') {
					BX = i; BY = j;
					loc[i][j] = '.';
				}
			}
		}
		Queue<Ball> q = new LinkedList<>();
		visited[RX][RY][BX][BY] = true;
		q.add(new Ball(RX, RY, BX, BY, 0));
		while(!q.isEmpty()) {
			Ball b = q.poll();
			if(b.cnt>10) {continue;}
			if(loc[b.rx][b.ry]=='O') {
				if(ans!=-1) ans = Math.min(ans, b.cnt);
				else ans = b.cnt;
				if(ans==1) break;
				continue;
			}
			int rX = b.rx; int rY = b.ry; int bX = b.bx; int bY = b.by;
			for(int i=0; i<4; i++) {
				int rx = rX; int ry = rY; int bx = bX; int by = bY;
				for(int j=1; j<100; j++) {
					if((rX+j*dx[i])>=0 & (rX+j*dx[i])<N & (rY+j*dy[i])>=0 & (rY+j*dy[i])<M) {
						if(rX+j*dx[i]==bX & rY+j*dy[i]==bY) {
							rx = -1;
							break;
						}
						if(loc[rX+j*dx[i]][rY+j*dy[i]]=='O') {
							rx = rX+j*dx[i]; ry = rY+j*dy[i];
							break;
						}
						else if(loc[rX+j*dx[i]][rY+j*dy[i]]=='#') {
							rx = rX+(j-1)*dx[i]; ry = rY+(j-1)*dy[i];
							break;
						}
					}else break;
				}
				
				for(int j=1; j<100; j++) {
					if(bX+j*dx[i]>=0 & bX+j*dx[i]<N & bY+j*dy[i]>=0 & bY+j*dy[i]<M) {
						if(bX+j*dx[i]==rx & bY+j*dy[i]==ry) {
							bx = rx+bdx[i];
							by = ry+bdy[i];
							break;
						}
						if(loc[bX+j*dx[i]][bY+j*dy[i]]=='O') {
							bx = bX+j*dx[i]; by = bY+j*dy[i];
							break;
						}
						else if(loc[bX+j*dx[i]][bY+j*dy[i]]=='#') {
							bx = bX+(j-1)*dx[i]; by = bY+(j-1)*dy[i];
							break;
						}
					}else break;
				}
				
				if(rx==-1) {
					rx = bx+bdx[i];
					ry = by+bdy[i];
				}
				if(visited[rx][ry][bx][by]==null & loc[bx][by]!='O') {
					if(loc[rx][ry]=='O' & bx==rx+bdx[i] & by==ry+bdy[i]) continue;
					visited[rx][ry][bx][by] = true;
					q.add(new Ball(rx, ry, bx, by, b.cnt+1));
				}
			}
		}
		
		System.out.println(ans);
	}
}
