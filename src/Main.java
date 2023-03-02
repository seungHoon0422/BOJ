import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[][] price;
    static int answer;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        price = new int[M][2];
        answer = Integer.MAX_VALUE;
        int count = N/6;
        if((N%6) != 0) count++;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            answer = Math.min(answer, price[i][0] * count);
            answer = Math.min(answer, price[i][1] * N);
        }


        System.out.println(answer);
    }
}