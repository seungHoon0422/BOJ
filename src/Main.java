import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        List<Character> charList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        String temp = "";
        for(int i=0; i<input.length(); i++) {

            if(input.charAt(i) == '+' || input.charAt(i) == '-') {
                numList.add(Integer.parseInt(temp));
                charList.add(input.charAt(i));
                temp = "";
            } else {
                temp += input.charAt(i);
            }
        }
        numList.add(Integer.parseInt(temp));
        for(int i=0; i<charList.size(); i++) {
            if(charList.get(i) == '+') {
                numList.set(i, numList.get(i) + numList.get(i + 1));
                numList.set(i+1, 0);
            }
        }

        int answer = numList.get(0);
        for (int i = 2; i < numList.size(); i++) {
            answer -= numList.get(i);
        }

        System.out.println(answer);

    }
}