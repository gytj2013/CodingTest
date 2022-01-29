package Baekjoon.week1.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1002_turret {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스
        int T = Integer.parseInt(br.readLine());

        int[][] location = new int[T][6];

        //좌표들
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < location[i].length; j++) {
                location[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < location.length; i++) {

            System.out.println(calculation(location[i]));
        }

    }

    static int calculation(int[] testcase) {


        int x1 = testcase[0];
        int y1 = testcase[1];
        int r1 = testcase[2];

        int x2 = testcase[3];
        int y2 = testcase[4];
        int r2 = testcase[5];

        int distance = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));


        //완전히 일치
        if (x1 == x2 && y1 == y2 && r1 == r2) {

            return -1;

            //원안에 원이 있지만 내접 X
        } else if (distance < Math.pow(r1 - r2, 2)) {
            return 0;

            //내접
        } else if (distance == Math.pow(r1 - r2, 2)) {
            return 1;

            //외접
        } else if (distance == Math.pow(r1 + r2, 2)) {
            return 1;

            //반지름의 합보다 두 점 사이의 거리가 길때
        } else if (distance > Math.pow(r1 + r2, 2)) {
            return 0;

        } else {

            return 2;
        }


    }

}
