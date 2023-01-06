package Implementation;

import java.util.StringTokenizer;

class Solution_92335_level2_2 {

    private static String number;
    public int solution(int n, int k) {
        int answer = 0;

        number = "";
        while( n > 0 ) {
            number = n%k + number;
            n/=k;
        }

        StringTokenizer st = new StringTokenizer(number, "0");
        while (st.hasMoreTokens()) {
            String nextToken = st.nextToken();
            long value = Long.parseLong(nextToken);
            if(isPrime(value))
                answer++;
        }

        return answer;
    }

    private boolean isPrime(long value) {
        if(value == 1) return false;
        for(long i=2; i*i<=value; i++) {
            if(value % i == 0) return false;
        }
        return true;
    }
}