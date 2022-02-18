import java.io.*;
import java.util.*;

public class Kriiiboard_11058 {
	static int N;
	static long[] maxNum = new long[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=1; i<=6; i++) {
			maxNum[i] = i;
		}
		for(int i=7; i<=N; i++) {
			maxNum[i] = maxNum[i-1];
			for(int j=2; j<5; j++) {
				maxNum[i] = Math.max(maxNum[i], maxNum[i-(j+1)]*j);
			}
		}
		System.out.println(maxNum[N]);
	}
}
