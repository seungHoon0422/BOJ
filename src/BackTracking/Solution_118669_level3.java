package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 출입구, 쉼터, 산봉우리
 * 양방향 통행이 가능하다.
 * 등산로별 시간 소요
 * intensity : 휴식없이 이동해야 하는 시간 중 가장 긴 시간
 * 한곳의 출입구에서 출발해 시작한 출입구로 다시 돌아오는 등산코스를 짜려고함
 * 출입구는 처음과 끝에 한번씩
 * 산봉우리는 한번만
 * <p>
 * intensity가 최소가 되는 등산코스가 여러 개라면
 * 그중 산봉우리의 번호가 가장 낮은 등산코스를 선택
 */
class Solution_118669_level3 {

//    private static int[][] weight;
    private static List<int[]>[] weight;
    private static int[] minCost;
    private static Set<Integer> summitSet;
    private static Set<Integer> gateSet;
    private static boolean[] visited;


    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        init(n, paths, gates, summits);
        for (int gate : gates) {
            visited = new boolean[n+1];
            visited[gate] = true;
            dfs(gate, Integer.MAX_VALUE);
            visited[gate] = false;
        }

        for (int summit : summits) {
            if(minCost[summit] < answer[1]) {
                answer = new int[] {summit, minCost[summit]};
            } else if(minCost[summit] == answer[1]) {
                if(summit < answer[0]) {
                    answer = new int[] {summit, minCost[summit]};
                }
            }
        }

        return answer;
    }

    private void dfs(int gate, int intensity) {


        // is summit
        if (summitSet.contains(gate)) {
            return;
        }

        for (int[] path : weight[gate]) {
            // 출입구는 패스
            int i = path[0];
            if(gateSet.contains(i)) continue;
            if(path[1] == 0) continue; // 길이 없는 경우
            if(visited[i]) continue; // 방문한 쉼터인 경우
            int nextIntensity;

            if(intensity == Integer.MAX_VALUE) // 출발지점 시작
                nextIntensity = path[1];
            else
                nextIntensity = Math.max(minCost[gate], path[1]);

//            if(minCost[i] == Integer.MAX_VALUE) {
//                minCost[i] = nextIntensity;
//            } else {
//                if(minCost[i] < nextIntensity)
//            }
//
            if(! (minCost[i] == Integer.MAX_VALUE) && minCost[i] < nextIntensity) continue;
            minCost[i] = nextIntensity;

            visited[i] = true;
            dfs(i, minCost[i]);
            visited[i] = false;

        }
    }

    private void init(int n, int[][] paths, int[] gates, int[] summits) {
        weight = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            weight[i] = new ArrayList<>();
        }
        minCost = new int[n+1];
        summitSet = new HashSet<>();
        gateSet = new HashSet<>();

        // init weight
        for (int[] path : paths) {
            weight[path[0]].add(new int[]{path[1], path[2]});
            weight[path[1]].add(new int[]{path[0], path[2]});
        }

        // init minCost
        for (int i = 0; i < minCost.length; i++) {
            minCost[i] = Integer.MAX_VALUE;
        }

        // init summit set
        for (int summit : summits) {
            summitSet.add(summit);
        }

        for (int gate : gates) {
            gateSet.add(gate);
        }
    }

}