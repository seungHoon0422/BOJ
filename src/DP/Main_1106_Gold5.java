package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
    1106 Gold5 호텔

    시작시간 : 4:30
    종료시간 : 4:57
    소요시간 : 27분


 */

public class Main_1106_Gold5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //////////////////////////////////////////////////////////////////////


    static int c, n;
    static int[] costs, persons;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        costs = new int[n];
        persons = new int[n];
        dp = new int[c+101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cost = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());

            for(int j=person; j<c+101; j++) {
                int before = dp[j-person];
                if(before != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], before + cost);
            } // end of j
        } // end of i

        int answer = Integer.MAX_VALUE;
        for(int i=c; i<c+101; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);



    }







}










