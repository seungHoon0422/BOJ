package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Solution_17686_level2 {

    public String[] solution(String[] files) {
        String[] answer = {};
        List<File> fileList = new ArrayList<>();

        for (String file : files) {
            fileList.add(new File(file));
        }
        Collections.sort(fileList);
        answer = new String[files.length];
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).original;
        }

        return answer;
    }


    static class File implements Comparable<File> {
        String original;
        String head, numberString;
        int number;

        public File(String original) {
            this.original = original;
            seperateOriginal(original);
        }

        private void seperateOriginal(String original) {

            this.head = "";
            this.numberString = "";
            int index = 0;

            // find head
            while (index < original.length()) {
                char ch = original.charAt(index);
                if (!('0' <= ch && ch <= '9')) {
                    this.head += ch;
                    index++;
                } else break;
            }

            // find number
            int numberCount = 0;
            while (index < original.length()) {
                char ch = original.charAt(index);
                if ('0' <= ch && ch <= '9') {
                    this.numberString += ch;
                    index++;
                    if(this.numberString.length() >= 5) {
                        break;
                    }
                } else break;
            }
            this.head = this.head.toLowerCase();
            this.number = Integer.parseInt(numberString);
        }

        @Override
        public int compareTo(File file) {
            int headCompare = this.head.compareTo(file.head);
            if(headCompare == 0)
                return this.number - file.number;
            return headCompare;
        }
    }
}



