package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_1043_Gold4 {

    static int N, M, answer;
    static boolean[] knows;
    static Set<Integer> finalKnows;
    static List<Integer>[] party;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        knows = new boolean[N+1];
        party = new List[M];
        answer = M;
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        for(int i=0; i<count; i++) {
            int person = Integer.parseInt(st.nextToken());
            knows[person] = true;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            count = Integer.parseInt(st.nextToken());
            party[i] = new ArrayList<>();

            for(int j=0; j<count; j++) {
                int person = Integer.parseInt(st.nextToken());
                party[i].add(person);
            }
        }

        bfs();


        System.out.println(answer);

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] partyVisited = new boolean[M];

        for(int i=0; i< knows.length; i++) {
            if(knows[i])
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int person = queue.poll();

            for(int i=0; i<M; i++) {
                if(partyVisited[i]) continue;
                if(!party[i].contains(person)) continue;

                // 진실을 아는 사람이 포함된 파티인 경우
                for(int j=0; j<party[i].size(); j++) {
                    int partyPerson = party[i].get(j);
                    if(knows[partyPerson]) continue;
                    knows[partyPerson] = true;
                    queue.offer(partyPerson);
                }
                partyVisited[i] = true;
                answer--;
            }
        }
    }
}