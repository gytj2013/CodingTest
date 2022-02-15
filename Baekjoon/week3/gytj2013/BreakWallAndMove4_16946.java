package Baekjoon.week3.gytj2013;

import java.io.*;
import java.util.*;

class Node{
	int x, y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BreakWallAndMove4_16946 {
	static String[][] map;
	static int[][] visited;
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		visited = new int[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().split("");
		}
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		int cnt = 0;
		int tmp = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j].equals("0") & visited[i][j]==0) {
					cnt++;
					Queue<Node> q = new LinkedList<>();
					q.add(new Node(i, j));
					visited[i][j] = cnt;
					tmp = 1;
					while(!q.isEmpty()) {
						Node n = q.poll();
						int x = n.x;
						int y = n.y;
						for(int l=0; l<4; l++) {
							if(x+dx[l]>=0 & x+dx[l]<N & y+dy[l]>=0 & y+dy[l]<M) {
								if(visited[x+dx[l]][y+dy[l]]==cnt) {continue;}
								if(map[x+dx[l]][y+dy[l]].equals("0")) {
									tmp++;
									visited[x+dx[l]][y+dy[l]] = cnt;
									q.add(new Node(x+dx[l], y+dy[l]));
								}
							}
						}
					}
					list.add(tmp);
				}	
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j].equals("0")) {
					sb.append(0);
				}else {
					Set<Integer> set = new HashSet<>();
					for(int l=0; l<4; l++) {
						if(i+dx[l]>=0 & i+dx[l]<N & j+dy[l]>=0 & j+dy[l]<M) {
							set.add(visited[i+dx[l]][j+dy[l]]);
						}
					}
					cnt = 0;
					Iterator<Integer> it = set.iterator(); 
					while(it.hasNext()) {
						cnt+=list.get(it.next());
					}
					sb.append((cnt+1)%10);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
