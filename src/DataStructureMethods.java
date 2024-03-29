import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*
 *
 *  자료구조 메서드 정리
 *
 * 1. 반복문
 * 2. String method
 * 3. List
 * 4. Map
 * 5. Stack
 * 6. Queue
 *
 *
 *
 *
 *
 */
class DataStructureMethods
{
    public static void main(String[] args) {

        For();
        MethodString();
        MethodList();
        MethodMap();
        MethodStack();
        MethodQueue();




    }
    private static void For() {

        methodDebug("For");

        for(int i=0; i<5; i++) System.out.print(i + " ");
        System.out.println();

        int[] arr = {1,2,3,4,5};
        for(int node : arr) System.out.print(node + " ");
        System.out.println();

        int index = 0;
        while(index < arr.length) System.out.print(arr[index++] + " ");
        System.out.println();

        /*
--------------------------
Method Name : For
--------------------------
0 1 2 3 4
1 2 3 4 5
1 2 3 4 5

         */
    }


    private static void MethodString() {

        methodDebug("String");

        String str = "0123456789";
        System.out.println("sample string : " + str);
        System.out.println();

        System.out.println("length() : " + str.length());
        System.out.println("str.charAt(3) : " + str.charAt(3));
        System.out.println("str.equals(\"12345\") : " + str.equals("12345"));
        System.out.println("str.substring(3) : " + str.substring(3));
        System.out.println("str.substring(3, 6) : " + str.substring(3, 6));
        System.out.println("str.split(\"3\") :" + Arrays.toString(str.split("3")));
        System.out.println("str.contains(\"1234\") : " + str.contains("1234"));

        System.out.println();
        String str1 = "AaaBbbCccDddAaa";
        System.out.println();
        System.out.println("str1 = " + str1);
        System.out.println("str1.toLowerCase() : " + str1.toLowerCase());
        System.out.println("str1.toUpperCase() : " + str1.toUpperCase());
        System.out.println("str1.replace(\"A\", \"a\") : " + str1.replace("A", "a"));
        System.out.println("str1.replaceAll(\"A\", \"a\") : " + str1.replaceAll("A", "a"));
        System.out.println("\"abcde\".compareTo(\"abcde\") : " + "abcde".compareTo("abcde"));
        System.out.println("\"abcde\".compareTo(\"bbcde\") : " + "abcde".compareTo("bbcde"));
        System.out.println("\"cbcde\".compareTo(\"abcde\") : " + "cbcde".compareTo("abcde"));


        String a = "aaabbbcccdddeeeaaacccaaaaaa";
        System.out.println("a.replace(\"a\", \"*\") : " + a.replace("a", "*"));
        System.out.println("a.replaceAll(\"[ac]\", \"*\") : " + a.replaceAll("[ac]", "*"));

        /*
--------------------------
Method Name : String
--------------------------
sample string : 0123456789

length() : 10
str.charAt(3) : 3
str.equals("12345") : false
str.substring(3) : 3456789
str.substring(3, 6) : 345
str.split("3") :[012, 456789]
str.contains("1234") : true


str1 = AaaBbbCccDddAaa
str1.toLowerCase() : aaabbbcccdddaaa
str1.toUpperCase() : AAABBBCCCDDDAAA
str1.replace("A", "a") : aaaBbbCccDddaaa
str1.replaceAll("A", "a") : aaaBbbCccDddaaa
"abcde".compareTo("abcde") : 0
"abcde".compareTo("bbcde") : -1
"cbcde".compareTo("abcde") : 2
a.replace("a", "*") : ***bbbcccdddeee***ccc******
a.replaceAll("[ac]", "*") : ***bbb***dddeee************
         */
    }


    private static void MethodList() {

    methodDebug("Method Array List");

    List<Integer> arraylist = new ArrayList<>();
    List<Integer> linkedlist = new LinkedList<>();

    for (int i = 0; i < 10; i++) arraylist.add(i);

    System.out.println(Arrays.toString(arraylist.toArray()));
    System.out.println("arraylist.get(3) = " + arraylist.get(3));
    System.out.println("arraylist.size() = " + arraylist.size());
    System.out.println("arraylist.add(7) = " + arraylist.add(7));
    System.out.println(Arrays.toString(arraylist.toArray()));
    System.out.println("arraylist.contains(5)  : " + arraylist.contains(5));
    System.out.println("arraylist.indexOf(2) = " + arraylist.indexOf(2));
    System.out.print("arraylist.remove(0) = " + arraylist.remove(0));
    System.out.println(" => " + Arrays.toString(arraylist.toArray()));
    System.out.print("arraylist.set(3, -1) = " + arraylist.set(3, -1));
    System.out.println(" => " + Arrays.toString(arraylist.toArray()));
    arraylist.sort((a, b) -> a - b);
    System.out.println("arraylist.sort((a,b) -> a-b) = " + arraylist.toString());
    Collections.sort(arraylist);

    /*
--------------------------
Method Name : Method Array List
--------------------------
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
arraylist.get(3) = 3
arraylist.size() = 10
arraylist.add(7) = true
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 7]
arraylist.contains(5)  : true
arraylist.indexOf(2) = 2
arraylist.remove(0) = 0 => [1, 2, 3, 4, 5, 6, 7, 8, 9, 7]
arraylist.set(3, -1) = 4 => [1, 2, 3, -1, 5, 6, 7, 8, 9, 7]
arraylist.sort((a,b) -> a-b) = [-1, 1, 2, 3, 5, 6, 7, 7, 8, 9]


     */
}



    private static void MethodMap() {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> linkedMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        for(int i=0; i<10; i++) map.put(i, i*10);

        int size = map.size();
        Set<Integer> keySet = map.keySet();
        Collection<Integer> values = map.values();
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        boolean containsKey = map.containsKey(3);
        boolean containsValue = map.containsValue(30);


        map.remove(5);

        // iterator
        for (Integer integer : keySet) {
            integer++;
        }
        for (Integer value : values) {
            value++;
        }
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            Integer integer = entry.getValue();
        }



    }

    private static void MethodStack() {

        methodDebug("Stack");
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<5; i++) stack.push(i);
        Integer pop = stack.pop();
        Integer peek = stack.peek();
        boolean empty = stack.isEmpty();
        int size = stack.size();
        boolean contains = stack.contains(3);


    }


    private static void MethodQueue() {
        methodDebug("Queue");

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < 10; i++) queue.offer(i);
        System.out.println("queue = " + queue.toString());


        System.out.println("queue.peek() = " + queue.peek());;
        System.out.println("queue.size() = " + queue.size());;
        System.out.println("queue.isEmpty() = " + queue.isEmpty());;
        System.out.println("queue.poll() = " + queue.poll());;


        seperate();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i < 10; i++) deque.offer(i);

        System.out.println("deque = " + deque);
        System.out.println("deque.peekFirst() = " + deque.peekFirst());;
        System.out.println("deque.pollLast() = " + deque.pollLast());;
        System.out.print("deque.offerFirst(0) = " + deque.offerFirst(0));;
        System.out.println(" => deque = " + deque);
        System.out.print("deque.offerLast(0) = " + deque.offerLast(0));;
        System.out.println(" => deque = " + deque);
        System.out.print("deque.pollFirst() = " + deque.pollFirst());;
        System.out.println(" => deque = " + deque);
        System.out.print("deque.pollFirst() = " + deque.pollFirst());;
        System.out.println(" => deque = " + deque);

        /*
--------------------------
Method Name : Queue
--------------------------
queue = [1, 2, 3, 4, 5, 6, 7, 8, 9]
queue.peek() = 1
queue.size() = 9
queue.isEmpty() = false
queue.poll() = 1

------------------------------

deque = [1, 2, 3, 4, 5, 6, 7, 8, 9]
deque.peekFirst() = 1
deque.pollLast() = 9
deque.offerFirst(0) = true => deque = [0, 1, 2, 3, 4, 5, 6, 7, 8]
deque.offerLast(0) = true => deque = [0, 1, 2, 3, 4, 5, 6, 7, 8, 0]
deque.pollFirst() = 0 => deque = [1, 2, 3, 4, 5, 6, 7, 8, 0]
deque.pollFirst() = 1 => deque = [2, 3, 4, 5, 6, 7, 8, 0]

Process finished with exit code 0

         */
    }






    private static void methodDebug(String name) {
        System.out.println("--------------------------");
        System.out.println("Method Name : " + name);
        System.out.println("--------------------------");
    }

    private static void seperate() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
    }


    static class Node implements Comparable<Node> {
        int value;

        @Override
        public int compareTo(Node node) {
            return this.value - node.value;
        }



    }


}