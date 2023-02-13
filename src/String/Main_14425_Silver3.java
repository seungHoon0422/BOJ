package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main_14425_Silver3 {

    static int N, M, answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> S;
    public static void main(String[] args) throws IOException {

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        answer = 0;

        S = new HashSet<>();
        for(int i=0; i<N; i++) {
            S.add(br.readLine());
        }

        for(int i=0; i<M; i++) {
            String input = br.readLine();
            if(S.contains(input)) {
                answer++;
            }
        }

        System.out.println(answer);

    }


}