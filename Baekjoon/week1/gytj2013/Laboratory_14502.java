import java.io.*;
import java.util.*;

class Virus{
	int x, y;
	Virus(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Laboratory_14502 {
	static int N, M;
	static int max=0;
	static int[][] map, tmp;
	static Queue<Virus> q;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmp = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		wall(0);
		System.out.println(max);
		
	}
	private static void wall(int cnt) {
		if(cnt==3) {
			q = new LinkedList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==2) {
						q.add(new Virus(i, j));
					}
				}
			}
			spread();
			max = Math.max(max, count());
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					wall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	private static int count() {
		int num = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tmp[i][j]==0) {
					num++;
				}
			}
		}
		return num;
	}
	private static void spread() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
	
		while(!q.isEmpty()) {
			Virus v = q.poll();
			int x = v.x;
			int y = v.y;
			for(int i=0; i<4; i++) {
				if(x+dx[i]>=0 & x+dx[i]<N & y+dy[i]>=0 & y+dy[i]<M) {
					if(tmp[x+dx[i]][y+dy[i]]==0) {
						tmp[x+dx[i]][y+dy[i]]=2;
						q.add(new Virus(x+dx[i], y+dy[i]));
					}
				}
			}
			
		}
		
	}
}
