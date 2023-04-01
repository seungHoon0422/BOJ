package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_2252_Gold3 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] edgeCount;
    static List[] graph;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeCount = new int[N+1];
        graph = new List[N + 1];
        for(int i=0; i<N+1; i++) {
            graph[i] = new ArrayList();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edgeCount[node2]++;
            graph[node1].add(node2);

        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<N+1; i++) {
            if(edgeCount[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {

            Integer node = queue.poll();
            sb.append(node).append(" ");

            List<Integer> nodes = graph[node];

            for (Integer next : nodes) {
                edgeCount[next]--;
                if(edgeCount[next] == 0)
                    queue.offer(next);

            }
        }


        System.out.println(sb);




    }
}