import java.io.*;
import java.util.*;

public class EscapeMovingMaze_16954 {
	static char[][] board = new char[8][8];
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<8; i++) {
			String tmp = br.readLine();
			for(int j=0; j<8; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		move(7, 0);
		System.out.println(0);
	}
	private static void move(int x, int y) {
		//System.out.println(x+", "+y);
		char[][] tmp = new char[8][8];
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				tmp[i][j] = board[i][j];
				//System.out.print(board[i][j]);
			}
			//System.out.println();
		}
		//System.out.println();
		if(x==0 & y==7) {
			System.out.println(1);
			System.exit(0);
		}
		for(int i=0; i<9; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 | nx>=8 | ny<0 | ny>=8) continue;
			if(board[nx][ny]=='#') continue;
			if(nx>0) {
				if(board[nx-1][ny]=='#') continue;
			}
			for(int j=7; j>0; j--) {
				for(int l=0; l<8; l++) {
					board[j][l] = board[j-1][l];
					board[j-1][l] = '.';
				}
			}
			move(nx, ny);
			for(int l=0; l<8; l++) {
				for(int j=0; j<8; j++) {
					board[l][j] = tmp[l][j];
				}
			}
		}
	}
}
