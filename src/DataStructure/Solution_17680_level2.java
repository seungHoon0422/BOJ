package DataStructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Solution_17680_level2 {

    private static int maxSize;
    private static Set<String> cacheSet;
    private static List<String> cache;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0)
            return cities.length * 5;
        cache = new ArrayList<>();
        cacheSet = new HashSet<>();
        maxSize = cacheSize;
        for (String city : cities) {
            city = city.toLowerCase();
            if (cacheSet.contains(city)) {
                // cache hit
                cache.add(cache.remove(cache.indexOf(city)));
                answer += 1;
            } else {
                // cache miss
                if(cache.size() == maxSize) {
                    cacheSet.remove(cache.remove(0));
                }
                cacheSet.add(city);
                cache.add(city);
                answer += 5;
            }
        }

        return answer;
    }

}