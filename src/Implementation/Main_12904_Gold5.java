package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    12904 A와 B Gold5

    시작시간 : 12:39
    종료시간 : 1:21
    소요시간 : 42분




 */

public class Main_12904_Gold5 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String S, T;

    public static void main(String[] args) throws IOException {
        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        while(S.length() < T.length()) {
            if(T.charAt(T.length()-1) == 'A') T.deleteCharAt(T.length()-1);
            else T.deleteCharAt(T.length() - 1).reverse();
        }

        if(S.toString().equals(T.toString())) System.out.println(1);
        else System.out.println(0);

    }
}