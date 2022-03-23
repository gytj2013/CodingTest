package Baekjoon.week9.gytj2013;

import java.util.*;

public class ConSumOfPrimeNum_1644 {
	static int N;
	static int cnt =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		int sum = 0;
		for(int i=N; i>=2; i--) {
			if(!isPrime(i)) continue;
			q.add(i);
			sum+=i;
			if(sum==N) {
				cnt++;
			}
			while(sum>=N) {
				sum-=q.poll();
			}
		}
		System.out.println(cnt);
	}
	private static boolean isPrime(int num) {
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
