package Programmers.PCCP.Level1;

/**
 *  PCCP 기출문제 1. 동영상 재생기
 *
 *  3가지 기능
 *  1. 10초 전으로 이동
 *  - "prev" 먕령어 입력
 *  - 재생위치를 현재위치에서 10초전으로 이동
 *  - 현재위치가 10초 미만일 경우 영상의 처음위치(0분 0초)로 이동
 *
 *  2. 10초 후로 이동
 *  - "next" 명령어 입력
 *  - 재생위치를 현재 위치에서 10초 후로 이동
 *  - 남은시간이 10초 미만일 경우 영상의 마지막(동영상의 길이)으로 이동
 *
 *  3. 오프닝 건너뛰기
 *  - 현재위치가
 *  오프닝 구간인 경우 자동으로 오프닝 끝나는 위치로 이동
 *
 *
 */
class Solution_동영상재생기 {


    private static final int TIME_DIVISION = 10;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int videoLen = this.convertTimeToSeconds(video_len);
        int currentPos = this.convertTimeToSeconds(pos);
        int opStart = this.convertTimeToSeconds(op_start);
        int opEnd = this.convertTimeToSeconds(op_end);

        for (String command : commands) {
            if(opStart <= currentPos && currentPos <= opEnd) currentPos = opEnd;
            switch (command) {
                case "prev" -> {
                    if(currentPos < TIME_DIVISION) currentPos = 0;
                    else currentPos -= TIME_DIVISION;
                }
                case "next" -> {
                    if(videoLen - currentPos < TIME_DIVISION) currentPos = videoLen;
                    else currentPos += TIME_DIVISION;
                }
            }
        } // end of for
        if(opStart <= currentPos && currentPos <= opEnd) currentPos = opEnd;

        // TODO: convert time sec to min
        answer = convertSecondsToTime(currentPos);



        return answer;
    }

    private int convertTimeToSeconds(String time) {

        String[] timeSplit = time.split(":");
        int min = Integer.parseInt(timeSplit[0]);
        int sec = Integer.parseInt(timeSplit[1]);
        return min * 60 + sec;
    }

    private String convertSecondsToTime(int seconds) {

        String min = String.valueOf(seconds / 60);
        String sec = String.valueOf(seconds % 60);
        return (min.length() <= 1 ? "0"+min : min) + ":" + (sec.length() <= 1 ? "0"+sec : sec);
    }
}