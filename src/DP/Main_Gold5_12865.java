package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    12865 Gold3 평범한 배낭

    시작시간 : 3:46
    종료시간 : 4:13
    소요시간 : 27분


 */

public class Main_Gold5_12865 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //////////////////////////////////////////////////////////////////////
    static int n, k;
    static Integer[][] dp;
    static int[][] items;





    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp  = new Integer[n][k+1];
        items = new int[n][2]; // [weight] [value]


        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        // top - down 방식으로 구현
        /*
            f(i, k) - 0                                                     (k = 0)
                    - f(i-1, k)                                             (item[i][0] < k)
                    - max(f(i-1, k - item[i][0]) + item[i][1], f(i-1, k)    (item[i][0] < k)
         */

        System.out.println(knapsack(n-1,k));

    }

    static int knapsack(int i, int k) {
        if(i<0) return 0;

        if(dp[i][k] == null) {

            if(items[i][0] > k) dp[i][k] = knapsack(i-1, k);
            else dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-items[i][0]) + items[i][1]);
        }

        return dp[i][k];
    }




}










