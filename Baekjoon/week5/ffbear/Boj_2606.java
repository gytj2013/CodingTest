package Baekjoon.week5.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Boj_2606 {

    static int N;
    static int edge;
    static ArrayList<ArrayList<Integer>> computers;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        edge = Integer.parseInt(bf.readLine());
        computers = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            computers.add(new ArrayList<Integer>());
        }


        for (int i = 0; i < edge; i++) {

            String input = bf.readLine();

            int from = Integer.parseInt(input.split(" ")[0]);
            int to = Integer.parseInt(input.split(" ")[1]);

            computers.get(from).add(to);
            computers.get(to).add(from);

        }

        cnt = 0;
        dfs(1);
        System.out.println(computers);

        System.out.println(cnt);
    }

    public static void dfs(int start) {

        visited[start] = true;

        for (int i = 0; i < computers.get(start).size(); i++) {
            int current = computers.get(start).get(i);

            if (!visited[current]){
                visited[current] = true;
                cnt++;
                dfs(current);
            }
        }

    }


}
