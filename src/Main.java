import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


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