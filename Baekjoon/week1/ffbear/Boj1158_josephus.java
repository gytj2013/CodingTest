package Baekjoon.week1.ffbear;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1158_josephus {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        bw.append('<');
        while (!list.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    int current = list.remove();
                    if (list.size() == 0) {
                        bw.append(String.valueOf(current));
                    } else {
                        bw.append(String.valueOf(current)).append(',').append(' ');
                    }

                } else {
                    list.add(list.remove());
                }
            }
        }

        bw.append('>');

        bw.flush();
        bw.close();


    }

}

