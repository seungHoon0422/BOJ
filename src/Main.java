import java.util.*;
import java.io.*;


/*
16235 Gold3 나무제태크
시작 : 4:31
종료 :
소요시간 :


가장 처음에 모든 양분은 5만큼 있다.
M 개의 나무를 구입해 나무를 심는다. -> 한칸에 여러개의 나무를 심을수 있다.
1년은 봄, 여름, 가을, 겨울로 구성
- 봄
나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가
자기칸의 양분만 먹을 수 있고, 여러개의 나무가 있다면 나이가 어린 나무부터 양분을 먹는다.
땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
- 여름
봄에 죽은 나무가 양분으로 변하게 된다.
각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
- 가을
나무가 번식
번식하는 나무는 나이가 5의 배수
인접한 8개의 칸에 나이가 1인 나무가 생긴다.
- 겨울
땅에 양분을 추가
각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.


 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] A, plus;
    static ArrayList<Integer>[][] trees, deadTrees;
    static int n, m, k;



    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[n+1][n+1];
        plus = new int[n+1][n+1];

        trees = new ArrayList[n+1][n+1];
        deadTrees = new ArrayList[n+1][n+1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++) {
                trees[i][j] = new ArrayList<>();
                deadTrees[i][j] = new ArrayList<>();
                A[i][j] = 5;
            }

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=n; j++) {
                plus[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees[r][c].add(age);
        }

        while(k-- > 0) {

//            - 봄
            spirngAction();
//            나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가
//            자기칸의 양분만 먹을 수 있고, 여러개의 나무가 있다면 나이가 어린 나무부터 양분을 먹는다.
//            땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.


//            - 여름
            summerAction();
//            봄에 죽은 나무가 양분으로 변하게 된다.
//            각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.


//            - 가을
            autumnAction();
//            나무가 번식
//            번식하는 나무는 나이가 5의 배수
//            인접한 8개의 칸에 나이가 1인 나무가 생긴다.


//            - 겨울
            winterAction();
//            땅에 양분을 추가
//            각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.



        } // end of while


        int answer = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                answer += trees[i][j].size();
            }
        }
        System.out.println(answer);






    }


//            나무가 자신의 나이만큼 양분을 먹고 나이가 1 증가
//            자기칸의 양분만 먹을 수 있고, 여러개의 나무가 있다면 나이가 어린 나무부터 양분을 먹는다.
//            땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
    private static void spirngAction() {

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {


                // 양분이 남아있지 않은 경우
                if(A[i][j] == 0) continue;
                ArrayList<Integer> localTrees = trees[i][j];
                ArrayList<Integer> liveTrees = new ArrayList<>();


                localTrees.sort((o1, o2) -> o1 - o2);
                int index = 0;
                for(; index < localTrees.size(); index++) {
                    if(A[i][j] >= localTrees.get(index)) {
                        A[i][j] -= localTrees.get(index);
                        liveTrees.add(localTrees.get(index) + 1);
                    } else break;
                }

                deadTrees[i][j].clear();
                if (index < localTrees.size()) {
                    for(; index < localTrees.size(); index++) {
                        deadTrees[i][j].add(localTrees.get(index));
                    }
                }

                trees[i][j] = liveTrees;


            } // end of for j
        } // end of for i





    }


//            봄에 죽은 나무가 양분으로 변하게 된다.
//            각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
    private static void summerAction() {
        // clear deadTree

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                for (Integer deadtree : deadTrees[i][j]) {
                    A[i][j] += deadtree / 2;
                }
                deadTrees[i][j].clear();
            }

    }

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0 ,-1, -1, -1};

//            나무가 번식
//            번식하는 나무는 나이가 5의 배수
//            인접한 8개의 칸에 나이가 1인 나무가 생긴다.
    private static void autumnAction() {

        int[][] babyTrees = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=0; k<trees[i][j].size(); k++) {
                    int age = trees[i][j].get(k);
                    if(age % 5 != 0) continue;

                    // 나이가 5의 배수인 나무 번식 시작
                    for(int d=0; d<dr.length; d++) {

                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(nr<=0 || nr>n+1 || nc<=0 || nc>n+1) continue;
                        babyTrees[nr][nc]++;

                    } // end of for dir
                } // end of for trees
            } // end of for j
        } // end of for i

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                while (babyTrees[i][j]-- > 0) {
                    trees[i][j].add(1);
                }
            }
        }
    }

//            땅에 양분을 추가
//            각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
    private static void winterAction() {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                A[i][j] += plus[i][j];
            }
        }
    }



}
