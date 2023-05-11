package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*

    17143 Gold1 낚시왕

    시작시간 : 8:11
    종료시간 : 9:37
    소요시간 : 1시간 26분

    <문제조건>
    1. 낚시왕이 오른쪽으로 한 칸 이동
    2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다.
    3. 상어가 이동한다.

    - 상어가 한칸에 2마리가 존재할 경우 크기가 큰 상어가 작은 상어를 잡아먹는다.
    - 상어의 방향 1 : 위, 2: 아래, 3: 오른쪽, 4: 왼쪽





 */

public class Main_17143_Gold1_낚시왕 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C, M;

    static Shark[][] board;

    static int position, answer;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new Shark[R][C];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            board[r][c] = new Shark(r, c, speed, dir, size);
        }

        position = -1;
        answer = 0;

        while(++position < C) {
            // 1. 상어를 잡아먹는다.
            Shark targetShark = null;
            for(int row=0; row<R; row++) {
                if(board[row][position] != null) {
                    targetShark = board[row][position];
                    break;
                }
            }

            if(targetShark != null) {
                answer += targetShark.size;
                board[targetShark.r][targetShark.c] = null;
            }

            // 2. 상어 이동
            moveShark();
        }
        System.out.println(answer);



    } // end of main


    private static void moveShark() {

        // 이동한 상어를 저장할 배열을 선언
        Shark[][] afterMove = new Shark[R][C];

        // 이동한 위치에 상어가 존재할 경우 크기비교 시작
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {

                if(board[i][j] == null) continue;

                // 상어 이동
                Shark shark = moveDir(board[i][j]);

                // 이동한 위치에 상어가 없거나, 기존에 있던 상어보다 사이즈가 큰 경우
                if(afterMove[shark.r][shark.c] == null || afterMove[shark.r][shark.c].size < shark.size)
                    afterMove[shark.r][shark.c] = shark;
            }
        }

        // 크기가 큰 상어가 작은 상어를 잡아먹는다.

        board = afterMove;

    }


    // index 1부터 시작, 순서대로 위, 아래, 오른쪽, 왼쪽
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};

    private static Shark moveDir(Shark shark) {

        int r = shark.r;
        int c = shark.c;

        if(shark.dir <= 2) {
            // 행이동

            int restDistance = shark.speed % ((R-1) * 2);
            for(int i=0; i<restDistance; i++) {
                if(r==0 && shark.dir == 1) shark.dir = 2;
                else if(r==R-1 && shark.dir == 2) shark.dir = 1;
                r += dr[shark.dir];
            }

        } else {
            // 열이동

            int restDistance = shark.speed % ((C-1) * 2);
            for(int i=0; i<restDistance; i++) {
                if(c==0 && shark.dir == 4) shark.dir = 3;
                else if(c==C-1 && shark.dir == 3) shark.dir = 4;
                c += dc[shark.dir];
            }
        }

        shark.r = r;
        shark.c = c;

        return shark;
    }

    static class Shark {
        int r, c, speed, dir, size;

        public Shark(int r, int c, int speed, int dir, int size) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }


}

