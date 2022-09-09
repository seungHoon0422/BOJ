import javax.xml.bind.Element;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
자리 배치 방식
1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정함
2. 1을 만족하는 칸이 여러개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
3. 2를 만족하는 칸도 여려 개인 경우에는 행의 번호가 가장 작은 칸으로,
그러한 칸도 여려개이면 열의 변호가 가장 작은 칸으로 자리를 정한다.

 */
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int students;
    private static int[][] board;
    private static int[][] hopeStudents;
    static StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    static Comparator<Position> comparatorBlank;
    static Comparator<Position> comparatorMinPosition;

    public static void main(String[] args) throws IOException {

        settingComparator();
        N = Integer.parseInt(br.readLine());
        students = N * N;
        board = new int[N][N];
        hopeStudents = new int[N*N+1][4];
        for(int i=0; i<students; i++) {
            String[] inputs = br.readLine().split(" ");
            int student = Integer.parseInt(inputs[0]);
            hopeStudents[student][0] = Integer.parseInt(inputs[1]);
            hopeStudents[student][1] = Integer.parseInt(inputs[2]);
            hopeStudents[student][2] = Integer.parseInt(inputs[3]);
            hopeStudents[student][3] = Integer.parseInt(inputs[4]);

            searchFirstCondition(student, hopeStudents[student]);
        }




        




    }

    private static void settingComparator() {
        comparatorBlank = new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.blankCount > o2.blankCount) return -1;
                return 1;
            }
        };

        comparatorMinPosition = new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.r < o2.r) return -1;
                else if(o1.r == o2.r) {
                    if(o1.c < o2.c) return -1;
                }
                return 1;
            }
        };
    }

    private static int[] dr = {1,-1,0,0};
    private static int[] dc = {0,0,1,-1};
    private static void searchFirstCondition(int student, int[] hopeStudents) {
        int len = N*N;
        boolean[][] visited = new boolean[N][N];
        Map<Integer, Boolean> hope = new HashMap<>();
        Arrays.stream(hopeStudents).map(Element -> {
            hope.put(Element, true);
            return Element;
        });

        int maxHope = 0;
        List<Position> PositionList = new ArrayList<>();
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(board[r][c] != 0) continue;
                int adjCount = 0;
                int blankCount = 0;

                for(int i=0; i<4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(!isPossible(nr,nc)) continue;
                    if(board[nr][nc] == 0) blankCount++;
                    else if(hope.containsKey(board[r][c])) adjCount++;
                }
                if(adjCount < maxHope) continue;
                if(adjCount > maxHope) {
                    maxHope = adjCount;
                    PositionList.clear();
                }
                PositionList.add(new Position(r,c,student, adjCount, blankCount));
            }
        } // end of search

        // 1번 조건에서 걸러진 경우
        if(PositionList.size() == 1) {
            board[PositionList.get(0).r][PositionList.get(0).c] = PositionList.get(0).number;
            return;
        }
    }




    public static boolean isPossible(int r, int c) {
        if(r<0 || r>=N || c<0 || c>=N) return false;
        return true;
    }
    public int getDistance(int r1, int c1, int r2, int c2) {

        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    static class Position {
        int r, c;
        int number, adjCount, blankCount;

        public Position(int r, int c, int number, int adjCount, int blankCount) {
            this.r = r;
            this.c = c;
            this.number = number;
            this.adjCount = adjCount;
            this.blankCount = blankCount;
        }
    }
}