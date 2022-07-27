    import java.util.*;
    import java.io.*;


/**
*   @Problem 진행한 판수와, 이긴 판수가 주어졌을 때 승률에 변화가 생기려면 몇판을 연속으로 이겨야 하는지 구하는 문제
 *
 *   @Solution
 *   [이분탐색, 수학]
 *   X의 범위가 10억이므로, 순차적으로 한판씩 이기는 경우를 고려하여 계산하면 시간초과 예상
 *   -> 이분탐색 적용 포인트
 *   승률을 구하는 수식에서 double로 형번환 하여 마지막에 100을 곱해주는 과정은
 *   부동소수점의 특징에 의해서 정확한 값이 계산되기 힘들다.
 *   따라서 소수점을 고려하지 않아도 되게 100을 곱한 뒤에 나눠주는게 포인트
 *
*
 *     (오답)
 *     private static int getPercent(int x, int y) {
 *          return Math.floor(((double) y / x) * 100);
 *     }
 *     (정답)
 *     private static int getPercent(int x, int y) {
 *          return (int)((long)y * 100 / x);
 *     }
*
*/

    class Main {

        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st;
        private static StringBuilder sb = new StringBuilder();
        public static void main(String[] args) throws IOException {

            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int percent = getPercent(X,Y);
            int answer = -1;
            int left = 0;
            int right = 1_000_000_000;

            while(left <= right) {
                int middle = (left + right) >> 1;
                int perc = getPercent(X+middle, Y+middle);
                if(perc != percent) {
                    answer = middle;
                    right = middle -1;
                } else {
                    left = middle + 1;
                }
            }
            System.out.println(answer);
        }

        private static int getPercent(int x, int y) {
            return (int)((long)y * 100 / x);
        }
    }