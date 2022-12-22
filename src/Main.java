import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int[] P, S, cards;
    private static Map<Integer, Set<Integer>> cardMap;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        cardMap = new HashMap<>();
        cardMap.put(0, new HashSet<>());
        cardMap.put(1, new HashSet<>());
        cardMap.put(2, new HashSet<>());

        cards = new int[N];
        P = new int[N];
        S = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            cards[i] = i%3;
            P[i] = Integer.parseInt(st.nextToken());
//            cardMap.get(i%3).add(P[i]);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            if(checkCards()) {
                System.out.println(i);
                return;
            }
            swap();
        }


        if(checkCards()) {
            System.out.println(N);
        } else {
            System.out.println(-1);

        }


    }

    private static boolean checkCards() {

        for(int i=0; i<N; i++) {
            if(!cardMap.get(i%3).contains(cards[i]))
                return false;
        }
        return true;
    }

    private static void swap() {
        int[] newCards = new int[N];
        for(int i=0; i<N; i++) {
            newCards[S[i]] = cards[i];
        }
        cards = newCards;

    }

}