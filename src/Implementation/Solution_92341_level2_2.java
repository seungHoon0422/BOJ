package Implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 입차되어있는 차량 리스트를 map으로 확인
 * 차량의 누적 주차시간을 체크
 *
 *
 */
class Solution_92341_level2_2 {

    private static Map<Integer, Integer> inTime;
    private static Map<Integer, Integer> accumulateTime;
    private static int[] answer;

    private static int defaultTime, defaultFee, unitTime, unitFee;
    public int[] solution(int[] fees, String[] records) {

        defaultTime = fees[0];
        defaultFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        inTime = new HashMap<>();
        accumulateTime = new HashMap<>();

        for (String record : records) {
            String[] recordSplit = record.split(" ");
            String time = recordSplit[0];
            int number = Integer.parseInt(recordSplit[1]);
            String type = recordSplit[2];

            if("IN".equals(type)) {
                inTime.put(number, hourToMinute(time));
                if(!accumulateTime.containsKey(number))
                    accumulateTime.put(number, 0);
            }
            if("OUT".equals(type)) {
                accumulateTime.put(number,
                        accumulateTime.get(number)
                        + (hourToMinute(time) - inTime.get(number)));
                inTime.remove(number);
            }
        }

        for (Integer rest : inTime.keySet()) {
            accumulateTime.put(rest,
                    accumulateTime.get(rest)
                    + hourToMinute("23:59") - inTime.get(rest));
//            inTime.remove(rest);
        }

        int[] carList = new int[accumulateTime.size()];
        int[] answer = new int[accumulateTime.size()];
        int index = 0;

        for (Integer number : accumulateTime.keySet()) {
            carList[index++] = number;
        }
        Arrays.sort(carList);

        for (int i = 0; i < carList.length; i++) {
            int time = accumulateTime.get(carList[i]);
            answer[i] = calcFee(time);
        }


        return answer;
    }

    private int calcFee(int time) {

        int pay = defaultFee;
        if(time > defaultTime) {
            pay += unitFee * ((time - defaultTime) / unitTime);
            if((time - defaultTime) % unitTime != 0)
                pay += unitFee;
        }

        return pay;
    }

    public int hourToMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }


}