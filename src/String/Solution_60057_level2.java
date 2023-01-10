package String;

class Solution_60057_level2 {
    public int solution(String s) {
        int answer = s.length();
        for(int i=s.length()/2; i>=1; i--) {
            answer = Math.min(answer, zip(s, i));
        }
        return answer;
    }

    private int zip(String s, int size) {

        String result = "";
        int i=0;

        for(; i<=s.length()-size;) {
            String substr1 = s.substring(i, i+size);
            int count = 1;
            int substrSize = i + size * 2;

            while(substrSize <= s.length()) {
                String substr2 = s.substring(i+size*count,substrSize);
                if(substr1.equals(substr2)) {
                    count++;
                    substrSize += size;
                } else {
                    break;
                }
            } // end of while
            if(count == 1) {
                result += substr1;
                i+=size;
            } else {
                result += count + substr1;
                i = substrSize - size;
                count = 1;
            }
        } // end of for

        if (i < s.length()) {
            result += s.substring(i, s.length());
        }

        return result.length();
    }
}