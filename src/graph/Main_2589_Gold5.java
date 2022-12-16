package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_Gold5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    private static int R, C;
    private static char[][] map;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                // 육지인 경우 bfs 진행
                if(map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(i,j));
                }
            }
        }

        System.out.println(answer);
    }


    private static final int[] dr = {1, -1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};
    private static int bfs(int r, int c) {

        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.offer(new Position(r, c,0));
        visited[r][c] = true;
        int distance = 0;
        while (!queue.isEmpty()) {

            Position position = queue.poll();
            for(int d=0; d<4; d++) {
                assert position != null;
                int nr = position.r + dr[d];
                int nc = position.c + dc[d];
                if(nr<0 || nr >=R || nc<0 || nc>=C) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] != 'L') continue;

                visited[nr][nc] = true;
                queue.offer(new Position(nr, nc, position.distance + 1));
                distance = Math.max(distance, position.distance + 1);


            }
        }
        return distance;
    }

    public static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
    static class Position {
        int r, c, distance;

        public Position(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }


}