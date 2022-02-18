package Baekjoon.week4.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15649_NM1 {

    static int N;
    static int M;

    static int[] nums;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];
        isVisited = new boolean[N];


        dfs(0);
        System.out.println(sb);

    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i : nums) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                nums[depth] = i + 1;
                dfs(depth + 1);
                isVisited[i] = false;
            }

        }

    }

}
