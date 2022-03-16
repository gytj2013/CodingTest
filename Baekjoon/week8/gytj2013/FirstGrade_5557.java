package Baekjoon.week8.gytj2013;

import java.util.*;

public class FirstGrade_5557 {
	static int N;
	static int[] arr;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		long[][] dp = new long[N-1][21];
		
		dp[0][arr[0]] = 1;
		for(int i=0; i<N-2; i++) {
			for(int j=0; j<21; j++) {
				if(dp[i][j]!=0) {
					if(j+arr[i+1]<=20) {
						dp[i+1][j+arr[i+1]] += dp[i][j];
					}
					if(j-arr[i+1]>=0) {
						dp[i+1][j-arr[i+1]] += dp[i][j];
					}
				}
			}
		}
		
		System.out.println(dp[N-2][arr[N-1]]);
	}
}
