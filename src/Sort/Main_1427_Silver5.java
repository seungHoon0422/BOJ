package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1427_Silver5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        char[] chars = br.readLine().toCharArray();
        int[] numberCount = new int[10];
        for(char c : chars) {
            numberCount[c- '0']++;
        }

        for(int i=9; i>=0; i--) {
            while(numberCount[i]-- > 0) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}