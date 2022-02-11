import java.io.*;
import java.util.*;

public class Sudominoku_4574 {
	static int[][] board;
	static boolean[][] domino;
	static boolean[][] row;
	static boolean[][] col;
	static boolean[][] matrix;
	static boolean lotto;
	static int N=1;
	static int num=1;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int U, V;
		String LU, LV, L;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) {break;}
			lotto=false;
			board = new int[9][9];
			domino = new boolean[10][10];
			row = new boolean [9][10];
			col = new boolean [9][10];
			matrix = new boolean [9][10];
			for(int i=0; i<N; i++) {	
				st = new StringTokenizer(br.readLine());
				U = Integer.parseInt(st.nextToken());
				LU = st.nextToken();
				V = Integer.parseInt(st.nextToken());
				LV = st.nextToken();
				int x = LU.charAt(0)-'A';
				int y = LU.charAt(1)-'1';
				int x2 = LV.charAt(0)-'A';
				int y2 = LV.charAt(1)-'1';
				domino[U][V] = true;
				domino[V][U] = true;
				board[LU.charAt(0)-'A'][LU.charAt(1)-'1'] = U;
				board[LV.charAt(0)-'A'][LV.charAt(1)-'1'] = V;
				row[x][U] = col[y][U] = matrix[(x / 3) * 3 + y / 3][U] = true;
				row[x2][V] = col[y2][V] = matrix[(x2 / 3) * 3 + y2 / 3][V] = true;
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=9; i++) {
				L = st.nextToken();
				int x = L.charAt(0)-'A';
				int y = L.charAt(1)-'1';
				board[x][y] = i;
				row[x][i] = col[y][i] = matrix[(x / 3) * 3 + y / 3][i] = true;
			}
			System.out.println("Puzzle "+num);
			recurr(0,0);
			num++;
		}
		
	}
	private static void recurr(int x, int y) {
		if(lotto) {return;}
		if(y==9) { recurr(x+1, 0); return;}
		if(x==9) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			lotto=true;
			return;
		}
		if(board[x][y]==0) {
			for(int j=0; j<2; j++) {
				if(x+dx[j]<9 & y+dy[j]<9) {
					if(board[x+dx[j]][y+dy[j]]==0) {
						for(int i=1; i<9; i++) {
							for(int l=1+i; l<=9; l++) {
								if(domino[i][l]) {continue;}
								if(l==i) {continue;}
								domino[i][l] = true;
								domino[l][i] = true;
								int nx = x+dx[j];
								int ny = y+dy[j];
								if (!row[x][i] && !col[y][i] & !matrix[(x / 3) * 3 + y / 3][i] &
										!row[nx][l] & !col[ny][l] & !matrix[(nx/3)*3 + ny/3][l]) {
									board[x][y] = i;
									board[nx][ny] = l;
									row[x][i] = col[y][i] = matrix[(x / 3) * 3 + y / 3][i] = true;
									row[nx][l] = col[ny][l] = matrix[(nx / 3) * 3 + ny / 3][l] = true;
									recurr(x, y+1);
									board[nx][ny] = 0;
									board[x][y] = 0;
									row[x][i] = col[y][i] = matrix[(x / 3) * 3 + y / 3][i] = false;
									row[nx][l] = col[ny][l] = matrix[(nx / 3) * 3 + ny / 3][l] = false;
								}
								if (!row[x][l] && !col[y][l] & !matrix[(x / 3) * 3 + y / 3][l] &
										!row[nx][i] & !col[ny][i] & !matrix[(nx/3)*3 + ny/3][i]) {
									board[x][y] = l;
									board[nx][ny] = i;
									row[x][l] = col[y][l] = matrix[(x / 3) * 3 + y / 3][l] = true;
									row[nx][i] = col[ny][i] = matrix[(nx / 3) * 3 + ny / 3][i] = true;
									recurr(x, y+1);
									board[nx][ny] = 0;
									board[x][y] = 0;
									row[x][l] = col[y][l] = matrix[(x / 3) * 3 + y / 3][l] = false;
									row[nx][i] = col[ny][i] = matrix[(nx / 3) * 3 + ny / 3][i] = false;
								}
								domino[i][l] = false;
								domino[l][i] = false;
							}
						}
						
					}
				}
			}
		}else {
			recurr(x, y+1);
		}
	}
}
