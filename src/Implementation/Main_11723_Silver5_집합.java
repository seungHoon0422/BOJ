package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*

1. add x
2. remove x
3. check x
4. toggle x
5. all
6. empty


 */

public class Main_11723_Silver5_집합 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            switch(st.nextToken()) {
                case "add" : {
                    int value = Integer.parseInt(st.nextToken());
                    set.add(value);
                    break;
                }
                case "remove" : {
                    int value = Integer.parseInt(st.nextToken());
                    if(set.contains(value)) set.remove(value);
                    break;

                }
                case "check" : {
                    int value = Integer.parseInt(st.nextToken());
                    if(set.contains(value)) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;

                }
                case "toggle" : {
                    int value = Integer.parseInt(st.nextToken());
                    if(set.contains(value)) set.remove(value);
                    else set.add(value);
                    break;

                }
                case "all" : {
                    set.clear();
                    for(int i=1; i<=20; i++) {
                        set.add(i);
                    }
                    break;

                }
                case "empty" : {
                    set.clear();
                }
            }


        }
        System.out.println(sb);





    }
}