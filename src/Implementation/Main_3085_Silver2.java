package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    3085 Silver2 사탕게임
    소요시간 : 15분

    <문제조건>
    - 이차원배열에 사탕이 주어진다.
    - 사탕 2개를 위치를 교환할 수 있고,
    - 연속되어 같은 문자의 사탕을 얼마나 먹을 수 있나

    <해결방법>
    - 사탕 2개의 위치를 변환했을 때마다 변환된 행, 열만 체크하는 거싱 효율성면에서 가장 좋다.
    - 시간초과가 우려되지 않는 부분이 있어 쉽게 전체배열 체크하는 방식



 */
public class Main_3085_Silver2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {

        int result = 0;
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int d=0; d<4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if(nr<0 || nr>=n || nc<0 || nc>=n) continue;
                    char c = board[i][j];
                    board[i][j] = board[nr][nc];
                    board[nr][nc] = c;
                    result = Math.max(result,findCandy());
                    c = board[i][j];
                    board[i][j] = board[nr][nc];
                    board[nr][nc] = c;
                }
            }
        }
        System.out.println(result);

    }

    public static int findCandy() {
        int answer = 1;
        for(int i=0; i<n; i++) {
            int index = 1;
            int count = 1;
            while(index < n) {
                if(board[index][i] == board[index-1][i]) {
                    index++;
                    count++;
                } else {
                    index++;
                    answer = Math.max(answer, count);
                    count = 1;
                }

            }
            answer = Math.max(answer, count);

            index = 1;
            count = 1;
            while(index < n) {
                if(board[i][index] == board[i][index-1]) {
                    index++;
                    count++;
                } else {
                    index++;
                    answer = Math.max(answer, count);
                    count = 1;
                }

            }
            answer = Math.max(answer, count);
        }
        return answer;
    }



}