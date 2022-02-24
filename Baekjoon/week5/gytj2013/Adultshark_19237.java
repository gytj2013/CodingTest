import java.io.*;
import java.util.*;

public class Adultshark_19237 {
	static int answer = 0;
	static int N, M, k;
	static int[][][] ocean;
	static int[][] map;
	static int[] curr;
	static int[][][] dir;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ocean = new int[N][N][2];
		curr = new int[M+1];
		dir = new int[M+1][5][4];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				ocean[i][j][0] = Integer.parseInt(st.nextToken());
				map[i][j] = ocean[i][j][0];
				if(ocean[i][j][0]!=0) { ocean[i][j][1] = k; }
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<M+1; i++) {
			curr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<M+1; i++) {
			for(int j=1; j<=4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int l=0; l<4; l++) {
					dir[i][j][l] = Integer.parseInt(st.nextToken());
				}
			}
		}
		int left = M;
		int time = 0;
		while(time<=1000) {
			if(left==1) {
				System.out.println(time);
				return;
			}
			moveDelete();
			left = smell();
			time++;
			
		}
		System.out.println(-1);
		
	}
	private static int smell() {
		int left = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) {
					if(ocean[i][j][1]>0) ocean[i][j][1]--;
				}else {
					ocean[i][j][0] = map[i][j];
					ocean[i][j][1] = k;
					left++;
				}
			}
		}
		return left;
	}
	private static void moveDelete() {
		int[][] tmp = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) continue;
				int num = map[i][j];
				boolean chk = false;
				for(int l=0; l<4; l++) {
					int d = dir[num][curr[num]][l];
					if(i+dx[d]>=0 & i+dx[d]<N & j+dy[d]>=0 & j+dy[d]<N) {
						if(ocean[i+dx[d]][j+dy[d]][1]==0) {
							if(tmp[i+dx[d]][j+dy[d]]==0 | tmp[i+dx[d]][j+dy[d]]>num) {
								tmp[i+dx[d]][j+dy[d]] = num;
								curr[num] = d;
							}
							chk = true;
							break;
						}
					}
				}
				if(!chk) {
					for(int l=0; l<4; l++) {
						int d = dir[num][curr[num]][l];
						if(i+dx[d]>=0 & i+dx[d]<N & j+dy[d]>=0 & j+dy[d]<N) {
							if(ocean[i+dx[d]][j+dy[d]][0]==num) {
								curr[num] = d;
								tmp[i+dx[d]][j+dy[d]] = num;
								break;
							}
						}
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=tmp[i][j];
			}
		}
	}
}
