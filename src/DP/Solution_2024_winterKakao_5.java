package DP;

class Solution_2024_winterKakao_5 {

    static int[] tri, rec;



    public int solution(int n, int[] tops) {
        int answer = 0;
        tri = new int[n];
        rec = new int[n];

        if(tops[0] == 1) {
            tri[0] = 3;
            rec[0] = 1;
        } else {
            tri[0] = 2;
            rec[0] = 1;
        }


        for(int i=1; i<n; i++) {


            // 봉우리가 있는 경우
            if(tops[i] == 1) {
                // 1. 마지막이 삼각형으로 채워지는 경우
                tri[i] = (tri[i-1] * 3 + rec[i-1] * 2) % 10007;
                // 2. 마지막이 마름모로 채워지는 경우
                rec[i] = (tri[i-1] + rec[i-1]) % 10007;
            }
            // 봉우리가 없는 경우
            else {
                // 1. 마지막이 삼각형으로 채워지는 경우
                tri[i] = (tri[i-1] * 2 + rec[i-1]) % 10007;
                // 2. 마지막이 마름모로 채워지는 경우
                rec[i] = (tri[i-1] + rec[i-1]) % 10007;
            }
        } // end of for


        answer = tri[n-1] + rec[n-1];




        return answer;
    }
}