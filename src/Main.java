import java.util.*;
import java.io.*;



public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, x;
    static int[] arr;

    public static void main(String[] args) throws IOException {


        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(br.readLine());


        Arrays.sort(arr);
        int left = 0, right = N-1;
        int answer = 0;
        while(left < right) {
            int sum = arr[left] + arr[right];

            if(sum < x) left++;
            else if(sum > x) right--;
            else {
                answer++;
                left++;
            }

        }

        System.out.println(answer);



    }

}