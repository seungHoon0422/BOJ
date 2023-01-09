package DataStructure;

import java.util.Stack;

class Solution_60058_level2 {
    public String solution(String p) {
        String answer = "";
        answer = findRightString(p);



        return answer;
    }

    private String findRightString(String p) {
        if(p.equals("")) return p;

        int index = 0, left = 0, right = 0;
        for(; index<p.length(); index++) {
            if(p.charAt(index) == '(') left++;
            else right++;
            if(left == right) break;
        }
        String u = p.substring(0, left+right);
        String v = p.substring(left + right);
        if(isRightString(u)) {
            return u + findRightString(v);
        } else {
            String newU = "";
            for(int i=1; i<u.length()-1; i++) {
                if(u.charAt(i) == '(') newU += ')';
                else newU += '(';   
            }
            return '(' + findRightString(v) + ')' + newU;
        }




    }

    private boolean isRightString(String u) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<u.length(); i++) {
            if(u.charAt(i) == '(') st.push('(');
            else {
                if(st.isEmpty()) return false;
                else st.pop();
            }
        }
        return true;
    }


}