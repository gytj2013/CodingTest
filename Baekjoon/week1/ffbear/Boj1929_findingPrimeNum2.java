package Baekjoon.week1.ffbear;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1929_findingPrimeNum2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        
        boolean[] nums = new boolean[M + 1];

        nums[0] = true;
        nums[1] = true;

        for (int i = 2; i <= Math.sqrt(M); i++) {

            if (nums[i]) {
                continue;
            }

            if (!nums[i]) {
                for (int j = i * i; j <= M; j += i) {
                    nums[j] = true;
                }
            }

        }

        for (int i = N; i <= M; i++) {
            if (!nums[i]) {
                bw.append(String.valueOf(i)).append(' ');
            }
        }

        bw.flush();
        bw.close();

    }

}
