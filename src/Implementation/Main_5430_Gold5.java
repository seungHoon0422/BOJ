package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


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
class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int test = Integer.parseInt(br.readLine());

        for (int t = 0; t < test; t++) {

            char[] action = br.readLine().toCharArray();
            ArrayDeque<Integer> dq = new ArrayDeque<>();

            int size = Integer.parseInt(br.readLine());

            for(int i=0; i<size; i++) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;
            boolean isError = false;
            for (int i = 0; i < action.length; i++) {
                char c = action[i];
                if(c == 'R') reverse = !reverse;
                else if(c == 'D') {
                    if(!delete(dq, reverse)) {
                        isError = true;
                        break;
                    };
                }
            }

            if(isError) sb.append("error").append("\n");
            else makePrintString(dq, !reverse);

        }
        System.out.println(sb.toString());

    }

    private static boolean delete(Deque<Integer> dq, boolean reverse) {
        if(dq.isEmpty()) return false;
        if(reverse) dq.pollLast();
        else dq.pollFirst();
        return true;
    }
    public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {

        sb.append('[');	// 여는 대괄호 먼저 StringBuilder에 저장
        if(deque.size() > 0) {	//만약 출력 할 원소가 한 개 이상일 경우
            if(isRight) {	// 정방향일경우
                sb.append(deque.pollFirst());	// 먼저 첫 번째 원소를 넘겨준다.
                // 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 하나씩 뽑아 넘긴다.
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else {	// 역방향일경우
                sb.append(deque.pollLast());	// 먼저 뒤에서부터 첫 번째 원소를 넘겨준다.
                // 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 뒤에서부터 하나씩 뽑아 넘긴다.
                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');	// 닫는 대괄호 및 개행으로 마무리
    }


}