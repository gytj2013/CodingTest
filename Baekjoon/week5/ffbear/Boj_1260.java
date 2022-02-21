package Baekjoon.week5.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1260 {

    static int N, M, V;
    static ArrayList<Integer>[] adj;

    static boolean[] visited;

    //dfs 결과
    static ArrayList<Integer> dfs_result = new ArrayList<>();
    static ArrayList<Integer> bfs_result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];


        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);

            adj[from].add(to);
            adj[to].add(from);

        }

        for (ArrayList<Integer> node : adj) {
            Collections.sort(node);
        }

        //--------------------
        visited = new boolean[N + 1];
        dfs(V);

        Arrays.fill(visited, false);
        bfs(V);


        for (Integer integer : dfs_result) {
            System.out.print(integer + " ");
        }

        System.out.println();

        for (Integer integer : bfs_result) {
            System.out.print(integer + " ");
        }

    }

    static void dfs(int current) {

        if (visited[current]) {
            return;
        }

        visited[current] = true;
        dfs_result.add(current);

        for (int i : adj[current]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int current) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(current);
        visited[current] = true;

        while (!queue.isEmpty()) {

            int temp = queue.poll();
            bfs_result.add(temp);

            for (int i : adj[temp]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }

    }

}
