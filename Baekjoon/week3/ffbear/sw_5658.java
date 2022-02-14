package Baekjoon.week3.ffbear;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sw_5658 {

    static Scanner sc = new Scanner(System.in);
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {


        T = sc.nextInt();

        for (int i = 1; i <= T; i++) {

            calculation(i);

        }
        System.out.println(sb);

    }

    static void calculation(int testcase) {

        int N = sc.nextInt();
        int K = sc.nextInt();

        String input = sc.next();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N / 4; i++) {

            int start = 0;
            int end = N / 4;

            for (int j = 0; j < 4; j++) {

                String fragment = input.substring(start, end);
                int convert = Integer.parseInt(fragment, 16);

                if (!list.contains(convert)) {
                    list.add(convert);
                }
                start = end;
                end += N / 4;

            }
            String remain = input.substring(0, N - 1);
            String last = String.valueOf(input.charAt(N - 1));

            input = last + remain;

            list.sort(Collections.reverseOrder());
        }

        sb.append("#").append(testcase).append(" ").append(list.get(K - 1)).append("\n");
    }


}
