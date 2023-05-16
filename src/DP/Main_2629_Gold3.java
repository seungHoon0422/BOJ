package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    2629 Gold3 양팔저울

    시작시간 : 7:27
    종료시간 : 7:41
    소요시간 : 14분


 */

public class Main_2629_Gold3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;

    static int[] chus;
    static Map<Integer, Boolean> possibles;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        chus = new int[n];
        possibles = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            chus[i] = Integer.parseInt(st.nextToken());
        }



        for(int i=0; i<n; i++) {
            int chu = chus[i];


            Set<Integer> keyset = new HashSet<>();
            keyset.addAll(possibles.keySet());
            for (Integer key : keyset) {
                possibles.put(Math.abs(key - chu), true);
                possibles.put(key + chu, true);
            }
            possibles.put(chu, true);
        }



        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k ;i++) {
            if (possibles.containsKey(Integer.parseInt(st.nextToken()))) {
                sb.append("Y ");
            } else
                sb.append("N ");
        }


        System.out.println(sb);










    }

}








