package kakao2023;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*

더 많은 선물을 준사람이 ㅁ

선물지수 : 이번달까지 자신이 친구들에게 준 선물의 수 - 받은 선물의 수
두 사람의 선물 지수도 같다면 다음달에 선물을 주고받지 않는다.


 */


class Solution_1 {

    int[][] board;
    int[] giftScore, result;
    Map<String, Integer> pos = new HashMap<>();
    StringTokenizer st;


    public int solution(String[] friends, String[] gifts) {

        board = new int[friends.length][friends.length];
        giftScore = new int[friends.length];
        result = new int[friends.length];
        int answer = 0;

        for(int i=0; i<friends.length; i++) {
            if(!pos.containsKey(friends[i]))
                pos.put(friends[i], i);
        }

        for(String gift : gifts) {
            st = new StringTokenizer(gift, " ");
            int from = pos.get(st.nextToken());
            int to = pos.get(st.nextToken());

            board[from][to]++;
            giftScore[from]++;
            giftScore[to]--;
        }

        for(int i=0; i< friends.length; i++) {
            for(int j=i+1; j< friends.length; j++) {

                // 서로 주고받은 선물개수가 다른 경우

                if(board[i][j] > board[j][i]) result[i]++;
                else if(board[i][j] < board[j][i]) result[j]++;
                else {
                    // 선물 지수로 판단
                    if(giftScore[i] > giftScore[j]) result[i]++;
                    else if(giftScore[i] < giftScore[j]) result[j]++;
                }
            }
        }
        for(int i=0; i<result.length; i++) {
            answer = Math.max(answer, result[i]);

        }
        return answer;
    }
}