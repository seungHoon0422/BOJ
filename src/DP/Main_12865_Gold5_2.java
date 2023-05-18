package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    12865 Gold5 평범한 배낭

    시작시간 : 4:17
    종료시간 : 4:27
    소요시간 : 10분


 */

public class Main_12865_Gold5_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //////////////////////////////////////////////////////////////////////
    static int n, k;
    static int[][] dp;
    static int[][] items;





    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp  = new int[n+1][k+1];
        items = new int[n+1][2]; // [weight] [value]


        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        // bottom up
        /*
            f(i, k) - 0                                                     (k = 0)
                    - f(i-1, k)                                             (item[i][0] < k)
                    - max(f(i-1, k - item[i][0]) + item[i][1], f(i-1, k)    (item[i][0] < k)
         */

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=k; j++) {
                if(items[i][0] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]] + items[i][1]);
            }
        }

        System.out.println(dp[n][k]);

    }


}










