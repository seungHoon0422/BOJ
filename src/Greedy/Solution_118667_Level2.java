package Greedy;

import java.util.LinkedList;
import java.util.Queue;

/*

제한사항
1 ≤ queue1의 길이 = queue2의 길이 ≤ 300,000
1 ≤ queue1의 원소, queue2의 원소 ≤ 109
 */

class Solution_118667_Level2 {
    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();
        long leftSum = 0;
        long rightSum = 0;
        for(int i=0; i<queue1.length; i++) {
            leftQueue.offer(queue1[i]);
            leftSum += queue1[i];
        }
        for(int i=0; i<queue2.length; i++) {
            rightQueue.offer(queue2[i]);
            rightSum += queue2[i];
        }


        int timeLimit = queue1.length * 3;
        int time = 0;



        while(time < timeLimit) {


            if (leftSum == rightSum) {
                break;
            }

            if(leftSum > rightSum && !leftQueue.isEmpty()) {
                int value = leftQueue.peek();
                leftSum -= value;
                rightSum += value;
                rightQueue.offer(leftQueue.poll());
            }
            else if(leftSum < rightSum && !rightQueue.isEmpty()){
                int value = rightQueue.peek();
                leftSum += value;
                rightSum -= value;
                leftQueue.offer(rightQueue.poll());
            }

            time++;


        }



        if(time == timeLimit) return -1;
        else return time;

    }
}