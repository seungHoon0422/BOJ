package Math;

import java.util.Arrays;

class Solution_최솟값만들기
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        //  시간초과 코드 : Coolections.reverseOrder를 사용하면 시간초과 발생
//        Integer[] bArr = Arrays.stream(B).boxed().toArray(Integer[]::new);
//        Arrays.sort(bArr, Collections.reverseOrder());
//        for(int i=0; i<A.length; i++) {
//            answer += A[i] * bArr[i];
//        }

        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[B.length - i - 1];
        }


        return answer;
    }
}