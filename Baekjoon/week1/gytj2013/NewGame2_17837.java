import java.io.*;
import java.util.*;

class Horse{
	int x, y, dir;
	Horse(int x, int y, int dir){
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
}

public class NewGame2_17837 {
	static int N, K;
	static int[][] chess;
	static Deque<Integer>[][] q;
	static ArrayList<Horse> horse = new ArrayList<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		chess = new int[N+2][N+2];
		q = new LinkedList[N+2][N+2];
		
		for(int i=0; i<=N+1; i++) {
			for(int j=0; j<=N+1; j++) {
				chess[i][j] = 2;
				q[i][j] = new LinkedList<>();
			}
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			horse.add(new Horse(x, y, dir));
			q[x][y].add(i);
		}
		int turn=1;
		while(turn<=1000) {
			for(int i=0; i<K; i++) {
				Horse h = horse.get(i);
				//if(q[h.x][h.y].peek()!=i+1) {continue;}
				move(h, false, i+1);
				if(q[h.x][h.y].size()>=4) {
					System.out.println(turn);
					return;
				}
			}
			turn++;
		}
		System.out.println(-1);
		return;
		
	}

	private static void move(Horse h, boolean chk, int i) {
		int x = h.x;
		int y = h.y;
		int dir = h.dir;
		int nx = x+dx[dir-1];
		int ny = y+dy[dir-1];
		
		switch(chess[nx][ny]) {
			case 0 :
				boolean st = false;
				int num = q[x][y].size();
				for(int j=0; j<num; j++) {
					int n = q[x][y].poll();
					if(n==i) { st = true; }
					if(st) {
						q[nx][ny].add(n);
						horse.get(n-1).x = nx;
						horse.get(n-1).y = ny;
					} else {
						q[x][y].add(n);
					}
				}
				break;
			case 1 :
				while(!q[x][y].isEmpty()) {
					int n = q[x][y].pollLast();
					q[nx][ny].add(n);
					horse.get(n-1).x = nx;
					horse.get(n-1).y = ny;
					if(n==i) { break; }
				}
				break;
			case 2 :
				if(!chk) {
					if(dir==1 | dir==3) {
						h.dir = dir+1;
						move(h, true, i);
					}else {
						h.dir = dir-1;
						move(h, true, i);
					}
				}
		}
	}
}