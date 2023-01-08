package Implementation;

import java.util.*;

class Solution_72411_level2 {

    private static Set<Integer> courseSet;

    private static Map<String, Integer> menus;
    private static Map<Integer, Integer> maxCount;
    private static Map<Integer, List<String>> answerMap;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        // Global Variable Initialization
        courseSet = new HashSet<>();
        maxCount = new HashMap<>();
        menus = new HashMap<>();
        answerMap = new HashMap<>();

        for (int courseCount : course) {
            maxCount.put(courseCount, 0);
            answerMap.put(courseCount, new ArrayList<>());
        }

        for (int courseCount : course) {
            courseSet.add(courseCount);
        }

        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            order = "";
            for (char ch : chars) {
                order += ch;
            }
            findMenu(0, "", order);
        }

        for (Map.Entry<String, Integer> menu : menus.entrySet()) {

            // course의 개수가 아닌 메뉴는 패스
            if(!courseSet.contains(menu.getKey().length())) continue;
            // 코스가 1명밖에 없는경우 패스
            if(menu.getValue() < 2) continue;
            if(menu.getValue() < maxCount.get(menu.getKey().length()))
                continue;
            if(menu.getValue() == maxCount.get(menu.getKey().length())){
                answerMap.get(menu.getKey().length()).add(menu.getKey());
            } else {
                maxCount.put(menu.getKey().length(), menu.getValue());
                answerMap.put(menu.getKey().length(), new ArrayList<>());
                answerMap.get(menu.getKey().length()).add(menu.getKey());
            }
        }
        List<String> answerList = new ArrayList<>();
        for (List<String> value : answerMap.values()) {
            for (String menu : value) {
                answerList.add(menu);
            }
        }
        Collections.sort(answerList);
        answer = new String[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    private void findMenu(int index, String temp, String order) {

        if (index == order.length()) {
            if(temp.length() < 2) return;
            if(!menus.containsKey(temp)) {

                menus.put(temp, 1);
            } else {
                menus.put(temp, menus.get(temp) + 1);
            }
            return;
        }

        findMenu(index+1, temp, order);
        findMenu(index+1, temp+order.charAt(index), order);
    }
}







