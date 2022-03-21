package Baekjoon.week8.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_16198 {

    static int res = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> nums = new ArrayList<>();


        while (st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }


        dfs(nums, 0);

        System.out.println(res);

    }

    private static void dfs(ArrayList<Integer> nums, int sum) {

        if (nums.size() <= 2) {
            if (res < sum) {
                res = sum;
            }
            return;
        }

        for (int i = 1; i < nums.size() - 1; i++) {

            int current = nums.get(i);
            int gather = nums.get(i - 1) * nums.get(i + 1);

            nums.remove(i);
            sum += gather;

            dfs(nums, sum);
            nums.add(i, current);
        }


    }

}
