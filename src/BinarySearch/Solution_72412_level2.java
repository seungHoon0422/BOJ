package BinarySearch;

import java.util.*;

/**
 * 개발언어 : cpp java python
 * 직군 : backend frontend
 * 경력 : junior senior
 * 송루푸드 : chicken pizza
 * 점수 : 1 이상 100,000 이하인 자연수
 */

class Solution_72412_level2 {

    private static Map<String, Integer>[] types;
    private static Map<String, List<Integer>> info;
    private static int[] answer;
    public int[] solution(String[] infos, String[] queries) {

        answer = new int[queries.length];

        init();
        settingInfos(infos);
        for(int i=0; i<queries.length; i++) {
            answer[i] = querySplit(queries[i]);
        }


        return answer;
    }

    private int querySplit(String query) {

        String[] querySplit = query.replaceAll(" and ", " ").split(" ");
        String simpleQuery = "";
        for(int i=0; i<querySplit.length-1; i++) {
            String queryToken = querySplit[i];
            if(queryToken.equals("-")) simpleQuery += queryToken;
            else simpleQuery += types[i].get(queryToken);
        }
        int limit = Integer.parseInt(querySplit[4]);
        if(!info.containsKey(simpleQuery)) return 0;

        List<Integer> values = info.get(simpleQuery);
        int left = 0, right = values.size() - 1;
        while (left <= right) {
            int mid = (left+right)>>1;
            if(values.get(mid) < limit) left = mid + 1;
            else right = mid - 1;
        }
        return values.size() - left;
    }

    private void settingInfos(String[] infos) {

        for(String in : infos) {
            String[] infoSplit = in.split(" ");
            saveInfo(infoSplit, 0, "");
        }
        for (List<Integer> value : info.values()) {
            Collections.sort(value);
        }

    }

    private void saveInfo(String[] infoSplit, int index, String simpleInfo) {
        if(index == 4) {
            if(!info.containsKey(simpleInfo))
                info.put(simpleInfo, new ArrayList<>());
            info.get(simpleInfo).add(Integer.parseInt(infoSplit[4]));
            return;
        }

        saveInfo(infoSplit, index+1, simpleInfo+"-");
        saveInfo(infoSplit, index+1, simpleInfo+types[index].get(infoSplit[index]));

    }

    private void init() {
        types = new Map[4];
        types[0] = new HashMap<>();
        types[0].put("cpp", 1);
        types[0].put("java", 2);
        types[0].put("python", 3);

        types[1] = new HashMap<>();
        types[1].put("backend", 1);
        types[1].put("frontend", 2);

        types[2] = new HashMap<>();
        types[2].put("junior", 1);
        types[2].put("senior", 2);

        types[3] = new HashMap<>();
        types[3].put("chicken", 1);
        types[3].put("pizza", 2);

        info = new HashMap<>();

    }
}