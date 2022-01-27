package Baekjoon.week1.gytj2013;

import java.io.*;
import java.util.*;

public class Guitarist_1495 {
	static int N, S, M;
	static int[] V;
	static boolean[][] F;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = new int[N];
		F = new boolean[N][M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		if(S+V[0]<=M) {
			F[0][S+V[0]]=true;
		}
		if(S-V[0]>=0) {
			F[0][S-V[0]]=true;
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<M+1; j++) {
				if(F[i-1][j]) {
					if(j+V[i]<=M) {
						F[i][j+V[i]]=true;
					}
					if(j-V[i]>=0) {
						F[i][j-V[i]]=true;
					}
				}
			}
		}
		
		for(int i=M; i>=0; i--) {
			if(F[N-1][i]) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
		return;

	}

}
