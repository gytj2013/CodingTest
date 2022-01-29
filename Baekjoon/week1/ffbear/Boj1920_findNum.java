package Baekjoon.week1.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1920_findNum {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Boolean> nums = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int token = Integer.parseInt(st.nextToken());
            nums.put(token, true);
        }


        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {

            int current = Integer.parseInt(st.nextToken());
            if (nums.containsKey(current)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }


        }


    }

}
