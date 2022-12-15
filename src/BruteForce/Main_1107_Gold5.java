package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * right var의 최대값 설정에서 시간이 오래 걸렸다.
 * 문제에서 주어진 조건은 500,000이었지만
 * 만약 버튼이 9를 제외하고 모두 고장난 겨웅에는 999,999를 선택해야하는 경우가 발생하기 때문에
 * 최대값을 999,999까지 잡아줘야 성공한다.
 *
 */
public class Main_1107_Gold5 {


    private static final int BUTTON_COUNT = 10;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int destination, currentPosition;
    private static boolean[] errorButtons;


    public static void main(String[] args) throws IOException {

        destination = Integer.parseInt(br.readLine());
        int error = Integer.parseInt(br.readLine());
        errorButtons = new boolean[BUTTON_COUNT];

        if(error != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                int errorButton = Integer.parseInt(st.nextToken());
                errorButtons[errorButton] = true;
            }

        }


        currentPosition = 100;
        int answer = Math.abs(destination - currentPosition);

        // 최종 번호를 누를 수 있는 경우
        if(isPossibleNumber(destination)){
            // 현재 체널에서 움직일 수 있는 경우와 비교
            answer = Math.min(answer, (destination + "").length());
        }

        int leftVar = destination-1;
        int rightVar = destination+1;

        while(0 <= leftVar || rightVar <= 999_999) {

            // left check
            if(leftVar >=0 && isPossibleNumber(leftVar)) {
                answer = Math.min(answer, Math.abs(destination - leftVar) + (leftVar+"").length());
            }

            // right check
            if(rightVar <= 999_999 && isPossibleNumber(rightVar)) {
                answer = Math.min(answer, Math.abs(destination - rightVar) + (rightVar+"").length());
            }

            // answer is minimum value of left, right, current
            leftVar--;
            rightVar++;
        }

        System.out.println(answer);




    }

    private static boolean isPossibleNumber(int channel) {

        String stringChannel = channel + "";
        char[] chars = stringChannel.toCharArray();
        for (char aChar : chars) {
            int number = aChar - '0';
            if (errorButtons[number]) return false;
        }


        return true;
    }
}