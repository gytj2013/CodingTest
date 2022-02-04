package Baekjoon.week1.ffbear;


import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj10816_numCard2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int current = Integer.parseInt(st.nextToken());

            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int current = Integer.parseInt(st.nextToken());
            if (map.containsKey(current)) {
                bw.write(map.get(current) + " ");
            } else {
                bw.write(String.valueOf(0) + " ");
            }

        }

        bw.flush();
        bw.close();
    }


}
