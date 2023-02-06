package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main_1039_Gold3 {

    static String number;
    static int K, answer;
    static boolean[][] visited = new boolean[1_000_001][11];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        String[] input = br.readLine().split(" ");

        answer = -1;
        number = input[0];
        K = Integer.parseInt(input[1]);

        calc(0, number);
        System.out.println(answer);

    }

    private static void calc(int count, String number) {

        // 기저조건
        if(count == K) {
            answer = Math.max(answer, Integer.parseInt(number));
            return;
        }

        for(int i=0; i<number.length(); i++) {
            for(int j=i+1; j<number.length(); j++) {
                if(i == j) continue;
                if(i==0 && number.charAt(j) == '0') continue;

                char[] numArr = number.toCharArray();

                char tmp;
                tmp = numArr[i];
                numArr[i] = numArr[j];
                numArr[j] = tmp;
                String result = new String(numArr);
                int parseNumber = Integer.parseInt(result);

                if(visited[parseNumber][count]) continue;

                visited[parseNumber][count] = true;
                calc(count + 1, result);

            }
        }


    }


}