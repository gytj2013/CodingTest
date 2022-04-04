package Baekjoon.week9.gytj2013;

import java.util.*;

public class SumOfTwoArr_2143 {
	static int n, m;
	static long ans = 0; 
	static int[] A, B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long T = sc.nextLong();
		n = sc.nextInt();
		A = new int[n+1];
		for(int i=1; i<=n; i++) {
			A[i] = sc.nextInt();
		}
		m = sc.nextInt();
		B = new int[m+1];
		for(int i=1; i<=m; i++) {
			B[i] = sc.nextInt();
		}
		HashMap<Long, Long> map = new HashMap<>();
		for(int i=1; i<=n; i++) {
			long tmp = 0;
			for(int j=0; j<=n-i; j++) {
				tmp+=A[i+j];
				if(map.containsKey(tmp)) {
					map.replace(tmp, map.get(tmp)+1);
				}else {
					map.put(tmp, (long) 1);
				}
			}
		}
		
		for(int i=1; i<=m; i++) {
			long tmp = 0;
			for(int j=0; j<=m-i; j++) {
				tmp+=B[i+j];
				if(!map.containsKey(T-tmp)) continue;
				ans += map.get(T-tmp);
			}
		}
		System.out.println(ans);
	}
}
