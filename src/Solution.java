import java.util.*;


class Solution {
    int t, x, y, h;
    int[][] attacks;
    public int solution(int[] bandage, int health, int[][] a) {

        t = bandage[0];
        x = bandage[1];
        y = bandage[2];
        h = health;
        attacks = a;

        int endAttackTime = attacks[attacks.length-1][0];
        int time = 1;
        int attackCounter = 0;
        int bandT = 0, bandX = x, bandY = y, bandCounter=0;
        for(;time <= endAttackTime && attackCounter < attacks.length; time++) {

            // 공격을 받는 경우
            if(attacks[attackCounter][0] == time) {
                h -= attacks[attackCounter++][1];
                if(h <= 0) break;
                bandT = 0;
            } else {
                // 공격을 받지 않는 경우
                if(h >= health) bandT = 0;
                bandT++;
                h += x;
                if(bandT == t) {
                    h += y;
                    bandT = 0;
                }
                if(h > health) h = health;
            }
//            System.out.println("Time : " + time + ", health : " + h + ", bandT : " + bandT);




        }




        if(h <=0 ) return -1;
        else return h;

    }
}