import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;


public class Main {

    private static Map<Integer, Integer> map;
    public static void main(String[] args) {

        map = new HashMap<>();
        map.put(10,1);
        map.put(20,2);
        map.put(30,3);
        map.put(40,4);
        map.put(50,5);
        map.put(60,6);
        map.put(70,7);
        map.put(80,8);
        map.put(90,9);
        map.put(100,10);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("--------------------------");

        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            System.out.println(key + " : " + map.get(key));
            if(key == 20 || key == 40)
                it.remove();
        }

        System.out.println("--------------------------------------");
//        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry<Integer, Integer> next = iter.next();
//            System.out.println(next.getKey() + " : " + next.getValue());
//            if(next.getKey() == 20 || next.getKey() == 40) {
//                iter.remove();
//            }
//        }

        for (Integer key : map.keySet()) {
            System.out.println("key : " + key);
        }

        Set<Integer> set = new ConcurrentSkipListSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        set.add(60);
        set.add(70);
        set.add(80);
        set.add(90);
        set.add(100);

//        Iterator<Integer> iter = new
//        for (Integer key : set) {
//            System.out.println(key);
//            if(key == 20 || key == 40)
//                set.remove(key);
//
//        }




//        for (Integer key : map.keySet()) {
//            System.out.println(key);
//            if(key == 20 || key == 40)
//                map.remove(key);
//        }

    }


}