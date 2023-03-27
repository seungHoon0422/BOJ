import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
//    static List<Integer> queue;
    static Integer[] queue = new Integer[2000000];
    static int front, back;
    public static void main(String[] args) throws IOException {


        int tc = Integer.parseInt(br.readLine());
        int front = 0, back = 0;
        while(tc-- > 0) {
            String[] input = br.readLine().split(" ");


            if("push".equals(input[0])) {
                queue[back++] = Integer.parseInt(input[1]);

            } else if("pop".equals(input[0])) {
                if(front == back) errorCase();
                else {
                    sb.append(queue[front++]).append("\n");
                }
            } else if("size".equals(input[0])) {
                sb.append(back-front).append("\n");

            } else if("empty".equals(input[0])) {
                if(front == back) sb.append("1\n");
                else sb.append("0\n");

            } else if("front".equals(input[0])) {
                if(front == back) errorCase();
                sb.append(queue[front]).append("\n");

            } else if("back".equals(input[0])) {
                if(front == back) errorCase();
                sb.append(queue[back-1]).append("\n");

            }


        }
        System.out.println(sb.toString());




    }

    static void errorCase() {
        sb.append("-1\n");
    }


}