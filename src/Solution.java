import java.util.*;
import java.io.*;

/*


    2023 kakao blind, Level1 개인정보 수집 유호기간
    시작시간 : 2:06

 */


class Solution {

    static String today;
    static String[] terms, privacies;

    static Map<String, Integer> term = new HashMap<>();

    public int[] solution(String to, String[] ts, String[] ps) {

        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();
        today = to;
        terms = ts;
        privacies = ps;

        StringTokenizer st = new StringTokenizer(today, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        for(int i=0; i<terms.length; i++) {
            String[] split = ts[i].split(" ");
            term.put(split[0], Integer.parseInt(split[1]));
        }

        for(int i=0; i<ps.length; i++) {
            String[] split = ps[i].split(" ");
            String date = split[0];
            String type = split[1];

            st = new StringTokenizer(date, ".");
            int tempYear = Integer.parseInt(st.nextToken());
            int tempMonth = Integer.parseInt(st.nextToken());
            int tempDay = Integer.parseInt(st.nextToken());
            tempMonth += term.get(type);

            tempDay--;
            if(tempDay< 1) {
                tempDay = 28;
                tempMonth--;
            }
            if(tempMonth > 12) {
                tempYear += tempMonth / 12;
                tempMonth = tempMonth % 12;
                if (tempMonth == 0) {
                    tempYear--;
                    tempMonth = 12;
                }
            }

                if(compareDate(year, month, day, tempYear, tempMonth, tempDay)) {
                    answerList.add(i+1);
                }
            }
            answer = new int[answerList.size()];
            for(int i=0; i<answerList.size(); i++)
                answer[i] = answerList.get(i);

            return answer;
        }

        private boolean compareDate(int year, int month, int day, int tempYear, int tempMonth, int tempDay) {

            if(year > tempYear) return true;
            else if(year == tempYear) {
                if(month > tempMonth) return true;
                else if(month == tempMonth) {
                    if(day > tempDay) return true;
                }
            }
            return false;
        }
    }