package Baekjoon.week3.ffbear;

import java.io.*;

public class Boj14889_startLink {

    static int N;
    static int[][] power;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        power = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split(" ");

            for (int j = 0; j < power.length; j++) {
                power[i][j] = Integer.parseInt(input[j]);

            }

        }

        dfs(0, 0);
        bw.append(String.valueOf(min));
        bw.flush();
        bw.close();


    }

    static void dfs(int depth, int idx) throws IOException {

        if (depth == N / 2) {
            combination();


            return;

        }

        for (int i = idx; i < N; i++) {

            if (!visit[i]) {

                visit[i] = true;
                dfs(depth + 1, i + 1);
                visit[i] = false;
            }

        }

    }

    static void combination() throws IOException {

        int start = 0;
        int link = 0;

        for (int i = 0; i < power.length; i++) {
            for (int j = i + 1; j < power[i].length; j++) {

                if (visit[i] && visit[j]) {
                    start += power[i][j] + power[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += power[i][j] + power[j][i];
                }

            }
        }

        int subtract = Math.abs(start - link);

        if (subtract == 0) {
            bw.append(String.valueOf(0));
            bw.flush();
            bw.close();
            System.exit(0);

        }

        min = Math.min(min, subtract);

    }

}
