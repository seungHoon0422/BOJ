package Programmers.PCCP.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * PCCP 기출문제 3. 충돌 위험 찾기
 *
 * 로봇마다 정해진 route 가 존재
 * points : 운송장의 위치 정보 -> 1부터 시작할 수 있게 수정
 * routes : 각 로봇의 이동 경로
 * - 운송장을 순서대로 이동 필요
 *
 * 충돌 위험을 카운트하는 문제
 * 매번 이동을 마칠때마다 충돌 위험횟수를 count
 *
 * 로봇은 운송장 -> 운송장으로 이동할 때 최단거리 이동
 * - r 좌표의 변화를 c좌표의 변화보다 먼저 이동
 *
 * 처음 시작위치에서도 충돌위험 확인
 * 마지막 도착지점에서도 충돌 위험 확인 필요
 *
 */
class Solution_충돌위험찾기 {


    Map<Integer, Station> stationMap = new HashMap<>();
    List<Robot> robots = new ArrayList<>();
    int crashCounter = 0;

    public int solution(int[][] points, int[][] routes) {

        // init variables

        // 운송장 초기 세팅
        for(int i = 0; i < points.length; i++) {
            stationMap.put(i+1, new Station(i+1, points[i][0], points[i][1]));
        }

        // 로봇 초기 세팅
        for(int i = 0; i < routes.length; i++) {

            int[] route = routes[i];
            int robotId = i+1;
            int startStation = route[0];
            int robotR = stationMap.get(startStation).r;
            int robotC = stationMap.get(startStation).c;
            List<int[]> findRoutePosition = findRoutePosition(route);

            robots.add(new Robot(robotId, robotR, robotC, findRoutePosition));
        }

        crashCount();

        while(true) {
            if(robots.isEmpty()) break;
            for (Robot robot : robots)
                robot.moveNextPosition();
            for(int i = robots.size() - 1; i >= 0; i--)
                if(robots.get(i).killFlag) robots.remove(i);

            crashCount();
        }

        return crashCounter;
    }

    // 운송장 -> 운송장으로 경로를 찾아주는 함수
    private List<int[]> findRoutePosition(int[] route) {


        List<int[]> nextRoute = new ArrayList<>();

        for(int stationIndex = 0; stationIndex < route.length - 1; stationIndex++) {
            Station sourceStation = stationMap.get(route[stationIndex]);
            Station targetStation = stationMap.get(route[stationIndex + 1]);

            // (1,1) -> (3,4) 이동
            // r = +2, c = +3
            int r = sourceStation.r;
            int c = sourceStation.c;


            int rowDiff = targetStation.r - sourceStation.r;
            int colDiff = targetStation.c - sourceStation.c;
            int rowDir = rowDiff > 0 ? 1 : -1;
            int colDir = colDiff > 0 ? 1 : -1;

            // row 우선 이동
            for(int i = 0; i < Math.abs(rowDiff); i++) {
                nextRoute.add(new int[] {r + rowDir, c});
                r += rowDir;
            }

            // col 이동
            for(int i = 0; i < Math.abs(colDiff); i++) {
                nextRoute.add(new int[] {r, c + colDir});
                c += colDir;
            }
        }

        return nextRoute;
    }



    // 충돌 위험을 체크하는 함수
    private void crashCount() {
        Map<Integer, List<Integer>> destinationMap = new HashMap<>();
        for (Robot robot : robots) {
            int robotId = robot.id;
            int robotR = robot.r;
            int robotC = robot.c;

            int newKey = robotR * 100 + robotC;

            if(!destinationMap.containsKey(newKey))
                destinationMap.put(newKey, new ArrayList<>());
            destinationMap.get(newKey).add(robotId);
        }
        for (List<Integer> value : destinationMap.values()) {
            if(value.size() >= 2) {
                crashCounter++;
            }
        }
     }


    // 다음 경로로 로봇 이동하는 함수


    public static class Robot {
        int id;
        int r, c;
        List<int[]> route;
        boolean killFlag;

        public Robot(int id, int r, int c, List<int[]> route) {
            this.id = id;
            this.r = r;
            this.c = c;
            this.route = route;
            this.killFlag = false;
        }

        public void moveNextPosition() {

            // 도착 운송지 체크
            if(this.route.isEmpty()) {
                this.killFlag = true;

            } else {
                int[] nextPoistion = this.route.remove(0);
                this.r = nextPoistion[0];
                this.c = nextPoistion[1];
            }
        }

    }

    public static class Station {
        int id;
        int r,c;

        public Station(int id, int r, int c) {
            this.id = id;
            this.r = r;
            this.c = c;
        }
    }
}