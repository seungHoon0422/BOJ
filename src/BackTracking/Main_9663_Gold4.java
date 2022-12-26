package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_Gold4 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, answer;
    private static int[] col;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        answer = 0;
        col = new int[N];

        for(int i=0; i<N; i++)
            col[i] = 1;
        nQueen(0);
        System.out.println(answer);
    }

    /**
     *
     * @param row
     */
    private static void nQueen(int row) {
        if(row == N) {
            answer++;
            return;
        }

        for(int i=0; i<N; i++) {
            col[row] = i;
            if(isPossibleCol(row)) {
                nQueen(row+1);
            }
        }
    }

    private static boolean isPossibleCol(int row) {
        for(int i=0; i<row; i++) {
            if(col[i] == col[row] || row - i == Math.abs(col[row] - col[i]))
                return false;
        }
        return true;
    }
}