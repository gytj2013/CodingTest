package Baekjoon.week4.ffbear;


import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1966_printerQueue {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            //문서의 갯수
            int N = Integer.parseInt(st.nextToken());
            //궁금한 문서가 현재 Queue 에서 몇 번째에 놓여 있는지를 나타내는
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> printer = new LinkedList<>();

            //중요도
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                printer.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int count = 0;

            while (!printer.isEmpty()) {

                int[] first = printer.poll();
                boolean isBiggest = true;

                for (int k = 0; k < printer.size(); k++) {

                    if (first[1] < printer.get(k)[1]) {
                        printer.offer(first);

                        for (int l = 0; l < k; l++) {
                            printer.offer(printer.poll());
                        }

                        isBiggest = false;
                        break;
                    }
                }

                if (!isBiggest) {
                    continue;
                }

                count++;
                if (first[0] == M) {
                    break;

                }
            }

            bw.append(String.valueOf(count)).append("\n");

        }

        bw.flush();
        bw.close();


    }
}