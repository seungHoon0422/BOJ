package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
    11866 Silver5 오세푸스 문제0
    시작시간 : 1:14
    종료시간 : 1:20
    소요시간 : 6분



 */


public class Main_11866_Silver5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) queue.offer(i);

        sb.append("<");

        for (int i = 0; i < n; i++) {
            int count = 0;
            if(queue.size() == 1) {
                sb.append(queue.peek()).append(">\n");
                break;
            }
            while(++count<k) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }

        System.out.println(sb);


    }
}