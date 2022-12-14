package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3079_Gold5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] times = new long[N];
        long answer = 0L;
        for (int i = 0; i < N; i++) times[i] = Long.parseLong(br.readLine());

        Arrays.sort(times);
        long left = 0L;
        long right = (long) M  * times[N-1];

        while (left <= right) {
            long mid = (left + right) / 2;

            long possible = 0;
            for(int i=0; i<N; i++) {
                possible += mid / times[i];
            }
            if (possible >= M) {
                right = mid -1;
                answer = mid;
            } else {
                left = mid + 1;
            }


        }

        System.out.println(answer);
    }

}