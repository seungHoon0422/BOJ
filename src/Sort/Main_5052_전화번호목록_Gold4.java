package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문자열, 정렬]
 * 접두어의 관계에 있는 경우 사전순으로 정렬을 헀을 때 필연적으로 붙어있게 된다!!
 * 이때 문자열의 접두어를 판단할 경우 [startwith] 메서드를 사용해서 판단
 */
class Main_5052_전화번호목록_Gold4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < tc; testcase++) {
            int N = Integer.parseInt(br.readLine());
            String[] phone = new String[N];
            for(int i=0; i<N; i++)
                phone[i] = br.readLine();

            Arrays.sort(phone);
            boolean success = true;
            for(int i=1; i<N; i++) {
                if(phone[i].startsWith(phone[i-1])) {
                    success = false;
                    break;
                }
            }
            if(success) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }


}