package BackTracking;

/**
 *
 * 1. 높은 점수부터 최대한 득점을 챙긴다.
 *
 * 2. 모든 경우의수를 체크한다.
 *
 *
 */

class Solution_92342_Level2 {

    private static int diffScore;
    private static int[] answer;
    public int[] solution(int n, int[] info) {
        answer = new int[11];

        diffScore = -1;
        int[] apeach = info;
        int[] lion = new int[11];
        int apeachScore = 0;
        int lionScore = 0;
        int index = 0;
        shoot(n, index, apeach, lion, apeachScore, lionScore);

        if(diffScore == -1)
            answer = new int[] {-1};
        return answer;
    }

    private void shoot(int n, int index, int[] apeach, int[] lion, int apeachScore, int lionScore) {

        if(index == 11) {
            if(apeachScore >= lionScore)
                return;

            int diff = lionScore - apeachScore;
            if(diff > diffScore) {
                diffScore = diff;
                for(int i=0; i<11; i++)
                    answer[i] = lion[i];
                return;
            }
            else if(diff == diffScore){
                for(int i=10; i>=0; i--) {
                    if(answer[i] == lion[i]) continue;
                    if(answer[i] > lion[i]) {
                        return;
                    } else {
                        for(int j=0; j<11; j++)
                            answer[j] = lion[j];
                        return;
                    }
                }
            }
            return;
        }

        for(int i=0; i<=n; i++) {
            lion[index] = i;
            if(lion[index] == 0 && apeach[index] == 0) {
                shoot(n-i, index+1, apeach, lion, apeachScore, lionScore);
            } else if(lion[index] > apeach[index]) {
                shoot(n-i, index+1, apeach, lion, apeachScore, lionScore + (10-index));
            } else {
                shoot(n-i, index + 1, apeach, lion, apeachScore + (10 - index), lionScore);
            }
        }


    }

}