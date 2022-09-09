package Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
소요시간 : 39분

[문제 요약]
주차장의 기본시간, 기본요금, 단위시간, 단위요금이 주어진다
입출차 내역이 주어졌을 때 각 차량의 요금을 계산
    요금을 계산할 때 기본시간을 초과하여 단위시간 계산이 필요할 때
    딱 나누어 떨어지지 않으면 올림하여 계산
    출차가 찍히지 않은 차량의 경우에는 23:59으로 계산해서 요금 계산

[Solution]
주차장에 들어온 차량 정보가 미리 주어지지 않으므로 입출차 내역을 확인하면서 처리
Map을 사용하여 각 차량의 누적 시간, 입출차 확인
Car 클래스를 만들어서 hash map에 관리
class 요소로는 차량번호, 누적시간, 입차되어있는지 유무 저장
모든 입출차 내역을 확인하면 남아있는 출차안한 차량의 시간을 23:59으로 계산
마지막으로 "차량 번호가 작은 자동차" 순서대로 요금을 리턴
-> comparable 클래스를 사용해서 Collection 정렬

 */

class Solution_92341_level2 {

    private int baseTime, baseFee, unitTime, unitFee;
    private HashMap<Integer, Car> cars;

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        baseTime = fees[0];
        baseFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        cars = new HashMap<Integer, Car>();


        for(String record : records) {
            String[] st = record.split(" ");
            String[] split = st[0].split(":");
            int time = parseToMinute(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            int number = Integer.parseInt(st[1]);

            if("IN".equals(st[2])) {

                if(!cars.containsKey(number)) cars.put(number, new Car(number));
                Car car = cars.get(number);
                car.isIn = true;
                car.inClock = time;

            } else if("OUT".equals(st[2])) {

                Car car = cars.get(number);
                car.totalClock += time - car.inClock;
                car.isIn = false;

            }
        }
        int endTime = parseToMinute(23,59);
        List<Car> carList = new ArrayList<>();
        for(Car car : cars.values()) {
            if(car.isIn) car.totalClock += endTime - car.inClock;
            carList.add(car);
        }

        Collections.sort(carList);

        List<Integer> answerList = new ArrayList<>();
        for(Car car : carList) {
            answerList.add(calculateFee(car.totalClock));

        }
        answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private int calculateFee(int totalClock) {
        int fee = baseFee;
        if(totalClock > baseTime){
            fee += ((totalClock - baseTime) / unitTime) * unitFee;
            if((totalClock-baseTime) % unitTime != 0) fee += unitFee;
        }
        return fee;
    }

    private int parseToMinute(int hour, int minute) {
        return hour * 60 + minute;
    }


    class Car implements Comparable<Car>{
        int number;

        @Override
        public String toString() {
            return "Car{" +
                    "number=" + number +
                    ", totalClock=" + totalClock +
                    ", inClock=" + inClock +
                    ", isIn=" + isIn +
                    '}';
        }

        int totalClock, inClock;
        boolean isIn;

        public Car(int number) {
            this.number = number;
            this.totalClock = 0;
            this.inClock = 0;
            this.isIn = false;
        }

        public Car(int number, int totalClock, int inClock, boolean isIn) {
            this.number = number;
            this.totalClock = totalClock;
            this.inClock = inClock;
            this.isIn = isIn;
        }

        @Override
        public int compareTo(Car o) {
            return this.number - o.number;
        }
    }
}