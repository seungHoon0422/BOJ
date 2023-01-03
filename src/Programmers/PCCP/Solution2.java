package Programmers.PCCP;

class Solution2 {

    private static int answer;
    public int solution(int[][] ability) {
        answer = 0;
        dfs(0, 0, ability, new boolean[ability.length]);

        return answer;
    }

    private void dfs(int count, int sum, int[][] ability, boolean[] visited) {
        if(count == ability[0].length) {
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0; i<ability.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(count + 1, sum + ability[i][count], ability, visited);
            visited[i] = false;
        }
    }
}