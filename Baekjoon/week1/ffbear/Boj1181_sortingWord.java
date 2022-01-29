package Baekjoon.week1.ffbear;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Boj1181_sortingWord {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }


        Arrays.sort(words, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }

        });

        String before = "";

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(before)) {
                bw.write(words[i] + "\n");
            }

            before = words[i];
        }

            bw.flush();
            bw.close();

        }

    }
