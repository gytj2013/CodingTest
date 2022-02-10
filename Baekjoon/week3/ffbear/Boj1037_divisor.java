package Baekjoon.week3.ffbear;

import java.io.*;
import java.util.Arrays;

public class Boj1037_divisor {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] nums = new int[input.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }


        Arrays.sort(nums);


        bw.append(String.valueOf(nums[nums.length - 1] * nums[0]));
        bw.flush();
        bw.close();

    }

}
