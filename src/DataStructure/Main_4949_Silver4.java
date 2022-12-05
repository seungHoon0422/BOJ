package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_Silver4 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) throws IOException {

        while(true){

            char[] input = br.readLine().toCharArray();
            if(input.length == 1 && input[0] == '.')
                break;
            sb.append(isCorrect(input)).append("\n");

        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static String isCorrect(char[] input) {
        Stack<Character> st = new Stack<>();

        for (char c : input) {
            if(c == '(' || c == '[')
                st.push(c);
            else if(c == ']') {
                if(st.isEmpty() || st.peek() != '[') {
                    return "no";
                }
                else {
                    st.pop();
                }
            }
            else if(c == ')') {
                if(st.isEmpty() || st.peek() != '(') {
                    return "no";
                }
                else {
                    st.pop();
                }
            }
        }

        if(st.isEmpty()) return "yes";
        else return "no";
    }


}