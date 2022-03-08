package Baekjoon.week7.gytj2013;

import java.util.*;

public class ComSubstring_5582 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		//System.out.println(s2);
		int[][] dp = new int[s1.length()][s2.length()];
		int answer = 0;
		for(int i=0; i<s1.length(); i++) {
			char c = s1.charAt(i);
			int idx = -1;
			while(true) {
				idx = s2.indexOf(c, idx);
				if(idx == -1) break;
				if(i==0 | idx == 0) {
					dp[i][idx] = 1;
				}else {
					dp[i][idx] = dp[i-1][idx-1]+1;
				}
				answer = Math.max(answer, dp[i][idx]);
				idx++;
			}
		}
		System.out.println(answer);
	}
}
