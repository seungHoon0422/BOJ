package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_18111_Silver2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb  = new StringBuilder();

    // ------------------------------ //

    static int N, M, B;
    static int[][] map;
    static int answer, time, currTime;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B  = Integer.parseInt(st.nextToken());
        int maxHeight = 0, minHeight = 256;
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }

        answer = Integer.MAX_VALUE;
        time = Integer.MAX_VALUE;
        for(int i=minHeight; i<=maxHeight; i++) {
            if (isPossibleHeight(i) && currTime <= time) {
                answer = i;
                time = currTime;
            }
        }

        sb.append(time).append(" ").append(answer);
        System.out.println(sb);

    }

    private static boolean isPossibleHeight(int height) {

        int timeCount = 0;
        int groundCount = B;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {

                int diff = Math.abs(map[i][j] - height);
                if(map[i][j] > height) {
                    timeCount += 2 * diff;
                    groundCount += diff;
                } else if(map[i][j] < height) {
                    timeCount += diff;
                    groundCount-=diff;
                }
            }
        }

        currTime = timeCount;

        if(groundCount >= 0) return true;
        return false;
    }

}