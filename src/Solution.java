import java.util.*;

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
class Solution {

//    private static int[][] weight;
    private static List<int[]>[] weight;
    private static int[] minCost;
    private static Set<Integer> summitSet;
    private static Set<Integer> gateSet;
    private static boolean[] visited;

    static final int INF = 1000000000;


    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        init(n, paths, gates, summits);
        for (int gate : gates) {
            visited = new boolean[n+1];
            visited[gate] = true;
            dfs(gate, 0);
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
            if(visited[i]) continue; // 방문한 쉼터인 경우
            int nextIntensity = Math.max(intensity, path[1]);

            if(minCost[i] <= nextIntensity) continue;
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
            minCost[i] = INF;
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