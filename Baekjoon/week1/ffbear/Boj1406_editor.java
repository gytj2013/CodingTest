package Baekjoon.week1.ffbear;


import java.io.*;
import java.util.Stack;

public class Boj1406_editor {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            left.push(input.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    if (left.empty()) {
                        break;
                    }
                    right.push(left.pop());
                    break;

                case 'D':
                    if (right.empty()) {
                        break;
                    }
                    left.push(right.pop());
                    break;

                case 'B':
                    if (left.empty()) {
                        break;
                    }
                    left.pop();
                    break;

                case 'P':
                    left.push(command.charAt(2));
                    break;

            }

        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (!left.empty()) {
            right.push(left.pop());
        }

        while (!right.empty()) {
            bw.write(right.pop());
        }


        bw.flush();
        bw.close();

    }

}
