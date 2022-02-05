import java.io.*;
import java.util.*;

public class NQueen_9663 {
	static int N;
	static boolean[][] chess;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		chess = new boolean[N][N];
		recurr(0);
		System.out.println(answer);
	}
	private static void recurr(int cnt) {
		if(cnt==N) {
			answer++;
			return;
		}
		for(int i=0; i<N; i++){
			if(!check(cnt, i)) {
				chess[cnt][i] = true;
				recurr(cnt+1);
				chess[cnt][i] = false;
			}
		}
	}
	private static boolean check(int i, int j) {
		for(int x=0; x<i; x++) {
			if(chess[x][j]) {return true;}
			if(j+x>=i) {
				if(chess[x][j-i+x]) {
					return true;
				}
			}
			if(j+i-x<N) {
				if(chess[x][j+i-x]) {
					return true;
				}
			}
		}
		return false;
	}
}
