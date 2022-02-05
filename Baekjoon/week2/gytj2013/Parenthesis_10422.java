import java.io.*;
import java.util.*;

public class Parenthesis_10422 {
	static int T;
	static int L;
	static long[] num = new long[5001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		num[0] = 1;
		num[2] = 1;
		for(int i=4; i<=5000; i+=2) {
			for(int j=2; j<=i; j+=2) {
				num[i] += num[j-2]*num[i-j];
				num[i] %= 1000000007L;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			sb.append(num[L]+"\n");
		}
		System.out.println(sb);
	}
}
