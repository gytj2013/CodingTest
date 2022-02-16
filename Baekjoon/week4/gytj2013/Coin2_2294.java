package Baekjoon.week4.gytj2013;

import java.io.*;
import java.util.*;

public class Coin2_2294 {
	static int n, k;
	static int[] value;
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		value = new int[n];
		num = new int[k+1];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			value[i] = Integer.parseInt(st.nextToken());
			if(value[i]<=k) num[value[i]] = 1;
		}
		for(int i=1; i<k; i++) {
			if(num[i]!=0) {
				for(int j=0; j<n; j++) {
					if(i+value[j]>k) {continue;}
					if(num[i+value[j]]==0) {
						num[i+value[j]] = num[i]+1;
					}else {
						num[i+value[j]] = Math.min(num[i+value[j]],num[i]+1);
					}
				}
			}
		}
		if(num[k]==0) {System.out.println(-1);}
		else {System.out.println(num[k]);}
	}
}
