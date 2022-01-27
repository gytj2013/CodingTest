package Baekjoon.week1.ffbear;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Boj10845 {

    static List<Integer> queue = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.matches("push.*")) {
                String[] input = command.split(" ");
                push(Integer.parseInt(input[1]));

            } else if (command.matches("pop")) {
                bw.write(pop() + "\n");

            } else if (command.matches("size")) {
                bw.write(size() + "\n");

            } else if (command.matches("empty")) {
                bw.write(empty() + "\n");

            } else if (command.matches("front")) {
                bw.write(front() +  "\n");

            } else if (command.matches("back")) {
                bw.write(back() + "\n");

            }

        }

        bw.flush();
        bw.close();

    }


    static void push(int element) {
        queue.add(element);
    }

    static int pop() throws IOException {

        if (queue.size() == 0) {
            return -1;

        } else {

            int index = queue.get(0);
            queue.remove(0);
            return index;
        }


    }

    static int size() {

        return queue.size();
    }

    static int empty() {

        if (queue.size() == 0) {
            return 1;
        } else {
            return 0;
        }

    }

    static int front() {

        if (queue.size() == 0) {
            return -1;
        } else {

            return queue.get(0);
        }
    }

    static int back() {
        if (queue.size() == 0) {
            return -1;
        } else {
            return queue.get(queue.size() - 1);
        }

    }

}
