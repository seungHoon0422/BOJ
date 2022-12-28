package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404_Gold4 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static final int INF = 987_654_321;
    private static int N;
    private static int[][] map;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                map[i][j] = INF;

        int nosun = Integer.parseInt(br.readLine());
        for(int i=0; i<nosun; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());
            if(map[start][end] == INF) map[start][end] = weight;
            else map[start][end] = Math.min(map[start][end], weight);
        }

        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(i==j || j==k || k==i) continue;
                    if(map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }

                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == INF) sb.append(0);
                else sb.append(map[i][j]);
                if(j != N-1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

}