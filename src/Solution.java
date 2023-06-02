import java.util.*;


/*


    시작시간 : 12:42
    종료시간 :
    소요시간 :
    다이얼의 길이 <= 100,000
    password를 맞추기 위해


    1 5 9 3 7
    2 6 0 4 8
    2 5 9 3 7

    2 5 9 3 7


 */

class Solution {

    static int answer;
    public int solution(int[] dials, int[] password) {
        answer = Integer.MAX_VALUE;




        move(0, 0, 0, dials, password);
        return answer;
    }



    // (다이얼 위치, 돌린 횟수, 돌린 방향 누적값, 다이얼, 패스워드)
    static void move(int index, int count, int acc, int[] dials, int[] password) {

        // 기저조건
        if(index == dials.length) {
            answer = Math.min(answer, count);
            return;
        }

        int value = ((dials[index] + acc) + 10) % 10;
        // 돌리지 않아도 되는 경우
        if(value == password[index]) move(index+1, count, acc, dials, password);
        else {
            // 돌려야하는 경우

            // 아래로 돌리기
            int moveCountA = 0;
            while(value != password[index]) {
                value = (10 + value - 1) % 10;
                moveCountA++;
            }

            value = ((dials[index] + acc) + 10) % 10;
            // 위로 돌리기
            int moveCountB = 0;
            while(value != password[index]) {
                value = (value + 1) % 10;
                moveCountB++;
            }

            if(moveCountA < moveCountB) move(index+1, count + moveCountA, acc - moveCountA, dials, password);
            else move(index+1, count + moveCountB, acc + moveCountB, dials, password);


        }


    }


}

/*

 0 1 2 3 4 5 6 7 8 9
   o             o



 */