package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main_1541_Silver2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        List<Integer> number = new ArrayList<>();
        List<Character> operator = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == '+' || input.charAt(i) == '-') {
                number.add(Integer.parseInt(sb.toString()));
                operator.add(input.charAt(i));
                sb = new StringBuilder();
            } else {
                sb.append(input.charAt(i));
            }
        }
        number.add(Integer.parseInt(sb.toString()));

        int index = 0;


        while(index < operator.size()) {
            if(operator.get(index) == '-') index++;
            else {
                number.set(index, number.get(index) + number.get(index+1));
                number.remove(index+1);
                operator.remove(index);
            }
        }




        int answer = number.get(0);
        while(number.size() > 1) {
            answer -= number.get(1);
            number.remove(1);
        }

        System.out.println(answer);
    }
}