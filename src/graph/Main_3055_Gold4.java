package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_3055_Gold4 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int R, C, answer;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        answer = Integer.MAX_VALUE;
        int startR = 0, startC= 0;


        for(int i=0; i<R; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j=0; j<C; j++) {
                map[i][j] = input[j];
                if(input[j] == 'S') {
                    startR = i; startC = j;
                }
            }
        }

        bfs(startR, startC);



        if (answer == Integer.MAX_VALUE)
            sb.append("KAKTUS\n");
        else sb.append(answer);

        System.out.println(sb);

    }

    private static void bfs(int startR, int startC) {

        int r = startR, c = startC;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        visited[r][c] = true;
        int distance = 0;

        while (!queue.isEmpty()) {

            spread();

            // queue의 사이즈만큼 따로 진행, 물이 1초마다 차기때문에 물이 진행되기 전에있는 포지션에 대해 확인
            int size = queue.size();
            for (; size>0; size--) {
                r = queue.peek()[0];
                c = queue.peek()[1];
                queue.poll();


                for(int i=0; i<4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    // map의 범위를 넘어간 경우
                    if(nr <0 || nr>=R || nc<0 || nc>=C) continue;

                    // 물이 있는 위치인 경우
                    if(map[nr][nc] == '*' || map[nr][nc] == 'X') continue;
                    if(visited[nr][nc]) continue;

                    // 비버 굴에 도착한 경우
                    if(map[nr][nc] == 'D') {
                        answer = distance + 1;
                        return;
                    }

                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
            distance++;

        }

    }

    public static void spread() {

        List<int[]> waters = new ArrayList<>();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] == '*') {
                    waters.add(new int[]{i, j});
                }
            }
        }
        for (int[] water : waters) {
            for(int i=0; i<4; i++) {
                int nr = water[0] + dr[i];
                int nc = water[1] + dc[i];
                if(nr <0 || nr>=R || nc<0 || nc>=C) continue;
                if(map[nr][nc] == 'D' || map[nr][nc] == 'S' || map[nr][nc] == 'X') continue;
                map[nr][nc] = '*';
            }
        }

    }

}