package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_Gold4 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int R, C, year;
    private static int[][] map;
    private static boolean[][] visited;
    private static boolean allMelt;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        year = 0;
        allMelt = false;

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(true) {
            if(checkSperate()) {
                break;
            } else if(allMelt) {
                year = 0;
                break;
            }
            melting();
            year++;
        }

        System.out.println(year);
    }

    private static void melting() {
        int[][] nextIce = new int[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == 0) continue;
                nextIce[i][j] = map[i][j];
                for(int d=0; d<4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                    if(map[nr][nc] == 0) nextIce[i][j]--;
                    if(nextIce[i][j] == 0) break;
                }
            }
        }
        map = nextIce;
    }

    private static boolean checkSperate() {

        visited = new boolean[R][C];
        allMelt = true;
        int part = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] > 0 && !visited[i][j]) {
                    allMelt = false;
                    if(part == 1)
                        return true;
                    bfs(i,j);
                    part++;
                }
            }
        }
        return false;
    }

    private static final int[] dr = {1, -1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};

    private static void bfs(int r, int c) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            r = front[0];
            c = front[1];

            for(int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                if(visited[nr][nc] || map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});

            }
        }

    }


}