package Baekjoon.week3.gytj2013;

import java.io.*;
import java.util.*;

public class LevelHamburger_16974 {
	static int N;
	static long X;
	static long[] P = new long[51];
	static long[] L = new long[51];
	static long answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		P[0]=1;
		L[0]=1;
		for(int i=1; i<=N; i++) {
			P[i]=2*P[i-1]+1;
			L[i]=2*L[i-1]+3;
		}
		count(N, X);
		System.out.println(answer);
	}
	private static void count(int n, long x) {
		if(x>=1 & n==0) {
			answer+=1;
			return;
		}
		if(x<=1) {return;}
		if(L[n]/2<x) {
			answer += P[n-1]+1;
			count(n-1, x-L[n-1]-2);
		}else {
			count(n-1, x-1);
		}
		
	}
}
