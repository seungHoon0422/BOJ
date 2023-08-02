package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_14500_Gold4 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N, M, answer;
    private static int[][] board;
    private static boolean[][] visited;
    private static boolean[][] innerVisit;

    private static final int[] dr = {1,-1,0,0};
    private static final int[] dc = {0,0,1,-1};

    static int case1(int x, int y)
    { // ㅏ
        return board[x][y] + board[x + 1][y] + board[x + 1][y + 1] + board[x + 2][y];
    }
    static int case2(int x, int y)
    { // ㅓ
        return board[x][y] + board[x + 1][y+1] + board[x][y+1] + board[x-1][y+1];
    }
    static int case3(int x, int y)
    { // ㅗ
        return board[x][y] + board[x][y+1] + board[x][y+2] + board[x-1][y+1];
    }
    static int case4(int x, int y)
    { // ㅜ
        return board[x][y] + board[x][y+1] + board[x + 1][y + 1] + board[x][y+2];
    }
    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        answer = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited[i][j] = true;
                dfs(i,j,board[i][j], 1);
                visited[i][j] = false;
                if(i + 2 < N && j + 1 < M) // ㅏ ㅓ ㅗ ㅜ
                    answer = Math.max(answer, case1(i, j));
                if (i + 1 < N && i-1>=0 && j+1 < M)
                    answer = Math.max(answer, case2(i, j));
                if (i - 1 >= 0 && j + 2 < M)
                    answer = Math.max(answer, case3(i, j));
                if (i + 1 < N && j + 2 < M)
                    answer = Math.max(answer, case4(i, j));

            }
        }

        System.out.println(answer);

    }

    private static void dfs(int r, int c, int value, int count) {

        if(count == 4) {
            answer = Math.max(answer, value);
            return;
        }

        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || nr >=N || nc>=M) continue;
            if(visited[nr][nc]) continue;

            // 2번째 탐색에 한번 더 dfs를 타게해서 ㅗ, ㅜ, ㅓ, ㅏ 모양을 판단
//            if(count == 2) {
//                visited[nr][nc] = true;
//                dfs(r,c,value + board[nr][nc], count + 1);
//                visited[nr][nc] = false;
//            }

            visited[nr][nc] = true;
            dfs(nr,nc,value + board[nr][nc], count + 1);
            visited[nr][nc] = false;
        }




    }


    public void printBoard() {
        System.out.println("<BOARD>");
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }




}