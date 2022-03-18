package Baekjoon.week8.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //초기 입력
        String str = br.readLine();
        int init = Integer.parseInt(str);
        int result = 0;

        for (int i = 0; i < init; i++) {

            int current = i;
            int sum = 0;

            while (current != 0) {
                sum += current % 10;
                current /= 10;
            }

            if (sum + i == init) {
                result = i;
                break;
            }

        }

        if (result < init) {
            System.out.println(result);
        } else {

            System.out.println(0);
        }


    }
}
