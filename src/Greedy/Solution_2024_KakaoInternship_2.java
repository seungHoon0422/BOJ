package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution_2024_KakaoInternship_2 {

    Map<Integer, List<Integer>> out = new HashMap<>();
    Map<Integer, List<Integer>> in = new HashMap<>();
    boolean[] visited = new boolean[1000001];


    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        for(int[] edge : edges) {
            List<Integer> list = new ArrayList<>();

            if(out.containsKey(edge[0])) list = out.get(edge[0]);
            list.add(edge[1]);
            out.put(edge[0], list);

            list = new ArrayList<>();
            if(in.containsKey(edge[1])) list = in.get(edge[1]);
            list.add(edge[0]);
            in.put(edge[1], list);
        }

        int createNode = 0;
        for(int outKey : out.keySet()) {
            if(!in.keySet().contains(outKey)) {
                createNode = outKey;
                break;
            }
        } // end of out for
        answer[0] = createNode;


        List<Integer> targetNodes =  out.get(createNode);
        for(Integer targetNode : targetNodes) {

            int answerCase = checkCase(targetNode);
            answer[answerCase]++;
        }

        // 1. 도넛모양, 2. 막대모양, 3. 8자모양





        return answer;
    }

    public int checkCase(int node) {
        visited[node] = true;
        int outCount = 0, inCount = 0;
        if(out.containsKey(node)) outCount = out.get(node).size();
        if(in.containsKey(node)) inCount = in.get(node).size();

        if(outCount == 0) return 2;
        else if(outCount >= 2 && inCount >= 2) return 3;
        else if(visited[out.get(node).get(0)]) return 1;
        return checkCase(out.get(node).get(0));

    }



}














