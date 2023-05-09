package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*

1193 Silver5 분수찾기
시작 : 1:43
종료 : 2:00
소요시간 : 17분

이차원 배열의 대각선으로 분수가 커진다.
지그재그 순서로 분수에 번호를 매길 때 X번째에 있는 분수가 무엇인지 찾는 문제
분수르 1,2,3,4 ... 개만큼 대각선 방향으로 묶는다.
X 번째가 몇번쨰 대각선인지 찾고
계산

 */
public class Main_1193_Silver5_분수찾기 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int x = Integer.parseInt(br.readLine());
        int sum = 0;
        int index = 1;
        while(true) {
            if(sum + index >= x) break;
            else sum += index++;

        }


        int up, down;
        int diff = x - sum- 1 ;
        if(index%2 == 0) {
            up = 1 + diff;
            down = index - diff;
        } else {
            down = 1 + diff;
            up = index - diff;
        }
        System.out.println(sb.append(up).append("/").append(down));

    }




}