package BruteForce;

import java.util.*;

class Solution_72411_level2 {
    private HashMap<String, Integer> menus;

    public String[] solution(String[] orders, int[] course) {
        menus = new HashMap<>();

        for(int i=0; i<orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            searchMenu(0, "", chars);
        }


        Map<Integer, ArrayList<String>> results = new HashMap<>();

        for (String key : menus.keySet()) {
            if(menus.get(key) < 2) continue;
            if(!results.containsKey(key.length())) results.put(key.length(), new ArrayList<>());

            // 첫 메뉴
            if(results.get(key.length()).size() == 0 ) results.get(key.length()).add(key);
            else {
                // 메뉴가 이미 존재하는 경우
                String mn = results.get(key.length()).get(0);
                int count = menus.get(mn);

                if (menus.get(key) == count) {
                    results.get(key.length()).add(key);
                } else if(menus.get(key) > count) {
                    results.put(key.length(), new ArrayList<>());
                    results.get(key.length()).add(key);
                }
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i< course.length; i++) {
            if(results.containsKey(course[i])){
                result.addAll(results.get(course[i]));
            }
        }
        Collections.sort(result);
        String[] answer = result.toArray(new String[0]);
        return answer;
    }

    private void searchMenu(int index, String menu, char[] chars) {

        if(index == chars.length) {
            if(!menus.containsKey(menu))
                menus.put(menu, 0);
            menus.put(menu, menus.get(menu) + 1);
            return;
        }

        searchMenu(index+1, menu, chars);
        searchMenu(index+1, menu+chars[index], chars);


    }
}