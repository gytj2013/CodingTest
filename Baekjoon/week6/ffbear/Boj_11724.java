package Baekjoon.week6.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11724 {

    static int N, M;
    static ArrayList<Integer>[] node;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        node = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            node[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            node[from].add(to);
            node[to].add(from);

        }

        for (int i = 1; i <= N; i++) {

            if (dfs(i)) {
                answer++;
            }

        }

        System.out.println(answer);

    }

    static boolean dfs(int current) {

        if (visited[current]) {
            return false;
        } else {
            visited[current] = true;

            for (int i = 0; i < node[current].size(); i++) {
                int compare = node[current].get(i);
                if (!visited[compare]) {
                    dfs(compare);
                }
            }

            return true;
        }

    }
}
