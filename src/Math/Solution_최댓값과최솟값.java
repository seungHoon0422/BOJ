package Math;

import java.util.StringTokenizer;

class Solution_최댓값과최솟값 {

    static StringTokenizer st;
    public String solution(String s) {
        String answer = "";

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        st = new StringTokenizer(s, " ");
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        answer = new StringBuilder().append(min).append(" ").append(max).toString();
        


        return answer;
    }
}