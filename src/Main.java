import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, answer;

    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        answer = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) continue;
            tree[parent].add(i);
        }

        int node = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            List<Integer> children = tree[i];
            for(int j=children.size()-1; j>=0; j--) {
                if(children.get(j) == node)
                    tree[i].remove(j);
            }
        }




        findLeafNode(0);

        if(node == 0) System.out.println(0);
        else System.out.println(answer);
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

