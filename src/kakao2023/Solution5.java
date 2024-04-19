package kakao2023;


class Solution5 {

    int[][] dp = new int[100001][2];

    public int solution(int n, int[] tops) {
        int answer = 0;

        dp[0][0] = 0;
        dp[0][1] = 1;
        if(tops[0] == 0) {
            dp[1][0] = 1;
            dp[1][1] = 2;
        }
        else {
            dp[1][0] = 1;
            dp[1][1] = 3;
        }

        for(int i=2; i<=n; i++) {
            if(tops[i-1] == 1) {
                dp[i][0] = (dp[i-1][0] + dp[i-1][1])% 10007;
                dp[i][1] = (dp[i-1][0] * 2 + dp[i-1][1] * 3)% 10007;
            } else {
                //민둥 사다리꼴
                dp[i][0] = (dp[i-1][0] + dp[i-1][1])% 10007;
                dp[i][1] = (dp[i-1][0] + dp[i-1][1] * 2)% 10007;

            }
        }


        return (dp[n][0] + dp[n][1]) % 10007;
    }
}