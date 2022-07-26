import java.io.*;
import java.util.*;


/**
 * @Problem 주어지는 숫자의 통계를 내는 문제, 산술평균, 중앙값, 최빈값, 최대 최소의 차이
 * @Solution
 * 1. 산술평균을 내는 과정에서 반올림이 필요한데 이 때 double형태로 바꿔서 계산해야한다.
 * 2. 중앙값의 경우 주어진 숫자들을 정렬시킨 후 주어진 N값의 인덱스를 활용해 추출
 * 3. 최빈값 : 최빈값이 여러개인 경우 두번째 값을 출력해야 하므로, 최대로 많이나온 경우를 저장한 다음
 * 해당하는 숫자들을 정렬하여 2개 이상일 경우 두번째 값을, 아닌 경우 첫번째 값을 출력
 * 4. 최대 최소의 차이 : 값을 입력받으면서 최대, 최소값을 찾고 그 차이를 출력한다.
 *
 *
 */
class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int N;
    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if(!count.containsKey(arr[i])) count.put(arr[i], 1);
            else count.put(arr[i], count.get(arr[i])+1);
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        int maxCount = 0;
        for(Integer key : count.keySet()) {
            if (count.get(key) > maxCount) {
                maxCount = count.get(key);
            }
        }
        List<Integer> mode = new ArrayList<>();
        for(Integer key : count.keySet()) {
            if (count.get(key) == maxCount) {
                mode.add(key);
            }
        }
        int arg3 = 0;
        Collections.sort(mode);
        if(mode.size() == 1) arg3 = mode.get(0);
        else arg3 = mode.get(1);

        Arrays.sort(arr);
        sb.append((int)Math.round((double)sum / N)).append("\n").
                append(arr[arr.length/2]).append("\n").
                append(arg3).append("\n").
                append(max - min);
        System.out.println(sb);
    }

}