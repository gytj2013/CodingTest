import java.io.*;
import java.util.*;

class Info{
	int currX, currY, currSize, time, num;
	Info(int currX, int currY, int currSize, int time, int num){
		this.currX = currX;
		this.currY = currY;
		this.currSize = currSize;
		this.time = time;
		this.num = num;
	}
}

public class BabyShark_16236 {
	static int N;
	static int[][] map;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int x=-1, y=-1;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {x = i; y = j;}
			}
		}
		eat(x, y, 2, 0, 0);
	}
	private static void eat(int X, int Y, int Size, int t, int n) {
		Queue<Info> q = new LinkedList<Info>();
		boolean[][] visited = new boolean[N][N];
		q.add(new Info(X, Y, Size, t, n));
		map[X][Y] = 0;
		visited[X][Y]=true;
		int NX = N;
		int NY = N;
		int NT = 2147483647;
		int NN = 0;
		int NS = 0;
		while(!q.isEmpty()) {
			Info s = q.poll();
			int currX = s.currX;
			int currY = s.currY;
			int currSize = s.currSize;
			int time = s.time;
			int num = s.num;
			if(time+1>NT) break;
			for(int i=0; i<4; i++) {
				if(currX+dx[i]>=0 & currX+dx[i]<N & currY+dy[i]>=0 & currY+dy[i]<N) {
					if(map[currX+dx[i]][currY+dy[i]]>currSize) continue;
					if(visited[currX+dx[i]][currY+dy[i]]) continue;
					visited[currX+dx[i]][currY+dy[i]]=true;
					if(map[currX+dx[i]][currY+dy[i]]==currSize) {
						q.add(new Info(currX+dx[i],currY+dy[i],currSize, time+1, num));
					}else {
						if(map[currX+dx[i]][currY+dy[i]]==0) {
							q.add(new Info(currX+dx[i],currY+dy[i],currSize, time+1, num));
						}else if(currSize==num+1) {
							if(NX>currX+dx[i] | (NX==currX+dx[i] & NY>currY+dy[i])) {
								NX = currX+dx[i];
								NY = currY+dy[i];
								NS = currSize+1;
								NT = time+1;
								NN = 0;
							}
						}else {
							if(NX>currX+dx[i] | (NX==currX+dx[i] & NY>currY+dy[i])) {
								NX = currX+dx[i];
								NY = currY+dy[i];
								NS = currSize;
								NT = time+1;
								NN = num+1;
							}
						}
					}
				}
			}
		}
		if(NS!=0) eat(NX,NY,NS,NT,NN);
		System.out.println(t);
		System.exit(0);
	}
}
