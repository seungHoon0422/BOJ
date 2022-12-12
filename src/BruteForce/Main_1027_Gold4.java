package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1027_Gold4 {


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String[] inputBuilding = br.readLine().split(" ");
        int[] building = new int[N];
        int[] visible = new int[N];

        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(inputBuilding[i]);
        }
        for(int i=0; i<N-1; i++) {

            // 바로 옆 아파트는 보이므로 1개 카운트
            visible[i] += 1;
            visible[i+1] += 1;

            double slope = building[i+1] - building[i];
            for(int j=i+2; j<N; j++) {
                double nextslope = (double) (building[j] - building[i]) / (j-i);
                if(nextslope <= slope) continue;
                slope = nextslope;
                visible[i]++;
                visible[j]++;
            }
        }
        Arrays.sort(visible);
        System.out.println(visible[N-1]);
        







    }
}