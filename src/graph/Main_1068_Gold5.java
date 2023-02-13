package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_1068_Gold5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, answer, delete;

    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
                continue;
            }
            tree[parent].add(i);
        }

        delete = Integer.parseInt(br.readLine());
        deleteNode(root);

        findLeafNode(root);

        if(delete == root) System.out.println(0);
        else System.out.println(answer);
    }

    static void deleteNode(int node) {

        for (Integer child : tree[node]) {
            if(child == delete) {
                tree[node].remove(child);
                return;
            }
            deleteNode(child);
        }
    }
    private static void findLeafNode(int node) {

        if(tree[node].size() == 0) {
            answer++;
        }
        for (Integer child : tree[node]) {
            findLeafNode(child);
        }
    }


}

