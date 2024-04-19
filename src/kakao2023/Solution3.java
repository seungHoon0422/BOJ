package kakao2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution3 {


    List<Integer> diceA = new ArrayList<>();
    List<Integer> diceB = new ArrayList<>();
    int diceCount;
    int[][] dice;
    double winRate = 0.0;
    int[] answer;
    public int[] solution(int[][] d) {
        dice = d;
        answer = new int[dice.length / 2];
        diceCount = dice.length;
//        System.out.println("diceCount = " + diceCount);

        findDice(0, new int[diceCount], new int[diceCount], 0, 0);

        Arrays.sort(answer);
        return answer;
    }

    private void findDice(int index, int[] diceA, int[] diceB, int acount, int bcount) {

        if(acount > 5 || bcount > 5) return;
        if(index == diceCount) {
            if(acount != bcount) return;
//            System.out.println("diceB = " + Arrays.toString(diceB));

            List<Integer> alist = new ArrayList<>();
            List<Integer> blist = new ArrayList<>();

            findSum(0, 0, diceA, alist);
            findSum(0,0,diceB, blist);

            int win=0, lose=0, same=0;
            for(int i=0; i<alist.size(); i++) {
                for(int j=0; j<blist.size(); j++) {
                    int a = alist.get(i);
                    int b = blist.get(j);
                    if(a>b) win++;
                    else if(a<b) lose++;
                    else same++;
                }
            }

            double rate = win * 100.0 / (win + lose + same);
            if(winRate < rate) {
                winRate = rate;
                for(int i=0; i<acount; i++)  {
                    answer[i] = diceA[i]+1;
                }
            }
//            System.out.println(win + " " + lose + " " + same);
//            System.out.println("rate = " + rate);



            return;
        }

        diceA[acount] = index;
        findDice(index+1, diceA, diceB, acount+1, bcount);
        diceA[acount] = 0;
        diceB[bcount] = index;
        findDice(index+1, diceA, diceB, acount, bcount+1);
        diceB[bcount] = 0;

    }

    private void findSum(int diceIndex, int temp, int[] diceList, List<Integer> sumList) {
        if(diceIndex == diceCount/2) {
            sumList.add(temp);
            return;
        }
        for(int i=0; i<6; i++) {
            findSum(diceIndex+1, temp +dice[diceList[diceIndex]][i], diceList, sumList);
        }
    }


}