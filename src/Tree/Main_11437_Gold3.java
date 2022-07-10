package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Problem
 * 백준 11437 LCA Gold3
 * [Tree]
 * 1~N번 노드까지의 트리가 주어진다.
 * M개의 정점 쌍이 주어졌을 때 두 노드의 가장 가까운 공통 조상을 찾는 문제
 *
 * @Solution
 * 트리가 부모, 자식의 구분없이 주어지기 때문에 양방향 트리로 구성하고
 * 정점 쌍이 주어졌을 때 root노드부터 dfs방식을 통해 해당 정점까지의 경로를 구한다. (stack 사용)
 */
class Main_11437_Gold3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[][] tree;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] parent;

    public static void main(String[] args) throws Exception {

        makeTree();
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            findCommonParent(node1, node2);
        }
        System.out.println(sb.toString());
    }

    private static void findCommonParent(int node1, int node2) {

        Stack<Integer> path1 = findPath(node1);
        Stack<Integer> path2 = findPath(node2);

        int common = 1;
        while(!path1.isEmpty() && !path2.isEmpty()) {
            int peek1 = path1.pop();
            int peek2 = path2.pop();
            if(peek1 == peek2) common = peek1;
            else break;
        }
        sb.append(common).append("\n");
    }

    private static Stack<Integer> findPath(int node) {
        Stack<Integer> stack = new Stack<>();
        int curr = node;
        stack.push(node);
        while(true) {
            stack.push(parent[curr]);
            if(parent[curr] == 1) break;
            curr = parent[curr];
        }

        return stack;
    }


    private static void makeTree() throws IOException {
        N = Integer.parseInt(br.readLine());
        tree = new boolean[N+1][N+1];
        ArrayList<Integer>[] trees = new ArrayList[N+1];
        for(int i=1; i<=N; i++) trees[i] = new ArrayList<Integer>();
        parent = new int[N+1];
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            trees[node1].add(node2);
            trees[node2].add(node1);
        }
        parent[1] = 0;
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        Queue q = new LinkedList<Integer>();
        q.offer(1);
        while(!q.isEmpty()) {
            int front = (int) q.poll();
            for(int i=0; i<trees[front].size(); i++) {
                int node = trees[front].get(i);
                if(!visited[node]) {
                    visited[node] = true;
                    parent[node] = front;
                    q.offer(node);
                }
            }
        }
    }


}