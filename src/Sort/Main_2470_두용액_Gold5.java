package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [정렬, 투포인터]
 * 합한 용액의 농도가 알칼리이면 알칼리 쪽 포인터를 당기고,
 * 산성이면 산성 쪽 포인터를 당긴다.
 *
 */
class Main_2470_두용액_Gold5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int[] nums;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int left = 0;
        int right = N-1;
        int value;

        int l=0, r = N-1;
        int minvalue = Integer.MAX_VALUE;



        while(left < right) {
            value = (nums[left] + nums[right]);
            if(Math.abs(value) < minvalue) {
                minvalue = Math.abs(value);
                l = left;
                r = right;
            }
            if(value < 0) left++;
            else right--;
        }

        System.out.println(nums[l] + " " + nums[r]);
    }
}