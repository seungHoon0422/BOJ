import java.util.*;
import java.io.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int[][] test = {
            {1,0,1,1,0},
            {0,0,1,0,1},
            {0,1,0,0,0}
    };
    static int total = 20;
    static int testSize, modelSize;
    static List<int[]> combList = new ArrayList<>();
//    static int rest;
    public static void main(String[] args) throws IOException{

        testSize = test[0].length;
        modelSize = test.length;

        int[] score = new int[testSize];
        Arrays.fill(score, 1);
//        int rest = total - testSize;
        comb(total-testSize, new int[testSize]);
        System.out.println(combList.size());

        for(int i=combList.size()-1; i>=0; i--) {
            int[] result =  combList.get(i);
            for(int j=0; j< testSize; j++){
                result[j]++;
            }
            System.out.println(Arrays.toString(result));
        }


    }

    public static void comb(int rest, int[] result) {
        if(rest <= 0) {
            int[] answer = new int[result.length];
            for(int i=0; i<testSize; i++) answer[i] = result[i];
            combList.add(answer);
            return;
        }
        for(int i=0; i<testSize; i++) {
            result[i]++;
            comb(rest-1, result);
            result[i]--;

        }
    }


}