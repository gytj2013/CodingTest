import java.io.*;
import java.util.*;

class Node{
	int x, y, cnt, dir;
	Node(int x, int y, int cnt, int dir){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.dir = dir;
	}
}

public class LaserCommu {
	static int W, H;
	static int ans = 1000000000;
	static char[][] map;
	static int[][] visited;
	static int sx=-1, sy, ex, ey;  
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visited = new int[H][W];
		for(int i=0; i<H; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<W; j++) {
				if(map[i][j]=='C') {
					if(sx==-1) {
						sx=i; sy=j;
					}else {
						ex=i; ey=j;
					}
				}
				visited[i][j] = 1000000000;
			}
		}
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy, 0, -1));
		visited[sx][sy] = 0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			//System.out.println(n.x+", "+n.y+", "+n.cnt);
			if(n.x==ex & n.y==ey) {
				ans = Math.min(ans, n.cnt);
				continue;
			}
			for(int i=0; i<4; i++) {
				if(n.x+dx[i]>=0 & n.x+dx[i]<H & n.y+dy[i]>=0 & n.y+dy[i]<W) {
					if(map[n.x+dx[i]][n.y+dy[i]]=='*') continue;
					if(n.dir==-1 | i==n.dir) {
						if(visited[n.x+dx[i]][n.y+dy[i]] < n.cnt) continue;
						visited[n.x+dx[i]][n.y+dy[i]] = n.cnt;
						q.add(new Node(n.x+dx[i], n.y+dy[i], n.cnt, i));
					}
					else {
						if(visited[n.x+dx[i]][n.y+dy[i]] < n.cnt+1) continue;
						visited[n.x+dx[i]][n.y+dy[i]] = n.cnt+1;
						q.add(new Node(n.x+dx[i], n.y+dy[i], n.cnt+1, i));
					}
				}
			}
		}
		System.out.println(ans);
	}
}
