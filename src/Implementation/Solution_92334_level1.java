package Implementation;

import java.util.*;

/*

걸린시간 : 20분

[문제 요약]
각 유저는 한번에 한명의 유저를 신고
    신고횟수 제한 x
    한 유저를 여러번 신고 가능, 신고 횟수는 1회로 측정
k번 이상 신고된 유저는 게시판 이용이 정지, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
    유저가 신고한 내용을 취합해서 마지막에 한꺼번에 정지메일 발송


[Solution]
신고당한 유저는 신고한 유저의 set에 저장 -> 중복 체크
신고 데이터를 모두 저장했으면 유저별로 신고당한 횟수를 확인(k)
k번이상 신고된 유저를 신고한 유저에게 카운트



 */
class Solution_92334_level1 {
    private int userSize;
    private Map<String, Set<String>> caller;
    private Map<String, Integer> calleeCounter;

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        userSize = id_list.length;
        caller = new HashMap<>();
        calleeCounter = new HashMap<>();

        Arrays.stream(id_list).forEach(element -> {
            caller.put(element, new HashSet());
            calleeCounter.put(element, 0);
        });
        Arrays.stream(report).forEach(element -> {
            String[] str = element.split(" ");
            String callerUser = str[0];
            String calleeUser = str[1];
            caller.get(callerUser).add(calleeUser);
        });



        for(String key : caller.keySet()) {
            Set<String> calleeList = caller.get(key);
            calleeList.forEach(callee -> calleeCounter.put(callee, calleeCounter.get(callee) + 1));
        }
        for(int i=0; i<userSize; i++) {
            String id = id_list[i];
            int finalI = i;
            caller.get(id).forEach(callee -> {
                if(calleeCounter.get(callee) >= k) {
                    answer[finalI]++;
                }
            });
        }

        return answer;
    } // end of solution



} // end of class






