import java.io.*;
import java.util.*;

public class StartLink_14889 {
	static int N;
	static boolean[] team;
	static int[][] S;
	static int answer = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = new int[N][N];
		team = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(answer);
	}
	private static void comb(int cnt, int start) {
		if(cnt == N/2) {
			calc();
			return;
		}
		for(int i=start; i<N; i++) {
			team[i] = true;
			comb(cnt+1, i+1);
			team[i] = false;
		}
		
	}
	private static void calc() {
		int tmp = 0;
		int tmp2 = 0;
		for(int i=0; i<N; i++) {
			if(team[i]) {
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					if(team[j]) {
						tmp += S[i][j];
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			if(!team[i]) {
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					if(!team[j]) {
						tmp2 += S[i][j];
					}
				}
			}
		}
		answer = Math.min(answer, Math.abs(tmp2-tmp));
	}
}
