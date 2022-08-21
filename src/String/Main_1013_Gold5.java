package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
백준 1013 Context Gold5
[문자열, 정규표현식]

java 의 matches를 사용하면 간단히 해결되는 문제이다.
문자열을 파싱할 때 dfs방식으로 100+1+ 패턴과 01패턴으로 분리해서 검증하는 방식을 선택했었는데
10011001과 같은 패턴의 경우, 100+1+패턴에서 두번째 1이 두번이상 나오는 경우 모든 경우를 나누어서
검증해야한다.
정규표현식을 사용하지 못하는 경우에는 보다 정교한 분석이 필요해 보인다.


 */
class Main_1013_Gold5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        String pattern = "(100+1+|01)+";
        for(int tc=0; tc<N; tc++) {
            String str = br.readLine();
            if(str.matches(pattern)) sb.append("YES\n");
            else sb.append("NO\n");

//            if(checkPattern(str,0)) sb.append("YES\n");
//            else sb.append("NO\n");
        }

//        System.out.println(sb.toString());
    }

    private static boolean checkPattern(String str, int startIndex) {

        if(startIndex == str.length()) return true;

        int index = startIndex;
        // check 100+1+ pattern
        if(index<str.length() && str.charAt(index++) == '1'){
            if(index<str.length() && str.charAt(index++) == '0') {
                if(index<str.length() && str.charAt(index++) == '0') {
                    while(index<str.length()) {
                        if(str.charAt(index++) == '1'){
                            if(checkPattern(str, index)) return true;
                            else break;
                        }
                    }
                }
            }
        }
        // check 01 pattern
        index = startIndex;
        if(index<str.length() && str.charAt(index++) == '0') {
            if(index <str.length() && str.charAt(index++) == '1' ) {
                if(checkPattern(str, index)) return true;
            }
        }


        return false;
    }


}