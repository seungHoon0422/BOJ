package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    2683 치즈 Gold3
    시작 12:20
    종료 13: 5
    소요시간 45분

    * 문제 조건
    1. 가장자리에 있는 치즈는 1시간이후에 녹는다.
    2. 치즈로 감싸여있는 공간은 외부로 판단하지 않는다.
    3. 치즈가 다 녹아 사라지는 시간을 구한다.


    * 문제 해결법
    - 치즈가 녹을 때마다 사이 공간을 확인해야한다.
    - 1시간이 지날 때마다 외부 공기와 내부공기 체크
    - 치즈마다 2면이상 붙어있는지 확인한다.
    - 내부공기와 붙어있는 면의 개수를 체크한다.
    - 치즈를 녹인다.

 */


public class Main_2683_Gold3_치즈 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    static int r, c, time;
    static int[][] board;
    static boolean[][] inside;
    static ArrayList<int[]> cheese;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        time = 0;
        cheese = new ArrayList<>();

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) cheese.add(new int[]{i,j});
            }
        }


        while(!cheeseIsEmpty()) {
            inside = new boolean[r][c];
            checkInside();

            // 사라질 치즈
            ArrayList<int[]> byeCheese = new ArrayList<>();
            for (int[] pos : cheese) {

                int count = 0;
                // 4방향 확인
                for(int d=0; d<4; d++) {
                    int nr = pos[0] + dr[d];
                    int nc = pos[1] + dc[d];
                    if(nr<0 || nr>=r || nc<0 || nc>=c) continue;
                    // 내부공기가 아닌 공기와 맞닿아있는 경우
                    if(board[nr][nc] == 0 && !inside[nr][nc]) count++;
                } // end of d
                if(count >= 2) byeCheese.add(pos);

            } // end of cheese

            for (int[] pos : byeCheese) {

                board[pos[0]][pos[1]] = 0;
                cheese.remove(pos);
            }
            time++;
        }


        sb.append(time);
        System.out.println(sb.toString());

    } // end of main

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    private static void checkInside() {


        boolean[][] visited = new boolean[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                // 치즈가 있으면 통과
                if(board[i][j] == 1) continue;
                if(visited[i][j]) continue;

                Queue<int[]> queue = new LinkedList<>();
                ArrayList<int[]> space = new ArrayList<>();
                space.add(new int[]{i,j});
                queue.offer(new int[]{i,j});
                visited[i][j] = true;

                while (!queue.isEmpty()) {

                    int[] pos = queue.poll();
                    for(int d=0; d<4; d++) {
                        int nr = pos[0] + dr[d];
                        int nc = pos[1] + dc[d];

                        if(nr<0 || nr>=r || nc<0 || nc>=c) continue;
                        if(board[nr][nc] == 1) continue;
                        if(visited[nr][nc]) continue;

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                        space.add(new int[]{nr,nc});
                    } // end of d
                }// end of while queue

                // 내부공기인지 확인한다.
                boolean isInside = true;
                for(int[] pos : space) {
                    if(pos[0] == r-1 || pos[0] == 0 || pos[1] == c-1 || pos[1] == 0)
                    {
                        isInside = false;
                        break;
                    }
                 }

                if (isInside) {
                    for(int[] pos : space)
                        inside[pos[0]][pos[1]] = true;
                }
            } // end of c
        } // end of r


    }

    private static boolean cheeseIsEmpty() {
        return cheese.size() == 0 ? true : false;
    }


}