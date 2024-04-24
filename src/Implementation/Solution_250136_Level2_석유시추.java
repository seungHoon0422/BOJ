package Implementation;

import java.util.LinkedList;
import java.util.Queue;


class Solution_250136_Level2_석유시추 {

    int R, C;
    int[][] landPrize, landNumber;
    boolean[][] visited;

    public int solution(int[][] land) {
        int answer = 0;

        R = land.length;
        C = land[0].length;

        landPrize = new int[R][C];
        landNumber = new int[R][C];
        visited = new boolean[R][C];
        int visitCounter = 1;



        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(visited[i][j]) continue;
                if(land[i][j] == 0) continue;
                findLandSize(land,i,j, visitCounter++);

            }
        }


        for(int c = 0; c<C; c++) {
            boolean[] visitedLand = new boolean[visitCounter];
            int temp = 0;
            for(int r = 0; r<R; r++) {
                if(landPrize[r][c] == 0) continue;
                if(visitedLand[landNumber[r][c]]) continue;
                temp += landPrize[r][c];
                visitedLand[landNumber[r][c]] = true;
            }
            answer = Math.max(answer, temp);
        }

        return answer;
    }

    int[] dr = {1,-1,0,0};
    int[] dc = {0,0,1,-1};

    public void findLandSize(int[][] land, int r, int c, int visitCounter) {

        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> visitLand = new LinkedList<>();
        queue.offer(new int[]{r,c});
        visited[r][c] = true;

        while(!queue.isEmpty()) {

            int[] current = queue.poll();
            visitLand.offer(current);

            for(int i=0; i<4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];
                if(nr<0 || nc<0 || nr>=R || nc >=C) continue;
                if(land[nr][nc] == 0) continue;
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.offer(new int[]{nr,nc});
            }


        } // end of while
        count = visitLand.size();
        while(!visitLand.isEmpty()) {
            int[] pos = visitLand.poll();
            landPrize[pos[0]][pos[1]] = count;
            landNumber[pos[0]][pos[1]] = visitCounter;
        }



    }



}