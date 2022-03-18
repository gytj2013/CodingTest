import java.util.*;

class Cur{
	int x, y, n;
	Cur(int x, int y, int n){
		this.x = x;
		this.y = y;
		this.n = n;
	}
}

public class RobotVacuum_4991 {
	static int w, h;
	static int rx, ry;
	static int ans;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<Cur> list;
	static int num;
	static boolean[] select;
	static int[] order;
	static int[][] save;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if(w==0 & h==0) break;
			map = new char[h][w];
			ans = Integer.MAX_VALUE;
			list = new ArrayList<>();
			for(int i=0; i<h; i++) {
				String s = sc.next();
				for(int j=0; j<w; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j]=='o') {
						rx = i; ry = j;
					}else if(map[i][j]=='*'){
						list.add(new Cur(i, j, 0));
					}
				}
			}
			num = list.size();
			select = new boolean[num];
			order = new int[num];
			save = new int[num+1][num+1];
			per(0);
			System.out.println(ans);
		}
	}

	private static void per(int cnt) {
		if(ans==-1) return;
		if(cnt == num) {
			int a = 0;
			if(save[order[0]][num]!=0) {
				a = save[order[0]][num];
			}else {
				a = bfs(list.get(order[0]).x, list.get(order[0]).y, a, 0);
				save[order[0]][num] = a;
				save[num][order[0]] = a;
			}
			for(int i=1; i<num; i++) {
				if(a>ans) return;
				if(a==-1) {
					ans = -1;
					break;
				}
				if(save[order[i]][order[i-1]]!=0) {
					a += save[order[i]][order[i-1]];
				}else {
					int tmp = bfs(list.get(order[i]).x, list.get(order[i]).y, a, i);
					save[order[i]][order[i-1]] = tmp-a;
					save[order[i-1]][order[i]] = tmp-a;
					a = tmp;
				}
			}
			if(ans!=-1) ans = Math.min(ans, a);
			return;
		}
		for(int i=0; i<num; i++) {
			if(select[i]) continue;
			select[i] = true;
			order[cnt] = i;
			per(cnt+1);
			select[i] = false;
		}
	}

	private static int bfs(int x, int y, int cnt, int idx) {
		Queue<Cur> q = new LinkedList<>();
		boolean[][] visited = new boolean[h][w];
		//System.out.println(x+", "+y);
		if(idx==0) {
			q.add(new Cur(rx, ry, cnt));
			visited[rx][ry] = true;
		}
		else {
			q.add(new Cur(list.get(order[idx-1]).x, list.get(order[idx-1]).y, cnt));
			visited[list.get(order[idx-1]).x][list.get(order[idx-1]).y] = true;
		}
		while(!q.isEmpty()) {
			Cur c = q.poll();
			//System.out.println(c.x+", "+c.y+", "+c.n);
			if(c.n>ans) {
				return c.n;
			}
			if(c.x==x & c.y==y) {
				return c.n;
			}
			for(int i=0; i<4; i++) {
				if(c.x+dx[i]<0 | c.x+dx[i]>=h | c.y+dy[i]<0 | c.y+dy[i]>=w) continue;
				if(map[c.x+dx[i]][c.y+dy[i]]=='x') continue;
				if(visited[c.x+dx[i]][c.y+dy[i]]) continue;
				visited[c.x+dx[i]][c.y+dy[i]] = true;
				q.add(new Cur(c.x+dx[i],c.y+dy[i], c.n+1));
			}
		}
		return -1;
	}
}
