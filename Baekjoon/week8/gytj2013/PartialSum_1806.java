import java.util.*;

public class PartialSum_1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = N+1;
		long sum = 0;
		int st = 0;
		for(int i=0; i<N+1; i++) {
			while(sum>=S) {
				ans = Math.min(ans, i-st);
				sum -= arr[st];
				st++;
			}
			if(i<N) sum += arr[i];
		}
		if(ans==N+1) ans = 0;
		System.out.println(ans);
	}
}
