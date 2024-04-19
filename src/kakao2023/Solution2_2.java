package kakao2023;

import java.util.*;



class Solution2_2 {

    List<Integer>[] graph;
    boolean[] startPoint, visited;
    int node, edge, size;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        size = 0;
        for(int[] edge : edges)
            size = Math.max(size, Math.max(edge[0], edge[1]));

        graph = new List[size+1];
        for(int i=0; i<size+1; i++) {
            graph[i] = new ArrayList<>();
        }

        startPoint = new boolean[size+1];
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            startPoint[edge[1]] = true;
        }

        int start = 0;
        for(int i=1; i<startPoint.length; i++) {
            if(!startPoint[i]) {
                start = i;
                break;
            }
        }
        answer[0] = start;

        for(int next : graph[start]) {
            node = 1;
            edge = 0;
            visited = new boolean[size+1];
//            System.out.println("stratNode = " + next);
            visited[next] = true;
            DFS(next);
//            System.out.println();
//            System.out.print("node = " + node);
//            System.out.println(", edge = " + edge);
//            System.out.println();
//            System.out.println("------------------");


            if(node == edge) answer[1]++;
            else if(node +1 == edge) answer[3]++;
            else answer[2]++;


        }



        return answer;
    }

    private void DFS(int n) {

//        System.out.print(n + "->");
        for(int i : graph[n]) {
            edge++;
            if(!visited[i]) {
                node++;
                visited[i] = true;
                DFS(i);
                visited[i] = false;
            }

        }

    }
}