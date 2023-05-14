package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*

    2740 Silver5 행렬곱셈
    시작시간 : 12:47



 */


public class Main_2740_Silver5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M][K];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[N][K];
        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) {
                for(int k=0; k<M; k++) {
                    answer[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

}