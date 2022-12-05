package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 기차의 길이는 4로 고정
 * 각 정거장에서 내리는 사람, 타는 사람이 고정되어있고 예외가 발생하는 경우가 주어지지 않는다.
 * train 변수를 사용해서 현재 기차에 타고있는 사람 수를 count하고
 * 정거장을 지날 떄 마다 내리는 사람, 타는 사람 수를 연산하여 answer 변수에 최대값을 저장
 *
 */
public class Main_2455_Bronze3 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int train = 0;
    private static final int TRAIN_LENGTH = 4;

    public static void main(String[] args) throws IOException {


        int answer = 0;
        for(int i=0; i<TRAIN_LENGTH; i++) {
            String[] inputLine = br.readLine().split(" ");
            int leave = Integer.parseInt(inputLine[0]);
            int in = Integer.parseInt(inputLine[1]);
            train -= leave;
            train += in;
            answer = Math.max(answer, train);

        }

        System.out.println(answer);


    }


}