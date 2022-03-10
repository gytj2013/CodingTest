import java.io.*;
import java.util.*;

public class Easy2048_12100 {
	static int N;
	static int[][] board;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recurr(0);
		System.out.println(ans);
	}
	private static void recurr(int cnt) {
	//	System.out.println("cnt: "+cnt);
		if(cnt==5) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					ans = Math.max(ans, board[i][j]);
				}
			}
			return;
		}
		for(int dir=0; dir<4; dir++) {
			int[][] tmp = new int[N][N];
			if(dir==0) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(board[i][j]==0) continue;
						int a = i;
						while(true) {
							if(a==0) {
								tmp[a][j] = board[i][j];
							}
							else if(tmp[a-1][j]==0) {
								a--;
								continue;
							}else if(tmp[a-1][j]==-1) {
								tmp[a-1][j] = board[i][j];
							}
							else if(tmp[a-1][j] == board[i][j]) {
								tmp[a-1][j] *= 2;
								tmp[a][j] = -1;
							}else {
								tmp[a][j] = board[i][j];
							}
							break;
						}
					}
				}
			}
			if(dir==1) {
				for(int i=0; i<N; i++) {
					for(int j=N-1; j>=0; j--) {
						if(board[i][j]==0) continue;
						int a = j;
						while(true) {
							if(a==N-1) {
								tmp[i][a] = board[i][j];
							}
							else if(tmp[i][a+1]==0) {
								a++;
								continue;
							}else if(tmp[i][a+1]==-1) {
								tmp[i][a+1] = board[i][j];
							}
							else if(tmp[i][a+1] == board[i][j]) {
								tmp[i][a+1] *= 2;
								tmp[i][a] = -1;
							}else {
								tmp[i][a] = board[i][j];
							}
							break;
						}
					}
				}
			}
			if(dir==2) {
				for(int i=N-1; i>=0; i--) {
					for(int j=0; j<N; j++) {
						if(board[i][j]==0) continue;
						int a = i;
						while(true) {
							if(a==N-1) {
								tmp[a][j] = board[i][j];
							}
							else if(tmp[a+1][j]==0) {
								a++;
								continue;
							}else if(tmp[a+1][j]==-1) {
								tmp[a+1][j] = board[i][j];
							}
							else if(tmp[a+1][j] == board[i][j]) {
								tmp[a+1][j] *= 2;
								tmp[a][j] = -1;
							}else {
								tmp[a][j] = board[i][j];
							}
							break;
						}
					}
				}
			}
			if(dir==3) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(board[i][j]==0) continue;
						int a = j;
						while(true) {
							if(a==0) {
								tmp[i][a] = board[i][j];
							}
							else if(tmp[i][a-1]==0) {
								a--;
								continue;
							}else if(tmp[i][a-1]==-1) {
								tmp[i][a-1] = board[i][j];
							}
							else if(tmp[i][a-1] == board[i][j]) {
								tmp[i][a-1] *= 2;
								tmp[i][a] = -1;
							}else {
								tmp[i][a] = board[i][j];
							}
							break;
						}
					}
				}
			}
			int[][] tmp2 = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					tmp2[i][j] = board[i][j];
					board[i][j] = tmp[i][j];
				//	System.out.print(tmp[i][j]+" ");
					if(tmp[i][j]==-1) {
						board[i][j] = 0;
					}
				}
				//System.out.println();
			}
			recurr(cnt+1);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					board[i][j] = tmp2[i][j];
					//System.out.print(tmp2[i][j]+" ");
				}
				//System.out.println();
			}
		}
		
	}
}
