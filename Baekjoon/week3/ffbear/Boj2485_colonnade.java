package Baekjoon.week3.ffbear;

import java.io.*;

public class Boj2485_colonnade {

    static int space = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(br.readLine());
            trees[i] = current;
        }

        int[] remainder = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            remainder[i] = trees[i + 1] - trees[i];
        }

        space = remainder[0];

        for (int i = 0; i < remainder.length - 1; i++) {
            gcd(remainder[i], remainder[i + 1]);
        }

        for (int i = 0; i < remainder.length; i++) {
            answer += (remainder[i] / space) - 1;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();


    }

    static void gcd(int a, int b) {

        while (b > 0) {

            int temp = a;
            a = b;
            b = temp % b;

        }

        space = Math.min(space, a);
    }

}
