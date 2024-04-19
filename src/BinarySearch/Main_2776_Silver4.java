package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2776_Silver4 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    // ------------------------------- static var ----------------------------------------

    private static int N, M, tc;
    private static int[] note1, note2;


    ////////////////////////// temp ////////////////////////////
    private static Set<Integer> keySet = new HashSet<>();
    public static void main(String[] args) throws IOException {

        tc = Integer.parseInt(br.readLine());
        while(tc-->0) {

            N = Integer.parseInt(br.readLine());
            note1 = new int[N];

            // note1 input
            st = new StringTokenizer(br.readLine(), " ");
            int index = 0;
            while (st.hasMoreTokens()) {
                keySet.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            note2 = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                if(keySet.contains(Integer.parseInt(st.nextToken()))) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void findNumber() {
        for(int i=0; i<M; i++) {
            if(keySet.contains(note2[i])) sb.append("1").append("\n");
            else sb.append("0").append("\n");
        }
    }

    private static boolean binarySerach(int num) {

        int left = 0;
        int right = N-1;
        while(left <= right) {
            int mid = (left + right)/2;
            if(note1[mid] == num) return true;
            if(num < note1[mid]) right = mid - 1;
            else left = mid +1;
        }
        return false;
    }
}



/////////////////////////// answer /////////////////////////////////////
//public static void main(String[] args) throws IOException {
//
//    tc = Integer.parseInt(br.readLine());
//    while(tc-->0) {
//
//        N = Integer.parseInt(br.readLine());
//        note1 = new int[N];
//
//        // note1 input
//        st = new StringTokenizer(br.readLine(), " ");
//        int index = 0;
//        while (st.hasMoreTokens()) {
//            note1[index++] = Integer.parseInt(st.nextToken());
//        }
//        // 이분탐색 진행을 위한 note1 배열 정렬
//        Arrays.sort(note1);
//
//        M = Integer.parseInt(br.readLine());
//        note2 = new int[M];
//        st = new StringTokenizer(br.readLine(), " ");
//        index = 0;
//        while (st.hasMoreTokens()) {
//            note2[index++] = Integer.parseInt(st.nextToken());
//        }
//        findNumber();
//
//
//    }
//
//    System.out.println(sb);
//
//
//
//}
//
//    private static void findNumber() {
//        for(int i=0; i<M; i++) {
//            if(binarySerach(note2[i])) sb.append("1").append("\n");
//            else sb.append("0").append("\n");
//        }
//    }
//
//    private static boolean binarySerach(int num) {
//
//        int left = 0;
//        int right = N-1;
//        while(left <= right) {
//            int mid = (left + right)/2;
//            if(note1[mid] == num) return true;
//            if(num < note1[mid]) right = mid - 1;
//            else left = mid +1;
//        }
//        return false;
//    }
//}