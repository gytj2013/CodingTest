package Baekjoon.week7.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11051 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] triangle = new int[1001][1001];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= i; j++) {

                if (i == j || j == 0) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = (triangle[i - 1][j - 1] + triangle[i - 1][j]) % 10007;
                }
            }
        }

        System.out.println(triangle[N][K]);

    }

}
