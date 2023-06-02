package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    1027 Gold4 고층 빌딩

    시작시간 : 7:43
    종료시간 : 8:15
    소요시간 : 32분


 */

public class Main_1027_Gold4_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //////////////////////////////////////////////////////////////////////

    static int n, answer;
    static int[] buildings;
    static int[] answers;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        buildings = new int[n];
        answers = new int[n];

        answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i < n-1; i++) {

            double degree = Double.MIN_VALUE;
            for(int j=i+1; j<n; j++) {
                double currentDegree = (double) (buildings[j] - buildings[i]) / (j - i);
                if(j ==i+1) {
                    degree = currentDegree;
                    answers[i]++;
                    answers[j]++;
                    continue;
                }
                if(degree >= currentDegree) continue;
                answers[i]++;
                answers[j]++;
                degree = currentDegree;
            }
        }

        for (int i = 0; i < n; i++) answer = Math.max(answer, answers[i]);
        System.out.println(answer);

    }


}










