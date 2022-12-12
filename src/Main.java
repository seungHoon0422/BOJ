import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[][] pay;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        pay = new int[N][N];
        for(int i=0; i<N; i++) {
            char[] inputLine = br.readLine().toCharArray();
            for(int j=0; j<N; j++)
                pay[i][j] = inputLine[j] - '0';


        }







    }


}