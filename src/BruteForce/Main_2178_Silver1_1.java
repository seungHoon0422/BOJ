package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_2178_Silver1_1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static char[][] board;
    static int[][] visited;
    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N+1][M+1];
        visited = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j=1; j<=M; j++){
                board[i][j] = input[j-1];
                visited[i][j] = Integer.MAX_VALUE;
            }

        }

        visited[1][1] = 1;
        dfs(1,1);

        System.out.println(visited[N][M]);



    }

    private static final int[] dr = {1,-1,0,0};
    private static final int[] dc = {0,0,1,-1};

    private static void dfs(int r, int c) {
        if(r == N && c == M) {
            return;
        }

        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr == 0 || nc == 0 || nr > N || nc > M) continue;
            if(board[nr][nc] == '0') continue;

            if(visited[nr][nc] == Integer.MAX_VALUE || visited[nr][nc] > visited[r][c] + 1) {
                visited[nr][nc] = visited[r][c] + 1;
                dfs(nr,nc);
            }




        }



    }

}