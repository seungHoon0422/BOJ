package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main_25206_Silver5 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Double> scoreMap = new HashMap<>();


    public static void main(String[] args) {


        scoreMap.put("A+", 4.5);
        scoreMap.put("A0", 4.0);
        scoreMap.put("B+", 3.5);
        scoreMap.put("B0", 3.0);
        scoreMap.put("C+", 2.5);
        scoreMap.put("C0", 2.0);
        scoreMap.put("D+", 1.5);
        scoreMap.put("D0", 1.0);
        scoreMap.put("F", 0.0);


        double scoreSum = 0.0;
        double pointSum = 0.0;

        while(true) {

            try {
                st = new StringTokenizer(br.readLine(), " ");
                String subject = st.nextToken();
                double point = Double.parseDouble(st.nextToken());
                String score = st.nextToken();

                if("P".equals(score)) continue;
                pointSum += point;
                scoreSum += scoreMap.get(score) * point;

            } catch (Exception e) {
                break;
            }

        } // end of while
        System.out.println(scoreSum / pointSum);




    }






}