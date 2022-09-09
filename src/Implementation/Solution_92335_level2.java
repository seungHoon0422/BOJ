package Implementation;

import java.util.StringTokenizer;

/*
소요 시간 : 15분

[문제 요약]
10진수의 n이 주어졌을 때 k진수로 변환 후
0을 기준으로 각 분리된 숫자들이 소수인지 판별하여 소수의 개수를 리턴

[Solution]
소수문제는 에라토스테네스의 체 사용
하지만 소수를 판별한 숫자의 범위가 정해져있지 않고, long 타입으로 판별해야하므로
각 숫자가 소수인지 그때마다 판별하는 방식으로 해결
문자열 연산 및 stringbuilder 사용 시 k진수로 변환하는 과정에서
reverse()함수를 사용하여 원하는 값을 획득한다.
그후 stringtokenizer 객체를 사용하여 0을 기준으로 구분하여 각 숫자가 소수인지 판별




 */
class Solution_92335_level2 {


    StringTokenizer st;
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String str = "";
        while(n != 0) {
            sb.append(n%k);
            n/=k;
        }
        sb.reverse();

        st = new StringTokenizer(sb.toString(), "0");
        while(st.hasMoreTokens()) {
            long value = Long.parseLong(st.nextToken());

            if(isPrime(value)) answer++;
//            System.out.println(value+ " " + answer);
        }



        return answer;
    }

    private boolean isPrime(long value) {

        if(value <= 1) return false;
        for(long i = 2L; i *i <= value; i++) {
            if(value%i == 0 ) return false;
        }
        return true;
    }


}