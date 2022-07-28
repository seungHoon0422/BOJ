package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


/**
 * @Problem [BOJ 5430 AC Gold5]
 * AC라는 언어는 R, D 2가지 동작이 가능하다. R은 배열을 뒤집는 함수이고, D는 배열의 가장 앞에있는 문자를 지우는 함수이다.
 * D를 수행하는데 배열에 값이 없는 경우 error를 리턴
 * testcase별로 동작이 주어졌을 때 결과를 리턴
 *
 * @Solution
 * [구현, 덱]
 * 배열의 앞, 뒤에 해당하는 숫자를 지워야 하는 작업이므로  deque를 사용한다.
 */
class Main_5430_Gold5 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            String action = br.readLine();
            Deque<Integer> dq = new ArrayDeque<>();
            int size = Integer.parseInt(br.readLine());
            arr = new int[size];
            if(size != 0) {
                String arrList = br.readLine();
                arrList = arrList.substring(1, arrList.length() - 1);
                st = new StringTokenizer(arrList, ",");
                int index = 0;
                do {
                    arr[index] = Integer.parseInt(st.nextToken());
                    dq.addLast(arr[index++]);
                } while (st.hasMoreTokens());
            }

            boolean reverse = false;
            boolean isError = false;
            for (int i = 0; i < action.length(); i++) {
                char c = action.charAt(i);
                if(c == 'R') reverse = !reverse;
                else if(c == 'D') {
                    if(!delete(dq, reverse)) {
                        isError = true;
                        break;
                    };
                }

            }

            if(isError) sb.append("error").append("\n");
            else {
                int[] result = new int[dq.size()];
                int index =0;
                if(!reverse) {
                    while(!dq.isEmpty()) result[index++] = dq.pollFirst();
                } else {
                    while(!dq.isEmpty()) result[index++] = dq.pollLast();
                }
                sb.append(Arrays.toString(result)).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static boolean delete(Deque<Integer> dq, boolean reverse) {
        if(dq.isEmpty()) return false;
        if(reverse) dq.pollLast();
        else dq.pollFirst();
        return true;
    }


}