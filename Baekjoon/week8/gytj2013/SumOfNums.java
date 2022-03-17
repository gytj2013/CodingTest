import java.util.*;

public class SumOfNums {
	static int N, M;
	static int[] A;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		int sum = 0;
		int st = 0;
		for(int i=0; i<=N; i++) {
			if(sum==M) {
				ans++;
				sum -= A[st];
				st++;
			}
			if(sum>M) {
				sum -= A[st];
				st++;
				i--;
				while(sum>M) {
					sum -= A[i];
					i--;
				}
				continue;
			}
			if(i<N) sum += A[i];
		}
		System.out.println(ans);
	}
}
