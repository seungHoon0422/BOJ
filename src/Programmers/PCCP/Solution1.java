package Programmers.PCCP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1 {

    private static Map<Character, List<int[]>> alpha;
    public String solution(String input) {
        String answer = "";

        alpha = new HashMap<>();
        for(char c = 'a'; c<='z'; c++) {
            alpha.put(c, new ArrayList<>());
        }

        char ch = '0';
        int count = 0;
        for(int i=0; i<input.length(); i++) {
            char next = input.charAt(i);
            if(ch == '0') {
                ch = next;
                count = 1;
                continue;
            }
            if(ch == next) {
                count++;
            } else {
                alpha.get(ch).add(new int[]{i - 1, count});
                ch = next;
                count = 1;
            }

        }
        alpha.get(ch).add(new int[]{input.length()-1, count});

        for (char c : alpha.keySet()) {
            List<int[]> list = alpha.get(c);
            if(list.size() < 2) continue;
            answer += c;
        }
        if(answer == "") return "N";
        else return answer;
    }
}