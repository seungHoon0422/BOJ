package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    1707 이분그래프 Gold4
    https://www.acmicpc.net/problem/1707

    시작시간 : 4:02
    종료시간 : 4:29
    소요시간 : 27분




 */

public class Main_1707_Gold4 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int K, V, E;
    static int[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        K = Integer.parseInt(br.readLine());
        while(K-- > 0) {

            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visited = new int[V+1];
            graph = new ArrayList[V+1];
            for(int i=1; i<=V; i++)
                graph[i] = new ArrayList<>();

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                int nodeA = Integer.parseInt(st.nextToken());
                int nodeB = Integer.parseInt(st.nextToken());

                graph[nodeA].add(nodeB);
                graph[nodeB].add(nodeA);
            }

            if(isBinaryGraph()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb.toString());

    }

    private static boolean isBinaryGraph() {

        for(int i=1; i<=V; i++) {
            if(visited[i] > 0) continue;
            if(!dfs(i, 1)) return false;
        }

        return true;
    }

    private static boolean dfs(int node, int depth) {

        visited[node] = depth;

        for (Integer next : graph[node]) {

            // 방문하지 않은 vertex
            if(visited[next] == 0) {
                if(!dfs(next, depth+1)) return false;
            } else if(visited[next] % 2 == depth % 2) return false;
        }

        return true;

    }


}