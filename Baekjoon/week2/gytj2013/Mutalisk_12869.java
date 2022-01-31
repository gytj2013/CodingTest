package Baekjoon.week2.gytj2013;

import java.io.*;
import java.util.*;

public class Mutalisk_12869 {
	static int N;
	static int[] hp = new int[3];
	static boolean[][][] visited = new boolean[61][61][61];
	static int answer = 61;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		recurr(hp[0], hp[1], hp[2], 0);
		System.out.println(answer);
		return;
		
	}
	private static void recurr(int x, int y, int z, int cnt) {
		if(x<0) {x=0;}
		if(y<0) {y=0;}
		if(z<0) {z=0;}
		
		if(x==0 & y==0 & z==0) {
			answer = Math.min(answer, cnt);
			//System.out.println(cnt);
			return;
		}
		int max = Math.max(x, Math.max(y, z));
		int min = Math.min(x, Math.min(y, z));
		int mid = x+y+z-max-min;
		
		x=max;
		y=mid;
		z=min;
		
		if(visited[x][y][z]) {return;}
		
		visited[x][y][z] = true;
		recurr(x-9,y-3,z-1, cnt+1);
		recurr(x-9,y-1,z-3, cnt+1);
		recurr(x-3,y-9,z-1, cnt+1);
		recurr(x-3,y-1,z-9, cnt+1);
		recurr(x-1,y-9,z-3, cnt+1);
		recurr(x-1,y-3,z-9, cnt+1);
	
	}
	
}
