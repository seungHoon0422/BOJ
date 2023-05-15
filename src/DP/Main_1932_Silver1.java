package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    1932 Silver1 정수 삼각형
    시작시간 : 2:30
    종료시간 : 3:35
    소요시간 : 5분




 */


public class Main_1932_Silver1 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {


        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(i==0) break;

                if(i == j) board[i][j] += board[i-1][j-1];
                else if( j== 0) board[i][j] += board[i-1][j];
                else board[i][j] += Math.max(board[i-1][j-1], board[i-1][j]);
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) answer = Math.max(answer, board[N - 1][i]);
        System.out.println(answer);





    }


}
