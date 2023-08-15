package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_2775_Bronze1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int tc, k, n;

    public static void main(String[] args) throws IOException{


        tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k+1][n+1];
            for(int i=1; i<=n; i++) dp[0][i] = i;
            for(int floor = 1; floor <= k; floor++) {
                dp[floor][1] = 1;
                for(int ho = 2; ho <=n; ho++) {
                    dp[floor][ho] = dp[floor][ho-1] + dp[floor-1][ho];
                }
            }
            sb.append(dp[k][n]).append("\n");

        }
        System.out.println(sb.toString());

    }

}