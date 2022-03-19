package Baekjoon.week8.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_16197 {

    static int N, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] board;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        int coin[][] = new int[2][2];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                char current = input.charAt(j);
                board[i][j] = current;

                if (current == 'o') {
                    coin[cnt][0] = i;
                    coin[cnt++][1] = j;
                }
            }
        }

        for (char x[] : board) {
            System.out.println(Arrays.toString(x));
        }

        find(coin[0][0], coin[0][1], coin[1][0], coin[1][1], 0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }


    }

    static void find(int c1x, int c1y, int c2x, int c2y, int depth) {

        //10번 이상 탐색은 무의미
        if (depth > 10) {
            return;
        }

        if ((!isValid(c1x, c1y) && !isValid(c2x, c2y))) {
            return;
        }

        if ((isValid(c1x, c1y) && !isValid(c2x, c2y)) || (!isValid(c1x, c1y) && isValid(c2x, c2y))) {
            if (ans > depth) {
                ans = depth;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {

            int x1 = c1x + dx[i];
            int y1 = c1y + dy[i];

            int x2 = c2x + dx[i];
            int y2 = c2y + dy[i];

            if (isValid(x1, y1) && board[x1][y1] == '#') {
                x1 = c1x;
                y1 = c1y;
            }

            if (isValid(x2, y2) && board[x2][y2] == '#') {
                x2 = c2x;
                y2 = c2y;
            }

            find(x1, y1, x2, y2, depth + 1);

        }


    }


    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}
