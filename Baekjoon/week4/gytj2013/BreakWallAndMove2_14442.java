import java.io.*;
import java.util.*;

class Node{
	int x, y, cnt, wall;
	Node(int x, int y, int cnt, int wall){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.wall = wall;
	}
}

public class BreakWallAndMove2_14442 {
	static char[][] map;
	static boolean[][][] visited;
	static int answer =-1;
	static int N, M, K;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][K+2];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			//Arrays.fill(visited[i], K+1);
		}
		q.add(new Node(0,0,1,0));
		visited[0][0][0]=true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			int cnt = n.cnt;
			int wall = n.wall;
			if(x==N-1 & y==M-1) {
				answer = cnt;
				break;
			}
			for(int a=0; a<4; a++) {
				if(x+dx[a]>=0 & x+dx[a]<N & y+dy[a]>=0 & y+dy[a]<M) {
					int nx = x+dx[a];
					int ny = y+dy[a];
					if(map[nx][ny]=='0' & !visited[nx][ny][wall]) {
						q.add(new Node(nx,ny,cnt+1, wall));
						visited[nx][ny][wall] = true;
					} 
					if(map[nx][ny]=='1' & wall<K & !visited[nx][ny][wall+1]) {
						q.add(new Node(nx,ny, cnt+1, wall+1));
						visited[nx][ny][wall+1] = true;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
