package Baekjoon.week6.ffbear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2178 {

    static int N, M;
    static int[][] maze;
    static boolean[][] visited;


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited[0][0] = true;

        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }


    static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                //범위 벗어나면 건너뛰기
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                //이미 방문했고 0이면 건너뛰기
                if (visited[nx][ny] || maze[nx][ny] == 0) {
                    continue;
                }

                //그게 아니라면 탐색할 필요있음
                queue.add(new int[]{nx, ny});
                maze[nx][ny] = maze[currentX][currentY] + 1;
                visited[nx][ny] = true;
            }


        }
    }

}
