import java.util.*;


/**
 *
 * 1번 : RT
 * 2번 : CF
 * 3번 : JM
 * 4번 : AN
 *
 *
 */

class Solution {

    private static final char[] charArr = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    private static Map<Character, Integer> map;


    public String solution(String[] survey, int[] choices) {
        String answer = "";
        map = new HashMap<>();
        for (char c : charArr) {
            map.put(c, 0);
        }

        for(int i=0; i<survey.length; i++) {
            countSurvey(survey[i], choices[i]);
        }

        answer += setType('R', 'T');
        answer += setType('C', 'F');
        answer += setType('J', 'M');
        answer += setType('A', 'N');


        return answer;
    }

    private String setType(char ch1, char ch2) {
        int choiceCh1 = map.get(ch1);
        int choiceCh2 = map.get(ch2);

        if(choiceCh1 == choiceCh2) {
            return ch1 < ch2 ? ch1+"" : ch2+"";
        } else {
            if(choiceCh1 >  choiceCh2)
                return ch1 + "";
            else
                return ch2 + "";
        }
    }

    private void countSurvey(String survey, int choice) {
        if(choice < 4)
            map.put(survey.charAt(0), map.get(survey.charAt(0)) + Math.abs(choice - 4));
        else
            map.put(survey.charAt(1), map.get(survey.charAt(1)) + Math.abs(choice - 4));



    }


}