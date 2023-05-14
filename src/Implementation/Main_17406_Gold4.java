package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    17406 Gold4 배열돌리기 4

    시작시간 : 2:18
    종료시간 : 3:00
    소요시간 : 42분


 */

public class Main_17406_Gold4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    ///////////////////////////////////////////////////////////////////////////////
    static int  N, M, K, answer;
    static int[][] board;
    static Option[] options;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        board = new int[N][M];
        options = new Option[K];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<K ;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            options[i] = new Option(r,c,s);
        }

        combination(0, new boolean[K], new int[K]);
        System.out.println(answer);

    }

    private static void combination(int index, boolean[] visited, int[] result) {
        if(index == K) {

            rotateArray(result);

            return;
        } // 기저조건
        for(int i=0; i<K; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            result[index] = i;
            combination(index + 1, visited, result);
            visited[i] = false;
        }

    }


    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void rotateArray(int[] flow) {

        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++) copy[i] = Arrays.copyOf(board[i], M);

        for (int index : flow) {
            Option option = options[index];

            int size = option.s * 2 + 1;
            int offset = 0;
            while(size > 1) {
                int startR = option.start[0] + offset;
                int startC = option.start[1] + offset;
                int r = startR;
                int c = startC;

                int rest = copy[r][c];

                for(; r < startR + size - 1;r++)
                    copy[r][c] = copy[r+1][c];
                for(; c < startC + size - 1;c++)
                    copy[r][c] = copy[r][c+1];
                for(; r > startR; r--)
                    copy[r][c] = copy[r-1][c];
                for(; c > startC; c--)
                    copy[r][c] = copy[r][c-1];

                copy[startR][startC+1] = rest;

                offset++;
                size -= 2;
            } // end of while
        } // end of rotate

        int sum = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            int tempSum = 0;
            for(int j=0; j<M; j++) {
                tempSum += copy[i][j];
            }
            sum = Math.min(sum, tempSum);
        }
        answer = Math.min(answer, sum);


    } // end of method

    static class Option {
        int r, c, s;
        int[] start, end;

        public Option(int r, int c, int s) {
            this.r = r-1;
            this.c = c-1;
            this.s = s;
            start = new int[]{this.r - s, this.c - s};
            end = new int[]{this.r + s, this.c + s};

        }
    }


}