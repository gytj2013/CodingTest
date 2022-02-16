import java.io.*;
import java.util.*;

public class Monominodomino2_20061 {
	static int N;
	static int cnt = 0;
	static int sc = 0;
	static boolean[][] board = new boolean[10][10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int t, x, y;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			addblock(t, x, y);
		}
		System.out.println(sc);
		System.out.println(cnt);
	}
	private static void addblock(int t, int x, int y) {
		int a = 9;
		int b = 9;
		if(t==1) {
			cnt += 2;
			for(int i=4; i<=9; i++) {
				if(board[i][y] & a==9) {a=i-1;}
				if(board[x][i] & b==9) {b=i-1;}
			}
			board[a][y] = true;
			board[x][b] = true;
		}else if(t==2) {
			cnt += 4;
			for(int i=4; i<=9; i++) {
				if((board[i][y] | board[i][y+1]) & a==9) {a=i-1;}
				if(board[x][i] & b==9) {b=i-1;}
			}
			board[a][y] = true; board[a][y+1] = true;
			board[x][b] = true; board[x][b-1] = true;
		}else {
			cnt += 4;
			for(int i=4; i<=9; i++) {
				if(board[i][y] & a==9) {a=i-1;}
				if((board[x][i] | board[x+1][i]) & b==9) {b=i-1;}
			}
			board[a][y] = true; board[a-1][y] = true;
			board[x][b] = true; board[x+1][b] = true;
		}
		score();
	}
	private static void score() {
		for(int i=9; i>=4; i--) {
			if(board[i][0] & board[i][1] & board[i][2] & board[i][3]) {
				sc++;
				cnt -= 4;
				for(int j=i-1; j>=4; j--) {
					board[j+1][0] = board[j][0];
					board[j+1][1] = board[j][1];
					board[j+1][2] = board[j][2];
					board[j+1][3] = board[j][3];
				}
				i++;
			}
		}
		for(int i=9; i>=4; i--) {
			if(board[0][i] & board[1][i] & board[2][i] & board[3][i]) {
				sc++;
				cnt -= 4;
				for(int j=i-1; j>=4; j--) {
					board[0][j+1] = board[0][j];
					board[1][j+1] = board[1][j];
					board[2][j+1] = board[2][j];
					board[3][j+1] = board[3][j];
				}
				i++;
			}
		}
		special();
	}
	private static void special() {
		int num = 0;
		for(int i=4; i<=5; i++) {
			if(board[0][i] | board[1][i] | board[2][i] | board[3][i]) {
				num++;
			}
		}
		if(num!=0) {
			if(num==1) {
				for(int i=0; i<4; i++) {
					if(board[i][9]) {cnt--;}
				}
				for(int j=8; j>=4; j--) {
					board[0][j+1] = board[0][j];
					board[1][j+1] = board[1][j];
					board[2][j+1] = board[2][j];
					board[3][j+1] = board[3][j];
				}
			}else{
				for(int i=0; i<4; i++) {
					if(board[i][9]) {cnt--;}
					if(board[i][8]) {cnt--;}
				}
				for(int j=7; j>=4; j--) {
					board[0][j+2] = board[0][j];
					board[1][j+2] = board[1][j];
					board[2][j+2] = board[2][j];
					board[3][j+2] = board[3][j];
				}
			}
			for(int j=4; j<=5; j++) {
				board[0][j] = false;
				board[1][j] = false;
				board[2][j] = false;
				board[3][j] = false;
			}
		}
		num = 0;
		for(int i=4; i<=5; i++) {
			if(board[i][0] | board[i][1] | board[i][2] | board[i][3]) {
				num++;
			}
		}
		if(num!=0) {
			if(num==1) {
				for(int i=0; i<4; i++) {
					if(board[9][i]) {cnt--;}
				}
				for(int j=8; j>=4; j--) {
					board[j+1][0] = board[j][0];
					board[j+1][1] = board[j][1];
					board[j+1][2] = board[j][2];
					board[j+1][3] = board[j][3];
				}
			}else{
				for(int i=0; i<4; i++) {
					if(board[9][i]) {cnt--;}
					if(board[8][i]) {cnt--;}
				}
				for(int j=7; j>=4; j--) {
					board[j+2][0] = board[j][0];
					board[j+2][1] = board[j][1];
					board[j+2][2] = board[j][2];
					board[j+2][3] = board[j][3];
				}
			}
			for(int j=4; j<=5; j++) {
				board[j][0] = false;
				board[j][1] = false;
				board[j][2] = false;
				board[j][3] = false;
			}
		}
		
	}
}
