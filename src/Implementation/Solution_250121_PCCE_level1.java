package Implementation;

import java.util.*;

class Solution_250121_PCCE_level1 {

    static int extIndex=0, sortIndex=0;


    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        Queue<Integer> queue = new LinkedList<>();
        if("code".equals(ext)) extIndex = 0;
        else if("date".equals(ext)) extIndex = 1;
        else if("maximum".equals(ext)) extIndex = 2;
        else if("remain".equals(ext)) extIndex = 3;


        if("code".equals(sort_by)) sortIndex = 0;
        else if("date".equals(sort_by)) sortIndex = 1;
        else if("maximum".equals(sort_by)) sortIndex = 2;
        else if("remain".equals(sort_by)) sortIndex = 3;

        List<Data> dataList = new ArrayList<>();
        for(int i=0; i<data.length; i++) {
            if(data[i][extIndex] < val_ext) {
                dataList.add(new Data(data[i][0],
                        data[i][1],
                        data[i][2],
                        data[i][3] ));
            }
        }

        Collections.sort(dataList);
        answer = new int[dataList.size()][4];
        for(int i=0; i<dataList.size(); i++) {
            for(int j=0; j<4; j++)
                answer[i][j] = dataList.get(i).arr[j];
        }
        return answer;
    }

    static class Data implements Comparable<Data> {
        int[] arr;
        public Data(int code,int date,int max,int remain) {
            this.arr = new int[4];
            this.arr[0] = code;
            this.arr[1] = date;
            this.arr[2] = max;
            this.arr[3] = remain;
        }

        @Override
        public int compareTo(Data data) {
            return this.arr[sortIndex] - data.arr[sortIndex] ;
        }

    }


}