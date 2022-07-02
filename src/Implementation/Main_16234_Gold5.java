package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * [백준 16234 인구이동]
 * [구현, BFS]
 *
 */
public class Main_16234_Gold5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;
    private static int N;
    private static int L;
    private static int R;
    private static int[][] countries;
    private static boolean[][] visited;
    private static final int[] dr = {1,-1,0,0};
    private static final int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws IOException {

        init();
        int time = 0;
        while (searchCountires())
            time++;

        System.out.println(time);
    }

    private static boolean searchCountires() {

        boolean unioned = false;
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]) {
                    ArrayList<int[]> linked = new ArrayList<int[]>();
                    linked.add(new int[]{i,j});
                    BFS(i,j, linked);
                    // 연합이 가능한 경우
                    if( linked.size() >=2 ) {
                        unionCountries(linked);
                        unioned = true;

                    }

                }
            }
        }
        return unioned;
    }

    private static void unionCountries(ArrayList<int[]> linked) {
        int sum = 0;
        for(int[] pos : linked)
            sum += countries[pos[0]][pos[1]];

        sum /= linked.size();

        for(int[] pos : linked) {
            countries[pos[0]][pos[1]] = sum;
        }

    }

    private static void BFS(int r, int c, ArrayList<int[]> linked) {
        visited[r][c] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(linked.get(0));

        while(!q.isEmpty()) {
            int[] front = q.poll();

            for(int i=0; i<4; i++){
                int nr = front[0] + dr[i];
                int nc = front[1] + dc[i];

                if(nr<0 || nr>=N || nc<0 || nc>=N) continue; // 배열의 범위를 벗어난 좌표
                if(visited[nr][nc]) continue; // 이미 방문한 나라인 경우
                int diff = Math.abs(countries[nr][nc] - countries[front[0]][front[1]]);
                if(diff < L || diff > R) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr,nc});
                linked.add(new int[]{nr,nc});
            }
        }
    }

    private static void init() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        countries = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                countries[i][j] = Integer.parseInt(st.nextToken());
        }
    }
}
