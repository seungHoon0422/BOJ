import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, range, e;
    static final int INF = Integer.MAX_VALUE;

    static int[][] map;
    static int[] item;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        item = new int[n+1];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<n+1; j++) {
                map[i][j] = INF;
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[node1][node2] = weight;
            map[node2][node1] = weight;
        }

        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(map[i][k] == INF || map[k][j] == INF) continue;
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

//        for(int i=1; i<=n; i++) {
//            for(int j=1; j<=n; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        int answer = 0;
        for(int pos=1; pos<=n; pos++) {
            int temp = item[pos];
            for(int i=1; i<=n; i++) {
                if(i == pos) continue;
                if(map[pos][i] <= range) temp += item[i];
            }
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);

    }


}
