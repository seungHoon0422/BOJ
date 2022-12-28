package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *
 *
 *
 *
 * 0 1 | 2 3 | 4 5 | 6
 * 0 1 2 3
 * 0 1 | 2 3 | 4 5 | 6 7
 * 0 1 2 3
 * 1 2 3 4 5 6 7
 * 0 1 2 3
 * 1 2 | 3 4 | 5 6 | 7 8
 * 0 1 2 3
 *
 */


public class Main_1057_Silver3 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, player1, player2;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        player1 = Integer.parseInt(st.nextToken())-1;
        player2 = Integer.parseInt(st.nextToken())-1;

        int answer = 0;
        while(N>=0) {
            answer++;
            player1 /= 2;
            player2 /= 2;
            if(player1 == player2) {
                System.out.println(answer);
                return;
            }
            N = (N - 1) / 2;
        }



    }
}