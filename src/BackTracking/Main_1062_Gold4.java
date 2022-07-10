package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * [백준 1062 가르침 gold4]
 * anta tica
 * a c i t n 5개는 필수로 학습해야하는 언어
 * K가 5보다 작을 경우에는 무조건 0
 * 가르쳐야할 단어들을 정리할 때 각 단어를 위해 학습해야하는 알파벳들을 미리 정리하여 알파벳 기준을 가능한 단어들을 카운트한다.
 * 알파벳들의 조합을 정할 때에는 count를 사용하여 K개까지 정해진 경우 확인
 *
 *
 */
class Main_1062_Gold4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int K;
    private static boolean[] alpha;
    private static HashMap<String, boolean[]> vocab;
    private static int answer;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        alpha = new boolean[26];
        alpha['a'-'a'] = true;
        alpha['c'-'a'] = true;
        alpha['i'-'a'] = true;
        alpha['t'-'a'] = true;
        alpha['n'-'a'] = true;

        vocab = new HashMap<String, boolean[]>();
        for (int i = 0; i < N; i++) {
            String voca = br.readLine();
            boolean[] need = new boolean[26];
            for(int index=0; index<voca.length(); index++) {
                need[voca.charAt(index) -'a'] = true;
            }
            vocab.put(voca, need);
        }

        K -= 5;
        if(K<0) {
            System.out.println(0);
            return;
        }
        answer = 0;
        combination(0,0);

        System.out.println(answer);


    }

    private static void combination(int start, int count) {

        // 기저조건
        if(count==K) {
            int possible = 0;
            for(String voca : vocab.keySet()) {
                boolean[] need = vocab.get(voca);
                boolean poss = true;
                for(int i=0; i<need.length; i++) {
                    if(need[i]) {
                        if(alpha[i] == false) {
                            poss = false;
                            break;
                        }
                    }
                }
                if(poss) possible++;
            }
            answer = Math.max(answer, possible);
            return;


        }

        for(int i=start; i<26; i++) {
            if(!alpha[i]) {
                alpha[i] = true;
                combination(i+1, count+1);
                alpha[i] = false;
            }
        }


    }
}