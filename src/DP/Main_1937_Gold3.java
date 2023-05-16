package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
    1937 Gold3 욕심쟁이 판다

    시작시간 : 5:22
    종료시간 :
    소요시간 : 1시간

    <문제조건>
    - 판다는 대나무를 먹고 이동할 때 그 전 지역보다 대나무가 더 많아야 한다.
    - 판다를 풀어놓는 위치는 지유
    - 판다가 최대한 많은 칸을 이동할 수 있게

    4
    14 9 3 10
    1 11 5 4
    7 15 2 13
    6 3 16 8

 */

public class Main_1937_Gold3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    /*

     */
    static int n;
    static int[][] board, dp;
    static Node[] nodes;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        dp = new int[n][n];


        nodes = new Node[n*n];


        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                int value = Integer.parseInt(st.nextToken());
                board[i][j] = value;
                nodes[i * n + j] = new Node(value, i, j);
//                dp[i][j] = 1;
            }
        }

        Arrays.sort(nodes);

        int answer = 0;
        for (Node node : nodes) {
//            System.out.println("node = " + node);
            int value = node.value;
            int r = node.r;
            int c = node.c;

            int count = 0;
            for(int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
                if(board[nr][nc] >= board[r][c]) continue;
//                System.out.println("nr = " + nr + " nc = " + nc);
                dp[r][c] = Math.max(dp[r][c],dp[nr][nc]);
                count++;
            }

            if(count !=0 && dp[r][c] == 0) dp[r][c]++;
            else if(dp[r][c] != 0) dp[r][c]++;

            answer = Math.max(answer, dp[r][c]);

        }

//        for(int i=0; i<n; i++) System.out.println(Arrays.toString(dp[i]));

        System.out.println(answer+1);

    }



    static class Node implements Comparable<Node>{
        int value;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", r=" + r +
                    ", c=" + c +
                    '}';
        }

        int r, c;

        public Node(int value, int r, int c) {
            this.value = value;
            this.r = r;
            this.c = c;
        }


        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }


}