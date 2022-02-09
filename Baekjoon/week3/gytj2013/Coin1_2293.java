package Baekjoon.week3.gytj2013;

import java.io.*;
import java.util.*;

public class Coin1_2293 {
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
		}
		Arrays.sort(value);
		num[0]=1;
		for(int i=0; i<n; i++) {
			for(int l=0; l<k; l++) {
				if(l+value[i]>k) {break;}
				num[l+value[i]] += num[l];
			}
		}
		System.out.println(num[k]);
	}
}
