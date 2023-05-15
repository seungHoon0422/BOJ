package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*

    2579 Silver3 계단 오르기
    시작시간 : 1:16
    종료시간 : 1:33
    소요시간 :17분


 */

public class Main_2579_Silver3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[i] = arr[i];
        }


        if(N > 1) dp[1] = arr[0] + arr[1];
        if(N > 2) dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);

        for(int i=3; i<N; i++) {
            dp[i] = arr[i] + Math.max(dp[i-3] + arr[i-1], dp[i-2]);
        }
        System.out.println(dp[N-1]);

    }
}