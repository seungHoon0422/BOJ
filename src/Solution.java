// you can also use imports, for example:
 import java.util.*;


/*

    두 PQ사이의 거리 = abs(A[P] - A[Q])
    최소거리가 100,000,000보다 크면 return -1
    인접한 인덱스가 없으면 -2 return


 */

class Solution {

    static int[] arr;
    static Node[] nodes;
    static Set<Integer> set;
    public int solution(int[] A) {

        arr = new int[A.length];
        nodes = new Node[A.length];
        set = new HashSet<>();
        for(int i=0; i < A.length; i++) {
            arr[i] = A[i];
            set.add(A[i]);
            nodes[i] = new Node(i,A[i]);
        }


        Arrays.sort(nodes);

        long minDistance = Long.MAX_VALUE;
        for(int i=0; i<nodes.length-1; i++) {
            int left = Math.min(nodes[i].value, nodes[i+1].value);
            int right = Math.max(nodes[i].value, nodes[i+1].value);

            // 인접한 경우
            if(left == right) {
                return 0;
            } else {
                boolean existValue = false;
                for(int val=left+1; val<right; val++) {
                    if(set.contains(val)) {
                        existValue = true;
                        break;
                    }
                }
                if(existValue) continue;
                minDistance = Math.min(minDistance, (long) Math.abs(nodes[i].value - nodes[i+1].value));
            }
        }

        if(minDistance > 100000000) return -1;
        else if(minDistance == Long.MAX_VALUE) return -2;
        else return (int) minDistance;

    }



    public class Node implements Comparable<Node> {
        int index, value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if(value != o.value)
                return value - o.value;
            return index - o.index;
        }
    }
}
