package Implementation;

/**
 *
 * [기억해야할 정보]
 * 악보에 맞는 음악
 * 여러개일 경우 가장 오래 재생된 노래
 * 재생 시간이 같으면 가장 먼저 재생된 노래
 *
 *
 */
class Solution_17683_level2 {

    private static String musicName;
    private static int musicTime;

    private static final String[] others = {"C#", "D#", "F#", "G#", "A#"};
    private static final String[] othersTo = {"1", "2", "3", "4", "5"};

    public String solution(String m, String[] musicinfos) {
        musicTime = Integer.MAX_VALUE;
        for(int i=0; i<others.length; i++) {
            m = m.replaceAll(others[i], othersTo[i]);
        }

        for (String musicinfo : musicinfos) {

            String[] info = musicinfo.split(",");
            int runTime = runningTime(info[0], info[1]);
            String name = info[2];

            for(int i=0; i< others.length; i++) {
                info[3] = info[3].replaceAll(others[i], othersTo[i]);
            }
            String codes = findRunningCode(runTime, info[3]);

            // 재생시간이 더 짧은 경우
            if (codes.length() < m.length()) {
                String subCode = m.substring(0, codes.length());
                if (subCode.equals(codes)) {
                    updateMusic(name, runTime);
                }
            } else {
                if (codes.contains(m)) {
                    updateMusic(name, runTime);
                }
            }
        }

        if(musicTime == Integer.MAX_VALUE) return "(None)";
        return musicName;
    }

    private String findRunningCode(int runTime, String code) {

        StringBuilder sb = new StringBuilder();
        while (runTime >= code.length()) {
            runTime -= code.length();
            sb.append(code);
        }
        return sb.append(code.substring(0, runTime)).toString();
    }

    private void updateMusic(String name, int runTime) {
        if (musicTime == Integer.MAX_VALUE) {
            musicName = name;
            musicTime = runTime;
        } else {
            if (runTime > musicTime) {
                musicName = name;
                musicTime = runTime;
            }
        }
    }

    public static int runningTime(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");

        int startHour = Integer.parseInt(start[0]);
        int startMin = Integer.parseInt(start[1]);
        int endHour = Integer.parseInt(end[0]);
        int endMin = Integer.parseInt(end[1]);

        return (endHour - startHour) * 60 + (endMin - startMin);

    }

}