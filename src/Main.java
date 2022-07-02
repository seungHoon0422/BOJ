import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int K;
    private static Stone[] stones;
    private static Bag[] bags;

    public static void main(String[] args) throws IOException {
        initVariables();
        sorting(stones, bags);
        debugCode(stones, bags);

        for(int i=0; i<N; i++) {

        }
    }


    private static void initVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stones = new Stone[N];
        bags = new Bag[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stones[i] = new Stone(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = new Bag(Integer.parseInt(st.nextToken()), 0);
        }
    }

    private static void debugCode(Stone[] stones, Bag[] bags) {
        System.out.println("stones : " + Arrays.toString(stones));
        System.out.println("bags : " + Arrays.toString(bags));
    }

    private static void sorting(Stone[] stones, Bag[] bags) {
        Arrays.sort(stones);
        Arrays.sort(bags);
    }

    static class Stone implements Comparable<Stone>{
        int weight, price;
        Stone(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }


        @Override
        public int compareTo(Stone o) {
            return o.price - this.price;
        }

        @Override
        public String toString() {
            return "Stone{" +
                    "weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }
    static class Bag implements Comparable<Bag> {

        int max;
        int price;

        public Bag(int max, int price) {
            this.max = max;
            this.price = price;
        }

        @Override
        public int compareTo(Bag o) {
            return o.max - this.max;
        }

        @Override
        public String toString() {
            return "Bag{" +
                    "max=" + max +
                    ", price=" + price +
                    '}';
        }
    }
}