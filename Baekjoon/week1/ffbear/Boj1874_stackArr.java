package Baekjoon.week1.ffbear;

import java.io.*;
import java.util.Stack;

public class Boj1874_stackArr {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bw = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int start = 0;

        while (N-- > 0) {
            int current = Integer.parseInt(br.readLine());

            if (current > start) {

                for (int j = start + 1; j <= current; j++) {
                    stack.push(j);
                    bw.append("+").append("\n");
                }
                start = current;

            } else if (stack.peek() != current) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            bw.append("-").append("\n");
        }

        System.out.println(bw);

    }


}
