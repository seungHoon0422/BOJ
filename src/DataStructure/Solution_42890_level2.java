package DataStructure;

import java.util.HashSet;
import java.util.Set;


class Solution_42890_level2 {
    private static String[][] relation;
    private static Set<String> answerSet;
    private static int columns;
    private static Set<String> keySubSet;
    public int solution(String[][] re) {
        relation = re;
        columns = relation[0].length;
        answerSet = new HashSet<>();

        for(int i=1; i<=columns; i++) {
            findPossibleKey(0, i, "");
        }

        return answerSet.size();
    }

    private void findPossibleKey(int index, int limit, String key) {
        if(index == columns || key.length() == limit) {
            if(key.length() != limit) return;
            if(!isPossibleKey(key)) return;
            keySubSet = new HashSet<>();
            findSubSetKey(0,key, "");
            for (String subsetKey : keySubSet) {
                if(key.equals("12")) {
                }
                if(answerSet.contains(subsetKey))
                    return;
            }
            answerSet.add(key);
            return;
        }
        findPossibleKey(index+1, limit, key);
        findPossibleKey(index+1, limit, key+index);

    }

    private boolean isPossibleKey(String key) {
        Set<String> tupleSet = new HashSet<>();
        for(int i=0; i<relation.length; i++) {
            String[] tuple = relation[i];
            StringBuilder tupleValue = new StringBuilder();
            for(int j=0; j<key.length(); j++) {
                tupleValue.append(relation[i][key.charAt(j)-'0']);
            }
            if (tupleSet.contains(tupleValue.toString())) {
                return false;
            } else {
                tupleSet.add(tupleValue.toString());
            }
        }
        return true;
    }


    private void findSubSetKey(int index, String key, String subkey) {
        if (index == key.length()) {
            keySubSet.add(subkey);
            return;
        }

        findSubSetKey(index + 1, key, subkey);
        findSubSetKey(index + 1, key, subkey+key.charAt(index));
    }
}












