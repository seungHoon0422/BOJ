package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @Problem
 * [백준 17951 흩날리는 시험지 속에서 내 평정이 느껴진거야 Gold 4]
 * 이분 탐색
 * 전체 score를 K개의 그룹으로 나눴을 때 합의 최소의 최대를 구하는 문제
 *
 * @Solution
 * 전체 점수가 주어졌을 때 이분탐색으로 최대합을 찾아나간다.
 * left = 0 으로 두고, right를 설정할 때 전체합의 평균으로 설정해서 시간을 단축
 * mid값으로 탐색해나가는데 기준은 K개의 그룹으로 설정이 가능한지 판단한다.
 * K개의 그룹보다 적게 만들어지면 기준이 높다는 얘기니까 right를 mid-1 로 낮추고,
 * 아니면 left를 mid+1로 증가시킨다.
 *
 */
class Main_17951_Gold4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int N, K;
    private static int[] score;


    public static void main(String[] args) throws Exception{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        score = new int[N];
        int all  = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            all += score[i];
        }
        int left = 0;
        int right = all/K;
        if(K==1) {
            System.out.println(all);
            return;
        }
        while(left <= right) {
            int mid = (left+right) >> 1;
            int groupCount = 1;
            int sum = 0;
            int minsum = Integer.MAX_VALUE;
            for(int i=0; i<N; i++) {
                sum += score[i];
                if(sum >= mid) {
                    minsum = Math.min(minsum, sum + score[i]);
                    groupCount++;
                    sum = 0;
                }
            }
            if(groupCount > K) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(right);

    }


}