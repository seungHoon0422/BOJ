package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @Problem [BOJ 1041 주사위 Gold5]
 * 정육면체 주사위가 주어졌다. 각면에 쓰여질 숫자가 있을 때 N^3개의 주사위가 주어지면, N*N*N의 정육면체 모양으로
 * 주사위를 쌓을 수 있다. 이때 바닥면을 제외한 5개의 면에 쓰여진 숫자의 합을 구했을 때 최솟값을 구하는 문제
 *
 * @Solution
 * [수학, 그리디]
 * 5개의 면에서 각각의 주사위가 보이는 면의 개수에 따라 카운트를 해보면
 * 1개 : (N-2)*(N-2)*5 + (N-2) * 4개 -> 각면 테투리를 제외한 주사위 + 바닥면에 붙어있는 모서리를 제외한 테투리 주사위
 * 2개 : (N-2) * 8 + 4 개 -> 제일 위에만 테투리4개 + 세로 테두리 4개 + 바닥 모서리 4개
 * 3개 : 4개
 *
 * 1개 면이 보이는 경우 : 주사위에 적힌 숫자 중 최댓값 사용
 * 2개 면이 보이는 경우 : 마주보는 면을 제외하고 두 수의 합의 최댓값
 * 3개 면이 보이는 경우 : 마주보는 두면중에서 최솟값의 합
 *
 *
 * @Question
 * 왜 N을 long type으로 선언해야 통과하는 걸까요?
 *
 */


class Main_1041_Gold5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static long N;
    private static int[] dice = new int[6];
    private static long[] count = new long[3];
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }


        if(N==1) {
            Arrays.sort(dice);
            int sum = 0;
            for(int i=0; i<5; i++) {
                sum += dice[i];
            }
            System.out.println(sum);
            return;
        }
        long result = 0L;

        count[0] = (N-2) * (N-2) * 5 + (N-2) * 4;
        count[1] = (N-2) * 8 + 4;
        count[2] = 4;


        int minPoint = Integer.MAX_VALUE;
        for(int i=0; i<6; i++) {
            minPoint = Math.min(minPoint, dice[i]);
        }
        result += count[0] * minPoint;

        int minDuo = Integer.MAX_VALUE;
        for(int i=0; i<6; i++) {
            for(int j=i+1; j<6; j++) {
                if(i+j == 5) continue;
                minDuo = Math.min(minDuo, dice[i] + dice[j]);
            }
        }
        result += count[1] * minDuo;

        int minTrio = 0;
        for(int i=0; i<3; i++) {
            minTrio += Math.min(dice[i], dice[5-i]);
        }
        result += count[2] * minTrio;

        sb.append(result).append('\n');
        System.out.println(sb);


    }



}