package Baekjoon.week4.gytj2013;

import java.io.*;
import java.util.*;

public class Inequality_2529 {
	static int k;
	static String min = "";
	static String max = "0";
	static String[] sign;
	static int[] arr;
	static boolean[] visited = new boolean[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		sign = br.readLine().split(" ");
		arr = new int[k+1];
		for(int i=0; i<k+1; i++) {
			min += "9";
		}
		permu(0);
		System.out.println(max);
		System.out.println(min);
	}
	private static void permu(int cnt) {
		if(cnt == k+1) {
			if(check()) {
				String tmp = "";
				for(int i=0; i<k+1; i++) {
					tmp += arr[i];
				}
				if(min.compareTo(tmp)>0) {
					min = tmp;
				}
				if(max.compareTo(tmp)<0) {
					max = tmp;
				}
			}
			return;
		}
		for(int i=0; i<=9; i++) {
			if(visited[i]) continue;
			arr[cnt] = i;
			visited[i] = true;
			permu(cnt+1);
			visited[i] = false;
		}
	}
	private static boolean check() {
		for(int i=0; i<k; i++) {
			if(sign[i].equals("<")) {
				if(arr[i]>arr[i+1]) {
					return false;
				}
			} else {
				if(arr[i]<arr[i+1]) {
					return false;
				}
			}
		}
		return true;
	}
}
