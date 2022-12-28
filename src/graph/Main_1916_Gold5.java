package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_Gold5 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int[] distance;
    private static boolean[] visited;
    private static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        distance = new int[N+1];
        visited = new boolean[N+1];


        // INF 초기화 작업, graph, distance
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        sb.append(dijkstra(start, end)).append("\n");
        System.out.println(sb);

    }

    private static final int INF = 999_999_999;
    private static int dijkstra(int start, int end) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
//            if(visited[node.vertex]) continue;
//            visited[node.vertex] = true;
            if(!visited[node.vertex]) {
                visited[node.vertex] = true;

                for (Node adj : graph[node.vertex]) {
                    if(!visited[adj.vertex] && distance[adj.vertex] > distance[node.vertex] + adj.cost ) {
                        distance[adj.vertex] = distance[node.vertex] + adj.cost;
                        pq.offer(new Node(adj.vertex, distance[adj.vertex]));
                    }

                }

            }
        }
        return distance[end];
    }

    static class Node implements Comparable<Node> {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}