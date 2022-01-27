package Baekjoon.week1.ffbear;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj10815 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Boolean> nums = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int current = Integer.parseInt(st.nextToken());

            nums.put(current, true);

        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        while (st.hasMoreTokens()) {
            int current = Integer.parseInt(st.nextToken());

            if (nums.containsKey(current)) {
                bw.write(1 + " ");
            } else {
                bw.write(0 + " ");

            }
        }


        bw.flush();
        bw.close();

    }
}
