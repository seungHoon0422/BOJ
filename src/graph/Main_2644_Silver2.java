package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2644_Silver2 {

    // --------------- common ----------------//
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //----------------- private --------------//

    private static int N;
    private static int start, destination;
    private static Map<Integer, List<Integer>> map;


    public static void main(String[] args) throws IOException {

        init();
        int chonsu = findChon();
        System.out.println(chonsu);


    }

    private static int findChon() {

        int distance = 0;
        boolean[] visited = new boolean[N+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();

            for(int neighbor : map.get(front[0])) {
                if(visited[neighbor]) continue;

                if(neighbor == destination)
                    return front[1] + 1;
                else {
                    queue.offer(new int[]{neighbor, front[1] + 1});
                    visited[neighbor] = true;
                }
            }
        }

        return -1;
    }

    private static void init() throws IOException {

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for(int i=1; i<=N; i++) {
            map.put(i, new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());
        while(M-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            map.get(child).add(parent);
            map.get(parent).add(child);

        }



    }
}