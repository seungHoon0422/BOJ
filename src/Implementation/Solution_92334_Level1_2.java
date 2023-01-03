package Implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution_92334_Level1_2 {

    private static Map<String, Set<String>> callee;
    private static Map<String, Integer> caller;


    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];
        caller = new HashMap<>();
        callee = new HashMap<>();

        for (String id : id_list) {
            caller.put(id, 0);
            callee.put(id, new HashSet<>());
        }

        for (String repo : report) {

            String[] users = repo.split(" ");
            String callerUser = users[0];
            String calleeUser = users[1];
            callee.get(calleeUser).add(callerUser);

        }

        for(int i=0; i<id_list.length; i++) {
            String id = id_list[i];
            Set<String> calleeSet = callee.get(id);
            if(calleeSet.size() < k) continue;
            for (String callerId : calleeSet) {
                caller.put(callerId, caller.get(callerId) + 1);
            }
        }

        for(int i=0; i<id_list.length; i++) {
            answer[i] = caller.get(id_list[i]);
        }

        return answer;
    }
}