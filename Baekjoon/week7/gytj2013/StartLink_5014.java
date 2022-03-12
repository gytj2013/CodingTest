package Baekjoon.week7.gytj2013;

import java.util.*;

class Info{
	int curr, num;
	Info(int curr, int num){
		this.curr = curr;
		this.num = num;
	}
}

public class StartLink_5014 {
	static int F, S, G, U, D;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		visited = new boolean[F+1];
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(S, 0));
		visited[S] = true;
		while(!q.isEmpty()) {
			Info in = q.poll();
			if(in.curr==G) {
				System.out.println(in.num);
				return;
			}
			if(in.curr+U <= F) {
				if(!visited[in.curr+U]) {
					visited[in.curr+U] = true;
					q.add(new Info(in.curr+U, in.num+1));
				}
			}
			if(in.curr-D >= 1) {
				if(!visited[in.curr-D]) {
					visited[in.curr-D] = true;
					q.add(new Info(in.curr-D, in.num+1));
				}
			}
		}
		System.out.println("use the stairs");
	}
}
