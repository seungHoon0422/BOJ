import java.util.*;

class Solution2 {
    static int answer;
    static List<Integer> numbers;
    public int solution(int[][] phone) {
        answer = 0;
        numbers = new ArrayList<>();
        for(int i=0; i<phone.length; i++) {
            for(int j=0; j<phone[i].length; j++) {
                if(phone[i][j] == 1) numbers.add(i*3 + j);
            }
        }
        if(numbers.size() < 2) return 0;
        subset(0, 0, new int[numbers.size()]);


        return answer;
    }
    static void subset(int index, int count, int[] nums) {

//        if(count > 1) {
//            if(!checkPositions(nums[count], nums[count-1])) return;
//        }
//
        if(index == numbers.size()) {

            if(count >= 2) {
                boolean isPossible = true;
                for(int i=1; i<count; i++) {
                    if(!checkPositions(nums[i-1], nums[i])) {
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible) {
//                    System.out.println(Arrays.toString());
                    answer++;
                }
            }
            return;

        }


        for(int i=index; i<numbers.size(); i++) {
            subset(index + 1, count, nums);
            nums[count] = numbers.get(i);
            subset(index + 1, count+1, nums);
        }

    }

    private static boolean checkPositions(int num1, int num2) {

        int row1 = num1 / 3;
        int col1 = num1 % 3;
        int row2 = num2 / 3;
        int col2 = num2 % 3;
        return (Math.abs(row1 - row2) <= 1 && Math.abs(col1 - col2) <= 1);



    }


}
