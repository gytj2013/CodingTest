package Baekjoon.week9.gytj2013;

import java.util.*;

class Node{
	int x, y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Castle_2234 {
	static int N, M;
	static int max = 0;
	static int[] size;
	static int[][] map;
	static int[][] room;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		size = new int[N*M+1];
		map = new int[M][N];
		room = new int[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		Queue<Node> q = new LinkedList<>();
		int num = 1;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(room[i][j]!=0) continue;
				q.add(new Node(i, j));
				room[i][j] = num;
				int cnt = 1;
				while(!q.isEmpty()) {
					Node n = q.poll();
					int x = n.x;
					int y = n.y;
					String tmp = "000"+Integer.toBinaryString(map[x][y]);
					int len = tmp.length()-1;
					for(int t=0; t<4; t++) {
						if(tmp.charAt(len-t)=='0') {
							if(room[x+dx[t]][y+dy[t]]!=0) continue;
							room[x+dx[t]][y+dy[t]] = num;
							cnt++;
							q.add(new Node(x+dx[t], y+dy[t]));
						}
					}
				}
				size[num] = cnt;
				max = Math.max(max, cnt);
				num++;
			}
		}
		int add =0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				//System.out.print(room[i][j]);
				for(int d=0; d<4; d++) {
					if(i+dx[d]>=0 & i+dx[d]<M & j+dy[d]>=0 & j+dy[d]<N) {
						if(room[i][j]==room[i+dx[d]][j+dy[d]]) continue;
						add = Math.max(add,size[room[i][j]]+size[room[i+dx[d]][j+dy[d]]]);
					}
				}
			}
			//System.out.println();
		}
		System.out.println(num-1);
		System.out.println(max);
		System.out.println(add);
	}
}
