package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    17413 Silver3 단어뒤집기2

    시작 시간 : 12:22
    종료 시간 : 12: 40
    소요 시간 : 18분

    <문제 조건>
    문자열 S의 특징
    알파벳 소문자, 숫자, 공백, <, > 로만 구성
    < 와 > 는 퐁당퐁당으로 주어진다.
    <> 안에는 길이가 최소 3인 문자열 존재


 */


public class Main_17413_Silver3_단어뒤집기2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String s = br.readLine();

        int startIndex = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean isTag = false;

        for(int i=0; i<s.length(); i++) {

            char c = s.charAt(i);
            switch (c) {
                case ' ' : {
                    if(isTag) continue;
                    sb.append(new StringBuilder(s.substring(startIndex, i)).reverse().append(" "));
                    startIndex = i + 1;
                    break;
                }
                case '<' : {
                    isTag = true;
                    if(startIndex != i)
                        sb.append(new StringBuilder(s.substring(startIndex, i)).reverse());

                    startIndex = i;
                    break;
                }
                case '>' : {
                    sb.append(new StringBuilder('<').append(s.substring(startIndex, i)).append('>'));
                    startIndex = i+1;
                    isTag = false;
                    break;
                }
                default: {

                }

            } // end of switch
        } // end of for i
        if(startIndex != s.length()) sb.append(new StringBuilder(s.substring(startIndex, s.length())).reverse());
        System.out.println(sb);






    }
}

