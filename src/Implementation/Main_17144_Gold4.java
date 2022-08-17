package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
백준 17144 미세먼지 안녕! Gold4
[구현]

[문제 요약]
집의 미세먼지 제거를 위해 공기청정기 설치
격자판의 크기 R * C 크기
미세먼지의 양을 실시간으로 모니터링하는 시스템

공기청정기는 항상 1번열에 설치, 크기는 두행
공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 존재

<공기청정기의 작동>
1. 미세먼지가 확산, 확산은 미세먼지가 있는 모든 칸에서 동시에 실행
    - 인접한 4방향으로 확산
    - 인접한 방향에 공기청정기가 있으면 확산 x
    - 확산되는 양은 A(r,c) / 5, 소수점은 버림
    - 확산되고 남은 미세먼지의 양 : A(r,c) - ( A(r,c)/5 ) * (확산된 방향수)
2. 공기청정기가 작동
    - 위쪽 공기청정기의 바람은 반시계 방향으로 순환, 아래쪽은 시계방향으로 순환
    - 바람이 불면 미세먼지가 바람의 방향대로 모두 한칸씩 이동
    - 공기청정기에서 부는 바람은 미세먼지가 없음, 공기청정기로 들어간 미세먼지는 모두 정화
 */
class Main_17144_Gold4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    private static int R, C, T;
    private static int[][] board;
    private static int[][] machine = {{-1, -1}, {-1, -1}};
    private static int[] dr = {1,-1,0,0};
    private static int[] dc = {0,0,1,-1};

    private static int[][] clockCycle = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private static int[][] nonclockCycle = {{0,1}, {-1,0}, {0,-1}, {1,0}};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                // 공기청정기 위치 저장
                if(board[i][j] == -1) {
                    if(machine[0][0] == -1) {
                        machine[0][0] = i;
                        machine[0][1] = j;
                    }
                    else {
                        machine[1][0] = i;
                        machine[1][1] = j;

                    }
                }
            }
        }
        while(T-->0) {
            spread();
            clean();
        }
        System.out.println(calcResult());
    }


    private static void spread() {

        int[][] spreadBoard = new int[R][C];


        // spreadBoard 연산
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(board[i][j] <= 0) continue;
                int currentDust = board[i][j];
                int directionCount = 0;
                for(int k=0; k<4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                    if(nr == machine[0][0] && nc == machine[0][1]) continue;
                    if(nr == machine[1][0] && nc == machine[1][1]) continue;
                    directionCount++;
                    spreadBoard[nr][nc] += currentDust / 5;
                }
                board[i][j] = currentDust - (currentDust / 5) * directionCount;
            }
        }

        // 확산된 먼지 합산
        for(int i=0; i<R; i++) {
            for (int j = 0; j < C; j++) {
                spreadBoard[i][j] += board[i][j];
            }
        }
        board = spreadBoard;
    }

    private static void clean() {
        // 공기청정기 윗부분 청소
        int dir = 0;
        int mr = machine[0][0];
        int mc = machine[0][1];
        int nr = machine[0][0];
        int nc = machine[0][1];
        int currentDust = 0;
        int[][] turnPosition = {{0, 0}, {0, C-1}, {mr, 0}, {mr, C-1}};

        while(true) {
            nr += nonclockCycle[dir][0];
            nc += nonclockCycle[dir][1];
            for (int i = 0; i < 4; i++){
                if (nr == turnPosition[i][0] && nc == turnPosition[i][1]) {
                    dir++;
                    break;
                }
            }
            if(nr == mr && nc == mc) break; // 공기청정기를 만나면 정지
            int nextDust = board[nr][nc];
            board[nr][nc] = currentDust;
            currentDust = nextDust;
        }

        // 공기청정기 아래부분 청소
        dir = 0;
        mr = machine[1][0];
        mc = machine[1][1];
        nr = machine[1][0];
        nc = machine[1][1];
        currentDust = 0;
        turnPosition = new int[][]{{mr, 0}, {mr, C - 1}, {R - 1, C - 1}, {R-1, 0}};

        while(true) {
            nr += clockCycle[dir][0];
            nc += clockCycle[dir][1];
            for (int i = 0; i < 4; i++){
                if (nr == turnPosition[i][0] && nc == turnPosition[i][1]) {
                    dir++;
                    break;
                }
            }
            if(nr == mr && nc == mc) break; // 공기청정기를 만나면 정지
            int nextDust = board[nr][nc];
            board[nr][nc] = currentDust;
            currentDust = nextDust;
        }

    }


    private static int calcResult() {
        int count = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(board[i][j] != -1) count += board[i][j];
            }
        }
        return count;
    }

}

