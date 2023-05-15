import java.util.*;
import java.io.*;


/*
    1051 Silver4 숫자 정사각형
    시작시간 : 12:47
    종료시간 : 12:57
    소요시간 : 10분



 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for(int i=0; i<N; i++) {
            char[] inputs = br.readLine().toCharArray();
            for(int j=0; j<M; j++)board[i][j] = Integer.parseInt(String.valueOf(inputs[j] - '0'));
        }
        int size = Math.min(N, M);
        while(size > 1) {

            for(int r = 0; r + size - 1< N; r++) {
                for(int c = 0; c + size - 1 < M; c++) {
                    int node1 = board[r][c];
                    int node2 = board[r+size-1][c];
                    int node3 = board[r][c+size-1];
                    int node4 = board[r+size-1][c+size-1];
                    if(node1 == node2 && node2 == node3 && node3 == node4) {
                        System.out.println(size *size);
                        return;
                    }
                }
            }
            size--;

        }


        System.out.println(1);

    }

}