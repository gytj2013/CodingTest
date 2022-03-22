package Baekjoon.week9.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_2529 {

    static int N;
    static int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static String[] input;
    static boolean[] isVisited;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static List<String> sum = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        isVisited = new boolean[10];

        dfs("", 0);

        Collections.sort(sum);
        System.out.println(sum.get(sum.size() - 1));
        System.out.println(sum.get(0));

    }

    static void dfs(String num, int depth) {

        if (depth == input.length + 1) {

            sum.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (depth == 0 || !isVisited[i] && compare(num.charAt(num.length() - 1) - '0', i, input[depth - 1])) {
                isVisited[i] = true;
                dfs(num + i, depth + 1);
                isVisited[i] = false;

            }


        }

    }

    static boolean compare(int a, int b, String s) {
        if (s.equals(">")) {
            return a > b;

        } else {
            return a < b;
        }
    }

}
