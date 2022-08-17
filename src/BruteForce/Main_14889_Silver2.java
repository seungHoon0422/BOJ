package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
[문제요약]
N은 항상 짝수, N/2명으로 스타트 팀, 링크 팀 으로 나눠야한다.
1~N 명의 선수 시너지가 주어짐, 두팀의 능력치 차이의 최솟값 구하는 문제

[풀이]
브루트포스 문제
모든 선수의 조합을 찾아야 한다.
선수의 소속여부를 boolean으로 처리하고, 20C10의 경우의수를 체크
능력치의 합을 계산하는 방식 => 전체 시너치 총합, 현재 팀구성원의 능력치합의 차
 */
class Main_14889_Silver2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] stat;
    static boolean[] startTeam;
    private static int N;
    private static int totalStat;
    private static int minDiff;

    public static void main(String[] args) throws IOException {
        minDiff = Integer.MAX_VALUE;
        init();
        organizeTeam(0,0);
        System.out.println(minDiff);
    }

    private static void organizeTeam(int start, int count) {
        // 팀구성이 완료된 경우
        if(count == N/2) {

            int startT =0, linkT = 0;
            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    if(startTeam[i] && startTeam[j]) startT += stat[i][j] + stat[j][i];
                }
            }

            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    if(!startTeam[i] && !startTeam[j]) linkT += stat[i][j] + stat[j][i];
                }
            }
            minDiff = Math.min(minDiff, Math.abs(startT - linkT));
            return;
        }

        for(int i=start; i<N; i++) {
            startTeam[i] = true;
            organizeTeam(i+1, count+1);
            startTeam[i] = false;
        }

    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        stat = new int[N][N];
        startTeam = new boolean[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}