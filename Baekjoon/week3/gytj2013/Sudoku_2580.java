package Baekjoon.week3.gytj2013;

import java.io.*;
import java.util.*;

public class Sudoku_2580 {
	static int[][] board = new int[9][9];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recurr(0,0);
	}
	private static void recurr(int x, int y) {
		if(y==9) { recurr(x+1, 0); return;}
		if(x==9) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(board[x][y]==0) {
			for(int i=1; i<=9; i++) {
				if(check(x, y, i)) {
					board[x][y] = i;
					recurr(x, y+1);
				}
			}
			board[x][y] = 0;
		}else {
			recurr(x, y+1);
		}
	}
	private static boolean check(int x, int y, int target) {
		for(int i=0; i<9; i++) { 
			if(board[i][y]==target){
				return false;
			} 
		}
		for(int i=0; i<9; i++) { 
			if(board[x][i]==target){
				return false;
			} 
		}
		int x1 = (x/3)*3;
		int y1 = (y/3)*3;
		for(int i=x1; i<x1+3; i++) {
			for(int j=y1; j<y1+3; j++) {
				if(board[i][j]==target){
					return false;
				} 
			}
		}
		return true;
	}
}
