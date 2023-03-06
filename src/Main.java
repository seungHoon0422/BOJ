import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, R, Q;
    static int subtreeCount;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] tree;
    static int[] subtree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        subtree = new int[N+1];
        parent = new int[N+1];
        graph = new ArrayList[N+1];
        tree = new ArrayList[N+1];

        for(int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
        parent[R] = -1;
        setDirection(R, -1);
        countSubtreeNodes(R);

        for(int i=0; i<Q; i++) {
            int subtreeRoot = Integer.parseInt(br.readLine());
            sb.append(subtree[subtreeRoot]).append('\n');
        }


        System.out.println(sb);


    }

    public static void setDirection(int curNode, int p) {

        for(int node : graph[curNode]) {
            if(node != p) {
                tree[curNode].add(node);
                parent[node] = curNode;
                setDirection(node, curNode);
            }
        }
    }
    public static void countSubtreeNodes(int curNode) {
        subtree[curNode] = 1;

        for(int node : tree[curNode]) {
            countSubtreeNodes(node);
            subtree[curNode] += subtree[node];
        }
    }



}