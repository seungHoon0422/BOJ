import java.util.*;


class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int number = 0;
        int index = 1;
        while(t > 0) {
            String convertString = change(number, n);
            for(int i=0; i<convertString.length(); i++) {
                char ch = convertString.charAt(i);

                // t번 모두 출력한 경우
                if( t == 0 ) break;

                // 튜브의 순서인 경우
                if(index == p) {
                    answer += ch;
                    t--;
                }
                if(index == m) index = 0;

                index++;

            }
            number++;

        }


        return answer;
    }


    private String change(int number, int n) {

        String result = "";
        if(number == 0) return "0";
        while(number > 0) {
            int mod = number % n;
            if(mod < 10) result = mod + result;
            else {
                if(mod == 10) result = 'A' + result;
                else if(mod == 11) result = 'B' + result;
                else if(mod == 12) result = 'C' + result;
                else if(mod == 13) result = 'D' + result;
                else if(mod == 14) result = 'E' + result;
                else if(mod == 15) result = 'F' + result;
            }
            number /= n;
        }
        return result;

    }
}