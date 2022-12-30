import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static char[][] map;
    private static int[][][] visited;
    private static int R, C, K;
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[R][C][K+1];
        map = new char[R][C];
        for(int i=0; i<R; i++)
            for (int j = 0; j < C; j++)
                for (int k = 0; k <= K; k++)
                    visited[i][j][k] = INF;


        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(0,0));

    }

    private static final int[] dr = {1, -1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};

    private static int bfs(int r, int c) {

        int answer = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c, 0, 0));
        visited[r][c][0] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // 최종 도착지에 도달 시 다음 요소 진행
            if(node.r == R-1 && node.c == C-1) {
                return node.distance + 1;
/*
                if(answer == -1) answer = node.distance;
                else answer = Math.min(answer, node.distance);
                continue;
*/
            }

            for(int i=0; i<4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if(nr<0 || nr>=R || nc<0 || nc>=C) continue;

                // 벽이 아닌 경우
                if(map[nr][nc] == '0') {
                    if(visited[nr][nc][node.k] > visited[node.r][node.c][node.k] + 1) {
                        visited[nr][nc][node.k] = visited[node.r][node.c][node.k] + 1;
                        queue.offer(new Node(nr,nc,node.k,visited[nr][nc][node.k]));
                    }
                } else if(map[nr][nc] == '1') {
                    if(node.k < K) {
                        if(visited[nr][nc][node.k + 1] > visited[node.r][node.c][node.k] + 1) {
                            visited[nr][nc][node.k + 1] = visited[node.r][node.c][node.k] + 1;
                            queue.offer(new Node(nr,nc,node.k+1,visited[nr][nc][node.k + 1]));
                        }

                    }
                }

            }
        }
        if(answer != -1) answer++;
        return answer;
    }


    static class Node {
        int r, c, k;
        int distance;

        public Node(int r, int c, int k, int distance) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.distance = distance;
        }
    }

}