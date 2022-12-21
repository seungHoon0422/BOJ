package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 *
 * [백준] 벽부수고 이동하기 2206 Gold3
 * 그래프탐색
 *
 *
 */
public class Main_2206_Gold3 {


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N, M;
    private static int[][] map;
    private static int [][][] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[2][N][M];

        for(int i=0; i<2; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < M; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }

        for(int i=0; i<N; i++) {
            String inputLine = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = inputLine.charAt(j) - '0';
            }
        }


        int minDistance = bfs();

        if (minDistance == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDistance);
        }


    }


    private static final int[] dr = {1,-1,0,0};
    private static final int[] dc = {0,0,1,-1};
    private static int bfs() {

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 1, 0));
        visited[0][0][0] = 0;

        int minDistance = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {

            Position position = queue.poll();
            if(position.r == N-1 && position.c == M-1) {
                minDistance = Math.min(minDistance, position.distance);
                continue;
            }

            for(int i=0; i<4; i++) {
                int nr = position.r + dr[i];
                int nc = position.c + dc[i];

                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;

                // 벽인 경우
                if(map[nr][nc] == 1) {
                    if(position.removeWall == 0) {
                        if(position.distance + 1 < visited[1][nr][nc]) {
                            visited[1][nr][nc] = position.distance + 1;
                            queue.offer(new Position(nr,nc,position.distance + 1, 1));
                        }
                    }
                } else {
                    if(position.distance + 1 < visited[position.removeWall][nr][nc]) {
                        visited[position.removeWall][nr][nc] = position.distance + 1;
                        queue.offer(new Position(nr,nc,position.distance + 1, position.removeWall));

                    }
                }
            }
        }

        return minDistance;
    }

    static class Position {
        int r, c, distance, removeWall;

        public Position(int r, int c, int distance, int removeWall) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.removeWall = removeWall;
        }
    }
}