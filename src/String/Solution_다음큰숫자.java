package String;


class Solution_다음큰숫자 {
    public int solution(int n) {
        int answer = 0;

        String input = Integer.toBinaryString(n);
        int originalOne = findOne(input);
        while (++n <= 1000000) {
            int nextOne = findOne(Integer.toBinaryString(n));
            if(originalOne == nextOne)
                break;
}

        return n;
    }

    public int findOne(String n) {
        int count = 0;
        for(int i=0; i<n.length(); i++) {
            if(n.charAt(i) == '1') count++;
        }
        return count;
    }

}